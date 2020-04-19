package br.com.futura.pw.resource;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.futura.pw.dto.CategoriaDTO;
import br.com.futura.pw.entity.Categoria;
import br.com.futura.pw.service.CategoriaService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CategoriaResourceTest {
	
	private static final String DESCRICAO = "Categoria Teste";
	private static final String IMAGEM = "URL da imagem para teste"; 
	private static final String URL = "/categorias";
	
	@MockBean
	private CategoriaService service;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void deveSalvarCategoria() throws Exception {
		BDDMockito.given(service.salvar(Mockito.any(Categoria.class))).willReturn(getMockCategoria());
		
		mvc.perform(MockMvcRequestBuilders.post(URL)
				.content(getJson())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}
	
	public Categoria getMockCategoria() {
		Categoria c = new Categoria();
		c.setDescricao(DESCRICAO);
		c.setImagem(IMAGEM);
		
		return c;
	}
	
	public String getJson() throws JsonProcessingException {
		CategoriaDTO dto = new CategoriaDTO();
		dto.setDescricao(DESCRICAO);
		dto.setImagem(IMAGEM);
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(dto);
	}
}

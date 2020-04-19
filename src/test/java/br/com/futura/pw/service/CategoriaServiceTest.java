package br.com.futura.pw.service;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.futura.pw.entity.Categoria;
import br.com.futura.pw.repository.CategoriaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CategoriaServiceTest {
	
	@MockBean
	private CategoriaRepository repository;
	
	@Autowired
	private CategoriaService service;
	
	@Before
	public void setUp() {
		BDDMockito.given(repository.findById(Mockito.anyLong()))
			.willReturn(Optional.of(new Categoria()));
		
		
	}
	
	@Test
	public void deveBuscarCategoriaPorId() {
		Optional<Categoria> categoria = service.buscarPor(1L);
		
		assertTrue(categoria.isPresent());
	}

}

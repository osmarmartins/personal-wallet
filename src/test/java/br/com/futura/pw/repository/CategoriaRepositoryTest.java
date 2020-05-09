package br.com.futura.pw.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.futura.pw.entity.Categoria;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CategoriaRepositoryTest {
	
	private final static String DESCRICAO = "Categoria de teste";
	
	private Categoria categoria;
	private Long id;
	
	@Autowired
	private CategoriaRepository repository;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none(); 
	
	@Before
	public void setUp() {
		Categoria c = new Categoria();
		c.setDescricao(DESCRICAO);
		
		categoria = repository.save(c);
		id = categoria.getId();
	}
	
	@After
	public void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	public void deveSalvarCategoria() {
		assertNotNull(categoria);
		assertEquals(DESCRICAO, categoria.getDescricao());
	}
	
	@Test
	public void deveBuscarCategoriaSalva() {
		Optional<Categoria> response = repository.findById(id);
		
		assertTrue(response.isPresent());
		assertEquals(DESCRICAO, response.get().getDescricao());
	}
	
//	@Test
	public void deveGerarExcecaoParaDescricaoComMenosDe3Caracteres() {
		Categoria c = new Categoria();
		c.setDescricao("Te");
		
		repository.save(c);

		expectedException.expectMessage("Descrição deve conter entre 3 e 30 caracteres");
	}

//	@Test
	public void deveGerarExcecaoParaDescricaoComMaisDe30Caracteres() {
		Categoria c = new Categoria();
		c.setDescricao("123456789012345678901234567890-ERRO");
		
		repository.save(c);

		expectedException.expectMessage("Descrição deve conter entre 3 e 30 caracteres");
	}

}

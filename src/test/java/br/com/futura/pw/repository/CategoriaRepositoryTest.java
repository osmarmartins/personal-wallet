package br.com.futura.pw.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
	
	@Autowired
	private CategoriaRepository repository;
	
	private Long id;
	
	@Before
	public void setUp() {
		Categoria c = new Categoria();
		c.setDescricao("Teste");
		
		Categoria response = repository.save(c);
		this.id = response.getId();
	}
	
	@After
	public void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	public void deveSalvarCategoria() {
		Categoria c = new Categoria();
		c.setId(1L);
		c.setDescricao("Teste");
		c.setImagem("");
		
		Categoria response = repository.save(c);

		assertNotNull(response);
	}
	
	@Test
	public void deveBuscarCategoriaSalva() {
		Optional<Categoria> response = repository.findById(this.id);
		
		assertTrue(response.isPresent());
		assertEquals("Teste", response.get().getDescricao());
	}

}

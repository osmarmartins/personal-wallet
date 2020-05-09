package br.com.futura.pw.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.futura.pw.entity.Lancamento;
import br.com.futura.pw.enums.SituacaoLancamento;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTest {
	
	private final static String HISTORICO = "Lançamento de teste";
	private final static SituacaoLancamento SITUACAO = SituacaoLancamento.EM_ABERTO;
	private final static LocalDate DATA = LocalDate.of(2020, 0, 1); // 01-jan-2020
	
	
	@Autowired
	private LancamentoRepository repository;
	
	private Lancamento lancamento;
	private Long id;
	
	@Before
	public void setUp() {
		Lancamento l = new Lancamento();
		l.setHistorico(HISTORICO);
		l.setData(DATA); 
		l.setSituacao(SITUACAO);
		
		lancamento  = repository.save(l);
		id = lancamento.getId();
	}
	
	@After
	public void tearDown() {
		repository.deleteAll();
	}
	
	@Test
	public void deveSalvarLancamento() {
		assertNotNull(lancamento);
//		assertEquals(id, lancamento.getId());
	}
	
	@Test
	public void deveBuscarLancamentoSalvo() {
		Optional<Lancamento> response = repository.findById(id);
		
		assertTrue(response.isPresent());
//		assertEquals(HISTORICO, response.get().getHistorico());
	}
}

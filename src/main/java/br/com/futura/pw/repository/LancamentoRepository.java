package br.com.futura.pw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.futura.pw.entity.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}

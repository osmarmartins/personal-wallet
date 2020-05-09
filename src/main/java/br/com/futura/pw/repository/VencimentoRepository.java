package br.com.futura.pw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.futura.pw.entity.Vencimento;

@Repository
public interface VencimentoRepository extends JpaRepository<Vencimento, Long>{

}

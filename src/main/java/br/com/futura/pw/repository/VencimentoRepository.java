package br.com.futura.pw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.futura.pw.entity.Parcela;

@Repository
public interface VencimentoRepository extends JpaRepository<Parcela, Long>{

}

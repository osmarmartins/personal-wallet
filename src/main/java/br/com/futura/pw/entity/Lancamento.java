package br.com.futura.pw.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.futura.pw.enums.SituacaoLancamento;
import lombok.Data;

@Entity
@Table(name = "lancamento")
@Data
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 5757863752821074596L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate data;
	
	@Column(length = 100)
	private String historico;
	
	@Enumerated(EnumType.STRING)
	private SituacaoLancamento situacao;
	
	@OneToMany(mappedBy = "lancamento")
	private List<Vencimento> vencimentos;

}

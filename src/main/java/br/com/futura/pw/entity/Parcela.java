package br.com.futura.pw.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "vencimento")
@Data
public class Parcela implements Serializable {
	
	private static final long serialVersionUID = -116030643637690486L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String parcela;
	
	private LocalDate vencimento;
	
	private BigDecimal valor;
	
	private LocalDate liquidacao;

	@ManyToOne
	@JoinColumn(name = "id_lancamento")
	private Lancamento lancamento;
	
	

}

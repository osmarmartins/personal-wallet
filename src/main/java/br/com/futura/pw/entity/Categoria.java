package br.com.futura.pw.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Categoria implements Serializable {

	private static final long serialVersionUID = -6697486574583006706L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 30)
	private String descricao;
	
	@Column(length = 200)
	private String imagem;

}

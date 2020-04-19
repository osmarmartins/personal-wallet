package br.com.futura.pw.dto;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class CategoriaDTO {
	
	private Long id;
	
	@Length(min=3, max=100, message = "Descrição deve conter entre 3 e 100 caracteres")
	private String descricao;
	
	private String imagem;

}

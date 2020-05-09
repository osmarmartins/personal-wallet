package br.com.futura.pw.enums;

public enum SituacaoLancamento {
	
	EM_ABERTO("Em aberto"), 
	LIQUIDADO("Liquidado"),
	BAIXADO("Baixa (s/ Financeiro)"),
	CANCELADO("Cancelado");
	
	private String descricao;

	private SituacaoLancamento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}

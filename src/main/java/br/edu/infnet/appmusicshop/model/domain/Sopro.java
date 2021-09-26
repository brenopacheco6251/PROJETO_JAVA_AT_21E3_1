package br.edu.infnet.appmusicshop.model.domain;

import br.edu.infnet.appmusicshop.model.exceptions.ItensZeradosException;

public class Sopro extends Instrumento {
	
	private boolean estojo;
	private String afinacao;
	private int itensInclusos;
	
	public Sopro(String nome, float valor, int codigo) {
		super(nome, valor, codigo);
	}
	
	@Override
	public float descontoBr() {
		return getValor() + (estojo ? (15 * valor / 100 ) : 0) + 0.05f * itensInclusos; // TODO Implementar algoritmo		
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(estojo ? "Pabrão" : "Extra luxo");
		sb.append(";");
		sb.append(afinacao);
		sb.append(";");
		sb.append(itensInclusos);
		
		return sb.toString();
	}

	public boolean isEstojo() {
		return estojo;
	}

	public void setEstojo(boolean estojo) {
		this.estojo = estojo;
	}

	public String getAfinacao() {
		return afinacao;
	}

	public void setAfinacao(String afinacao) {
		this.afinacao = afinacao;
	}

	public int getItensInclusos() {
		return itensInclusos;
	}

	public void setItensInclusos(int itensInclusos) throws ItensZeradosException {
		
		if(itensInclusos <= 0) {
			throw new ItensZeradosException("Impossível calcular o valor com a quantidade de itens zerados!!!");		
		}
		this.itensInclusos = itensInclusos;
	}




}

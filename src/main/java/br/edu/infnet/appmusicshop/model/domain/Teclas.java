package br.edu.infnet.appmusicshop.model.domain;

import br.edu.infnet.appmusicshop.model.exceptions.QuantidadeTeclasZeradasException;

public class Teclas extends Instrumento {
	
	private boolean digital;
	private String distribuidor;	  
	private int quantidadeTeclas;
 
	public Teclas(String nome, float valor, int codigo) {
		super(nome, valor, codigo);
	}

	@Override
	public float descontoBr() {
		
		return getValor() - (digital ? (15 * valor / 100 ) : 0)  + 0.05f * quantidadeTeclas; 
								//      (15 * 4500  / 100    )  + 0.05 * 61	
		
								// 675 // 678.05
	}  
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(digital ? "Piano Digital" : "Piano Acústico");
		sb.append(";");
		sb.append(distribuidor);
		sb.append(";");
		sb.append(quantidadeTeclas);
		
		return sb.toString();
	}

	public boolean isDigital() {
		return digital;
	}

	public void setDigital(boolean digital) {
		this.digital = digital;
	}

	public String getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}

	public int getQuantidadeTeclas() {
		return quantidadeTeclas;
	}

	public void setQuantidadeTeclas(int quantidadeTeclas) throws QuantidadeTeclasZeradasException {
		
		if(quantidadeTeclas <= 0) {
			
			throw new QuantidadeTeclasZeradasException("Impossível calcular desconto com a quantidade de teclas zerada!!!");			
		}
		this.quantidadeTeclas = quantidadeTeclas;
	}	
}

package br.edu.infnet.appmusicshop.model.domain;

import br.edu.infnet.appmusicshop.model.exceptions.PesoNegativoException;

public class Cordas extends Instrumento {
	
	private boolean nacional;
	private String fabricante;
	private String modelo;
	private float peso;
	
	
	public Cordas(String nome, float valor, int codigo) {
		super(nome, valor, codigo);
		
	}

	@Override
	public float descontoBr() {
	
		return getValor() - (nacional ? (15 * valor / 100 ) : 0) + 0.05f * peso; // TODO Implementar algoritmo
	                       
	} 
	
	//// ********************* -05:25 *************************************

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(nacional ? "madeInBrazil" : "madeOutCountry");
		sb.append(";");
		sb.append(fabricante);
		sb.append(";");
		sb.append(peso);
		sb.append(";");
		sb.append(descontoBr());
		
		return sb.toString();
	}
	
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isNacional() {
		return nacional;
	}

	public void setNacional(boolean nacional) {
		this.nacional = nacional;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) throws PesoNegativoException {
		
		if(peso <= 0) {
			throw new PesoNegativoException("Impossível calcular desconto e frete com peso zerado!!!");
		}
		this.peso = peso;
	}
	
	

}


//01:03
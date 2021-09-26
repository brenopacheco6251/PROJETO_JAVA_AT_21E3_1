package br.edu.infnet.appmusicshop.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Venda {
	
	private String descricao;
	private LocalDateTime data;
	private boolean web;
	private Cliente cliente;
	private List<Instrumento> instrumentos;
	
	public Venda() {
		data = LocalDateTime.now();
	}
	 
	@Override
	public String toString() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		StringBuilder sb = new StringBuilder();
		sb.append(descricao);
		sb.append(";");
		sb.append(data.format(formato));
		sb.append(";");
		sb.append(web ? "web" : "loja");
		sb.append(";");
		sb.append(cliente.toString());
		sb.append(";");
		if(instrumentos !=null) {
			sb.append(instrumentos.size());	
		}
		
		return sb.toString();
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isWeb() {
		return web;
	}

	public void setWeb(boolean web) {
		this.web = web;
	}

	public List<Instrumento> getInstrumentos() {
		return instrumentos;
	}

	public void setInstrumentos(List<Instrumento> instrumentos) {
		this.instrumentos = instrumentos;
	}
	
	

}

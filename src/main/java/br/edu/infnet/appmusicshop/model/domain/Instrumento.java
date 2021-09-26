package br.edu.infnet.appmusicshop.model.domain;


public abstract class Instrumento {
	
	private String nome;
	protected float valor;
	private int codigo;
	private boolean lefthanded;
	
	
		public Instrumento(String nome, float valor, int codigo) {
		this.nome = nome;
		this.valor = valor;
		this.codigo = codigo;
	}
		
//	public abstract float calcularValor();
//	public abstract String relatorio();
//	public abstract int qtdeProdutosVendidos();
	public abstract float descontoBr();
	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(valor);
		sb.append(";");
		sb.append(codigo);
		
		return sb.toString();
	}

	public String getNome() {
		return nome;
	}

	public float getValor() {
		return valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public boolean isLefthanded() {
		return lefthanded;
	}

}

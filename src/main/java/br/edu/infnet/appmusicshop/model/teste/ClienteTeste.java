package br.edu.infnet.appmusicshop.model.teste;

import br.edu.infnet.appmusicshop.model.domain.Cliente;

public class ClienteTeste {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("Paulo", "123456789-12", "paulo@paulo.com");
		System.out.println(cliente);
	}
	

}

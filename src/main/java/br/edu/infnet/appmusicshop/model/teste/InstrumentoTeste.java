package br.edu.infnet.appmusicshop.model.teste;

import br.edu.infnet.appmusicshop.model.domain.Cordas;
import br.edu.infnet.appmusicshop.model.domain.Sopro;
import br.edu.infnet.appmusicshop.model.domain.Teclas;
import br.edu.infnet.appmusicshop.model.exceptions.ItensZeradosException;
import br.edu.infnet.appmusicshop.model.exceptions.PesoNegativoException;
import br.edu.infnet.appmusicshop.model.exceptions.QuantidadeTeclasZeradasException;

public class InstrumentoTeste {
	
	public static void main(String[] args) {
		
		try {
			Cordas acustico = new Cordas("viola 10 cordas", 2500, 123);
			acustico.setFabricante("Giannini");
			acustico.setNacional(false);
			acustico.setPeso(110);
			System.out.println(acustico); // Exibe toString
			
		} catch (PesoNegativoException e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			Cordas nylon = new Cordas("classico", 2000, 354);
			nylon.setFabricante("Tagima");
			nylon.setNacional(false );
			nylon.setPeso(550);
			System.out.println("Valor venda: " + nylon.descontoBr()); // Exibe valor metodo abstract
		} catch (PesoNegativoException e) {
			System.out.println(e.getMessage());
		}
		
				
		Teclas sintetizador = new Teclas("PX-5S", 5500, 6598);
		try {
			sintetizador.setDistribuidor("RoyalMusic"); 
			sintetizador.setDigital(false);
			sintetizador.setQuantidadeTeclas(88);
			System.out.println(sintetizador);
		} catch (QuantidadeTeclasZeradasException e) {
			System.out.println(e.getMessage());
		}		
		
		Teclas workstation = new Teclas("psr-sx900", 4500, 2356);
		try {
			//////////////////////////// **************************************
			workstation.setDistribuidor("TeclaCenter");
			workstation.setDigital(false);
			workstation.setQuantidadeTeclas(61);
			System.out.println("Valor venda: " + workstation.descontoBr());
		} catch (QuantidadeTeclasZeradasException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Sopro saxofone = new Sopro("Saxofone Tenor", 9600, 326);
			saxofone.setAfinacao("SIb");
			saxofone.setEstojo(true);
			saxofone.setItensInclusos(10);
			System.out.println(saxofone);
		} catch (ItensZeradosException e) {
			System.out.println(e.getMessage());		
		}			
		
		try {
			Sopro trompete = new Sopro("Pocket Trumpet", 4500, 659);
			trompete.setAfinacao("DÓ");
			trompete.setEstojo(false);
			trompete.setItensInclusos(3);
			System.out.println("Valor venda: " + trompete.descontoBr());
		} catch (ItensZeradosException e) {
			System.out.println(e.getMessage());
			
		}
	}
}

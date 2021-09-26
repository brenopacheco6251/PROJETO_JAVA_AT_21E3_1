package br.edu.infnet.appmusicshop.model.teste;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appmusicshop.model.domain.Cliente;
import br.edu.infnet.appmusicshop.model.domain.Cordas;
import br.edu.infnet.appmusicshop.model.domain.Instrumento;
import br.edu.infnet.appmusicshop.model.domain.Sopro;
import br.edu.infnet.appmusicshop.model.domain.Teclas;
import br.edu.infnet.appmusicshop.model.domain.Venda;
import br.edu.infnet.appmusicshop.model.exceptions.ItensZeradosException;
import br.edu.infnet.appmusicshop.model.exceptions.PesoNegativoException;
import br.edu.infnet.appmusicshop.model.exceptions.QuantidadeTeclasZeradasException;

public class VendaTeste {
	
	public static void main(String[] args) {
		
		List<Instrumento> listaOutlet = new ArrayList<Instrumento>();		
		List<Instrumento> listaPromoDia = new ArrayList<Instrumento>();
				
		Cliente cliente = new Cliente("Paulo", "123456789-12", "paulo@paulo.com");
		
		Teclas piano = new Teclas("Piano de Calda", 23900, 4878);
		try {			
			piano.setQuantidadeTeclas(88);
			piano.setDistribuidor("Yamaha");
			piano.setDigital(false);			
		} catch (QuantidadeTeclasZeradasException e) {
			System.out.println(e.getMessage());
		}
		listaOutlet.add(piano);
						
		Cordas guitarra = new Cordas("Les Paul", 6900, 4569);
		try {		
				guitarra.setFabricante("PRS");
				guitarra.setModelo("Classic");
				guitarra.setNacional(false);
				guitarra.setPeso(1000);
				listaPromoDia.add(guitarra);
			} catch (PesoNegativoException e) {
				System.out.println(e.getMessage());
		 }
		
		Cordas cavaco = new Cordas("Zeca Pagodinho", 1500, 6258); // TODO Exception
		try {					
				cavaco.setFabricante("Giannini");
				cavaco.setModelo("estudante");
				cavaco.setNacional(true);
				cavaco.setPeso(100);
				listaPromoDia.add(cavaco);
				
			} catch (PesoNegativoException e) {
				System.out.println(e.getMessage());
			}
				
		
		
		Sopro trompete = new Sopro("Pocket Trumpet", 4500, 659);
		try {			
			trompete.setAfinacao("DÓ");
			trompete.setEstojo(false);
			trompete.setItensInclusos(3);
			listaPromoDia.add(trompete);
		} catch (ItensZeradosException e) {
			System.out.println(e.getMessage());
		}
	 		
		Venda outlet = new Venda();
		outlet.setDescricao("Violao");
		outlet.setWeb(true);
		outlet.setCliente(cliente);
		outlet.setInstrumentos(listaOutlet);
		System.out.println(outlet);
		
		Venda promoDia = new Venda();
		promoDia.setDescricao("Cavaco");
		promoDia.setWeb(true);
		promoDia.setCliente(cliente);
		promoDia.setInstrumentos(listaPromoDia); 
		System.out.println(promoDia);
	}
}


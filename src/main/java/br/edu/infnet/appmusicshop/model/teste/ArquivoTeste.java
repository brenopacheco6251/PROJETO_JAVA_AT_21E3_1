package br.edu.infnet.appmusicshop.model.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

public class ArquivoTeste {

	public static void main(String[] args) {
		
		String dir = "C:/loja_vendas/";
		String arq = "loja_vendas.txt";
		
		try {
			
			try {
				FileReader file = new FileReader(dir+arq);				
				BufferedReader leitura = new BufferedReader(file);
				
				FileWriter fileW = new FileWriter(dir+"out_"+arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				String linha = null;
				String[] campos;
				
				linha = leitura.readLine();							
				
				List<Instrumento> instrumentos = new ArrayList<Instrumento>();
				Venda promocao = new Venda();
				
				while(linha != null) {
					
					campos = linha.split(";");
					 
					if(campos.length == 5) {
						Cliente cliente = new Cliente(
								campos[2],
								campos[3],
								campos[4]
							);
												
						promocao.setDescricao(campos[0]);
						promocao.setWeb(Boolean.valueOf(campos[1]));
						promocao.setCliente(cliente);
																		
					} else {
						
					}
					
					switch (campos[0]) {
					case "C":
						
						Cordas cordas = new Cordas(
								campos[1],
								Float.valueOf(campos[2]),
								Integer.valueOf(campos[3])
							);
						
						try {
							cordas.setNacional(Boolean.valueOf(campos[4]));
							cordas.setFabricante(campos[5]);
							cordas.setPeso(Float.valueOf(campos[6]));
							
							instrumentos.add(cordas);
							
						} catch (NumberFormatException | PesoNegativoException e) {
							System.out.println(e.getMessage());
						}
						
						break;
			 		
					case "T":
												
						Teclas teclas = new Teclas(
								campos[1],
								Float.valueOf(campos[2]),
								Integer.valueOf(campos[3])
							);
						
						try {
							teclas.setDigital(Boolean.valueOf(campos[4]));
							teclas.setDistribuidor(campos[5]);
							teclas.setQuantidadeTeclas(Integer.valueOf(campos[6]));
							
							instrumentos.add(teclas);	
							
						} catch (NumberFormatException | QuantidadeTeclasZeradasException e) {
							System.out.println(e.getMessage());
						}
						break;
						
					case "S":
						Sopro sopro = new Sopro(
								campos[1],
								Float.valueOf(campos[2]),
								Integer.valueOf(campos[3])
							);
						
						try {
							sopro.setAfinacao(campos[4]);
							sopro.setEstojo(Boolean.valueOf(campos[5]));
							sopro.setItensInclusos(Integer.valueOf(campos[6]));
							
							instrumentos.add(sopro);
							
						} catch (NumberFormatException | ItensZeradosException e) {
							System.out.println(e.getLocalizedMessage());
						}
						
						break;

					default:
						System.out.println("Venda sem tipo!!!");
						break;
					}

					linha = leitura.readLine();
				}
				
				promocao.setInstrumentos(instrumentos);

				//System.out.println(promocao);
				for(Instrumento itemVenda : promocao.getInstrumentos()) {
					//System.out.println(itemVenda);
					escrita.write(
							promocao.getDescricao() +";"+
							promocao.getCliente().getNome()+";"+
							itemVenda.getNome() +";"+
							itemVenda.descontoBr()+"\r\n"
						);
				}
			
				leitura.close();
				file.close();
				
				escrita.close();
				fileW.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		} finally {
			System.out.println("Processamento realizado!!!");
		}
	}
}
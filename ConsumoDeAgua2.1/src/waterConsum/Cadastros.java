package waterConsum;

import java.awt.TextArea;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class Cadastros {
	//Definição de todos os métodos que são usados na manipulação dos cadaastros(Objetos da Classe Imovel)
	
	
	public static void AdicionarListasNaChave(HashMap<String, ArrayList<Imovel>> mapa, String listaEstados[]) throws Exception {
		//Método usado somente uma vez | Adiciona todas as chaves de Estados dentro do HashMap
		try {
		for(int  i=0; i < listaEstados.length; i++) {
			mapa.put(listaEstados[i], new ArrayList<Imovel>());
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível adicionar o elemento à lista");
		}	
	}
	
	public static boolean adicionarImovel(HashMap<String, ArrayList<Imovel>> mapa, Imovel cliente) {
		//Recebe um Objeto da classe Imovel e adiciona no Arraylist
		try {
			mapa.get(cliente.getEstado()).add(cliente);
			return true;
		} catch(Exception n) {
			return false;
		}
		
	}

	public static boolean removerImovel(HashMap<String, ArrayList<Imovel>> mapa ,String logradouro, int numero, String cidade, String estado) {
		//Recebe alguns dados referente a um endereço e realiza a remoção, se existir, do Objeto imóvel dentro do HashMap
		ArrayList<Imovel> list = (ArrayList<Imovel>) mapa.get(estado);
		Iterator<Imovel> it = list.iterator();
		boolean operationComplete = false;
		
		while(it.hasNext()) {
			Imovel temp = it.next();
			if (temp.getLogradouro().equalsIgnoreCase(logradouro) && temp.getNumero()== numero && temp.getCidade().equalsIgnoreCase(cidade)){
				it.remove();
				operationComplete = true;
			}
		}
		if (operationComplete == false) {
			return false;
		} else {
			return true;
		}	
	}
	
	public static boolean verificarExistenciaCadastro(HashMap<String, ArrayList<Imovel>> mapa, Imovel cadastro) {
		//Metodo usado para verifar se um determinado Imovel já existe no Hashmap com os mesmos dados
		ArrayList<Imovel> list = (ArrayList<Imovel>) mapa.get(cadastro.getEstado());
		
		if (list.isEmpty() == true) {
			return false;
		}
		
		Iterator<Imovel> it = list.iterator();
		boolean exist = false;
		
		while(it.hasNext()) {
			Imovel temp = it.next();
			if (temp.getLogradouro().equalsIgnoreCase(cadastro.getLogradouro()) && temp.getNumero() == cadastro.getNumero() && temp.getCidade().equalsIgnoreCase(cadastro.getCidade())) {
				exist = true;
			}
		} 
		if (exist == false) {
			return false;
		} else {
			return true;
		}	
	}
	
	public static void mostrarCadastros(HashMap<String, ArrayList<Imovel>> mapa, String UF) {
		//NO TERMINAL | Mostra dados de todos os objetos da Classe Imovel que estão cadastrados em denterminada chave
		ArrayList<Imovel> list = (ArrayList<Imovel>) mapa.get(UF);
		if(list.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não existem Imóveis cadastrados para esse Estado");
		}
		Iterator<Imovel> it = list.iterator();
		int n = 1;
		while(it.hasNext()) {
			Imovel temp = it.next();

			System.out.println("________________________________________________________");
			System.out.println("Cadastro Nº                  " + n );
			System.out.println("Tipo de Residência:          " + temp.getTipoResidencia());
			System.out.println("Logradouro:                  " + temp.getLogradouro() );
			System.out.println("Numero:                      " + temp.getNumero());
			System.out.println("Cidade:                      " + temp.getCidade());
			System.out.println("Número de Moradores:         " + temp.getNum_moradores());
			System.out.println("Consumo de Água:             " + temp.getCons_Agua() + "  m3");
			System.out.println("Consumo Médio por Habitante: " + temp.getConsMedio() + " m3");
			System.out.println("________________________________________________________");
			n++;
		} 	
	}
	
	public static void mostrarCadastros(HashMap<String, ArrayList<Imovel>> mapa, String UF, TextArea campo) {
		////NO JFRAME | Mostra dados de todos os objetos da Classe Imovel que estão cadastrados em denterminada chave
		ArrayList<Imovel> list = (ArrayList<Imovel>) mapa.get(UF);
		if(list.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não existem Imóveis cadastrados para esse Estado");
		} else {
			Iterator<Imovel> it = list.iterator();
			int n = 1;
			while(it.hasNext()) {
				Imovel temp = it.next();
	
				campo.append("________________________________________________________"    + "\n"  );
				campo.append("Cadastro Nº                  " + n                           + "\n"  );
				campo.append("Tipo de Residência:          " + temp.getTipoResidencia()    + "\n"  );
				campo.append("Logradouro:                  " + temp.getLogradouro()        + "\n"  );
				campo.append("Numero:                      " + temp.getNumero()            + "\n"  );
				campo.append("Cidade:                      " + temp.getCidade()            + "\n"  );
				campo.append("Número de Moradores:         " + temp.getNum_moradores()     + "\n"  );
				campo.append("Consumo de Água:             " + temp.getCons_Agua() + "  m3"+ "\n"  );
				campo.append("Consumo Médio por Habitante: " + temp.getConsMedio() + " m3" + "\n"  );
				//campo.append("________________________________________________________"    + "\n"  );
				n++;
			} 	
		}
	}
	
	public static void mostrarConsumoMedioMorador(HashMap<String, ArrayList<Imovel>> mapa) {
		//NO TERMINAL | Mostra a relação de consumo medio de agua em cada Chave do Hashmap | ConsumoAgua/TotalHabitantes = ConsumoMedio
		boolean allEmpty = true;
		for (String estado : mapa.keySet()) {
			
			if(mapa.get(estado).isEmpty() != true) {
				allEmpty = false;
				
				int totalMoradoresUF = 0;
				double consumoTotalUF = 0;
				
				ArrayList<Imovel> temp = mapa.get(estado);
				for(Imovel cadastro : temp) {
					totalMoradoresUF += cadastro.getNum_moradores();
					consumoTotalUF += cadastro.getCons_Agua();
				}
				if(totalMoradoresUF == 0) {
					System.out.println("Estado: " + estado + " | Consumo Médio por Habitante: " + 0 + " m3");
				} else {
				System.out.println("Estado: " + estado + " | Consumo Médio por Habitante: " + (double)consumoTotalUF/totalMoradoresUF + " m3");
				}
			} 
				
		}
		
		if (allEmpty == true) {
			System.out.println("Não existem Imóveis cadastrados");
			
	}
		
}
		
	public static void mostrarConsumoMedioMorador(HashMap<String, ArrayList<Imovel>> mapa, TextArea Campo) {
		//NO JFRAME | Mostra a relação de consumo medio de agua em cada Chave do Hashmap | ConsumoAgua/TotalHabitantes = ConsumoMedio
		boolean allEmpty = true;
		for (String estado : mapa.keySet()) {
			
			if(mapa.get(estado).isEmpty() != true) {
				allEmpty = false;
				
				int totalMoradoresUF = 0;
				double consumoTotalUF = 0;
				
				ArrayList<Imovel> temp = mapa.get(estado);
				for(Imovel cadastro : temp) {
					totalMoradoresUF += cadastro.getNum_moradores();
					consumoTotalUF += cadastro.getCons_Agua();
				}
				if(totalMoradoresUF == 0) {
					Campo.append("Estado: " + estado + " | Consumo Médio por Habitante: " + 0 + " m3" + "\n");
				} else {
				Campo.append("Estado: " + estado + " | Consumo Médio por Habitante: " + (double)consumoTotalUF/totalMoradoresUF + " m3" + "\n");
				}
			} 
				
		}
		
		if (allEmpty == true) {
			JOptionPane.showMessageDialog(null, "Não existem Imóveis cadastrados");
			
			
	}
		
}
	
	public static void mostrarPercentualCadastros(HashMap<String, ArrayList<Imovel>> mapa) {
		//NO TERMINAL | Com base no total de cadastros, mostra a distribuição percentual por chave no HashMap
		int totalCadastros = 0;
		int cadastrosUF = 0;
		
		
		for (String estado : mapa.keySet()) {
				
				ArrayList<Imovel> temp = mapa.get(estado);
				totalCadastros += temp.size(); 
				
		}
				
		for (String Estado : mapa.keySet()) {
			cadastrosUF = 0;		
			ArrayList<Imovel> temp = mapa.get(Estado);
			Iterator<Imovel> it = temp.iterator();
			while(it.hasNext()) {
				it.next();
				cadastrosUF++;
			}
			if (totalCadastros == 0) {
				System.out.println("Percentual de cadastros | Estado: " + Estado + " | " + 0 + "  %");	
			} else {
		System.out.println("Percentual de cadastros | Estado: " + Estado + " | " + (double)cadastrosUF/totalCadastros*100 + "  %");	
			}
		}
		
	}
	
	public static void mostrarPercentualCadastros(HashMap<String, ArrayList<Imovel>> mapa, TextArea Campo) {
		//NO JFRAME | Com base no total de cadastros, mostra a distribuição percentual por chave no HashMap
		int totalCadastros = 0;
		int cadastrosUF = 0;
		
		
		for (String estado : mapa.keySet()) {
				
				ArrayList<Imovel> temp = mapa.get(estado);
				totalCadastros += temp.size(); 
				
		}
				
		for (String Estado : mapa.keySet()) {
			cadastrosUF = 0;		
			ArrayList<Imovel> temp = mapa.get(Estado);
			Iterator<Imovel> it = temp.iterator();
			while(it.hasNext()) {
				it.next();
				cadastrosUF++;
			}
			if (totalCadastros == 0) {
				Campo.append("Percentual de cadastros | Estado: " + Estado + " | " + 0 + "  %" + "\n");	
			} else {
		Campo.append("Percentual de cadastros | Estado: " + Estado + " | " + (double)cadastrosUF/totalCadastros*100 + "  %" + "\n");	
			}
		}
		
	}
			
	public static void mostrarTipoMaisConsumidor(HashMap<String, ArrayList<Imovel>> mapa) {
		//Retorna o tipo de imóvel com maior consumo médio de água
		ArrayList<String> todosTiposImovel = new ArrayList<String>();
		
		// Consulta em todos os imoveis cadastrados o seu tipo e adiciona no ArrayList 'todosTiposImovel 
		for (String estado : mapa.keySet()) {
			
			if(!mapa.get(estado).isEmpty()) {
				
				ArrayList<Imovel> temp = mapa.get(estado);
				for (Imovel cadastro : temp ) {
					if (!todosTiposImovel.contains(cadastro.getTipoResidencia())){
						todosTiposImovel.add(cadastro.getTipoResidencia());
					}
				}
			}
		}
			
			
		HashMap<String, Double> consumoMedioTipo = new HashMap<String, Double>();
		
		for (String tipo : todosTiposImovel) {
			int totalHabitantesTipo = 0;
			int totalConsumoTipo = 0;
			for (String estado : mapa.keySet()) {
				ArrayList<Imovel> temp = mapa.get(estado);
				
				for (Imovel cadastro : temp) {
					if (cadastro.getTipoResidencia().equals(tipo)) {
						totalHabitantesTipo += cadastro.getNum_moradores();
						totalConsumoTipo += cadastro.getCons_Agua();
					}
				}
				if (totalHabitantesTipo == 0){
					consumoMedioTipo.put(tipo, 0.0);
				} else {
				consumoMedioTipo.put(tipo, (double)totalConsumoTipo/totalHabitantesTipo);
				}
			}
		}
		
		ArrayList<String> ListaTipoMaiorConsumoMedio = new ArrayList<String>();
		String TipoMaiorConsumidorMedio = null;
		double MaiorConsumoMedioTipo = -1.0;
		
		for (String tipo : consumoMedioTipo.keySet()) {
			if (consumoMedioTipo.get(tipo) == MaiorConsumoMedioTipo ) {
				ListaTipoMaiorConsumoMedio.add(tipo);
			}
			if(consumoMedioTipo.get(tipo) > MaiorConsumoMedioTipo) {
				ListaTipoMaiorConsumoMedio.clear();
				TipoMaiorConsumidorMedio = tipo;
				ListaTipoMaiorConsumoMedio.add(tipo);
				
				MaiorConsumoMedioTipo = consumoMedioTipo.get(tipo);
				
			}
		}
		
		if(ListaTipoMaiorConsumoMedio.isEmpty()){
			JOptionPane.showMessageDialog(null, "Não Existem Imoveis Cadastrados");
			
		} else if(ListaTipoMaiorConsumoMedio.size() == 1){
			JOptionPane.showMessageDialog(null, "O tipo de Imóvel com maior consumo médio é o " + TipoMaiorConsumidorMedio + " | Consumo Médio por Habitante: " + MaiorConsumoMedioTipo + " m3");
		} else {
			String temp = "";
			System.out.println("Os tipos de Imóvel com maior consumo médio são: "); 
			for (String tipo : ListaTipoMaiorConsumoMedio) {
				System.out.println("> " + tipo);
				temp+= tipo + " | ";
			}
			JOptionPane.showMessageDialog(null, "Os tipos de Imóvel com maior consumo médio são: \n" + temp + "\nConsumo Médio por Habitante: " + MaiorConsumoMedioTipo + " m3");
			
		}
			

		/*
		ArrayList<Imovel> listaImovelMaisConsumidor = new ArrayList<Imovel>();
		listaImovelMaisConsumidor.add(ImovelMaisConsumidor);
		
		Iterator<Imovel> it;
		
		for (String estado : mapa.keySet()) {
				
				if(mapa.get(estado).isEmpty() == false) {
					ArrayList<Imovel> temp = mapa.get(estado);
					it = temp.iterator();
			

					while(it.hasNext()) {
						Imovel Cadastro = it.next();
						if (Cadastro.getConsMedio() == ImovelMaisConsumidor.getConsMedio()) {
							listaImovelMaisConsumidor.add(Cadastro);
						}
						
						
						if (Cadastro.getConsMedio() > ImovelMaisConsumidor.getConsMedio()){
							listaImovelMaisConsumidor.clear();
							ImovelMaisConsumidor = Cadastro;
							listaImovelMaisConsumidor.add(ImovelMaisConsumidor);
							}
					}
				}

	}
		if(ImovelMaisConsumidor.getEstado().equals("-")) {
			System.out.println("Ainda não existem Imóveis Cadastrados");
		} else if(listaImovelMaisConsumidor.size() == 1) {
			System.out.println("Imovel de Maior Consumo Médio Por Habitante : ");
			System.out.println("Endereço: " + ImovelMaisConsumidor.getEndereco());
			System.out.println("Consumo Médio por Morador: " + ImovelMaisConsumidor.getConsMedio() + " m3");
		} else {
			System.out.println("Imóveis de Maior Consumo Médio Por Habitante : ");
			for(Imovel casa : listaImovelMaisConsumidor) {
				
				System.out.println("Endereço: " + casa.getEndereco());
				System.out.println("Consumo Médio por Morador: " + casa.getConsMedio() + " m3");
				System.out.println("__________________________________________________________________________________________________");
			}
		} */
			
}
	
}
	

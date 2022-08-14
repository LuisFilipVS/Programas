package waterConsum;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;




@SuppressWarnings("serial")
public class main implements Serializable {

	public static void main(String[] args) throws Exception {
	
		HashMap<String, ArrayList<Imovel>> cadastros = new HashMap<String, ArrayList<Imovel>>();
		
		String[] listaEstados = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MG","MS","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SE","SP","TO"};
		Cadastros.AdicionarListasNaChave(cadastros, listaEstados);
		
		
		//Carregar Dados Salvos
		lerArquivo pag0; //Instanciando o Objeto da classe lerArquivo (Primeira Pag)
		String caminho = "DadosSalvos.txt";   //Localização do arquivo
		
		
		// Inicialização de todo o Programa
		do {
			pag0 = new lerArquivo(cadastros, caminho);
		}
		while(pag0.isActive());
			
		
		//_________________________________________________________________________Janela Principal___________________________________________________
		
			
		
		
		
	
		
		
		
		
		
		
		
		
		
/*		int op = 0;
		
		do {
			op = 0;
			
			System.out.println("+______________________+ Menu +___________________+");
			System.out.println("|1 - Cadastrar Imovel                             |");
			System.out.println("|2 - Remover Imovel                               |");
			System.out.println("|3 - Listar Imoveis Cadastrados por UF            |");
			System.out.println("|4 - Consumo médio p/ morador em cada UF          |");
			System.out.println("|5 - Percentual de imoveis cadastrados            |");
			System.out.println("|6 - Tipo de Imovel com maior consumo Medio       |");
			System.out.println("|7 - Sair                                         |");
			System.out.println("+_________________________________________________+");
			
			System.out.print("\n >> ");
			try {
			op = kb.nextInt();
			
			} catch (Exception e) {
				System.out.println("Insira um numero válido");
				
			}
			kb.nextLine();
			
			String tipoResidencia = null;
			String logradouro = null;
			int numero = 0;
			String cidade = null;
			String estado = null;
			int numMoradores = 0;
			double ConsAgua = 0.0;

			switch (op) {
				case(1):
					boolean verificarCadastro = false;
					
					try {
					//_________________________________________________________________________________
					System.out.println("Tipo de Residência: ");
					tipoResidencia = kb.nextLine();
					//_________________________________________________________________________________
					System.out.println("Logradouro:   ");
					logradouro = kb.nextLine();
					
					//_________________________________________________________________________________
					boolean verificarNumero = false;
					do {
						numero = 0;
						try{
							System.out.println("Numero da Residência:  ");
							numero = kb.nextInt();
							
							verificarNumero = true;
						} catch(Exception e) {
							System.out.println("Insira um Nº de Residência válido!");
						}
					kb.nextLine();
					} while (!verificarNumero);
					
					//_________________________________________________________________________________
					System.out.println("Cidade:                ");
					cidade = kb.nextLine();
					//_________________________________________________________________________________
					boolean verificarEstado = false;
					do {
						System.out.println("Estado:                ");
						estado = kb.nextLine().toUpperCase();
						for (String verificador : listaEstados){
							if (verificador.equals(estado)) {
								verificarEstado = true;
							}
						}
						if (verificarEstado == false) {
							System.out.println("Insira uma sigla de estado Existente!");
						}
					} while(!verificarEstado);
					
					//_________________________________________________________________________________
					
		
					boolean verificarMoradores = false;
					do {
						numMoradores = 0;
						try{
							System.out.println("Quantidade de Moradores");
							numMoradores = kb.nextInt();
							if (numMoradores < 0) {
								System.out.println("Insira um Nº de moradores válido!");
							} else {
								verificarMoradores = true;
							}	
						} catch(Exception e) {
							System.out.println("Insira um Nº de moradores válido!");
						}
					kb.nextLine();
					} while (!verificarMoradores);
					
					
					//_________________________________________________________________________________
					
					
					boolean verificarConsAgua= false;
					do {
						ConsAgua = 0.0;
						try{
							System.out.println("Volume do Consumo(m3)     ");
							ConsAgua = kb.nextDouble();
							if (ConsAgua < 0) {
								System.out.println("Insira um Nº de moradores válido!");
							} else {
								verificarConsAgua = true;
							}	
							
						} catch(Exception e) {
							System.out.println("Insira um Nº de Consumo válido");
						}
					kb.nextLine();
					} while (!verificarConsAgua);
					
					verificarCadastro = true;
					
					} catch (Exception e) {
						System.out.println("Dados informados incorretamente");
					}
				if (verificarCadastro == true) {
					
				Imovel cliente = new Imovel(tipoResidencia, logradouro, numero, cidade, estado, numMoradores, ConsAgua);
					if (Cadastros.verificarExistenciaCadastro(cadastros, cliente) == false){
						if (Cadastros.adicionarImovel(cadastros, cliente) == true) {
							System.out.println("Imovel Cadastrado com sucesso!");
						} else {
							System.out.println("Cadastro não realizado | Já existe um cadastro com os dados informados ");
						}
					}else {
						System.out.println("Cadastro não realizado | Já existe um cadastro com os dados informados ");
					}
				}
					break;
				
				case(2):
					//_________________________________________________________________________________
					
					System.out.println("Insira o nome do Logradouro:    ");
					logradouro = kb.nextLine();
					//_________________________________________________________________________________
					
					System.out.println("Insira o Numero da Residência:  ");
					numero = kb.nextInt();kb.nextLine();
					//_________________________________________________________________________________
					
					System.out.println("Insira a Cidade:                ");
					cidade = kb.nextLine();
					//_________________________________________________________________________________
			
					boolean verificarEstado = false;
					do {
						System.out.println("Estado:                     ");
						estado = kb.nextLine().toUpperCase();
						for (String verificador : listaEstados){
							if (verificador.equals(estado)) {
								verificarEstado = true;
							}
						}
						if (verificarEstado == false) {
							System.out.println("Insira uma sigla de estado Existente!");
						}
					} while(!verificarEstado);
					
					//_________________________________________________________________________________
					
					
					if (Cadastros.removerImovel(cadastros, logradouro, numero, cidade, estado) == true) {
						System.out.println("Cadastro removido com sucesso");
					}else{
						System.out.println("Cadastro não encontrado | Cadastro não removido");
					}
					break;
				
				case(3):
					
					verificarEstado = false;
					do {
						System.out.println("Insira a Sigla do Estado:      ");
						estado = kb.nextLine().toUpperCase();
						for (String verificador : listaEstados){
							if (verificador.equals(estado)) {
								verificarEstado = true;
							}
						}
						if (verificarEstado == false) {
							System.out.println("Insira uma sigla de estado Existente!");
						}
					} while(!verificarEstado);
					
					Cadastros.mostrarCadastros(cadastros, estado);
					break;
					
				case(4):
					Cadastros.mostrarConsumoMedioMorador(cadastros);
					break;
				case(5):
					Cadastros.mostrarPercentualCadastros(cadastros);
					break;
				case(6):
					Cadastros.mostrarTipoMaisConsumidor(cadastros);
					break;
				case(7):
					break;
				default:
					System.out.println("Insira um valor entre 1 e 7!");
					break;
					
			}
			
		}while(op != 7);
		kb.close();
 	*/
		//System.out.println("Programa executado com sucesso!");

	}

	@SuppressWarnings("unused")
	private static ObjectInputStream ObjectInputStream(FileInputStream input) {
		// TODO Auto-generated method stub
		return null;
	}

}

package waterConsum;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

public class Opcao1 extends JFrame {
	/**
		Classe que vai instaciar um objeto JFRAME responsável por cadastrar um Imovel
	 */
	private static final long serialVersionUID = 1L;

	HashMap<String, ArrayList<Imovel>> cadastros;
	
	JFrame janelaOpcao1;
	
	public JLabel tipoResidencia;
	public JTextField TexttipoResidencia;
	
	public JLabel logradouro;
	public JTextField Textlogradouro;
	
	public JLabel numero;
	public JTextField Textnumero;
	
	public JLabel cidade;
	public JTextField TextCidade;
	
	public JLabel estado;
	public JTextField TextEstado;
	
	public JLabel numMoradores;
	public JTextField TextnumMoradores;
	
	public JLabel consAgua;
	public JTextField TextconsAgua;
	
	public JButton botao;
	
	
	//Construtor
	public Opcao1(HashMap<String, ArrayList<Imovel>> cadastros) {
		this.cadastros = cadastros;
		
		janelaOpcao1 = new JFrame("Opcao1");
		
		janelaOpcao1.setSize(500,500);
		janelaOpcao1.setLayout(null);
		
		JLabel titulo = new JLabel("INSIRA OS DADOS DESEJADOS: ");
		titulo.setBounds(30, 5,200,30);
		janelaOpcao1.add(titulo);
		
		
		tipoResidencia = new JLabel("TIPO DE RESIDENCIA: ");
		tipoResidencia.setBounds(30, 30,200,30);
		janelaOpcao1.add(tipoResidencia);
		
		TexttipoResidencia = new JTextField(30);
		TexttipoResidencia.setBounds(230, 30,200,30);
		janelaOpcao1.add(TexttipoResidencia );
		
		logradouro = new JLabel("LOGRADOURO: ");
		logradouro.setBounds(30, 60,200,30);
		janelaOpcao1.add(logradouro);
		
		Textlogradouro = new JTextField(30);
		Textlogradouro.setBounds(230, 60,200,30);
		janelaOpcao1.add(Textlogradouro);
		
		numero = new JLabel("NUMERO DA RESIDENCIA: ");
		numero.setBounds(30, 90,200,30);
		janelaOpcao1.add(numero);
		
		Textnumero = new JTextField(5);
		Textnumero.setBounds(230, 90,200,30);
		janelaOpcao1.add(Textnumero);
		
		
		cidade = new JLabel("CIDADE");
		cidade.setBounds(30, 120,200,30);
		janelaOpcao1.add(cidade);
		
		TextCidade = new JTextField(30);
		TextCidade.setBounds(230, 120,200,30);
		janelaOpcao1.add(TextCidade);
		
		
		estado = new JLabel("ESTADO");
		estado.setBounds(30, 150,200,30);
		janelaOpcao1.add(estado);
		
		TextEstado = new JTextField(2);
		TextEstado.setBounds(230, 150,200,30);
		janelaOpcao1.add(TextEstado);
		
		numMoradores = new JLabel("QUANTIDADE DE MORADORES");
		numMoradores.setBounds(30, 180,200,30);
		janelaOpcao1.add(numMoradores);
		
		TextnumMoradores = new JTextField(2);
		TextnumMoradores.setBounds(230, 180,200,30);
		janelaOpcao1.add(TextnumMoradores);
		
		consAgua = new JLabel("CONSUMO DE AGUA: ");
		consAgua.setBounds(30, 210,200,30);
		janelaOpcao1.add(consAgua);
		
		TextconsAgua = new JTextField(2);
		TextconsAgua.setBounds(230, 210,200,30);
		janelaOpcao1.add(TextconsAgua);
		
		botao = new JButton("CADASTRAR");
		botao.setBounds(300, 400, 150, 30);
		janelaOpcao1.add(botao);
		
		
		botao.addActionListener(new pressionarBotao());
		
		//janelaOpcao1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaOpcao1.setVisible(true);
		
	}
	
	public class pressionarBotao implements ActionListener{
		String tipoResidencia;
		String logradouro;
		int numero;
		String cidade;
		String estado;
		int numMoradores;
		double ConsAgua;
		
		
		boolean verificarNumero;
		boolean verificarEstado;
		boolean verificarMoradores;
		boolean verificarConsAgua;
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String[] listaEstados = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MG","MS","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SE","SP","TO"};
			//Tentativa de realização de cadastro
			try {
			
			
			//___________________________________________________________________________
			verificarNumero = false;
				
			tipoResidencia = TexttipoResidencia.getText();
			logradouro = Textlogradouro.getText();
			
			
			
				numero = 0;
				try{
					
					numero = Integer.parseInt(Textnumero.getText());
					verificarNumero = true;
					
				} catch(Exception exc) {
	
					JOptionPane.showMessageDialog(null, "Insira um Nº de Residência válido!");
				}
		
			
			cidade = TextCidade.getText();
			//_________________________________________________________________________________
			verificarEstado = false;
			
				
				estado = TextEstado.getText().toUpperCase();
				for (String verificador : listaEstados){
					if (verificador.equals(estado)) {
						verificarEstado = true;
					}
				}
				if (verificarEstado == false) {
					
					JOptionPane.showMessageDialog(null, "Insira uma sigla de estado Existente!");
				}
				
			//________________________________________________________________________________
			verificarMoradores = false;
			
				numMoradores = 0;
				try{
					
					numMoradores = Integer.parseInt(TextnumMoradores.getText());
					if (numMoradores < 0) {
						
						JOptionPane.showMessageDialog(null, "Insira um Nº de moradores válido!");
					} else {
						verificarMoradores = true;
					}	
				} catch(Exception exce) {
					
					JOptionPane.showMessageDialog(null, "Insira um Nº de moradores válido!");
				}
			
			
			//_________________________________________________________________________________
			
			verificarConsAgua = false;
			
				ConsAgua = 0.0;
				try{
					ConsAgua = Double.parseDouble(TextconsAgua.getText());
					verificarConsAgua = true;
					
					if (ConsAgua < 0) {
						
						JOptionPane.showMessageDialog(null, "Insira um Nº de Consumo válido!");
					}
					
				} catch(Exception excecao1) {
					
					JOptionPane.showMessageDialog(null, "Insira um Nº de Consumo válido!");
				}
			
			
			
			} catch (Exception excecao2) {
				
				JOptionPane.showMessageDialog(null, "Dados informados incorretamente");
				
			}
		
			
			
			
			
		if ((verificarNumero == true) && (verificarEstado == true) && (verificarMoradores == true) && (verificarConsAgua == true)) {
		//Instanciação do Objeto da Classe Imóvel e adição do mesmo no HashMap
		Imovel cliente = new Imovel(tipoResidencia, logradouro, numero, cidade, estado, numMoradores, ConsAgua);
			if (Cadastros.verificarExistenciaCadastro(cadastros, cliente) == false){
				if (Cadastros.adicionarImovel(cadastros, cliente) == true) {
					janelaOpcao1.setVisible(false);
					JOptionPane.showMessageDialog(null, "Imovel Cadastrado com sucesso!");
				} else {
					janelaOpcao1.setVisible(false);
					JOptionPane.showMessageDialog(null, "Cadastro não realizado | Já existe um cadastro com os dados informados ");
				}
			}else {
				janelaOpcao1.setVisible(false);
				JOptionPane.showMessageDialog(null, "Cadastro não realizado | Já existe um cadastro com os dados informados     ");
			}
		}
				
		}
		
	}
		
	
}

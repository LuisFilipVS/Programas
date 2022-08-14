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

public class Opcao2 extends JFrame {
	/**
	 Classe que vai instanciar um objeto da classe JFRAME, reponsável por remover um cadastro
	 */
	private static final long serialVersionUID = 1L;

	HashMap<String, ArrayList<Imovel>> cadastros;
	
	public JFrame janelaOpcao2;
	
	public JLabel logradouro;
	public JTextField Textlogradouro;
	
	public JLabel numero;
	public JTextField Textnumero;
	
	public JLabel cidade;
	public JTextField TextCidade;
	
	public JLabel estado;
	public JTextField TextEstado;
	
	
	public JButton botao;
	
	
	//Construtor
	public Opcao2(HashMap<String, ArrayList<Imovel>> cadastros) {
		this.cadastros = cadastros;
		
		janelaOpcao2 = new JFrame("Opcao2");
		janelaOpcao2.setSize(500,500);
		janelaOpcao2.setLayout(null);
		
		JLabel titulo = new JLabel("INSIRA OS DADOS PARA EXCLUIR CADASTRO: ");
		titulo.setBounds(30, 10,200,30);
		janelaOpcao2.add(titulo);
		
		
		
		logradouro = new JLabel("LOGRADOURO: ");
		logradouro.setBounds(30, 60,200,30);
		janelaOpcao2.add(logradouro);
		
		Textlogradouro = new JTextField(30);
		Textlogradouro.setBounds(230, 60,200,30);
		janelaOpcao2.add(Textlogradouro);
		
		
		numero = new JLabel("NUMERO DA RESIDENCIA: ");
		numero.setBounds(30, 90,200,30);
		janelaOpcao2.add(numero);
		
		Textnumero = new JTextField(5);
		Textnumero.setBounds(230, 90,200,30);
		janelaOpcao2.add(Textnumero);
		
		
		cidade = new JLabel("CIDADE");
		cidade.setBounds(30, 120,200,30);
		janelaOpcao2.add(cidade);
		
		TextCidade = new JTextField(30);
		TextCidade.setBounds(230, 120,200,30);
		janelaOpcao2.add(TextCidade);
		
		
		estado = new JLabel("ESTADO");
		estado.setBounds(30, 150,200,30);
		janelaOpcao2.add(estado);
		
		TextEstado = new JTextField(2);
		TextEstado.setBounds(230, 150,200,30);
		janelaOpcao2.add(TextEstado);
		
		
		
		botao = new JButton("APAGAR CADASTRO");
		botao.setBounds(300, 400, 150, 30);
		janelaOpcao2.add(botao);
		
		
		botao.addActionListener(new pressionarBotao());
		
		//janelaOpcao1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaOpcao2.setVisible(true);
		
	}
	
	public class pressionarBotao implements ActionListener{
		boolean verificarCadastro;
		String logradouro;
		int numero;
		String cidade;
		String estado;

		
		@Override
		public void actionPerformed(ActionEvent e) {
			String[] listaEstados = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MG","MS","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SE","SP","TO"};
			
			//Tentativa de excluir cadastro
			logradouro = Textlogradouro.getText();
			cidade = TextCidade.getText();
			
			//_________________________________________________________________________________
			boolean verificarNumero = false;
			
				numero = 0;
				try{
					
					numero = Integer.parseInt(Textnumero.getText());
					verificarNumero = true;
					
				} catch(Exception exc) {
	
					JOptionPane.showMessageDialog(null, "Insira um Nº de Residência válido!");
				}
			
			
			//_________________________________________________________________________________
			boolean verificarEstado = false;
		
				
				estado = TextEstado.getText().toUpperCase();
				for (String verificador : listaEstados){
					if (verificador.equals(estado)) {
						verificarEstado = true;
					}
				}
				if (verificarEstado == false) {
					JOptionPane.showMessageDialog(null, "Insira uma sigla de estado Existente!");
				}
			
				
				
				
				
				if(verificarEstado = true && verificarNumero == true) {
					if (Cadastros.removerImovel(cadastros, logradouro, numero, cidade, estado) == true) {
						janelaOpcao2.setVisible(false);
						JOptionPane.showMessageDialog(null, "Cadastro removido com sucesso");
					}else{
						janelaOpcao2.setVisible(false);
						JOptionPane.showMessageDialog(null, "Cadastro não encontrado | Cadastro não removido");
					}
				}
			
			
			
			}
		
	}
		
	
}
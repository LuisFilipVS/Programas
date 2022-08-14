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

public class Opcao3 extends JFrame {
	/**
	Janela que vai instaciar um objeto da classe JFRAME, responsável por mostrar a tela que solicita do usuário um valor de chave (UF do estado)
	para retornar os obejtos da Classe Imóve da Coleção HashMap
	 */
	private static final long serialVersionUID = 1L;


	static HashMap<String, ArrayList<Imovel>> cadastros;
	
	
	public static JLabel estado;
	public JTextField TextEstado;
	
	
	public JButton botao;
	
	JFrame janelaOpcao3;
	
	
	
	@SuppressWarnings("static-access")
	//Construtor
	public Opcao3(HashMap<String, ArrayList<Imovel>> cadastros) {
		this.cadastros = cadastros;
		
		janelaOpcao3 = new JFrame("Opcao3");
		janelaOpcao3.setSize(500,500);
		janelaOpcao3.setLayout(null);
		
		JLabel titulo = new JLabel("INSIRA A SIGLA DO ESTADO PARA MOSTRAR DADOS: ");
		titulo.setBounds(30, 10,200,30);
		janelaOpcao3.add(titulo);
		
		
		estado = new JLabel("ESTADO");
		estado.setBounds(30, 150,200,30);
		janelaOpcao3.add(estado);
		
		TextEstado = new JTextField(2);
		TextEstado.setBounds(230, 150,200,30);
		janelaOpcao3.add(TextEstado);
		
		botao = new JButton("MOSTRAR DADOS");
		botao.setBounds(300, 400, 150, 30);
		janelaOpcao3.add(botao);
		
		
		botao.addActionListener(new pressionarBotao());
		
		//janelaOpcao1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaOpcao3.setVisible(true);
		
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
			

			//Execução do código  que vai tentar mostrar os cadastros(Objetos da Classe Imovel)
			boolean verificarEstado = false;
			
				estado = TextEstado.getText().toUpperCase();
				for (String verificador : listaEstados){
					if (verificador.equals(estado)) {
						verificarEstado = true;
					}
				}
				if (verificarEstado == false) {
					JOptionPane.showMessageDialog(null, "Insira uma sigla de estado Existente!");
					janelaOpcao3.setVisible(false);
				} else {
						janelaOpcao3.setVisible(false);
						//@SuppressWarnings("unused")
						Opcao3_1 pag3_1 = new Opcao3_1(cadastros, estado);
						pag3_1.setVisible(true);
						Cadastros.mostrarCadastros(cadastros, estado);
				}
			
			}
		
	}
		
	
}
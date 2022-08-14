package waterConsum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class PainelPrincipal extends JFrame implements Serializable{
	
	/**
	 Classe que vai instanciar um objeto da classe JFRAME, responsável por  mostrar a segunda Janela do projeto, no qual vai listar 
	 todas a funções que serão executadas com base na escolha do usuário.
	 */
	private static final long serialVersionUID = 1L;
	public RadioButtonHd hd;
	public JRadioButton RD1;
	public JRadioButton RD2;
	public JRadioButton RD3;
	public JRadioButton RD4;
	public JRadioButton RD5;
	public JRadioButton RD6;
	public JRadioButton RD7;
	public ButtonGroup grupo1;
	public HashMap<String, ArrayList<Imovel>> cadastros;
	public String caminho;
	public JButton botao1;
	
	//construtor
	public PainelPrincipal(HashMap<String, ArrayList<Imovel>> cadastros, String caminho) {
		this.cadastros = cadastros;
		this.caminho = caminho;
		
		//Execução da janela
		JFrame janelaPrincipal = new JFrame("Consumo de água");
		janelaPrincipal.setSize(500, 500);
		janelaPrincipal.setLayout(null);
		
		JLabel Rotulo1 = new JLabel("*MENU*");
		Rotulo1.setBounds(250, 10, 50,30);
		janelaPrincipal.add(Rotulo1);
		
		JLabel Rotulo2 = new JLabel("ESCOLHA UMA OPERAÇAO: ");
		Rotulo2.setBounds(30, 50,200,30);
		janelaPrincipal.add(Rotulo2);
		
		
		RD1 = new JRadioButton("Cadastrar Imovel", false);
		RD1.setBounds(30,70,400,30);
		janelaPrincipal.add(RD1);
		
		RD2 = new JRadioButton("Remover Imovel", false);
		RD2.setBounds(30,90,400,30);
		janelaPrincipal.add(RD2);

		RD3 = new JRadioButton("Listar Imoveis Cadastrados por UF ", false);
		RD3.setBounds(30,110,400,30);
		janelaPrincipal.add(RD3);

		RD4 = new JRadioButton("Consumo médio p/ morador em cada UF ", false);
		RD4.setBounds(30,130,400,30);
		janelaPrincipal.add(RD4);

		RD5 = new JRadioButton("Percentual de imoveis cadastrados", false);
		RD5.setBounds(30,150,400,30);
		janelaPrincipal.add(RD5);

		RD6 = new JRadioButton("Tipo de Imovel com maior consumo Medio", false);
		RD6.setBounds(30,170,400,30);
		janelaPrincipal.add(RD6);
		
		RD7 = new JRadioButton("Salvar dados", false);
		RD7.setBounds(30,190,400,30);
		janelaPrincipal.add(RD7);

		grupo1 = new ButtonGroup();
		grupo1.add(RD1);
		grupo1.add(RD2);
		grupo1.add(RD3);
		grupo1.add(RD4);
		grupo1.add(RD5);
		grupo1.add(RD6);
		
		//botao1 = new JButton("SELECIONAR");
		//janelaPrincipal.add(botao1);
		//botao1.setBounds(300, 350, 150, 40);
		
		hd = new RadioButtonHd();
		
		//Adição de escuta para os RadiosButtons
		RD1.addItemListener(hd);
		RD2.addItemListener(hd);
		RD3.addItemListener(hd);
		RD4.addItemListener(hd);
		RD5.addItemListener(hd);
		RD6.addItemListener(hd);
		RD7.addItemListener(hd);
		
		

		
		janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaPrincipal.setVisible(true);
	}



private class RadioButtonHd implements ItemListener{

	
	
	
		public void itemStateChanged(ItemEvent e) {
			
			if (RD1.isSelected() /*&& BotaoPressionado == botao1*/) {
				RD1.setSelected(false);
				@SuppressWarnings("unused")
				Opcao1 opcao1 = new Opcao1(cadastros);
				
			}
			if (RD2.isSelected()) {
				RD2.setSelected(false);
				@SuppressWarnings("unused")
				Opcao2 opcao2 = new Opcao2(cadastros);
			}
			if (RD3.isSelected()) {
				@SuppressWarnings("unused")
				Opcao3 opcao3 = new Opcao3(cadastros);
			}
			if (RD4.isSelected()) {
				Opcao4 opcao4 = new Opcao4(cadastros);
				opcao4.setVisible(true);
			}
			if (RD5.isSelected()) {
				Opcao5 opcao5 = new Opcao5(cadastros);
				opcao5.setVisible(true);
				//Cadastros.mostrarPercentualCadastros(cadastros);
			}
			if (RD6.isSelected()) {
				Cadastros.mostrarTipoMaisConsumidor(cadastros);
			}
			if (RD7.isSelected()) {
				try {
					FileOutputStream output = new FileOutputStream(caminho);
					ObjectOutputStream outputWrite = new ObjectOutputStream(output);
					
					
					outputWrite.writeObject(cadastros);
					
					 /* for (String estado : cadastros.keySet()) {
							ArrayList<Imovel> temp = cadastros.get(estado);
							for (Imovel cadastro : temp ) {
								outputWrite.writeObject(cadastro);
							}
						
					} */
					
					
					 JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
					
					outputWrite.close();
					
					
				}catch(FileNotFoundException exception) {
					JOptionPane.showMessageDialog(null, "Local de salvamento não encontrado");
				}catch(IOException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
					
				
			}

		}
	
		


	}

}
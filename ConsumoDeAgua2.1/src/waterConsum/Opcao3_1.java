package waterConsum;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Opcao3_1 extends JFrame {

	private JPanel contentPane;
	public   HashMap<String, ArrayList<Imovel>> mapa;
	public 	 String UF;

	/**
	 Classe que vai instanciar um objeto da classe JFRAME, responsável por mostrar os dados da chave hashmap, a partir do dado que foi informado na
	 janela Opcao3
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Opcao3_1 frame = new Opcao3_1();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Opcao3_1(HashMap<String, ArrayList<Imovel>> mapa, String UF) {
		this.mapa = mapa;
		this.UF = UF;
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Mostrar Cadastros por Estado | UF : " + UF);
		contentPane.add(lblNewLabel);
		
		TextArea textArea = new TextArea();
		contentPane.add(textArea);
		
		Cadastros.mostrarCadastros(mapa, UF, textArea);
		
		
	}

}

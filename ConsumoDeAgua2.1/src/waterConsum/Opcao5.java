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
public class Opcao5 extends JFrame {

	private JPanel contentPane;
	public   HashMap<String, ArrayList<Imovel>> mapa;

	/**
	 * Classe que Instacia um objeto da classe JFRAME 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Criação da Janela
	 */
	public Opcao5(HashMap<String, ArrayList<Imovel>> mapa) {
		this.mapa = mapa;
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Percentual de cadastros por Estado");
		contentPane.add(lblNewLabel);
		
		TextArea textArea = new TextArea();
		contentPane.add(textArea);
		
		//Chamada do método da classe Cadastros que vai mostrar o percentual de castrados por UF (Relação percentual de objetos por chave do
		//hasmaap por total cadastrado
		Cadastros.mostrarPercentualCadastros(mapa, textArea);
	}

}

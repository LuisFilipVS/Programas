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
public class Opcao4 extends JFrame {

	private JPanel contentPane;
	public   HashMap<String, ArrayList<Imovel>> mapa;
	static TextArea textArea;

	/**
	 * Launch the application.
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
	public Opcao4(HashMap<String, ArrayList<Imovel>> mapa) {
		this.mapa = mapa; 
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Consumo médio/Habitante por UF");
		contentPane.add(lblNewLabel);
		
		textArea = new TextArea();
		contentPane.add(textArea);
		
		//Chamada do método da classe Cadastros que vai mostrar os dados dentro do Objeto da classe TextArea.
		Cadastros.mostrarConsumoMedioMorador(mapa, textArea);
		
		
	}

}

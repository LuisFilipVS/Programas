package waterConsum;


import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextArea;

public class teste extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public   HashMap<String, ArrayList<Imovel>> mapa;
	public 	 String UF;

	/**
	 * Launch the application.
	 */
	


	/**
	 * Create the frame.
	 */
	public teste(HashMap<String, ArrayList<Imovel>> mapa, String UF) {
		this.mapa = mapa;
		this.UF = UF;
		
		
		setTitle("OPÇÃO 4");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MOSTRAR CONSUMO MEDIO POR MORADOR");
		lblNewLabel.setBounds(10, 24, 474, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(10, 49, 200, 470);
		contentPane.add(textArea);
		
		//Cadastros.mostrarCadastros(mapa, UF, textArea);
		
		setVisible(true);
		
		}
		
	}
	


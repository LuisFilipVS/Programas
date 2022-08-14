package waterConsum;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class lerArquivo extends JFrame implements Serializable{
	
	/**
	 Primeira Janela do programa | Solicita ao usuário para responder se deseja iniciar o programa com dados existentes ou a partir de novos dados
	 */
	private static final long serialVersionUID = 1L;
	public JLabel frase;
	public JRadioButton sim, nao;
	public Pressionado press;
	public boolean lerArquivo;
	public JFrame janela;
	
	
	public HashMap<String, ArrayList<Imovel>> cadastros;
	public String localArquivo;
	
	
	//Construtor	
	public lerArquivo(HashMap<String, ArrayList<Imovel>> cadastros, String localArquivo) {
		this.cadastros = cadastros;
		this.localArquivo = localArquivo;
		
		
		janela = new JFrame();
		janela.setSize(500, 500);
		janela.setLayout(null);
		
		press = new Pressionado();
		
		frase = new JLabel("Deseja abrir a partir de um arquivo?");
		frase.setBounds(30,50, 300,30);
		janela.add(frase);
		
		sim = new JRadioButton("SIM", false);
		sim.setBounds(30, 100, 100, 30);
		nao = new JRadioButton("NÃO", false);
		nao.setBounds(30, 130, 100, 30);
		
		janela.add(sim);
		janela.add(nao);
		
		sim.addItemListener(press);
		nao.addItemListener(press);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		
	}

	public FileInputStream input;
	public ObjectInputStream inputObject;



	public boolean getLerArquivo() {
		return lerArquivo;
	}
	public void setLerArquivo(boolean cond) {
		lerArquivo = cond;
	}
	
	


private class Pressionado implements ItemListener{

	@SuppressWarnings("unchecked")
	@Override
	public void itemStateChanged(ItemEvent e) {
		//Trecho de código que vai tentar ler os dados de um arquivo salvo
		if(sim.isSelected()) {
				try {
				input = new FileInputStream(localArquivo);
				inputObject = new ObjectInputStream(input);
				
				
				
				/*Imovel temp = null;
				if (inputObject.readObject() == null){
					JOptionPane.showMessageDialog(null, "Arquivo Vazio");
				}
				while(inputObject.readObject() != null) {
					temp = (Imovel) inputObject.readObject();
					ArrayList<Imovel> temp2 = cadastros.get(temp.getEstado());
					temp2.add(temp);
				} */
				
				
				
				cadastros = (HashMap<String, ArrayList<Imovel>>) inputObject.readObject();
				janela.setVisible(false);
				
				}catch (FileNotFoundException E) {
					JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo |1|  " + E.getMessage());
					janela.setVisible(false);
				}catch (IOException exc) {
					JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo |2|  " + exc.getMessage());
					janela.setVisible(false);
				}
				catch(ClassNotFoundException ex) {
					JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo |3|  " + ex.getMessage());
					janela.setVisible(false);
					
				}
				
				@SuppressWarnings("unused")
				PainelPrincipal pag = new PainelPrincipal(cadastros, localArquivo);
			
			}
		if(nao.isSelected()){
			// Inicialização do programa sem a leitura de dados salvos
			janela.setVisible(false);
			@SuppressWarnings("unused")
			PainelPrincipal pag = new PainelPrincipal(cadastros, localArquivo);
			}
		
		}
	
	
	}
}


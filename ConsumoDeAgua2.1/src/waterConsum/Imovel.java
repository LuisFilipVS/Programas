package waterConsum;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Imovel implements Serializable{
	/*
	  Classe usada para instaciar os objetos que armazenam os dados primitivos de cadastro dos clientes
	 */
	public String tipoResidencia = "";
	public String logradouro = "";
	public int numero = 0;
	public String cidade = "";
	public String estado = "";
	public int num_moradores = 0;
	public double Cons_Agua = 0.0;
	
	
	//Construtor
	public Imovel(String tipoResidencia, String logradouro, int numero, String cidade, String estado, int num_moradores, double Cons_Agua) {
		this.tipoResidencia = tipoResidencia;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.num_moradores = num_moradores;
		this.Cons_Agua = Cons_Agua;
		
	}
	
	//SETS
	
	public void setTipoResidencia(String newTipoResidencia) {
		logradouro = tipoResidencia;
	}
	
	public void setLogradouro(String newLogradouro) {
		logradouro = newLogradouro;
	}
	
	public void setNumero(int newNumero) {
		numero = newNumero;
	}
	
	public void setCidade(String newCidade) {
		cidade = newCidade;
	}
	
	public void setNum_Moradores(int newNum_moradores) {
		num_moradores = newNum_moradores;
	}
	
	public void setCons_Agua(Double newCons_Agua) {
		Cons_Agua = newCons_Agua;
	}
	
	//GETS
	
	public String getTipoResidencia() {
		return tipoResidencia; 
	}
	
	public String getEndereco() {
		return "Logradouro: " + getLogradouro() + " | Número: " + getNumero() + " | Cidade: " + getCidade() + " | Estado: " + getEstado();
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public int getNum_moradores() {
		return num_moradores;
	}
	
	public double getCons_Agua() {
		return Cons_Agua;
	}
	
	public double getConsMedio() {
		if (num_moradores == 0){
			return 0.0;
		}
		return (double)Cons_Agua/num_moradores;
	}
		
	public String toString() {
		return "Logradouro: " + getLogradouro() + " | Número: " + getNumero() + " | Cidade: " + getCidade() + " | Estado: " + getEstado();
	}
}

package br.com.accenture.pessoas;

import javax.swing.JOptionPane;

import br.com.accenture.funcionarios.Pessoa;

public class Responsaveis extends Pessoa{

	String cpf;
		
	public Responsaveis(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
	}

	@Override
	public void imprimirCartaoAniversario() {
		JOptionPane.showMessageDialog(null , "Parabéns ao Srª/Srº " + this.getNome());
	}
	
}

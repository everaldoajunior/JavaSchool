package br.com.accenture.funcionarios;

public abstract class Pessoa {

	private String nome;
	private int idade;

	public Pessoa (String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public abstract void imprimirCartaoAniversario();
	
	public final void incrementarIdade() {
		this.idade++;
	}
}

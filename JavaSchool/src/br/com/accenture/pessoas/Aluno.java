package br.com.accenture.pessoas;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.accenture.funcionarios.Pessoa;
import br.com.accenture.interfaces.Autenticavel;


public class Aluno extends Pessoa implements Autenticavel {

	private Escolaridade escolaridade;
	private float media;
	private String matricula;
	private Responsaveis pai;
	private Responsaveis mae;

	public static String senha = "aluno";

	public enum Escolaridade {
		FUNDAMENTAL, MEDIO, SUPERIOR, OUTRO
	}

	public Aluno(String nome, String matricula) {
		super(nome);
		this.matricula = matricula;
	}


	public Aluno(String nome) {
		super(nome);
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}


	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}


	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Responsaveis getPai() {
		return pai;
	}

	public void setPai(Responsaveis pai) {
		this.pai = pai;
	}

	public Responsaveis getMae() {
		return mae;
	}

	public void setMae(Responsaveis mae) {
		this.mae = mae;
	}

	public void imprimirCartaoAniversario() {
		JOptionPane.showMessageDialog(null, "Parabéns Aluno " + this.getNome());
	}

	public float calcularMedia(float nota , float nota2) {
		float mediaTotal = (nota + nota2) /2;
		return mediaTotal; 
	}


	public float calcularMedia(List<Float> notas) {
		float media;
		float somatorioTotal = 0;

		for (float nota: notas) {
			somatorioTotal += nota;
		}

		media = somatorioTotal / notas.size();

		return media;
	}

	@Override
	public boolean autenticar(String login, String senha) {

		boolean logado = false;
		if(login.equals(this.matricula) && senha.equals(ConstanteAcesso.SENHA) ) {
			logado = true;
		}
		return logado;
	}

}

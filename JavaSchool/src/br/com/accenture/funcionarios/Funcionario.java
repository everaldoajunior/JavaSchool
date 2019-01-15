package br.com.accenture.funcionarios;

import javax.swing.JOptionPane;

public abstract class Funcionario extends Pessoa {

	int pid;
	String email;
	double salario;

	public Funcionario(String nome, String email, int pid) {
		super(nome);
		this.email = email;
		this.pid = pid;
	}
	
	public Funcionario (String nome) {
		super(nome);
	}
	
	public Funcionario (String nome, String email) {
		super(nome);
		this.email = email;
	}
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void imprimirCartaoAniversario() {
		JOptionPane.showMessageDialog(null, "Parabens, o senhor(a) " + this.getNome() + " é uma honra ter você em nossa Escola!" );
	}

	public void reajusteSalario(double percentual) {
		this.salario += salario * percentual;
	}
}

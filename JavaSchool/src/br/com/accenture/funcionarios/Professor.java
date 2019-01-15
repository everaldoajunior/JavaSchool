package br.com.accenture.funcionarios;

import br.com.accenture.interfaces.Autenticavel;
import br.com.accenture.pessoas.ConstanteAcesso;

public class Professor extends Funcionario implements Autenticavel{
	
	int id;
	String disciplina;
	
	public Professor(String nome, String email, int pid) {
		super(nome, email, pid);
	}

	public Professor (String email) {
		super(email);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public boolean autenticar(String login, String senha) {
	boolean logado = false;
		
		if (login.equals(Integer.toString(this.pid)) && senha.equals(ConstanteAcesso.SENHA)) {
			logado = true;
		}
		
		return logado;
	}
	
	
	
}

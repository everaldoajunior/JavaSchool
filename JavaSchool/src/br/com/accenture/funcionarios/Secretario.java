package br.com.accenture.funcionarios;

import br.com.accenture.interfaces.Autenticavel;
import br.com.accenture.pessoas.ConstanteAcesso;

public class Secretario extends Funcionario implements Autenticavel{

	public Secretario(String nome, String string, int i) {
		super(nome);
	}
	
	@Override
	public boolean autenticar(String login, String senha) {
		boolean logado = false;
		
		if (login.equals(this.email) && senha.equals(ConstanteAcesso.SENHA)) {
			logado = true;
		}
		
		return logado;
	}
}

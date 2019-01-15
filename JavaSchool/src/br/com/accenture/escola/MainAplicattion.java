package br.com.accenture.escola;

import br.com.accenture.interfaces.Autenticavel;

public class MainAplicattion {

	
	public static void main(String[] args) {
		
		Autenticavel autenticaPessoa = Escola.pegarTipoUsuario();
		Escola escola = new Escola();
		
		escola.login(autenticaPessoa);
		escola.novoAluno();
		escola.exibirRelatorio();
	}
}

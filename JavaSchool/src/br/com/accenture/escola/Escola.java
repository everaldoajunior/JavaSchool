package br.com.accenture.escola;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import br.com.accenture.funcionarios.Diretor;
import br.com.accenture.funcionarios.Professor;
import br.com.accenture.funcionarios.Secretario;
import br.com.accenture.interfaces.Autenticavel;
import br.com.accenture.pessoas.Aluno;

public class Escola {

	private List<Aluno> listaAlunos;
	private Diretor diretor;
	private List<Secretario> listaSecretario;
	private List<Professor> listaProfessor;

	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}



	public void setListaAlunos(List<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}


	public Escola() {
		listaAlunos = new ArrayList<>();
	}

	public void novoAluno() {
		int novoAluno = 0;
		int qtdNotas;
		List<Float> notas;

		while (novoAluno == 0) {
			Aluno aluno;
			notas = new ArrayList<Float>();

			String nome = JOptionPane.showInputDialog("Digite o nome do aluno por favor: ");

			aluno = new Aluno(nome);

			int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade : "));
			aluno.setIdade(idade);

			Aluno.Escolaridade enumEscolaridade;
			String escolaridade = JOptionPane.showInputDialog("Escolaridade: 1 - Fundamental, 2 - Medio, 3 - Superior");

			switch (escolaridade) {

			case "1":
				enumEscolaridade = Aluno.Escolaridade.FUNDAMENTAL;
				break;
			case "2":
				enumEscolaridade = Aluno.Escolaridade.MEDIO;
				break;
			case "3":
				enumEscolaridade = Aluno.Escolaridade.SUPERIOR;
				break;
			default:
				enumEscolaridade = Aluno.Escolaridade.OUTRO;
			}

			aluno.setEscolaridade(enumEscolaridade);

			qtdNotas = Integer.parseInt(JOptionPane.showInputDialog("Quantas notas você quer adicionar?"));

			for (int i = 0; i < qtdNotas; i++) {
				notas.add(
						Float.parseFloat(JOptionPane.showInputDialog("Por favor, digite sua " + (i + 1) + "ª Nota " )));
			}

			int faltas = Integer.parseInt(JOptionPane.showInputDialog("Quantas faltas voce tem?"));

			Object[] options = { "Sim", "Nao" };
			int trabalhoNoturno = JOptionPane.showOptionDialog(null, "Voce trabalha de noite?", "Trabalho noturno",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

			float media = aluno.calcularMedia(notas);

			aluno.setMedia(media);

			listaAlunos.add(aluno);

			String aviso = "Você faltou " + faltas + " vezes e sua média ficou : " + media + " \n você terminou o ano ";

			if (media >= 4 && media < 7) {
				if (faltas < 10) {
					aviso += "em Recuperação, Sua média ficou entre 4 e 7 e você teve menos de 10 faltas!";
				} else {
					aviso += "Reprovado, Você faltou mais de 10 vezes, apesar de ter ficado em 4 e 7 de média!";
				}
			} else if (media >= 7 && media < 9) {
				if (faltas < 3) {
					aviso += "Aprovado, Sua média está entre 7 e 9, e você possui menos de 3 faltas!";
				} else if (trabalhoNoturno == 0) {
					aviso += "Aprovados, Sua média está entre 7 e 9, e voce trabalha à noite!";
				} else {
					aviso += "em Recuperação, Sua média está entre 7 e 9, você nao trabalha a noite faltas superiores a 2";
				}
			} else if (media < 4) {
				aviso += "Reprovado, média abaixo de 4";
			} else {
				aviso += "Aprovado, parabéns";
			}

			JOptionPane.showMessageDialog(null, aviso, "Calcular Media do Aluno", JOptionPane.PLAIN_MESSAGE);

			Object[] options2 = { "Sim", "Nao" };
			novoAluno = JOptionPane.showOptionDialog(null, "Quer cadastrar um novo aluno?", "Novo aluno",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options2, options2[0]);
		}
	}


	public void exibirRelatorio() {
		for (Aluno aluno : this.listaAlunos) {
			String li = "Nome: " + aluno.getNome();
			li += "\nMedia: " + aluno.getMedia();
			li += "\nIdade: " + aluno.getIdade();
			li += "\nEscolaridade: " + aluno.getEscolaridade();
			JOptionPane.showMessageDialog(null, li, "Aluno : " + aluno.getNome(), JOptionPane.PLAIN_MESSAGE);
		}
	}

	public void login(Autenticavel autenticavel) {
		boolean loginErrado = true;

		String usuario;
		String senha;

		while (loginErrado) {
			String msgUsuario = "";

			if (autenticavel.getClass().equals(Aluno.class)) {
				msgUsuario = "Digite sua matricula";
			}
			else if (autenticavel.getClass().equals(Professor.class)) {
				msgUsuario = "Digite seu PID";
			}
			else if (autenticavel.getClass().equals(Secretario.class)) {
				msgUsuario = "Digite seu e-mail";
			}

			String nomeDeUsuario = JOptionPane.showInputDialog(msgUsuario);
			String password = JOptionPane.showInputDialog("Por favor, digite sua senha");

			loginErrado = !autenticavel.autenticar(nomeDeUsuario, password);

		}
	}
	public List<Secretario> getListaSecretario() {
		return listaSecretario;
	}

	public void setListaSecretario(List<Secretario> listaSecretario) {
		this.listaSecretario = listaSecretario;
	}

	public List<Professor> getListaProfessor() {
		return listaProfessor;
	}

	public void setListaProfessor(List<Professor> listaProfessor) {
		this.listaProfessor = listaProfessor;
	}

	public static Autenticavel pegarTipoUsuario() {
		Autenticavel pessoa = null;
		boolean tipoUsuarioErrado = true;

		while (tipoUsuarioErrado) {
			String tipoUsuario = JOptionPane.showInputDialog("1 - Aluno, 2- Professor, 3 - Secretario");

			switch (tipoUsuario) {
			case "1":
				pessoa = new Aluno("Everaldo", "123");
				tipoUsuarioErrado = false;
				break;
			case "2":
				pessoa = new Professor("Everaldo", "everaldo@email.com", 123);
				tipoUsuarioErrado = false;
				break;
			case "3":
				pessoa = new Secretario("Mario", "Mario@email.com", 123);
				tipoUsuarioErrado = false;
				break;
			}
		}
		return pessoa;
	}

}

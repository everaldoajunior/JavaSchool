package br.com.accenture.funcionarios;

public class Porteiro extends Funcionario {

	public Porteiro(String nome, Turno turno) {
		super(nome);
		this.turno = turno;
	}

	public static enum Turno{
		DIURNO, NOTURNO
	}

	Turno turno;

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	@Override
	public void reajusteSalario(double reajuste) {
		if (this.turno.equals(Turno.NOTURNO)) {
			this.salario += salario * (reajuste + 0.1);
		}
		else {
			super.reajusteSalario(reajuste);
		}
	}

}


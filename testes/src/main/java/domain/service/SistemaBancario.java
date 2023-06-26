package domain.service;

import domain.model.Banco;

public class SistemaBancario {

	private Bacen bacen;

	public SistemaBancario(Bacen bacen) {
		super();
		this.bacen = bacen;
	}

	public long registrarBanco(Banco banco) {

		// outras regras de negocio

		return bacen.cadastrarBanco(banco);
	}
}

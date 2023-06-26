package domain.model;

import java.util.InputMismatchException;

import domain.exception.CNPJInvalidoException;
import domain.exception.CPFInvalidoException;
import infra.util.validators.ValidatorCNPJ;
import infra.util.validators.ValidatorCPF;

public abstract class Cliente {

	private String nome;
	private String email;
	protected Cliente(String nome) {
		this.nome = nome;
	}

	Cliente(){

	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public Cliente setEmail(String email) {
		this.email = email;
		return this;
	}
}

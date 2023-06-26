package domain.model;

import domain.exception.SaldoInsuficienteException;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private double saldo;
	@Embedded
	private ClientePF cliente;
	
	public Conta (ClientePF cliente) {
		this.cliente = cliente;
	}

	public Conta() {
	}

	public long getId() {
		return id;
	}

	public double getSaldo() {

		return this.saldo;
	}
	
	public ClientePF getCliente() {
		return cliente;
	}

	public Conta depositar(double valor) {

		validarSeValorInformadoEhMenorOuIgualAZero(valor);
		this.saldo += valor;
		return this;

	}

	public Conta sacar(double valor) {
		
		validarSeValorInformadoEhMenorOuIgualAZero(valor);
		validarSeContaPossuiSaldoSuficiente(valor);
		this.saldo -= valor;
		
		return this;

	}

	private void validarSeContaPossuiSaldoSuficiente(double valor) {
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException("valor do saldo " + this.saldo);
		}
	}

	private void validarSeValorInformadoEhMenorOuIgualAZero(double valor) {
		if(valor<=0) {
			throw new IllegalArgumentException("Valor inválido " + valor + " foi informado");
		}
	}

	public void transferirPara(Conta contaDestino, double valor) {

		this.sacar(valor);
		contaDestino.depositar(valor);
		
	}

}

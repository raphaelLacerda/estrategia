package domain.model;

import static org.junit.jupiter.api.Assertions.*;

import domain.model.Cliente;
import domain.model.Conta;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
//import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domain.exception.SaldoInsuficienteException;
import net.vidageek.mirror.dsl.Mirror;

public class ContaTest {

	private Conta conta;
	private Conta contaFonte;
	private Conta contaDestino;

	@BeforeAll
	public static void setUpClass() {

	}

	@AfterAll
	public static void tearDownClass() {

	}

	@BeforeEach
	public void setUp() {
		conta = criarContaComCliente();
		contaFonte = criarContaComCliente();
		contaDestino = criarContaComCliente();

	}

	private Conta criarContaComCliente() {
//		return new Conta(Cliente.getClienteComCPF("01117588157"));
		return new Conta(new ClientePF("rafa", "334.697.880-06"));
	}

	@AfterEach
	public void tearDown() {
		// liberação de recursos
	}

	@DisplayName("Depósito simples com valores válidos")
	@ParameterizedTest
	@ValueSource(doubles = { 10, 30, 100.10, 50.54, 88.7 })
	public void quando_adicionar_valor_positivo_deve_atualizar_saldo(double valor) {

		// execucao
		conta.depositar(valor);

		// saida
		assertEquals(valor, conta.getSaldo());

	}

	@DisplayName("Múltiplos depósitos em sequência")
	@Test
	public void quando_adicionar_valores_positivos_em_sequencia() {

		conta.depositar(100.43);
		assertEquals(100.43, conta.getSaldo());

		// depósito feito em sequência
		conta.depositar(20.33);

		assertEquals(120.76, conta.getSaldo());
	}

	@DisplayName("deposito com valores negativos")
	@Test
	public void nao_deve_aceitar_valores_negativos_para_deposito() {

		conta.depositar(100);

		// execucao
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> conta.depositar(-300));

		assertEquals("Valor inválido -300.0 foi informado", exception.getMessage());

		assertEquals(100, conta.getSaldo());
	}

	@Test
	public void nao_deve_aceitar_deposito_com_valor_zerado() {

		assertThrows(IllegalArgumentException.class, () -> conta.depositar(0));

		assertEquals(0, conta.getSaldo());

	}

	@Test
	public void deve_sacar_valor_de_uma_conta_quando_ela_possuir_saldo() {

		// entrada
		conta.depositar(200);
		// execucao
		conta.sacar(50);
		// saida
		assertEquals(150, conta.getSaldo());

	}

	@Test
	public void nao_deve_sacar_valor_de_uma_conta_quando_ela_nao_possuir_saldo() {

		// entrada
		conta.depositar(200);
		// execucao

		SaldoInsuficienteException e = assertThrows(SaldoInsuficienteException.class, () -> conta.sacar(250));

		assertEquals("valor do saldo 200.0", e.getMessage());

		// saida
		assertEquals(200, conta.getSaldo());

	}

	@Test
	public void nao_deve_aceitar_valores_invalidos_para_saque() {

		assertThrows(IllegalArgumentException.class, () -> conta.sacar(-100));

		assertThrows(IllegalArgumentException.class, () -> conta.sacar(0));

	}
	
	@Test
	public void deve_sacar_valor_quando_saldo_da_conta_for_igual_a_valor() {
		
		conta.depositar(100);
		
		conta.sacar(100);
		
		assertEquals(0, conta.getSaldo());
		
	}

	@Test
	public void deve_transferir_saldo_de_uma_conta_para_outra_quando_conta_fonte_possuir_saldo() {

		contaFonte.depositar(500);
		contaDestino.depositar(100);

		contaFonte.transferirPara(contaDestino, 100);

		assertEquals(400, contaFonte.getSaldo());
		assertEquals(200, contaDestino.getSaldo());

	}

	@Test
	public void nao_deve_transferir_saldo_de_uma_conta_para_outra_se_conta_fonte_nao_possuir_saldo() {

		contaFonte.depositar(500);

		assertThrows(SaldoInsuficienteException.class, () -> contaFonte.transferirPara(contaDestino, 1000));

	}

}

package domain.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.model.Banco;

class SistemaBancarioTest {

	private SistemaBancario sistemaBancario;

	@BeforeEach
	public void setUp() {

		sistemaBancario = new SistemaBancario(new BacenFake());
	}

	@Test
	void deve_registrar_banco_se_ele_possuir_autorizacao_do_bacen() {

		Banco nubank = new Banco(null, null);
		Banco bb = new Banco(null, null);

		long numeroDoRegistro = sistemaBancario.registrarBanco(nubank);
		assertTrue(numeroDoRegistro == 1);

		numeroDoRegistro = sistemaBancario.registrarBanco(bb);
		assertTrue(numeroDoRegistro == 2);

	}

}

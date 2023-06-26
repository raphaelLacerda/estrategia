package domain.model;

import domain.exception.CPFNegativadoException;
import domain.exception.SistemaIndisponivelException;
import infra.broker.Mensagem;
import infra.broker.Mensageria;
import infra.receita.ReceitaFederal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BancoTest {

	private static final String CPF_NEGATIVADO = "77507706079";
	private static final String CPF_VALIDO = "01117588157";

	@Spy
	@InjectMocks
	private Banco nubank;

	@Mock
	private ReceitaFederal receitaFederal;

	@Mock
	private Mensageria email;

	@Test
	public void deve_adicionar_conta_no_banco() {

		nubank.adicionarConta(criarConta(CPF_VALIDO, 1000));
		nubank.adicionarConta(criarConta("92468831012", 1000));

		assertEquals(2, nubank.getTotalDeContas());
	}

	@Test
	public void nao_deve_adicionar_conta_se_CPF_estiver_negativado() {


		Mockito.doReturn(true).when(nubank).verificarSeCPFEstaNegativado(CPF_NEGATIVADO);

		assertThrows(CPFNegativadoException.class, () -> nubank.adicionarConta(criarConta(CPF_NEGATIVADO, 1000)));
		
		nubank.adicionarConta(criarConta("92468831012", 1000));
		
		assertEquals(1, nubank.getTotalDeContas());

	}

	@Test
	public void nao_deve_adicionar_conta_se_sistema_da_receita_federal_tiver_fora_do_ar() {

		Mockito.doThrow(IllegalStateException.class).when(receitaFederal).isCPFNegativado(CPF_VALIDO);

		assertThrows(SistemaIndisponivelException.class, () -> nubank.adicionarConta(criarConta(CPF_VALIDO, 1000)));
	}

	@Test
	public void deve_recuperar_conta_por_cliente_existente() {

		nubank.adicionarConta(criarConta(CPF_VALIDO, 1000));

		Optional<Conta> conta = nubank.getContaDoCliente(CPF_VALIDO);

		assertTrue(conta.isPresent());
		assertEquals(CPF_VALIDO, conta.get().getCliente().getCpf());
	}

	@Test
	public void nao_deve_recuperar_conta_se_cliente_nao_existir() {

		Optional<Conta> conta = nubank.getContaDoCliente("123123");
		assertFalse(conta.isPresent());

	}

	@Test
	public void deve_listar_contas_de_alta_renda() {
		criarContasAleatoriasDeBaixaeAltaRenda();

		List<Conta> contasAltaRenda = nubank.listarContasAltaRenda();

		assertEquals(3, contasAltaRenda.size());
	}

	@Test
	public void deve_listar_contas_de_baixa_renda() {
		criarContasAleatoriasDeBaixaeAltaRenda();

		List<Conta> contasBaixaRenda = nubank.listarContasBaixaRenda();

		assertEquals(2, contasBaixaRenda.size());
	}

	@Test
	public void deve_oferecer_titulos_de_capitalizacao() {
		criarContasAleatoriasDeBaixaeAltaRenda();

		nubank.oferecerSeguros();

		ArgumentCaptor<Mensagem> argument = ArgumentCaptor.forClass(Mensagem.class);


		Mensagem mensagem = new Mensagem("compre titulo 59432843033", "59432843033@gmail.com");
		Mensagem mensagemNaoEnviada = new Mensagem("compre titulo " + CPF_VALIDO, CPF_VALIDO+"@gmail.com");
//		Mockito.verify(email, Mockito.times(3)).enviar(Mockito.any());
//		Mockito.verify(email, Mockito.times(1)).enviar(Mockito.eq(mensagem));
		Mockito.verify(email, Mockito.times(1)).enviar(mensagem);
//		Mockito.verify(email, Mockito.never()).enviar(mensagemNaoEnviada);
	}

	private void criarContasAleatoriasDeBaixaeAltaRenda() {
		// baixa renda
		nubank.adicionarConta(criarConta(CPF_VALIDO, 500));
		nubank.adicionarConta(criarConta("92468831012", 1000));

		// classe média
		nubank.adicionarConta(criarConta("40302693033", 3000));

		// alta renda
		nubank.adicionarConta(criarConta("59432843033", 15000));
		nubank.adicionarConta(criarConta("68356490030", 20000));
		nubank.adicionarConta(criarConta("77243837077", 20000000));
	}

	private Conta criarConta(String cpf, double deposito) {
		ClientePF rafa = new ClientePF("rafa", cpf);
		rafa.setEmail(cpf+"@gmail.com");
		return new Conta(rafa).depositar(deposito);
	}

}

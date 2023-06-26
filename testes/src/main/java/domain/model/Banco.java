package domain.model;

import domain.exception.CPFNegativadoException;
import domain.exception.SistemaIndisponivelException;
import infra.receita.ReceitaFederal;
import infra.receita.ReceitaFederalStatic;
import infra.broker.Mensagem;
import infra.broker.Mensageria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Banco {

	private List<Conta> contas = new ArrayList<>();

	private ReceitaFederal receitaFederal;
	private Mensageria mensageria;


	//default constructor
	public Banco() {
		super();
	}

	public Banco(ReceitaFederal receitaFederal, Mensageria email) {
		this.receitaFederal = receitaFederal;
		this.mensageria = email;
	}

	public void adicionarConta(Conta conta) {

		try {
			if (verificarSeCPFEstaNegativado(conta.getCliente().getCpf())) {

				throw new CPFNegativadoException();
			}
			contas.add(conta);
		} catch (IllegalStateException e) {
			throw new SistemaIndisponivelException(e);
		}

	}

	boolean verificarSeCPFEstaNegativado(String cpf) {
		return ReceitaFederalStatic.isCPFNegativado(cpf);
//		return receitaFederal.isCPFNegativado(cpf);
	}

	public int getTotalDeContas() {
		return contas.size();
	}

	public Optional<Conta> getContaDoCliente(String cpfValido) {
		return contas.stream().filter(c -> c.getCliente().getCpf().equals(cpfValido)).findFirst();
	}

	public List<Conta> listarContasAltaRenda() {
		return filtrarContas(c -> c.getSaldo() >= 10000);
	}

	public List<Conta> listarContasBaixaRenda() {
		return filtrarContas(c -> c.getSaldo() <= 1000);
	}

	private List<Conta> filtrarContas(Predicate<Conta> filtro) {
		return contas.stream().filter(filtro).collect(Collectors.toList());
	}

	public void oferecerSeguros() {

		List<Conta> contasAltaRenda = listarContasAltaRenda();

		contasAltaRenda.forEach(c -> mensageria
				.enviar(new Mensagem("compre titulo " + c.getCliente().getCpf(), c.getCliente().getEmail())));

	}

}

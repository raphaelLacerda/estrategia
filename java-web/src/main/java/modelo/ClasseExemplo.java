package modelo;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ClasseExemplo {

	public static final int CONSTANTES_PRIMERO = 10;	
	private static final int CONSTANTES_PRIVATE = 10;
	
	private static int contador;
	
	//indentação não horizontal
	private int idade;
	private String nome;
	
	public void executaAlgo() {
		List<String> dados = buscarDados();
		System.out.println(dados.size()+CONSTANTES_PRIVATE);
	}

	private List<String> buscarDados() {
		return Collections.emptyList();
	}
	
	public void salvar(String nome) {
		validar(nome);
		System.out.println(nome);
	}
	//we like to keep functions private, but we're not fanatic about it
	//pode ter visibilidade alterada para os testes
	void validar(String nome) {
		Objects.requireNonNull(nome, "nome não pode ser null");
	}
}

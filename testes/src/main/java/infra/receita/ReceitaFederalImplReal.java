package infra.receita;

public class ReceitaFederalImplReal implements ReceitaFederal {

	@Override
	public boolean isCPFNegativado(String cpf) {

		System.out.println("simulando uma chamada de rede");
		System.out.println("integrando com sistema externo");
		System.out.println("fazendo chamando REST");
		return false;
	}
}

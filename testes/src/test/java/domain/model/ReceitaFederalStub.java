package domain.model;

import infra.receita.ReceitaFederal;

public class ReceitaFederalStub implements ReceitaFederal {

	@Override
	public boolean isCPFNegativado(String cpf) {
		if (cpf.equals("77507706079")) {
			return true;
		}
		return false;
	}
}

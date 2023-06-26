package domain.service;

import domain.model.Banco;
import domain.service.Bacen;

public class BacenStub extends Bacen {

	@Override
	public long cadastrarBanco(Banco banco) {
		return 1;
	}

}

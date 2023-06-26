package domain.service;

import java.util.HashMap;
import java.util.Map;

import domain.model.Banco;
import domain.service.Bacen;

public class BacenFake extends Bacen {

	private Map<Long, Banco> bancos = new HashMap();

	@Override
	public long cadastrarBanco(Banco banco) {

		long id = bancos.size() + 1;
		bancos.put(id, banco);
		return id;
	}

	@Override
	public Banco buscarPorId(long id) {
		return bancos.get(id);
	}
}

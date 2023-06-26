package decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import dao.DAO;
import modelo.Aluno;
import modelo.HistoricoAluno;
import observers.AlunoObserver;

@Decorator
public class HistoricoDecorator implements DAO {

	@Inject
	@Delegate
	@Any
	private DAO dao;

	@Inject
	private EntityManager entityManager;

	@Override
	public Aluno salvar(Aluno aluno) {

		Aluno alunoSalvo = dao.salvar(aluno);

		entityManager.getTransaction().begin();
		
		entityManager.persist(new HistoricoAluno(aluno));
		
		entityManager.getTransaction().commit();
		
		return alunoSalvo;
	}

}

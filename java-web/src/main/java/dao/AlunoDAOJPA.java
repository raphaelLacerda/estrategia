package dao;

import java.util.List;

import javax.persistence.EntityManager;

import factory.JpaFactory;
import modelo.Aluno;

public class AlunoDAOJPA{

	private EntityManager em;

	public AlunoDAOJPA() {
		this.em = JpaFactory.getEntityManager();

	}

	public Aluno salvar(Aluno aluno) {

		this.em.persist(aluno);
		return aluno;
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> listar() {

		return this.em.createQuery("SELECT a FROM Aluno a").getResultList();
	}

	
	
	
}

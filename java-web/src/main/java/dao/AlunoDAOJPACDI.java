package dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import factory.JpaFactory;
import interceptor.Transactional;
import modelo.Aluno;

public class AlunoDAOJPACDI implements DAO{

	private EntityManager em;
	
	public AlunoDAOJPACDI() {
		this.em = JpaFactory.getEntityManager();
	}
	
	@PostConstruct
	public void init() {
		System.out.println("criando ALUNODAOJPACDI");
	}

	public Aluno salvar(Aluno aluno) {

		this.em.getTransaction().begin();
		
		this.em.persist(aluno);
		
		this.em.getTransaction().commit();
		return aluno;
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> listar() {

		return this.em.createQuery("SELECT a FROM Aluno a").getResultList();
	}

	
	
	
}

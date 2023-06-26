package dao;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import factory.JpaFactory;
import modelo.Aluno;

@Stateless
public class AlunoDAOJPAEJB {

	@PersistenceContext
	private EntityManager em;

	

	@Transactional
	public Aluno salvar(Aluno aluno) {

		this.em.persist(aluno);

		return aluno;
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> listar() {

		return this.em.createQuery("SELECT a FROM Aluno a").getResultList();
	}

	public List<Aluno> listarAniversariantes() {
		return this.em
				.createQuery(
						"SELECT a FROM Aluno a WHERE DAY(a.dataNascimento) = :dia and MONTH(a.dataNascimento) = :mes")
				.setParameter("dia", LocalDate.now().getDayOfMonth())
				.setParameter("mes", LocalDate.now().getMonthValue()).getResultList();
	}

}

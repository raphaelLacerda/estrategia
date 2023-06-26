package dao;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ValidationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import modelo.Aluno;

@Ignore
public class AlunoDAOJPAEJBTest {

	private AlunoDAOJPAEJB dao;
	private EntityManager em;

	@Before
	public void setUp() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2");
		em = emf.createEntityManager();

		dao = new AlunoDAOJPAEJB(em);

		em.getTransaction().begin();
	}

	@After
	public void tearDown() {

		em.getTransaction().commit();
	}

	@Test
	public void deve_adicionar_alunos() {

		salvandoAlunosAleatorios();

		List<Aluno> alunos = dao.listar();

		assertEquals(3, alunos.size());

	}

	@Test(expected = ValidationException.class)
	public void nao_deve_salvar_aluno_com_email_invalido() {
		Aluno aluno1 = new Aluno("rafa", "lacerdaph@", LocalDate.of(1985, 4, 28));
		dao.salvar(aluno1);
	}

	@Test
	public void deve_listar_aniversariantes() {
		salvandoAlunosAleatorios();
		assertEquals(2, dao.listarAniversariantes().size());
	}

	private void salvandoAlunosAleatorios() {
		Aluno aluno1 = new Aluno("rafa", "lacerdaph@gmail.com", LocalDate.of(1985, 4, 28));
		Aluno aluno2 = new Aluno("gabriel", "gabi@gmail.com", LocalDate.of(1990, 1, 15));
		Aluno aluno3 = new Aluno("carlos", "carlos@gmail.com", LocalDate.of(2000, 1, 15));

		dao.salvar(aluno1);
		dao.salvar(aluno2);
		dao.salvar(aluno3);
	}
}

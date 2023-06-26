package factory;

import java.time.LocalDate;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import modelo.Aluno;

public class JpaFactory {

	private static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("estrategia");
	}

	@Produces
	@RequestScoped
	public static EntityManager getEntityManager() {
		
		System.out.println("criando nova conexao");

		return emf.createEntityManager();
	}
	
	public void close(@Disposes EntityManager em) {
		
		System.out.println("fechando conexao com banco");
		em.close();
	}

	public static void main(String[] args) {
		System.out.println("Criando banco de dados");
		System.out.println(getEntityManager());
		

//		for (int i = 1; i <= 100; i++) {
//			EntityManager em = getEntityManager();
//			em.getTransaction().begin();
//			System.out.println("criando conexao " + i + ": " + em);
//		}
	}

}

package domain.repositorio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class AbstractBaseTestDataBase {

    protected EntityManager entityManager;
    private static EntityManagerFactory emf;


    static {
        emf = Persistence.createEntityManagerFactory("defaultTeste");
    }

    @BeforeEach
    public void setUpEntityManager() {
        this.entityManager = emf.createEntityManager();
        this.entityManager.getTransaction().begin();
    }

    @AfterEach
    public void clearDataBase(){
        this.entityManager.createQuery("delete from Conta").executeUpdate();
        this.entityManager.getTransaction().commit();
    }

}

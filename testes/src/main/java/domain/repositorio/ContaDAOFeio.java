package domain.repositorio;


import domain.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ContaDAOFeio {

    private EntityManager entityManager;

    public ContaDAOFeio() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        this.entityManager = emf.createEntityManager();
    }

    public Conta adicionar(Conta conta) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(conta);
        this.entityManager.getTransaction().commit();
        return conta;
    }

    public Conta atualizar(Conta conta) {
        this.entityManager.getTransaction().begin();
        conta = this.entityManager.merge(conta);
        this.entityManager.getTransaction().commit();
        return conta;
    }

    public Conta buscar(Conta conta) {
        return this.entityManager.find(Conta.class, conta.getId());
    }

    public List<Conta> listar() {
        return this.entityManager.createQuery("select c from Conta c").getResultList();
    }

    public void remover(Conta conta) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(conta);
        this.entityManager.getTransaction().commit();
    }

}

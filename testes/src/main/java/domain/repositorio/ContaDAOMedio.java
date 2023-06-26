package domain.repositorio;


import domain.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ContaDAOMedio {

    private EntityManager entityManager;

    public ContaDAOMedio() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        this.entityManager = emf.createEntityManager();
        this.entityManager.getTransaction().begin();
    }

    public Conta adicionar(Conta conta) {

        this.entityManager.persist(conta);
        return conta;
    }

    public Conta atualizar(Conta conta) {
        conta = this.entityManager.merge(conta);
        return conta;
    }

    public Conta buscar(Conta conta) {
        return this.entityManager.find(Conta.class, conta.getId());
    }

    public List<Conta> listar() {
        return this.entityManager.createQuery("select c from Conta c").getResultList();
    }

    public void remover(Conta conta) {
        this.entityManager.remove(conta);
    }

}

package domain.repositorio;


import domain.model.Conta;

import javax.persistence.EntityManager;
import java.util.List;

public class ContaDAO {

    private EntityManager entityManager;

    public ContaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Conta adicionar(Conta conta) {
        this.entityManager.persist(conta);
        return conta;
    }

    public Conta atualizar(Conta conta) {
        return this.entityManager.merge(conta);
    }

    public Conta buscar(Conta conta) {
        return this.entityManager.find(Conta.class, conta.getId());
    }

    public List<Conta> listar() {
        return this.entityManager.createQuery("select c from Conta c").getResultList();
    }


    public List<Conta> listarContasPositivas() {
        return this.entityManager.createQuery("select c from Conta c where c.saldo > 0").getResultList();
    }

    public void remover(Conta conta) {
        this.entityManager.remove(conta);
    }

}

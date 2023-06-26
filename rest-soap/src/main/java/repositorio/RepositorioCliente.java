package repositorio;

import model.Cliente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Stateless
public class RepositorioCliente {

    @PersistenceContext
    private EntityManager entityManager;

    public Cliente salvar(Cliente cliente) {
        return entityManager.merge(cliente);
    }

    public List<Cliente> listar() {

        return entityManager.createQuery("from Cliente").getResultList();
    }

    public Cliente buscar(long id) {
        return entityManager.find(Cliente.class, id);
    }
}

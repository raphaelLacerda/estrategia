package domain.repositorio;

import domain.model.ClientePF;
import domain.model.Conta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContaDAOTest extends AbstractBaseTestDataBase {

    private ContaDAO contaDAO;

    @BeforeEach
    public void setUpDAO() {
        this.contaDAO = new ContaDAO(entityManager);
    }

    @Test
    void deve_adicionar_contas() {
        this.contaDAO.adicionar(new Conta(new ClientePF("rafa", "01117588157")));
        this.contaDAO.adicionar(new Conta(new ClientePF("rafa2", "01117588157")));
        this.contaDAO.adicionar(new Conta(new ClientePF("rafa3", "01117588157")));

        Assertions.assertEquals(3, contaDAO.listar().size());
    }

    @Test
    void deve_listar_contas_positivas() {
        Conta c1 = new Conta(new ClientePF("rafa", "01117588157"));
        c1.depositar(100);
        Conta c2 = new Conta(new ClientePF("rafa", "01117588157"));
        c2.depositar(500);
        Conta c3 = new Conta(new ClientePF("rafa", "01117588157"));

        this.contaDAO.adicionar(c1);
        this.contaDAO.adicionar(c2);
        this.contaDAO.adicionar(c3);

        Assertions.assertEquals(2, this.contaDAO.listarContasPositivas().size());
    }
}
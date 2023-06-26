package domain.model;

import domain.exception.CPFNegativadoException;
import infra.receita.ReceitaFederal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BancoTestComMock {

    @InjectMocks
    private Banco nubank;

    @Mock
    private ReceitaFederal receitaFederal;
    private static final String CPF_VALIDO = "01117588157";
    private static final String CPF_NEGATIVADO = "77507706079";

    @Test
    public void deve_adicionar_conta_no_banco() {

        Mockito.doReturn(false).when(receitaFederal).isCPFNegativado(CPF_VALIDO);
        nubank.adicionarConta(criarConta(CPF_VALIDO, 1000));
        assertEquals(1, nubank.getTotalDeContas());
    }

    @Test
    public void nao_deve_adicionar_conta_se_CPF_estiver_negativado() {

        Mockito.doReturn(true).when(receitaFederal).isCPFNegativado(CPF_NEGATIVADO);
        assertThrows(CPFNegativadoException.class, () -> nubank.adicionarConta(criarConta(CPF_NEGATIVADO, 1000)));
        assertEquals(0, nubank.getTotalDeContas());

    }

    private Conta criarConta(String cpf, double deposito) {
        return new Conta(new ClientePF("rafa", cpf)).depositar(deposito);
    }

}

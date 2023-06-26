package domain.model;

import domain.exception.CPFNegativadoException;
import infra.receita.ReceitaFederalStatic;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled
public class BancoTestComMockStatic {

    private Banco nubank = new Banco();
    private static final String CPF_VALIDO = "01117588157";
    private static final String CPF_NEGATIVADO = "77507706079";

    @Test
    public void deve_adicionar_conta_no_banco() {
        try(MockedStatic<ReceitaFederalStatic> mocked =
                    Mockito.mockStatic(ReceitaFederalStatic.class);
        ){
            mocked.when(()-> ReceitaFederalStatic.isCPFNegativado(CPF_VALIDO))
                    .thenReturn(false);
            mocked.when(()-> ReceitaFederalStatic.isCPFNegativado("92468831012"))
                    .thenReturn(false);

            nubank.adicionarConta(criarConta(CPF_VALIDO, 1000));
            nubank.adicionarConta(criarConta("92468831012", 1000));

            assertEquals(2, nubank.getTotalDeContas());
        }
    }

    @Test
    public void nao_deve_adicionar_conta_se_CPF_estiver_negativado() {

        MockedStatic<ReceitaFederalStatic> mocked =
                Mockito.mockStatic(ReceitaFederalStatic.class);
        mocked.when(()-> ReceitaFederalStatic.isCPFNegativado(CPF_NEGATIVADO))
                .thenReturn(true);
        assertThrows(CPFNegativadoException.class, () -> nubank.adicionarConta(criarConta(CPF_NEGATIVADO, 1000)));
        assertEquals(0, nubank.getTotalDeContas());


    }

    private Conta criarConta(String cpf, double deposito) {
        return new Conta(new ClientePF("rafa", cpf)).depositar(deposito);
    }

}

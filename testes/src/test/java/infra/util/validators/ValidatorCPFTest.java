package infra.util.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorCPFTest {


    @ParameterizedTest
    @NullAndEmptySource
    public void deve_retornar_cpf_invalido_para_parametros_invalidos(String cpf){
        assertFalse(ValidatorCPF.isCPFValido(cpf));
    }

    @ParameterizedTest
    @ValueSource(strings = {"426.867.900-67", "42686790067"})
    public void deve_retornar_cpf_valido(String cpf){
        assertTrue(ValidatorCPF.isCPFValido(cpf));
    }
}
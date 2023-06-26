package domain.model;

import domain.exception.CNPJInvalidoException;
import infra.util.validators.ValidatorCNPJ;

public class ClientePJ extends Cliente {
    private String cnpj;

    public ClientePJ(String nome, String cnpj) {
        super(nome);
        if (!ValidatorCNPJ.isCNPJValido(cnpj)) {
            throw new CNPJInvalidoException();
        }
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
}

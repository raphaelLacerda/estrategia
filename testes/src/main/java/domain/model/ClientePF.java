package domain.model;

import domain.exception.CPFInvalidoException;
import infra.util.validators.ValidatorCPF;

import javax.persistence.Embeddable;

@Embeddable
public class ClientePF extends Cliente {

    private String cpf;

    private ClientePF() {
    }

    public ClientePF(String nome, String cpf) {
        super(nome);
        //TODO: COLOCAR um BUG aqui de proposito, passar o atributo CPF ao inves do PARAMETRO, para isso o parametro
        // vem MAIUSCULO
        if (!ValidatorCPF.isCPFValido(cpf)) {
            throw new CPFInvalidoException();
        }
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}

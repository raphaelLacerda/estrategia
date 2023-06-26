package resource;

import model.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClienteDTO {

    private List<Cliente> clientes = new ArrayList<>();

    {
        clientes =Arrays.asList(new Cliente("rafa"), new Cliente("matheus"));
    }


    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}


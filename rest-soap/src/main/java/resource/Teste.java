package resource;

import model.Cliente;
import repositorio.RepositorioCliente;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.List;

@WebService(name = "teste", serviceName = "testeEndpoint", portName = "testeSOAP")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Teste {

    @WebResult(name = "resposta")
    @WebMethod
    public String metodoOlaMundo() {

        return "ola mundo - Raphael";
    }

    @WebResult(name = "soma", header = true)
    @WebMethod(operationName = "somarDoisNumeros")
    public int somar(@WebParam(name = "primeiro") int a, @WebParam(name = "segundo") int b) {
        return a + b;
    }

    @WebResult(name ="listar", header =true)
    @WebMethod(operationName ="listar")
    public ClienteDTO listar(){
        throw new IllegalStateException();
    }
}

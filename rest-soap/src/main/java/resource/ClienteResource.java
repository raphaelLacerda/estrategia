package resource;

import model.Cliente;
import repositorio.RepositorioCliente;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/clientes")
public class ClienteResource {

    @Context
    protected UriInfo uriInfo;

    @Inject
    private RepositorioCliente repositorioCliente;

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") long id, Cliente cliente) {
        Cliente clienteEncontrado = repositorioCliente.buscar(id);

        return clienteEncontrado != null
                ? Response.ok(repositorioCliente.salvar(cliente.setId(id))).build()
                : Response.status(Response.Status.NOT_FOUND).build();

    }

    @GET
    public Response listar() {

        System.out.println(uriInfo);

        return Response.ok(repositorioCliente.listar()).build();
    }


    @POST
    public Response salvar(Cliente cliente) {

        return Response.status(Response.Status.CREATED).entity(repositorioCliente.salvar(cliente)).build();
    }


    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") long id) {

        Cliente cliente = repositorioCliente.buscar(id);
        return cliente != null
                ? Response.ok(cliente).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }


}


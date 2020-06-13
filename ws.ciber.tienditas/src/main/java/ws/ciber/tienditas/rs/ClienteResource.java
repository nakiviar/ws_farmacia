package ws.ciber.tienditas.rs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ws.ciber.tienditas.entidad.Cliente;
import ws.ciber.tienditas.service.ClienteService;

@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {

	private ClienteService service = new ClienteService();

	@POST
	public Response crearCliente(Cliente cliente) {
		service.addCliente(cliente);
		return Response.status(Status.CREATED).entity(cliente).build();
	}

	@GET
	public List<Cliente> consultarCliente() {
		return service.getAllCliente();
	}

	@GET
	@Path("/{clienteId}")
	public Cliente getCliente(@PathParam("clienteId") int clienteId) {
		return service.getCliente(clienteId);
	}

	@PUT
	public String update(Cliente cliente) {
		return service.updateCliente(cliente);
	}


}
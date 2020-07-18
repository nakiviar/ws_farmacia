package ws.ciber.tienditas.rs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ws.ciber.tienditas.entidad.Boleta;
import ws.ciber.tienditas.entidad.DetalleBoleta;
import ws.ciber.tienditas.service.BoletaService;

@Path("/boleta")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BoletaResource {
	private BoletaService service = new BoletaService();

	@POST
	public String crearBoleta(Boleta boleta) {
		return service.addBoleta(boleta);
	}

	@GET
	public List<Boleta> listarTodo() {
		return service.getAllBoletas();
	}

	@GET
	@Path("/{boletaId}")
	public Boleta getBoleta(@PathParam("boletaId") int boletaId) {
		return service.getBoletaId(boletaId);
	}

	@PUT
	public String updateBoleta(Boleta boleta) {
		return service.updateBoleta(boleta);
	}

	@GET
	@Path("/cliente/{clienteId}")
	public List<Boleta> getBoletaCliente(@PathParam("clienteId") int clienteId) {
		return service.getBoletaSCliente(clienteId);
	}
	
	@DELETE
	@Path("/item/{itemId}")
	public String eliminarItem(@PathParam("itemId") int itemId) {
		return service.deleteItem(itemId);
	}
	
	@POST
	@Path("/item")
	public String añadirItem(DetalleBoleta item) {
		return service.addItem(item);
	}
	
	@PUT
	@Path("/item")
	public String guardarItem(DetalleBoleta item) {
		return service.updateItem(item);
	}
	
	@POST
	@Path("/app")
	public Response getCustomers(
			@QueryParam("origen") String origen, 
			@QueryParam("eai_URLDestino") String eai_URLDestino) {
		String result = String.format("origen = %s, eai_URLDestino = %s", new String[]{origen, eai_URLDestino});
		return Response.ok(result).build();
	}
	
	
	

}

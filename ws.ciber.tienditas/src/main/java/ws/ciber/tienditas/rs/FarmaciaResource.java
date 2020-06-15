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

import ws.ciber.tienditas.entidad.Farmacia;
import ws.ciber.tienditas.service.FarmaciaService;


@Path("/farmacias")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FarmaciaResource {

	private FarmaciaService service = new FarmaciaService();

	@POST
	public String crearFarmacia(Farmacia farmacia) {
		return service.addFarmacia(farmacia);
		//return Response.status(Status.CREATED).entity(cliente).build();
	}

	@GET
	public List<Farmacia> consultarFarmacia() {
		return service.getAllFarmacias();
	}

	@GET
	@Path("/{id}")
	public Farmacia getFarmacia(@PathParam("id") int id) {
		return service.getFarmacia(id);
	}

	@PUT
	public String update(Farmacia farmacia) {
		return service.updateFarmacia(farmacia);
	}

}

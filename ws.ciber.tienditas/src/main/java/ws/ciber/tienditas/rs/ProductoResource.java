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

import ws.ciber.tienditas.entidad.Producto;
import ws.ciber.tienditas.service.ProductoService;

@Path("/productos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductoResource {

	private ProductoService service = new ProductoService();

	@POST
	public Response crearProductos(Producto producto) {
		service.addProducto(producto);
		return Response.status(Status.CREATED).entity(producto).build();
	}

	@GET
	public List<Producto> consultarProductos() {
		return service.getAllProducto();
	}

	@GET
	@Path("/{productoId}")
	public Producto getProductos(@PathParam("productoId") int productoId) {
		return service.getProducto(productoId);
	}

	@PUT
	public String update(Producto producto) {
		return service.updateProducto(producto);
	}

}

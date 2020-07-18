package ws.ciber.tienditas.rs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
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
	
    private static final java.nio.file.Path BASE_DIR = Paths.get(System.getProperty("user.home"), "Documents","imagenes");

    private static final int MAX_SIZE_IN_MB = 1;

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

    @GET
    @Path("/imagenes/{productoId}")
    @Produces("image/jpeg")
    public InputStream getJpegImage(@PathParam("productoId") String fileName) throws IOException {
        
        fileName += ".jpg";
        System.out.println(" base dir : "+BASE_DIR);
        java.nio.file.Path dest = BASE_DIR.resolve(fileName);
        System.out.println("filename : "+ dest);
        if (!Files.exists(dest)) {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        
        return Files.newInputStream(dest);
    }
    

    @POST
    @Path("/imagenes/Subir/{productoId}")
    @Consumes({"image/jpeg", "image/png"})
    public Response uploadImage(@PathParam("productoId") String id,InputStream in, @HeaderParam("Content-Type") String fileType, @HeaderParam("Content-Length") long fileSize) throws IOException {
        

        if (fileSize > 1024 * 1024 * MAX_SIZE_IN_MB) {
            throw new WebApplicationException(Response.status(Status.BAD_REQUEST).entity("La imagen es más grande que " + MAX_SIZE_IN_MB + "MB").build());
        }
        
        String fileName = id;

        if (fileType.equals("image/jpeg")) {
            fileName += ".jpg";
        } else {
            fileName += ".png";
        }
        
        Files.copy(in, BASE_DIR.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        String mensaje = "{\"Status\": \"Created\"}";
       
        return Response.status(Status.CREATED)
        		.entity(mensaje)
        		.type(MediaType.APPLICATION_JSON)
        		.location(URI.create("/" + fileName))
        		.build();
    }
}

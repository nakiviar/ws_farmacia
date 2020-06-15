package ws.ciber.tienditas.service;

import java.util.List;

import ws.ciber.tienditas.entidad.Producto;
import ws.ciber.tienditas.repository.impl.ProductoRepository;

public class ProductoService {
	
	ProductoRepository repository = ProductoRepository.getInstance();

	public String addProducto(Producto producto) {
		repository.save(producto);
		return "Producto Agregado";
	}

	public List<Producto> getAllProducto() {
		return repository.all();
	}

	public Producto getProducto(int productoId) {
		return repository.get(productoId);
	}

	public String updateProducto(Producto producto) {
		if (repository.update(producto) <= 0)
			return "Error al actualizar";
		return "Producto Actualizado";
	}

}

package ws.ciber.tienditas.repository.interfaces;

import java.util.List;

import ws.ciber.tienditas.entidad.Categoria;
import ws.ciber.tienditas.entidad.Producto;

public interface IProductoRepository extends ITRepository<Producto, Integer> {

	List<Categoria> allCategories();
	List<Producto> Filtrado(int idCat);
}

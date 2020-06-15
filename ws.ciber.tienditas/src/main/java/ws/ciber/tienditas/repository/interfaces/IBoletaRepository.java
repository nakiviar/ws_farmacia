package ws.ciber.tienditas.repository.interfaces;

import java.util.List;

import ws.ciber.tienditas.entidad.Boleta;
import ws.ciber.tienditas.entidad.DetalleBoleta;

public interface IBoletaRepository extends ITRepository<Boleta, Integer> {

	void saveItem(DetalleBoleta item);

	int updateItem(DetalleBoleta item);

	int deleteItem(int id_item);
	
	List<Boleta> getBoletaCliente(int id_cliente); 
	
}

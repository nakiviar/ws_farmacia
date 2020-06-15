package ws.ciber.tienditas.service;

import java.util.List;

import ws.ciber.tienditas.entidad.Boleta;
import ws.ciber.tienditas.entidad.DetalleBoleta;
import ws.ciber.tienditas.repository.impl.BoletaRepository;

public class BoletaService {
	BoletaRepository repository = BoletaRepository.getInstance();

	public String addBoleta(Boleta boleta) {
		repository.save(boleta);
		return "Boleta Agregada";
	}

	public List<Boleta> getAllBoletas() {
		return repository.all();
	}

	public Boleta getBoletaId(int boletaId) {
		return repository.get(boletaId);
	}

	
	public String updateBoleta(Boleta boleta) {
		if (repository.update(boleta) <= 0)
			return "Error al actualizar";
		return "Boleta Actualizada";
	}
	
	public List<Boleta>  getBoletaSCliente(int clienteId) {
		return repository.getBoletaCliente(clienteId);
	}
	
	//PRODUCTOS ITEMS
	public String addItem(DetalleBoleta item) {
		repository.saveItem(item);
		return "Item Agregado";
	}
	
	public String updateItem(DetalleBoleta item) {
		repository.updateItem(item);
		return "Item Actualizado";
	}
	
	public String deleteItem(int id_item) {
		int i =repository.deleteItem(id_item);
		return i+ " Item eliminado";
	}

	

}

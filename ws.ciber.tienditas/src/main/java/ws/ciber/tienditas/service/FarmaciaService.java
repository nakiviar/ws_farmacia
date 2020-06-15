package ws.ciber.tienditas.service;

import java.util.List;

import ws.ciber.tienditas.entidad.Farmacia;
import ws.ciber.tienditas.repository.impl.FarmaciaRepository;

public class FarmaciaService {

	FarmaciaRepository repository = FarmaciaRepository.getInstance();

	public String addFarmacia(Farmacia farmacia) {
		repository.save(farmacia);
		return "Farmacia registrada";
	}

	public List<Farmacia> getAllFarmacias() {
		return repository.all();
	}

	public Farmacia getFarmacia(int id) {
		return repository.get(id);
	}

	public String updateFarmacia(Farmacia farmacia) {
		if (repository.update(farmacia) <= 0)
			return "Error al actualizar";
		return "Datos Actualizados";
	}

	
}

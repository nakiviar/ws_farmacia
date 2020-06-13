package ws.ciber.tienditas.service;

import java.util.List;

import ws.ciber.tienditas.entidad.Cliente;
import ws.ciber.tienditas.repository.impl.ClienteRepository;

public class ClienteService {

	ClienteRepository repository = ClienteRepository.getInstance();

	public String addCliente(Cliente cliente) {
		repository.save(cliente);
		return "Cliente Agregado";
	}

	public List<Cliente> getAllCliente() {
		return repository.all();
	}

	public Cliente getCliente(int clienteId) {
		return repository.get(clienteId);
	}

	public String updateCliente(Cliente cliente) {
		if (repository.update(cliente) <= 0)
			return "Error al actualizar";
		return "Cliente Actualizado";
	}

}

package ws.ciber.tienditas.repository.interfaces;

import java.util.List;

public interface ITRepository <T, ID>{

	void save(T resourse);

	T get(ID primaryKey);

	List<T> all();

	int update(T resourse);
	
}

package ws.ciber.tienditas.entidad;

public class Farmacia {

	private int id_tienda;
	private String nombre;
	private int ruc;
	private int telefono;
	public int getId_tienda() {
		return id_tienda;
	}
	public void setId_tienda(int id_tienda) {
		this.id_tienda = id_tienda;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getRuc() {
		return ruc;
	}
	public void setRuc(int ruc) {
		this.ruc = ruc;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public Farmacia(int id_tienda, String nombre, int ruc, int telefono) {
		this.id_tienda = id_tienda;
		this.nombre = nombre;
		this.ruc = ruc;
		this.telefono = telefono;
	}
	public Farmacia() {
		// TODO Auto-generated constructor stub
	}
	
}

package ws.ciber.tienditas.entidad;

public class Producto {

	private int id_producto;
	private String descripcion;
	private int stock;
	private Double precio;
	private int id_categoria;
	private String unidadMed;

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public String getUnidadMed() {
		return unidadMed;
	}

	public void setUnidadMed(String unidadMed) {
		this.unidadMed = unidadMed;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public Producto(int id_producto, String descripcion, int stock, Double precio, int id_categoria) {
		this.id_producto = id_producto;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.id_categoria = id_categoria;
	}

	public Producto() {

	}

}
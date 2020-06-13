package ws.ciber.tienditas.entidad;

public class DetalleBoleta {

	private int id_detalle;
	private int id_boleta;
	private int id_producto;
	private Double precio;
	private int cantidad;

	public int getId_detalle() {
		return id_detalle;
	}

	public void setId_detalle(int id_detalle) {
		this.id_detalle = id_detalle;
	}

	public int getId_boleta() {
		return id_boleta;
	}

	public void setId_boleta(int id_boleta) {
		this.id_boleta = id_boleta;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public DetalleBoleta(int id_detalle, int id_boleta, int id_producto, Double precio, int cantidad) {
		this.id_detalle = id_detalle;
		this.id_boleta = id_boleta;
		this.id_producto = id_producto;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public DetalleBoleta() {

	}

}

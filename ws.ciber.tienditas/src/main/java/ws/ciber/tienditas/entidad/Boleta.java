package ws.ciber.tienditas.entidad;

public class Boleta {

	private int id_boleta;
	private int id_cliente;
	private String fecha;
	private int id_tienda;
	private Double total;

	public Boleta() {
	}

	public Boleta(int id_boleta, int id_cliente, String fecha, int id_tienda, Double total) {
		this.id_boleta = id_boleta;
		this.id_cliente = id_cliente;
		this.fecha = fecha;
		this.id_tienda = id_tienda;
		this.total = total;
	}

	public int getId_boleta() {
		return id_boleta;
	}

	public void setId_boleta(int id_boleta) {
		this.id_boleta = id_boleta;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getId_tienda() {
		return id_tienda;
	}

	public void setId_tienda(int id_tienda) {
		this.id_tienda = id_tienda;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}


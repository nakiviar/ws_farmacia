package ws.ciber.tienditas.entidad;

public class Cliente {
	private int id_ciente;
	private String nombres;
	private String ape_mat;
	private String ape_pat;
	private String dni;
	private long telefono;

	public int getId_ciente() {
		return id_ciente;
	}

	public void setId_ciente(int id_ciente) {
		this.id_ciente = id_ciente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApe_mat() {
		return ape_mat;
	}

	public void setApe_mat(String ape_mat) {
		this.ape_mat = ape_mat;
	}

	public String getApe_pat() {
		return ape_pat;
	}

	public void setApe_pat(String ape_pat) {
		this.ape_pat = ape_pat;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public Cliente(int id_ciente, String nombres, String ape_mat, String ape_pat, String dni, int telefono) {
		this.id_ciente = id_ciente;
		this.nombres = nombres;
		this.ape_mat = ape_mat;
		this.ape_pat = ape_pat;
		this.dni = dni;
		this.telefono = telefono;
	}

	public Cliente() {
	}
}

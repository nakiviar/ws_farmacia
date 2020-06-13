package ws.ciber.tienditas.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ws.ciber.tienditas.entidad.Cliente;
import ws.ciber.tienditas.repository.interfaces.IClienteRepository;
import ws.ciber.tienditas.repository.util.MySqlConexion;

public class ClienteRepository implements IClienteRepository {
	
	private static ClienteRepository instance = null;

	private ClienteRepository() {

	}

	public static ClienteRepository getInstance() {
		if (instance == null) {
			instance = new ClienteRepository();
		}
		return instance;
	}
	@Override
	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = MySqlConexion.getConexion();

			String sql = "insert into tb_cliente(dni,nombres,ape_mat,ape_pat,telefono) values(?,?,?,?,?)";

			pst = con.prepareStatement(sql);
			pst.setString(1, cliente.getDni());
			pst.setString(2, cliente.getNombres());
			pst.setString(3, cliente.getApe_mat());
			pst.setString(4, cliente.getApe_pat());
			pst.setLong(5, cliente.getTelefono());

			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}

	}

	@Override
	public Cliente get(Integer pk) {
		Cliente cliente = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = MySqlConexion.getConexion();
			String sql = "select * from tb_cliente where id_cliente = " + pk + "";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				cliente = new Cliente();
				cliente.setId_ciente(rs.getInt(1));
				cliente.setDni(rs.getString(2));
				cliente.setNombres(rs.getString(3));
				cliente.setApe_mat(rs.getString(4));
				cliente.setApe_pat(rs.getString(5));
				cliente.setTelefono(rs.getLong(6));
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cliente;
	}

	@Override
	public List<Cliente> all() {
		List<Cliente> listado = new ArrayList<Cliente>();
		Cliente cliente = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = MySqlConexion.getConexion();
			String sql = "select * from tb_cliente";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				cliente = new Cliente();
				cliente.setId_ciente(rs.getInt(1));
				cliente.setDni(rs.getString(2));
				cliente.setNombres(rs.getString(3));
				cliente.setApe_mat(rs.getString(4));
				cliente.setApe_pat(rs.getString(5));
				cliente.setTelefono(rs.getLong(6));
				listado.add(cliente);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listado;
	}

	@Override
	public int update(Cliente cliente) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = MySqlConexion.getConexion();

			String sql = "update tb_cliente  set dni=?,nombres=?,ape_mat=?,ape_pat=?,telefono=?  " + "where id_cliente="
					+ cliente.getId_ciente();

			pst = con.prepareStatement(sql);
			pst.setString(1, cliente.getDni());
			pst.setString(2, cliente.getNombres());
			pst.setString(3, cliente.getApe_mat());
			pst.setString(4, cliente.getApe_pat());
			pst.setLong(5, cliente.getTelefono());

			i = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}

}

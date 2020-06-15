package ws.ciber.tienditas.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ws.ciber.tienditas.entidad.Farmacia;
import ws.ciber.tienditas.repository.interfaces.IFarmaciaRepository;
import ws.ciber.tienditas.repository.util.MySqlConexion;

public class FarmaciaRepository implements IFarmaciaRepository{

	private static FarmaciaRepository instance = null;

	private FarmaciaRepository() {

	}
	

	public static FarmaciaRepository getInstance() {
		if (instance == null) {
			instance = new FarmaciaRepository();
		}
		return instance;
	}
	
	@Override
	public void save(Farmacia farmacia) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = MySqlConexion.getConexion();

			String sql = "insert tb_farmacia(nombre,ruc,telefono) values(?,?,?)";

			pst = con.prepareStatement(sql);
			pst.setString(1, farmacia.getNombre());
			pst.setInt(2, farmacia.getRuc());
			pst.setInt(3, farmacia.getTelefono());
			
			pst.executeUpdate();

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
	}

	@Override
	public Farmacia get(Integer pk) {
		// TODO Auto-generated method stub
		Farmacia farmacia= null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = MySqlConexion.getConexion();
			String sql = "select * from tb_farmacia where id_farmacia = " + pk;
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				farmacia = new Farmacia();
				farmacia.setId_tienda(rs.getInt(1));
				farmacia.setNombre(rs.getString(2));
				farmacia.setRuc(rs.getInt(3));
				farmacia.setTelefono(rs.getInt(4));
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
		return farmacia;
	}

	@Override
	public List<Farmacia> all() {
		// TODO Auto-generated method stub
		List<Farmacia> listado = new ArrayList<Farmacia>();
		Farmacia farmacia = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = MySqlConexion.getConexion();
			String sql = "select * from tb_farmacia";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				farmacia = new Farmacia();
				farmacia.setId_tienda(rs.getInt(1));
				farmacia.setNombre(rs.getString(2));
				farmacia.setRuc(rs.getInt(3));
				farmacia.setTelefono(rs.getInt(4));
				listado.add(farmacia);
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
	public int update(Farmacia farmacia) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = MySqlConexion.getConexion();

			String sql = "update tb_farmacia set nombre=?,ruc=?,telefono=? where id_farmacia=?";


			pst = con.prepareStatement(sql);
			pst.setString(1, farmacia.getNombre());
			pst.setInt(2, farmacia.getRuc());
			pst.setInt(3, farmacia.getTelefono());
			pst.setInt(4, farmacia.getId_tienda());

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

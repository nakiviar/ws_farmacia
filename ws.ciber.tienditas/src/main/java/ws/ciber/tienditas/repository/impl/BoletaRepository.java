package ws.ciber.tienditas.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ws.ciber.tienditas.entidad.Boleta;
import ws.ciber.tienditas.entidad.DetalleBoleta;
import ws.ciber.tienditas.repository.interfaces.IBoletaRepository;
import ws.ciber.tienditas.repository.util.MySqlConexion;

public class BoletaRepository implements IBoletaRepository{

	private static BoletaRepository instance = null;

	private BoletaRepository() {

	}

	public static BoletaRepository getInstance() {
		if (instance == null) {
			instance = new BoletaRepository();
		}
		return instance;
	}

	
	@Override
	public void save(Boleta boleta) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = MySqlConexion.getConexion();

			String sql = "insert into tb_boleta(id_cliente,id_farmacia,fecha) values(?,?,?)";

			pst = con.prepareStatement(sql);
			pst.setInt(1, boleta.getId_cliente());
			pst.setInt(2, boleta.getId_tienda());
			pst.setString(3, boleta.getFecha());
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
	public Boleta get(Integer pk) {
		// TODO Auto-generated method stub
		Boleta boleta= null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = MySqlConexion.getConexion();
			String sql = "select * from tb_boleta where id_boleta = " + pk + "";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				boleta = new Boleta();
				boleta.setId_boleta(rs.getInt(1));
				boleta.setId_cliente(rs.getInt(2));
				boleta.setFecha(rs.getString(3));
				boleta.setId_tienda(rs.getInt(4));
				boleta.setTotal(rs.getDouble(5));
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
		return boleta;
	}

	@Override
	public List<Boleta> all() {
		// TODO Auto-generated method stub
		List<Boleta> listado = new ArrayList<Boleta>();
		Boleta boleta= null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = MySqlConexion.getConexion();
			String sql = "select * from tb_boleta";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				boleta = new Boleta();
				boleta.setId_boleta(rs.getInt(1));
				boleta.setId_cliente(rs.getInt(2));
				boleta.setFecha(rs.getString(3));
				boleta.setId_tienda(rs.getInt(4));
				boleta.setTotal(rs.getDouble(5));
				listado.add(boleta);
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
	public int update(Boleta boleta) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		int rs =0;
		try {

			con = MySqlConexion.getConexion();

			String sql = "update tb_boleta set id_cliente=?, fecha=?, id_farmacia=?,total=? where id_boleta=?";

			pst = con.prepareStatement(sql);
			pst.setInt(1, boleta.getId_cliente());
			pst.setString(2, boleta.getFecha());
			pst.setInt(3, boleta.getId_tienda());
			pst.setDouble(4, boleta.getTotal());
			pst.setInt(5, boleta.getId_boleta());
			rs= pst.executeUpdate();

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
		return rs;
	}

	@Override
	public void saveItem(DetalleBoleta item) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = MySqlConexion.getConexion();

			String sql = "insert into tb_detalle_boleta(id_boleta,id_producto,cantidad) values(?,?,?)";

			pst = con.prepareStatement(sql);
			pst.setInt(1, item.getId_boleta());
			pst.setInt(2, item.getId_producto());
			pst.setDouble(3, item.getCantidad());
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
	public int updateItem(DetalleBoleta item) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		int rs =0;
		try {

			con = MySqlConexion.getConexion();

			String sql = "update tb_detalle_boleta set id_boleta=?, id_producto=?, precio=?,cantidad=? where id_detalle=?";

			pst = con.prepareStatement(sql);
			pst.setInt(1, item.getId_boleta());
			pst.setInt(2, item.getId_producto());
			pst.setDouble(3, item.getPrecio());
			pst.setInt(4, item.getCantidad());
			pst.setInt(5, item.getId_detalle());
			rs=pst.executeUpdate();

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
		return rs;
	}

	@Override
	public int deleteItem(int id_item) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		int rs =0;
		try {

			con = MySqlConexion.getConexion();

			String sql = "delete from tb_detalle_boleta where id_detalle=?";

			pst = con.prepareStatement(sql);
			pst.setInt(1, id_item);
			rs=pst.executeUpdate();

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
		return rs;
	}

	@Override
	public List<Boleta> getBoletaCliente(int id_cliente) {
		// TODO Auto-generated method stub
		List<Boleta> listado = new ArrayList<Boleta>();
		Boleta boleta= null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = MySqlConexion.getConexion();
			String sql = "select * from tb_boleta where id_cliente = " + id_cliente + "";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				boleta = new Boleta();
				boleta.setId_boleta(rs.getInt(1));
				boleta.setId_cliente(rs.getInt(2));
				boleta.setFecha(rs.getString(3));
				boleta.setId_tienda(rs.getInt(4));
				boleta.setTotal(rs.getDouble(5));
				listado.add(boleta);
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

}

package ws.ciber.tienditas.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ws.ciber.tienditas.entidad.Categoria;
import ws.ciber.tienditas.entidad.Producto;
import ws.ciber.tienditas.repository.interfaces.IProductoRepository;
import ws.ciber.tienditas.repository.util.MySqlConexion;

public class ProductoRepository implements IProductoRepository {

	private static ProductoRepository instance = null;

	private ProductoRepository() {

	}

	public static ProductoRepository getInstance() {
		if (instance == null) {
			instance = new ProductoRepository();
		}
		return instance;
	}
	
	@Override
	public void save(Producto producto) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = MySqlConexion.getConexion();

			String sql = "insert into tb_producto(descripcion,stock,precio,id_categoria,unidadMed) values(?,?,?,?,?)";

			pst = con.prepareStatement(sql);
			pst.setString(1, producto.getDescripcion());
			pst.setInt(2, producto.getStock());
			pst.setDouble(3, producto.getPrecio());
			pst.setInt(4, producto.getId_categoria());
			pst.setString(5, producto.getUnidadMed());
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
	public Producto get(Integer pk) {
		Producto producto = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = MySqlConexion.getConexion();
			String sql = "select * from tb_producto where id_producto = " + pk + "";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				producto = new Producto();
				producto.setId_producto(rs.getInt(1));
				producto.setDescripcion(rs.getString(2));
				producto.setStock(rs.getInt(3));
				producto.setPrecio(rs.getDouble(4));
				producto.setUnidadMed(rs.getString(5));
				producto.setId_categoria(rs.getInt(6));
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
		return producto;
	}

	@Override
	public List<Producto> all() {
		List<Producto> listado = new ArrayList<Producto>();
		Producto producto = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			con = MySqlConexion.getConexion();
			String sql = "select * from tb_producto";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				producto = new Producto();
				producto.setId_producto(rs.getInt(1));
				producto.setDescripcion(rs.getString(2));
				producto.setStock(rs.getInt(3));
				producto.setPrecio(rs.getDouble(4));
				producto.setUnidadMed(rs.getString(5));
				producto.setId_categoria(rs.getInt(6));
				listado.add(producto);
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
	public int update(Producto producto) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = MySqlConexion.getConexion();

			String sql = "update tb_producto  set descripcion=?,stock=?,precio=?,unidadMed=?,id_categoria=?  "
					+ "where id_producto=" + producto.getId_producto();

			pst = con.prepareStatement(sql);
			pst.setString(1, producto.getDescripcion());
			pst.setInt(2, producto.getStock());
			pst.setDouble(3, producto.getPrecio());
			pst.setString(4, producto.getUnidadMed());
			pst.setInt(5, producto.getId_categoria());

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

	@Override
	public List<Categoria> allCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> Filtrado(int idCat) {
		// TODO Auto-generated method stub
		return null;
	}

}

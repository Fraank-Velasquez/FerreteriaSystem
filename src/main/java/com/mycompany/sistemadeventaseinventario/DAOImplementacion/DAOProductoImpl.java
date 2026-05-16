package com.mycompany.sistemadeventaseinventario.DAOImplementacion;

import com.mycompany.sistemadeventaseinventario.Conexion.ConexionDB;
import com.mycompany.sistemadeventaseinventario.Entidades.Producto;
import com.mycompany.sistemadeventaseinventario.Entidades.Proveedor;
import com.mycompany.sistemadeventaseinventario.PersistenciaDAO.DAOProducto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProductoImpl extends ConexionDB implements DAOProducto {

    @Override
    public void registrar(Producto product, Proveedor proveed) throws Exception {

        try {
            this.establecerConexionDB();
            PreparedStatement st = this.conectar.prepareStatement
        ("INSERT INTO Productos(Nombre, Marca, Stock, Precio, Observacion, id_proveedor, estado) VALUES (?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, product.getNombre());
            st.setString(2, product.getMarca());
            st.setInt(3, product.getStock());
            st.setDouble(4, product.getPrecio());
            st.setString(5, product.getObservacion());
            st.setInt(6, proveed.getId_proveedor());
            st.setString(7, "Activo");
            st.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {

            this.cerrarConexionDB();
        }

    }

    @Override
    public void Editar(int id_producto, Producto product, Proveedor prov) throws Exception {

        try {

            this.establecerConexionDB();
            String sql = "UPDATE Productos SET Nombre = ?, Marca = ?, Stock = ?, Precio = ?, Observacion = ?, id_proveedor = ? WHERE Id_producto = ?";
            PreparedStatement st = this.conectar.prepareStatement(sql);
            st.setString(1, product.getNombre());
            st.setString(2, product.getMarca());
            st.setInt(3, product.getStock());
            st.setDouble(4, product.getPrecio());
            st.setString(5, product.getObservacion());
            st.setInt(6, prov.getId_proveedor());
            st.setInt(7, id_producto);
            st.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }

    }

    @Override
    public void desactivar(int id_producto) throws Exception {
        try {
            this.establecerConexionDB();

            // En lugar de DELETE, hacemos un UPDATE para cambiar el estado.
            String sql = "UPDATE Productos SET estado = 'Inactivo' WHERE Id_producto = ?";

            PreparedStatement st = this.conectar.prepareStatement(sql);
            st.setInt(1, id_producto);
            st.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }
    }

    @Override
    public List<Producto> listarProductos() throws Exception {

        List<Producto> listaDeProductos = new ArrayList<>();

        try {
            this.establecerConexionDB();

            String sql = "SELECT p.*, pr.Empresa "
                    + "FROM Productos p "
                    + "INNER JOIN Proveedores pr ON p.id_proveedor = pr.id_proveedor "
                    + "WHERE p.Estado = 'Activo'";

            PreparedStatement st = this.conectar.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Producto prod = new Producto();
                prod.setId_producto(rs.getInt("Id_producto"));
                prod.setNombre(rs.getString("Nombre"));
                prod.setMarca(rs.getString("Marca"));
                prod.setStock(rs.getInt("Stock"));
                prod.setPrecio(rs.getDouble("Precio"));
                prod.setObservacion(rs.getString("Observacion"));

                Proveedor prov = new Proveedor();

                prov.setId_proveedor(rs.getInt("id_proveedor"));
                prov.setEmpresa(rs.getString("Empresa"));

                prod.setProovedor(prov);

                listaDeProductos.add(prod);

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }
        return listaDeProductos;

    }

    @Override
    public List<Producto> BuscarProductos(String nombre) throws Exception {

        List<Producto> listaBDeProductos = new ArrayList<>();

        try {
            this.establecerConexionDB();
            String sql = "SELECT p.*, pr.Empresa "
                    + "FROM Productos p "
                    + "INNER JOIN Proveedores pr ON p.id_proveedor = pr.id_proveedor "
                    + "WHERE (p.Nombre LIKE ? OR p.Marca LIKE ?) AND p.Estado = 'Activo'";
            PreparedStatement st = this.conectar.prepareStatement(sql);
            st.setString(1, "%" + nombre + "%");
            st.setString(2, "%" + nombre + "%");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Producto prod = new Producto();
                prod.setId_producto(rs.getInt("Id_producto"));
                prod.setNombre(rs.getString("Nombre"));
                prod.setMarca(rs.getString("Marca"));
                prod.setStock(rs.getInt("Stock"));
                prod.setPrecio(rs.getDouble("Precio"));
                prod.setObservacion(rs.getString("Observacion"));

                Proveedor prov = new Proveedor();

                prov.setId_proveedor(rs.getInt("id_proveedor"));
                prov.setEmpresa(rs.getString("Empresa"));

                prod.setProovedor(prov);

                listaBDeProductos.add(prod);

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }
        return listaBDeProductos;

    }

    @Override
    public List<Object[]> listarBajoStock() throws Exception {
        List<Object[]> lista = new ArrayList<>();
        try {
            this.establecerConexionDB();
            // La consulta busca productos con stock menor o igual a 10 y los ordena.
            String sql = "SELECT id_producto, Nombre, Stock FROM Productos WHERE Stock <= 10 ORDER BY Stock ASC";
            PreparedStatement st = this.conectar.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_producto"),
                    rs.getString("Nombre"),
                    rs.getInt("Stock")
                };
                lista.add(fila);
            }
        } finally {
            this.cerrarConexionDB();
        }
        return lista;
    }

    @Override
    public List<Object[]> listarMasVendidos() throws Exception {
        List<Object[]> lista = new ArrayList<>();
        try {
            this.establecerConexionDB();
            // La consulta busca los 5 productos más vendidos sumando las cantidades de la tabla de unión.
            String sql = "SELECT TOP 5 p.id_producto, p.Nombre, SUM(vp.Cantidad) as CantidadVendida "
                    + "FROM Ventas_Productos vp "
                    + "JOIN Productos p ON vp.id_producto = p.id_producto "
                    + "GROUP BY p.id_producto, p.Nombre "
                    + "ORDER BY CantidadVendida DESC";
            PreparedStatement st = this.conectar.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("id_producto"),
                    rs.getString("Nombre"),
                    rs.getInt("CantidadVendida")
                };
                lista.add(fila);
            }
        } finally {
            this.cerrarConexionDB();
        }
        return lista;
    }
}

package com.mycompany.sistemadeventaseinventario.DAOImplementacion;

import com.mycompany.sistemadeventaseinventario.Conexion.ConexionDB;
import com.mycompany.sistemadeventaseinventario.Entidades.DetalleVenta;
import com.mycompany.sistemadeventaseinventario.Entidades.Venta;
import com.mycompany.sistemadeventaseinventario.PersistenciaDAO.DAOVenta;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOVentaImpl extends ConexionDB implements DAOVenta {

    @Override
    public void registrar(Venta venta) throws Exception {
        try {
            this.establecerConexionDB();

            // Deshabilitar el AutoCommit para iniciar la transaccion en la Base de Datos            this.conectar.setAutoCommit(false);

            // Registrar el encabezado de la Venta 
            String sqlVenta = "INSERT INTO Ventas(id_cliente, Fecha, Total) VALUES (?, ?, ?)";
            PreparedStatement stVenta = this.conectar.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS);
            stVenta.setInt(1, venta.getId_cliente());
            stVenta.setDate(2, (Date) venta.getFecha());
            stVenta.setDouble(3, venta.getTotal());

            stVenta.executeUpdate();

            //  Obtener el ID de la Venta que se acaba de generar
            ResultSet rs = stVenta.getGeneratedKeys();
            int idVentaGenerado = 0;
            if (rs.next()) {
                idVentaGenerado = rs.getInt(1);
            }
            rs.close();
            stVenta.close();

            // Registrar el detalle de la venta y actualizar el stock 
            String sqlDetalle = "INSERT INTO Ventas_Productos(id_venta, id_producto, Cantidad, SubTotal) VALUES (?, ?, ?, ?)";
            String sqlStock = "UPDATE Productos SET Stock = Stock - ? WHERE id_producto = ?";

            PreparedStatement stDetalle = this.conectar.prepareStatement(sqlDetalle);
            PreparedStatement stStock = this.conectar.prepareStatement(sqlStock);

            for (DetalleVenta detalle : venta.getDetalles()) {
                // Para el INSERT en Ventas_Productos
                stDetalle.setInt(1, idVentaGenerado);
                stDetalle.setInt(2, detalle.getProducto().getId_producto());
                stDetalle.setInt(3, detalle.getCantidad());
                stDetalle.setDouble(4, detalle.getSubtotal());
                stDetalle.executeUpdate();

                // Para el UPDATE en Productos
                stStock.setInt(1, detalle.getCantidad());
                stStock.setInt(2, detalle.getProducto().getId_producto());
                stStock.executeUpdate();
            }
            stDetalle.close();
            stStock.close();

            // Si todo salió bien, confirmar la transacción
            this.conectar.commit();

        } catch (SQLException e) {
            // Si algo falló, revertir TODOS los cambios
            if (this.conectar != null) {
                this.conectar.rollback();
            }
            // Lanzamos la excepción para que la la IGU sepa que hubo un error
            throw e;
        } finally {
            // En cualquier caso (éxito o fracaso), cerrar la conexión
            // y reactivar el autocommit para futuras operaciones.
            if (this.conectar != null) {
                this.conectar.setAutoCommit(true);
            }
            this.cerrarConexionDB();
        }
    }

    @Override
    public List<Object[]> listaDeVentas() throws Exception {

        List<Object[]> listaVentas = new ArrayList<>();
        try {
            this.establecerConexionDB();

            String sql = "SELECT "
                    + "  v.id_venta, "
                    + "  v.Fecha, "
                    + "  c.Nombres, "
                    + "  c.DNI, "
                    + "  v.Total "
                    + "FROM Ventas v "
                    + "JOIN Clientes c ON v.id_cliente = c.id_cliente "
                    + "ORDER BY v.id_venta DESC";

            PreparedStatement st = this.conectar.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("id_venta");
                fila[1] = rs.getDate("Fecha");
                fila[2] = rs.getString("Nombres");
                fila[3] = rs.getString("DNI");
                fila[4] = rs.getDouble("Total");
                listaVentas.add(fila);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }
        return listaVentas;

    }

    @Override
    public Object[] obtenerVentaConCliente(int idVenta) throws Exception {

        Object[] datosVenta = null;
        try {
            this.establecerConexionDB();
            String sql = "SELECT v.id_venta, v.Fecha, c.Nombres, c.DNI, v.Total "
                    + "FROM Ventas v "
                    + "JOIN Clientes c ON v.id_cliente = c.id_cliente "
                    + "WHERE v.id_venta = ?";
            PreparedStatement st = this.conectar.prepareStatement(sql);
            st.setInt(1, idVenta);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                datosVenta = new Object[5];
                datosVenta[0] = rs.getInt("id_venta");
                datosVenta[1] = rs.getDate("Fecha");
                datosVenta[2] = rs.getString("Nombres");
                datosVenta[3] = rs.getString("DNI");
                datosVenta[4] = rs.getDouble("Total");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }
        return datosVenta;
    }

    @Override
    public List<Object[]> listarDetallesPorVenta(int idVenta) throws Exception {
        List<Object[]> listaDetalles = new ArrayList<>();
        try {
            this.establecerConexionDB();
            String sql = "SELECT p.id_producto, p.Nombre, vp.Cantidad, p.Precio, vp.SubTotal "
                    + "FROM Ventas_Productos vp "
                    + "JOIN Productos p ON vp.id_producto = p.id_producto "
                    + "WHERE vp.id_venta = ?";
            PreparedStatement st = this.conectar.prepareStatement(sql);
            st.setInt(1, idVenta);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("id_producto");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getInt("Cantidad");
                fila[3] = rs.getDouble("Precio");
                fila[4] = rs.getDouble("SubTotal");
                listaDetalles.add(fila);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }
        return listaDetalles;
    }

    @Override
    public List<Object[]> buscar(String criterio) throws Exception {

        List<Object[]> listaVentas = new ArrayList<>();
        try {
            this.establecerConexionDB();

            String sql = "SELECT "
                    + "  v.id_venta, v.Fecha, c.Nombres, c.DNI, v.Total "
                    + "FROM Ventas v "
                    + "JOIN Clientes c ON v.id_cliente = c.id_cliente "
                    + "WHERE c.Nombres LIKE ? OR c.DNI LIKE ? "
                    + // <-- AQUÍ ESTÁ LA MAGIA
                    "ORDER BY v.id_venta DESC";

            PreparedStatement st = this.conectar.prepareStatement(sql);
            st.setString(1, "%" + criterio + "%");
            st.setString(2, "%" + criterio + "%");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("id_venta");
                fila[1] = rs.getDate("Fecha");
                fila[2] = rs.getString("Nombres");
                fila[3] = rs.getString("DNI");
                fila[4] = rs.getDouble("Total");
                listaVentas.add(fila);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }
        return listaVentas;
    }

}

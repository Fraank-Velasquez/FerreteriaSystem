/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadeventaseinventario.DAOImplementacion;

import com.mycompany.sistemadeventaseinventario.Conexion.ConexionDB;
import com.mycompany.sistemadeventaseinventario.PersistenciaDAO.DAOReportes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Frank
 */
public class DAOReportesImpl extends ConexionDB implements DAOReportes {

    @Override
    public List<Object[]> generarReporteInventario(int anio, int mes) throws Exception {
        List<Object[]> listaReporte = new ArrayList<>();
        try {
            this.establecerConexionDB();
            String sql = "SELECT "
                    + "  p.id_producto, p.Nombre, "
                    + "  SUM(vp.Cantidad) AS CantidadTotalVendida, "
                    + "  SUM(vp.SubTotal) AS IngresosTotalesPorProducto "
                    + "FROM Ventas v "
                    + "JOIN Ventas_Productos vp ON v.id_venta = vp.id_venta "
                    + "JOIN Productos p ON vp.id_producto = p.id_producto "
                    + "WHERE YEAR(v.Fecha) = ? AND MONTH(v.Fecha) = ? "
                    + "GROUP BY p.id_producto, p.Nombre "
                    + "ORDER BY CantidadTotalVendida DESC"; // Ordenamos por los más vendidos
            PreparedStatement st = this.conectar.prepareStatement(sql);
            st.setInt(1, anio);
            st.setInt(2, mes);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getInt("id_producto");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getInt("CantidadTotalVendida");
                fila[3] = rs.getDouble("IngresosTotalesPorProducto");
                listaReporte.add(fila);
            }
        } finally {
            this.cerrarConexionDB();
        }
        return listaReporte;
    }

    @Override
    public List<Object[]> generarResumenAnualPorMes(int anio) throws Exception {

        List<Object[]> listaResumen = new ArrayList<>();
        try {
            this.establecerConexionDB();

            // --- NUEVA CONSULTA: Agrupa por mes para un año específico ---
            String sql = "SELECT "
                    + "  MONTH(Fecha) AS MesVenta, "
                    + "  SUM(Total) AS TotalIngresos, "
                    + "  COUNT(id_venta) AS CantVentas, "
                    + "  AVG(Total) AS TicketPromedio "
                    + "FROM Ventas "
                    + "WHERE YEAR(Fecha) = ? "
                    + "GROUP BY MONTH(Fecha) "
                    + "ORDER BY MesVenta"; // Ordenamos por mes

            PreparedStatement st = this.conectar.prepareStatement(sql);
            st.setInt(1, anio);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[4]; // Ahora son 4 columnas desde el DAO
                fila[0] = rs.getInt("MesVenta");
                fila[1] = rs.getDouble("TotalIngresos");
                fila[2] = rs.getInt("CantVentas");
                fila[3] = rs.getDouble("TicketPromedio");
                listaResumen.add(fila);
            }
        } finally {
            this.cerrarConexionDB();
        }
        return listaResumen;

    }
}

package com.mycompany.sistemadeventaseinventario.PersistenciaDAO;

import java.util.List;

/**
 *
 * @author Frank
 */
public interface DAOReportes {

    // Genera un reporte de los productos más vendidos en un mes y año.
    // Devuelve una lista de filas, cada una con: [ID Prod, Nombre Prod, Cant. Vendida, Total Ingresado]
    public List<Object[]> generarReporteInventario(int anio, int mes) throws Exception;


    public List<Object[]> generarResumenAnualPorMes(int anio) throws Exception;

}

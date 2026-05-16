package com.mycompany.sistemadeventaseinventario.PersistenciaDAO;

import com.mycompany.sistemadeventaseinventario.Entidades.Venta;
import java.util.List;

public interface DAOVenta {

    public void registrar(Venta venta) throws Exception;

    public List<Object[]> listaDeVentas() throws Exception;

    public Object[] obtenerVentaConCliente(int idVenta) throws Exception;

    public List<Object[]> listarDetallesPorVenta(int idVenta) throws Exception;
    
    public List<Object[]> buscar(String criterio) throws Exception;

}

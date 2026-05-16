package com.mycompany.sistemadeventaseinventario.PersistenciaDAO;

import com.mycompany.sistemadeventaseinventario.Entidades.Proveedor;
import java.util.List;

public interface DAOProveedores {

    public void registrar(Proveedor proveed) throws Exception;

    public void Editar(Proveedor prov, int id_proveedor) throws Exception;

    public void Eliminar(int id_proveedor) throws Exception;

    public List<Proveedor> listarProveedores() throws Exception;

    public Proveedor traerProveedor(int id_proveedor) throws Exception;

    public List<String> obtenerNombresEmpresas() throws Exception;

    public List<Proveedor> BuscarProveedor(String nombre) throws Exception;
}

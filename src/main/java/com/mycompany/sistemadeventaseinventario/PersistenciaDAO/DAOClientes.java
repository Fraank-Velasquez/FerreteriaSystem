package com.mycompany.sistemadeventaseinventario.PersistenciaDAO;

import com.mycompany.sistemadeventaseinventario.Entidades.Cliente;

import java.util.List;

/**
 *
 * @author Frank
 */
public interface DAOClientes {

    public void registrar(Cliente cliente) throws Exception;

    public void Editar(int id_cliente,  Cliente client) throws Exception;

    public void Eliminar(int id_cliente) throws Exception;

    public List<Cliente> listarClientes() throws Exception;

    public List<Cliente> BuscarClientes(String DNI) throws Exception;
    
    public Cliente buscarPorDNI(String DNI) throws Exception;

}

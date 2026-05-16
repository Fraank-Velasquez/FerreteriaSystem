package com.mycompany.sistemadeventaseinventario.DAOImplementacion;

import com.mycompany.sistemadeventaseinventario.Conexion.ConexionDB;
import com.mycompany.sistemadeventaseinventario.Entidades.Cliente;
import com.mycompany.sistemadeventaseinventario.PersistenciaDAO.DAOClientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Frank
 */
public class DAOClientesImpl extends ConexionDB implements DAOClientes {

   @Override
    public void registrar(Cliente cliente) throws Exception {

        try {
            this.establecerConexionDB();

            PreparedStatement ps = this.conectar.prepareStatement
        ("INSERT INTO Clientes(Nombres,Telefono,Email,Direccion,DNI) VALUES(?,?,?,?,?)");
            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getDNI());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }

    }

    @Override
    public void Editar(int id_cliente, Cliente client) throws Exception {

        try {
            this.establecerConexionDB();
            PreparedStatement st = this.conectar.prepareStatement
        ("UPDATE Clientes SET Nombres = ?, Telefono = ?,Email = ?,Direccion = ?,DNI = ? WHERE id_cliente = " + id_cliente);
            st.setString(1, client.getNombres());
            st.setString(2, client.getTelefono());
            st.setString(3, client.getEmail());
            st.setString(4, client.getDireccion());
            st.setString(5, client.getDNI());

            st.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        } finally {
            this.cerrarConexionDB();
        }

    }

    @Override
    public void Eliminar(int id_cliente) throws Exception {

        try {
            this.establecerConexionDB();
            PreparedStatement stm = this.conectar.prepareStatement("DELETE FROM Clientes where id_cliente = ? ");
            stm.setInt(1, id_cliente);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrarConexionDB();
        }

    }

    @Override
    public List<Cliente> listarClientes() throws Exception {

        List<Cliente> listaDeClientes = new ArrayList<>();

        try {

            this.establecerConexionDB();

            PreparedStatement st = this.conectar.prepareStatement("select * from Clientes");
            ResultSet rs = st.executeQuery();
            

            while (rs.next()) {

                Cliente Lcliente = new Cliente();

                Lcliente.setId_cliente(rs.getInt("id_cliente"));
                Lcliente.setNombres(rs.getString("Nombres"));
                Lcliente.setTelefono(rs.getString("Telefono"));
                Lcliente.setEmail(rs.getString("Email"));
                Lcliente.setDireccion(rs.getString("Direccion"));
                Lcliente.setDNI(rs.getString("DNI"));

                listaDeClientes.add(Lcliente);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrarConexionDB();
        }
        return listaDeClientes;

    }

    @Override
    public List<Cliente> BuscarClientes(String DNI) throws Exception {

        List<Cliente> listaBClientes = new ArrayList<>();

        try {
            this.establecerConexionDB();
            PreparedStatement st = this.conectar.prepareStatement("select * from Clientes WHERE DNI LIKE '%" + DNI + "%'");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Cliente clB = new Cliente();
                clB.setId_cliente(rs.getInt("id_cliente"));
                clB.setNombres(rs.getString("Nombres"));
                clB.setDNI(rs.getString("DNI"));
                clB.setTelefono(rs.getString("Telefono"));
                clB.setEmail(rs.getString("Email"));
                clB.setDireccion(rs.getString("Direccion"));

                listaBClientes.add(clB);
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }
        return listaBClientes;

    }

    @Override
    public Cliente buscarPorDNI(String DNI) throws Exception {
        Cliente cliente = null; // Empezamos asumiendo que no lo encontraremos
        try {
            this.establecerConexionDB();
            PreparedStatement st = this.conectar.prepareStatement("SELECT * FROM Clientes WHERE DNI = ?");
            st.setString(1, DNI);

            ResultSet rs = st.executeQuery();
            if (rs.next()) { // Si rs.next() es true, significa que se encontró una fila
                cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNombres(rs.getString("Nombres"));
                cliente.setDNI(rs.getString("DNI"));
                // ... setear los otros atributos si los necesitas ...
            }
 
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrarConexionDB();
        }
        return cliente; // Devuelve el cliente encontrado, o null si no se encontró ninguno
    }

}

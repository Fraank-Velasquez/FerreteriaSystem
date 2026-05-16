package com.mycompany.sistemadeventaseinventario.DAOImplementacion;

import com.mycompany.sistemadeventaseinventario.Conexion.ConexionDB;
import com.mycompany.sistemadeventaseinventario.Entidades.Proveedor;
import com.mycompany.sistemadeventaseinventario.PersistenciaDAO.DAOProveedores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProveedoresImpl extends ConexionDB implements DAOProveedores {

    @Override
    public void registrar(Proveedor proveed) throws Exception {

        try {

            this.establecerConexionDB();
            PreparedStatement st = this.conectar.prepareStatement("INSERT INTO Proveedores(Empresa,Contacto,Telefono, Email,ProdSuministrados,Direccion)VALUES (?,?,?,?,?,?)");
            st.setString(1, proveed.getEmpresa());
            st.setString(2, proveed.getContacto());
            st.setString(3, proveed.getTelefono());
            st.setString(4, proveed.getEmail());
            st.setString(5, proveed.getProdSuministrados());
            st.setString(6, proveed.getDireccion());
            st.executeUpdate();

        } catch (SQLException e) {
        } finally {
            this.cerrarConexionDB();
        }

    }

    @Override
    public List<Proveedor> listarProveedores() throws Exception {
        List<Proveedor> listaProv = new ArrayList<>();

        try {

            this.establecerConexionDB();
            PreparedStatement st = this.conectar.prepareStatement("select * from Proveedores");
            ResultSet resultado = st.executeQuery();

            while (resultado.next()) {
                Proveedor prov = new Proveedor();
                prov.setId_proveedor(resultado.getInt("id_proveedor"));
                prov.setEmpresa(resultado.getString("Empresa"));
                prov.setContacto(resultado.getString("Contacto"));
                prov.setTelefono(resultado.getString("Telefono"));
                prov.setEmail(resultado.getString("Email"));
                prov.setProdSuministrados(resultado.getString("ProdSuministrados"));
                prov.setDireccion(resultado.getString("Direccion"));
                listaProv.add(prov);
            }
        } catch (SQLException e) {
        } finally {
            this.cerrarConexionDB();
        }

        return listaProv;
    }

    @Override
    public Proveedor traerProveedor(int id_proveedor) throws Exception {
        Proveedor proveed = new Proveedor();
        try {

            this.establecerConexionDB();
            PreparedStatement st = this.conectar.prepareStatement(" select * from Proveedores where Proveedores.id_proveedor = ?");
            st.setInt(1, id_proveedor);

            ResultSet RS = st.executeQuery();

            if (RS.next()) {
                proveed.setId_proveedor(RS.getInt("id_proveedor"));
                proveed.setEmpresa(RS.getString("Empresa"));
                proveed.setContacto(RS.getString("Contacto"));
                proveed.setContacto(RS.getString("Telefono"));
                proveed.setEmail(RS.getString("Email"));
                proveed.setProdSuministrados(RS.getString("ProdSuministrados"));
                proveed.setDireccion(RS.getString("Direccion"));
            }

        } catch (SQLException e) {
            throw e;

        } finally {
            this.cerrarConexionDB();
        }
        return proveed;
    }

    @Override
    public List<String> obtenerNombresEmpresas() throws Exception {

        List<String> nombres = new ArrayList<>();
        List<Proveedor> lista = listarProveedores(); // Ya existente

        for (Proveedor p : lista) {
            nombres.add(p.getEmpresa());
        }

        return nombres;
    }

    @Override
    public List<Proveedor> BuscarProveedor(String nombre) throws Exception {

        List<Proveedor> listaBPrveedores = new ArrayList<>();

        try {

            this.establecerConexionDB();
            PreparedStatement stB = this.conectar.prepareStatement("select * from Proveedores WHERE Empresa LIKE '%" + nombre + "%'");
            ResultSet rs = stB.executeQuery();

            while (rs.next()) {

                Proveedor provB = new Proveedor();
                provB.setId_proveedor(rs.getInt("id_proveedor"));
                provB.setEmpresa(rs.getString("Empresa"));
                provB.setContacto(rs.getString("Contacto"));
                provB.setTelefono(rs.getString("Telefono"));
                provB.setEmail(rs.getString("Email"));
                provB.setProdSuministrados(rs.getString("ProdSuministrados"));
                provB.setDireccion(rs.getString("Direccion"));
                listaBPrveedores.add(provB);
            }

        } catch (SQLException e) {

            e.getMessage();
        } finally {

            this.cerrarConexionDB();
        }

        return listaBPrveedores;
    }

    @Override
    public void Editar(Proveedor prov, int id_proveedor) throws Exception {

        try {

            this.establecerConexionDB();

            PreparedStatement st = this.conectar.prepareStatement("UPDATE Proveedores SET Empresa = ?, Contacto = ?,Telefono = ?,Email=?,ProdSuministrados=?,Direccion=? where id_proveedor = " + id_proveedor);
            st.setString(1, prov.getEmpresa());
            st.setString(2, prov.getContacto());
            st.setString(3, prov.getTelefono());
            st.setString(4, prov.getEmail());
            st.setString(5, prov.getProdSuministrados());
            st.setString(6, prov.getDireccion());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.cerrarConexionDB();
        }

    }

    @Override
    public void Eliminar(int id_proveedor) throws Exception {

        try {

            this.establecerConexionDB();
            PreparedStatement stD = this.conectar.prepareStatement("DELETE FROM Proveedores where id_proveedor = ?");
            stD.setInt(1, id_proveedor);
            stD.executeUpdate();

        } catch (SQLException e) {

            e.getMessage();

        } finally {

            this.cerrarConexionDB();
        }

    }

}

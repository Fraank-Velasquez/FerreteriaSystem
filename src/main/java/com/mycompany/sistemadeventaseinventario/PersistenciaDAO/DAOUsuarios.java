package com.mycompany.sistemadeventaseinventario.PersistenciaDAO;

import com.mycompany.sistemadeventaseinventario.Entidades.Usuario;
import java.util.List;

public interface DAOUsuarios {

    public void registrar(Usuario user) throws Exception;

    public void editar(Usuario user) throws Exception;

    public List<Usuario> ListarUsuarios() throws Exception;

    public Usuario validarUsuario(String correo, String contrasenia) throws Exception;

    public void actualizar_password(Usuario user, String nueva) throws Exception;

}

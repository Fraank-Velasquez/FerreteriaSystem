package com.mycompany.sistemadeventaseinventario.Entidades;

public class Usuario {

    private String Nombres;
    private String Primer_apellido;
    private String Segundo_apellido;
    private String DNI;
    private String Correo;
    private String Contrasenia;
    private String Rol;

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getPrimer_apellido() {
        return Primer_apellido;
    }

    public void setPrimer_apellido(String Primer_apellido) {
        this.Primer_apellido = Primer_apellido;
    }

    public String getSegundo_apellido() {
        return Segundo_apellido;
    }

    public void setSegundo_apellido(String Segundo_apellido) {
        this.Segundo_apellido = Segundo_apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contraseña) {
        this.Contrasenia = Contraseña;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

}

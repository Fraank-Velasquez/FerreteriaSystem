package com.mycompany.sistemadeventaseinventario.Entidades;

public class Proveedor {

    private int id_proveedor;
    private String Empresa;
    private String Contacto;
    private String Telefono;
    private String Email;
    private String ProdSuministrados;
    private String Direccion;

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getProdSuministrados() {
        return ProdSuministrados;
    }

    public void setProdSuministrados(String ProdSuministrados) {
        this.ProdSuministrados = ProdSuministrados;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    @Override
    public String toString() {
        return this.Empresa;
    }

}

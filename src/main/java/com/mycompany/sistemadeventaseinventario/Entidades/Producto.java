package com.mycompany.sistemadeventaseinventario.Entidades;

/**
 *
 * @author Frank
 */
public class Producto {

    private int Id_producto;
    private String Nombre;
    private String Marca;
    private int Stock;
    private double Precio;
    private String Observacion;
    private Proveedor proovedor;

    public int getId_producto() {
        return Id_producto;
    }

    public void setId_producto(int Id_producto) {
        this.Id_producto = Id_producto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public Proveedor getProovedor() {
        return proovedor;
    }

    public void setProovedor(Proveedor proovedor) {
        this.proovedor = proovedor;
    }




}

package com.iudigital.gusto.supremo.domain;

public class Ingrediente {
    
    private int id;
    private String idUnidadMedida;
    private String unidadMedidaNombre;
    private String nombre;
    private int cantidadInventario;
    private int cantidadMinima;

    public Ingrediente() {
    }

    public Ingrediente(int id, String idUnidadMedida, String unidadMedidaNombre, String nombre, int cantidadInventario, int cantidadMinima) {
        this.id = id;
        this.idUnidadMedida = idUnidadMedida;
        this.unidadMedidaNombre = unidadMedidaNombre;
        this.nombre = nombre;
        this.cantidadInventario = cantidadInventario;
        this.cantidadMinima = cantidadMinima;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(String idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getUnidadMedidaNombre() {
        return unidadMedidaNombre;
    }

    public void setUnidadMedidaNombre(String unidadMedidaNombre) {
        this.unidadMedidaNombre = unidadMedidaNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(int cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    @Override
    public String toString() {
        return nombre;
    }   
    
}

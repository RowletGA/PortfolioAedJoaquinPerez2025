package com.example;

public class Sucursal implements ISucursal {
    private String nombre;

    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

}


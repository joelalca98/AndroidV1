package com.example.login;

import java.io.Serializable;

public class Arma implements Serializable {
    String nombre;
    int damage;
    double precio;
    String imagen;

    public Arma() {
    }

    public Arma(String nombre, int damage, double precio, String imagen) {
        this.nombre = nombre;
        this.damage = damage;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Arma{" +
                "nombre='" + nombre + '\'' +
                ", damage=" + damage +
                ", precio=" + precio +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}

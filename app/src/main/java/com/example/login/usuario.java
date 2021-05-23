package com.example.login;

import java.io.Serializable;

public class usuario implements Serializable {
    String idUser;
    String nombre;
    String apellido;
    String password;

    @Override
    public String toString() {
        return "Usuario{" +
                "idUser='" + idUser + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public usuario() {
    }

    public usuario(String idUser, String nombre, String apellido, String password) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

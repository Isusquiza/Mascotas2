package com.eisusquiza.mascotas;

/**
 * Created by eisusquiza on 27/11/2016.
 */

public class Mascota {

    private int foto;
    private String nombre;
    private int estrellas;

    public Mascota(int foto, String nombre, int estrellas) {
        this.foto = foto;
        this.nombre = nombre;
        this.estrellas = estrellas;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }


}

package com.florenciaolivieri.petgrammascotas;

public class Mascota {
    private String nombre;
    private String numeroLikes;
    private int foto;

    public Mascota( int foto, String nombre, String numeroLikes) {
        this.nombre      = nombre;
        this.numeroLikes = numeroLikes;
        this.foto        = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getNumeroLikes() {
        return numeroLikes;
    }

    public void setNumeroLikes(String numeroLikes) {
        this.numeroLikes = numeroLikes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
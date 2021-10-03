package com.example.irfan.sistempakar.model;

public class Penyakit {
    private int idPenyakit;
    private String kodePenyakit;
    private String namaPenyakit;
    private String definisiPenyakit;
    private String imagePenyakit;

    public Penyakit(int idPenyakit, String kodePenyakit, String namaPenyakit, String definisiPenyakit, String imagePenyakit) {
        this.idPenyakit = idPenyakit;
        this.kodePenyakit = kodePenyakit;
        this.namaPenyakit = namaPenyakit;
        this.definisiPenyakit = definisiPenyakit;
        this.imagePenyakit = imagePenyakit;
    }

    public int getIdPenyakit() {
        return idPenyakit;
    }

    public String getKodePenyakit() {
        return kodePenyakit;
    }

    public String getNamaPenyakit() {
        return namaPenyakit;
    }

    public String getDefinisiPenyakit() {
        return definisiPenyakit;
    }

    public String getImagePenyakit() {
        return imagePenyakit;
    }
}

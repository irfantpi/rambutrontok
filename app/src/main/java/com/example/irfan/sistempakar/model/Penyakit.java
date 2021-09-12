package com.example.irfan.sistempakar.model;

public class Penyakit {
    private int idPenyakit;
    private String kodePenyakit;
    private String namaPenyakit;

    public Penyakit(int idPenyakit, String kodePenyakit, String namaPenyakit) {
        this.idPenyakit = idPenyakit;
        this.kodePenyakit = kodePenyakit;
        this.namaPenyakit = namaPenyakit;
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
}

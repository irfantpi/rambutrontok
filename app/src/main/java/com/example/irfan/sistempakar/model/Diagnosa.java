package com.example.irfan.sistempakar.model;

public class Diagnosa {
    private int id_penyakit;
    private int id_gejala;

    public Diagnosa(int id_penyakit, int id_gejala) {
        this.id_penyakit = id_penyakit;
        this.id_gejala = id_gejala;
    }

    public int getId_penyakit() {
        return id_penyakit;
    }

    public int getId_gejala() {
        return id_gejala;
    }
}

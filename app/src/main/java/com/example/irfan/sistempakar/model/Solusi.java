package com.example.irfan.sistempakar.model;

public class Solusi {
    private int idSolusi;
    private int idPenyakit;
    private String keteranganSolusi;

    public Solusi(int idSolusi, int idPenyakit, String keteranganSolusi) {
        this.idSolusi = idSolusi;
        this.idPenyakit = idPenyakit;
        this.keteranganSolusi = keteranganSolusi;
    }

    public int getIdSolusi() {
        return idSolusi;
    }

    public int getIdPenyakit() {
        return idPenyakit;
    }

    public String getKeteranganSolusi() {
        return keteranganSolusi;
    }
}

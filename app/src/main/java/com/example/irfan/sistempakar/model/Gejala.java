package com.example.irfan.sistempakar.model;

public class Gejala {
    private int idGejala;
    private int penyakitId;
    private String kodeGejala;
    private String namaGejala;

    public Gejala(int idGejala, int penyakitId, String kodeGejala, String namaGejala) {
        this.idGejala = idGejala;
        this.penyakitId = penyakitId;
        this.kodeGejala = kodeGejala;
        this.namaGejala = namaGejala;
    }

    public int getIdGejala() {
        return idGejala;
    }

    public int getPenyakitId() {
        return penyakitId;
    }

    public String getKodeGejala() {
        return kodeGejala;
    }

    public String getNamaGejala() {
        return namaGejala;
    }
}

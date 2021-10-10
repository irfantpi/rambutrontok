package com.example.irfan.sistempakar.model;

public class DiagnosaModel {
    private int idDiagnosa;
    private int idPenyakit;
    private int idUser;

    public DiagnosaModel(int idDiagnosa, int idPenyakit, int idUser) {
        this.idDiagnosa = idDiagnosa;
        this.idPenyakit = idPenyakit;
        this.idUser = idUser;
    }

    public int getIdDiagnosa() {
        return idDiagnosa;
    }

    public int getIdPenyakit() {
        return idPenyakit;
    }

    public int getIdUser() {
        return idUser;
    }
}

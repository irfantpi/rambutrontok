package com.example.irfan.sistempakar.model;

public class History {
    private int idDiagnosa;
    private int idPenyakit;
    private int idUser;
    private String namaPenyakit;
    private String namaUser;
    private String jenisKelamin;

    public History(int idDiagnosa, int idPenyakit, int idUser, String namaPenyakit, String namaUser, String jenisKelamin) {
        this.idDiagnosa = idDiagnosa;
        this.idPenyakit = idPenyakit;
        this.idUser = idUser;
        this.namaPenyakit = namaPenyakit;
        this.namaUser = namaUser;
        this.jenisKelamin = jenisKelamin;
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

    public String getNamaPenyakit() {
        return namaPenyakit;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setIdDiagnosa(int idDiagnosa) {
        this.idDiagnosa = idDiagnosa;
    }

    public void setIdPenyakit(int idPenyakit) {
        this.idPenyakit = idPenyakit;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setNamaPenyakit(String namaPenyakit) {
        this.namaPenyakit = namaPenyakit;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
}

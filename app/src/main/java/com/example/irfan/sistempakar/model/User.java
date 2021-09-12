package com.example.irfan.sistempakar.model;

public class User {
    private int idUser;
    private String namaUser;
    private String umurUser;
    private String jenisKelaminUser;

    public User(int idUser, String namaUser, String umurUser, String jenisKelaminUser) {
        this.idUser = idUser;
        this.namaUser = namaUser;
        this.umurUser = umurUser;
        this.jenisKelaminUser = jenisKelaminUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public String getUmurUser() {
        return umurUser;
    }

    public String getJenisKelaminUser() {
        return jenisKelaminUser;
    }
}

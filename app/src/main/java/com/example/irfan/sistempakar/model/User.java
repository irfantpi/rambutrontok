package com.example.irfan.sistempakar.model;

public class User {
    private int idUser;
    private String namaUser;
    private String umurUser;
    private String jenisKelaminUser;
    private String alamat;
    private String noTelepon;

    public User(int idUser, String namaUser, String umurUser, String jenisKelaminUser, String alamat, String noTelepon) {
        this.idUser = idUser;
        this.namaUser = namaUser;
        this.umurUser = umurUser;
        this.jenisKelaminUser = jenisKelaminUser;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
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

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }
}

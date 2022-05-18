package com.example.miniproject.Model;

import com.google.gson.annotations.SerializedName;

public class ModelBuku {
    @SerializedName("id")
    private int id;
    @SerializedName("kode")
    private String kode;
    @SerializedName("nama")
    private String nama;
    @SerializedName("matpel")
    private String matpel;
    @SerializedName("image")
    private String image;
    @SerializedName("url")
    private String url;

    public ModelBuku(int id, String kode, String nama, String matpel, String image, String url) {
        this.id = id;
        this.kode = kode;
        this.nama = nama;
        this.matpel = matpel;
        this.image = image;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMatpel() {
        return matpel;
    }

    public void setMatpel(String matpel) {
        this.matpel = matpel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

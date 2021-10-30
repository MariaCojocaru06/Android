package com.example.youtube_tut;

public class Domeniu {
    private String denumire;
    private int nr_postari;
    int imgUrl;

    public int getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }
//    private String imgUrl;
//
//    public String getImgUrl() {
//        return imgUrl;
//    }
//
//    public void setImgUrl(String imgUrl) {
//        this.imgUrl = imgUrl;
//    }

    public String getDenumire() {
        return denumire;
    }

    public Domeniu(String denumire, int nr_postari) {
        this.denumire = denumire;
        this.nr_postari = nr_postari;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public float getNr_postari() {
        return nr_postari;
    }

    public void setNr_postari(int nr_postari) {
        this.nr_postari = nr_postari;
    }
//
    public Domeniu(String denumire, int nr_postari, int img) {
        this.denumire = denumire;
        this.nr_postari = nr_postari;
        this.imgUrl=img;
    }


    public Domeniu() {
    }

    @Override
    public String toString() {
        return "Domeniu{" +
                "denumire='" + denumire + '\'' +
                ", nr_postari=" + nr_postari +
                '}';
    }
}

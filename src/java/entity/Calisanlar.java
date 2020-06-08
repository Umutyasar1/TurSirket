/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Umut
 */
public class Calisanlar {
    private Long calisan_id;
    private String calisan_adi;
    private String calisan_soyad;
    private int calisan_yas;
    
    private Sirket sirket;
 

    public Calisanlar() {
    }

    public Calisanlar(Long calisan_id, String calisan_adi, String calisan_soyad, int calisan_yas, Sirket sirket) {
        this.calisan_id = calisan_id;
        this.calisan_adi = calisan_adi;
        this.calisan_soyad = calisan_soyad;
        this.calisan_yas = calisan_yas;
        this.sirket = sirket;
    }

    
    

    public Long getCalisan_id() {
        return calisan_id;
    }

    public void setCalisan_id(Long calisan_id) {
        this.calisan_id = calisan_id;
    }

    public String getCalisan_adi() {
        return calisan_adi;
    }

    public void setCalisan_adi(String calisan_adi) {
        this.calisan_adi = calisan_adi;
    }

    public String getCalisan_soyad() {
        return calisan_soyad;
    }

    public void setCalisan_soyad(String calisan_soyad) {
        this.calisan_soyad = calisan_soyad;
    }

    public int getCalisan_yas() {
        return calisan_yas;
    }

    public void setCalisan_yas(int calisan_yas) {
        this.calisan_yas = calisan_yas;
    }

    public Sirket getSirket() {
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }
    
  
}

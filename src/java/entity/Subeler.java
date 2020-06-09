/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class Subeler {
    private int sube_id;
    private String sube_il;
    private String sube_ilce;
    private String sube_isim;

    public Subeler(int sube_id, String sube_il, String sube_ilce, String sube_isim) {
        this.sube_id = sube_id;
        this.sube_il = sube_il;
        this.sube_ilce = sube_ilce;
        this.sube_isim = sube_isim;
    }

    public Subeler() {
    }

    public int getSube_id() {
        return sube_id;
    }

    public void setSube_id(int sube_id) {
        this.sube_id = sube_id;
    }

    public String getSube_il() {
        return sube_il;
    }

    public void setSube_il(String sube_il) {
        this.sube_il = sube_il;
    }

    public String getSube_ilce() {
        return sube_ilce;
    }

    public void setSube_ilce(String sube_ilce) {
        this.sube_ilce = sube_ilce;
    }

    public String getSube_isim() {
        return sube_isim;
    }

    public void setSube_isim(String sube_isim) {
        this.sube_isim = sube_isim;
    }
    
    
}

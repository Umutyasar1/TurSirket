/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author casper
 */
public class Araclar {
    private int arac_id;
    private String arac_marka;
    private String arac_plaka;

    public Araclar(int arac_id, String arac_marka, String arac_plaka) {
        this.arac_id = arac_id;
        this.arac_marka = arac_marka;
        this.arac_plaka = arac_plaka;
    }

    public Araclar() {
    }

    public int getArac_id() {
        return arac_id;
    }

    public void setArac_id(int arac_id) {
        this.arac_id = arac_id;
    }

    public String getArac_marka() {
        return arac_marka;
    }

    public void setArac_marka(String arac_marka) {
        this.arac_marka = arac_marka;
    }

    public String getArac_plaka() {
        return arac_plaka;
    }

    public void setArac_plaka(String arac_plaka) {
        this.arac_plaka = arac_plaka;
    }
    
    
}

package entity;

import java.util.List;

public class Turlar {

    private Long tur_id;
    private String tur_yeri;
    private int tur_fiyat;
    
    private List<Musteri> musteriTur;
    

    public Turlar() {
    }

    public Turlar(Long tur_id, String tur_yeri, int tur_fiyat) {
        this.tur_id = tur_id;
        this.tur_yeri = tur_yeri;
        this.tur_fiyat = tur_fiyat;
    }

    public Long getTur_id() {
        return tur_id;
    }

    public void setTur_id(Long tur_id) {
        this.tur_id = tur_id;
    }


    public String getTur_yeri() {
        return tur_yeri;
    }

    public void setTur_yeri(String tur_yeri) {
        this.tur_yeri = tur_yeri;
    }

    public int getTur_fiyat() {
        return tur_fiyat;
    }

    public void setTur_fiyat(int tur_fiyat) {
        this.tur_fiyat = tur_fiyat;
    }

    public List<Musteri> getMusteriTur() {
        return musteriTur;
    }

    public void setMusteriTur(List<Musteri> musteriTur) {
        this.musteriTur = musteriTur;
    }

}

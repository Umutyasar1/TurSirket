
package entity;

//import java.util.List;

import java.util.Objects;


/**
 *
 * @author casper
 */
public class Musteri {
     private Long musteri_id;
    private String ad;
    private String soyad;
    private int telno;

    public Musteri() {
    }

    public Musteri(Long musteri_id, String ad, String soyad, int telno) {
        this.musteri_id = musteri_id;
        this.ad = ad;
        this.soyad = soyad;
        this.telno = telno;
    }

    public Long getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(Long musteri_id) {
        this.musteri_id = musteri_id;
    }


    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getTelno() {
        return telno;
    }

    public void setTelno(int telno) {
        this.telno = telno;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.musteri_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Musteri other = (Musteri) obj;
        if (!Objects.equals(this.musteri_id, other.musteri_id)) {
            return false;
        }
        return true;
    }


}

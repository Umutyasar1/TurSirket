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
public class Sirket {
    
    private Long sirket_id;
    private String sirket_ad;
    private String hakkimizda;

    public Sirket(Long sirket_id, String sirket_ad, String hakkimizda) {
        this.sirket_id = sirket_id;
        this.sirket_ad = sirket_ad;
        this.hakkimizda = hakkimizda;
    }

   
    public Sirket() {
    }
   
    public Long getSirket_id() {
        return sirket_id;
    }

    public void setSirket_id(Long sirket_id) {
        this.sirket_id = sirket_id;
    }

    public String getSirket_ad() {
        return sirket_ad;
    }

    public void setSirket_ad(String sirket_ad) {
        this.sirket_ad = sirket_ad;
    }

    public String getHakkimizda() {
        return hakkimizda;
    }

    public void setHakkimizda(String hakkimizda) {
        this.hakkimizda = hakkimizda;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.sirket_id);
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
        final Sirket other = (Sirket) obj;
        if (!Objects.equals(this.sirket_id, other.sirket_id)) {
            return false;
        }
        return true;
    }

  
    
    
}

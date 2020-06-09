/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AraclarDao;
import entity.Araclar;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author casper
 */
@Named
@SessionScoped
public class AraclarController implements Serializable {
    private List<Araclar> araclarList;
    private AraclarDao araclarDao;
    private Araclar araclar;
    
    
    public void updateForm(Araclar cat) {
        this.araclar = cat;

    }

    public void clearForm() {
        this.araclar = new Araclar();
    }

    public void deleteConfirm(Araclar cat) {
        this.araclar = cat;
    }

    public void update() {
        this.araclarDao.update(this.araclar);
        this.araclar = new Araclar();
    }

    public void delete() {
        this.getAraclarDao().delete(this.araclar);
        this.araclar = new Araclar();

    }

    public void create() {
        this.getAraclarDao().create(this.araclar);
        this.araclar = new Araclar();
    }

    public List<Araclar> getAraclarList() {
        this.araclarList = this.getAraclarDao().findAll();
        return araclarList;
    }

    public void setAraclarList(List<Araclar> araclarList) {
        this.araclarList = araclarList;
    }

    public AraclarDao getAraclarDao() {
        if (this.araclarDao == null) {
            this.araclarDao = new AraclarDao();
        }
        return araclarDao;
    }

    public void setAraclarDao(AraclarDao araclarDao) {
        this.araclarDao = araclarDao;
    }

    public Araclar getAraclar() {
        if (this.araclar == null) {
            this.araclar = new Araclar();
        }
        return araclar;
    }

    public void setAraclar(Araclar araclar) {
        this.araclar = araclar;
    }

}

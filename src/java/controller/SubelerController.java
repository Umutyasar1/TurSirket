/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SubelerDao;
import entity.Subeler;
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
public class SubelerController implements Serializable {
    
    private List<Subeler> subelerList;
    private SubelerDao subelerDao;
    private Subeler subeler;
    

    public void updateForm(Subeler cat) {
        this.subeler = cat;

    }

    public void clearForm() {
        this.subeler = new Subeler();
    }

    public void deleteConfirm(Subeler cat) {
        this.subeler = cat;
    }

    public void update() {
        this.subelerDao.update(this.subeler);
        this.subeler = new Subeler();
    }

    public void delete() {
        this.getSubelerDao().delete(this.subeler);
        this.subeler = new Subeler();

    }

    public void create() {
        this.getSubelerDao().create(this.subeler);
        this.subeler = new Subeler();
    }

    public List<Subeler> getSubelerList() {
        this.subelerList = this.getSubelerDao().findAll();
        return subelerList;
    }

    public void setSubelerList(List<Subeler> subelerList) {
        this.subelerList = subelerList;
    }

    public SubelerDao getSubelerDao() {
        if (this.subelerDao == null) {
            this.subelerDao = new SubelerDao();
        }
        return subelerDao;
    }

    public void setSubelerDao(SubelerDao subelerDao) {
        this.subelerDao = subelerDao;
    }

    public Subeler getSubeler() {
        if (this.subeler == null) {
            this.subeler = new Subeler();
        }
        return subeler;
    }

    public void setSubeler(Subeler subeler) {
        this.subeler = subeler;
    }

}

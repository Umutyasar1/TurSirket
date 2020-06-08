/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SirketDao;
import entity.Sirket;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Umut
 */
@Named
@SessionScoped
public class SirketController extends BaseBean implements Serializable {
    private List<Sirket> sirketList;
    private SirketDao sirketDao;

    private Sirket sirket;
    

    public void updateForm(Sirket sirket){
        this.sirket=sirket;
    }

    public void clearForm() {
        this.sirket = new Sirket();
    }

    public void update() {
        this.getSirketDao().update(this.sirket);
        this.sirket = new Sirket();
    }

    public String delete() {
        this.getSirketDao().delete(this.sirket);
        this.sirket= new Sirket();
        
        return "/sirket?faces-redirect=true" ;
    }

    public void create() {
        this.getSirketDao().create(this.sirket);
        this.sirket = new Sirket();
    }

    public List<Sirket> getSirketList() {
        this.sirketList = this.getSirketDao().findAll(page, pageSize);
        return sirketList;
    }

    public void setSirketList(List<Sirket> sirketList) {
        this.sirketList = sirketList;
    }

    public SirketDao getSirketDao() {
        if (this.sirketDao == null) {
            this.sirketDao = new SirketDao();
        }
        return sirketDao;
    }

    public void setSirketDao(SirketDao sirketDao) {
        this.sirketDao = sirketDao;
    }

    public Sirket getSirket() {
         if (this.sirket == null) {
            this.sirket = new Sirket();
        }
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }

    @Override
   public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getSirketDao().count()/(double) pageSize);
        return pageCount;
    }
    
}

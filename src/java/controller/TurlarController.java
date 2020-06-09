/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TurlarDao;
import entity.Turlar;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author casper
 */
@Named
@SessionScoped
public class TurlarController implements Serializable {

    private List<Turlar> turlarList;
    private TurlarDao turlarDao;
    private Turlar turlar;

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        
        this.pageCount = (int) Math.ceil(this.getTurlarDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Inject
    private MusteriController musteriController;

    public void updateForm(Turlar t) {
        this.turlar = t;

    }

    public void delete() {
        this.getTurlarDao().remove(this.turlar);
        this.clearForm();

    }

    public void clearForm() {
        this.turlar = new Turlar();
    }

    public void update() {
        this.getTurlarDao().edit(this.turlar);
        this.clearForm();
    }

    public void create() {
        this.getTurlarDao().create(this.turlar);
        this.clearForm();
    }

    public List<Turlar> getTurlarList() {
        this.turlarList = this.getTurlarDao().findAll(page, pageSize);
        return turlarList;
    }

    public void setTurlarList(List<Turlar> turlarList) {
        this.turlarList = turlarList;
    }

    public TurlarDao getTurlarDao() {
        if (this.turlarDao == null) {
            this.turlarDao = new TurlarDao();
        }
        return turlarDao;
    }

    public void setTurlarDao(TurlarDao turlarDao) {
        this.turlarDao = turlarDao;
    }

    public Turlar getTurlar() {
        if (this.turlar == null) {
            this.turlar = new Turlar();
        }
        return turlar;
    }

    public void setTurlar(Turlar turlar) {
        this.turlar = turlar;
    }

    public MusteriController getMusteriController() {
        return musteriController;
    }

    public void setMusteriController(MusteriController musteriController) {
        this.musteriController = musteriController;
    }

}

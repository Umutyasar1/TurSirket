package controller;

import dao.CalisanlarDao;
import dao.SirketDao;
import entity.Calisanlar;
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
public class CalisanlarController extends BaseBean implements Serializable {

    private List<Calisanlar> calisanlarList;
    private CalisanlarDao calisanlarDao;

    private Calisanlar calisanlar;
    private SirketDao sirketDao;

    private List<Sirket> sirketList;

    public void updateForm(Calisanlar calisanlar) {
        this.calisanlar = calisanlar;
    }

    public void clearForm() {
        this.calisanlar = new Calisanlar();
    }

    public void update() {
        this.getCalisanlarDao().update(this.calisanlar);
        this.clearForm();
    }

    public void delete() {
        this.getCalisanlarDao().delete(this.calisanlar);
        this.clearForm();
        // return "/calisanlar?faces-redirect=true";
    }

    public void create() {
        this.getCalisanlarDao().create(this.calisanlar);
        this.clearForm();
    }

    public List<Calisanlar> getCalisanlarList() {
        this.calisanlarList = this.getCalisanlarDao().findAll(page, pageSize);
        return calisanlarList;
    }

    public void setCalisanlarList(List<Calisanlar> calisanlarList) {
        this.calisanlarList = calisanlarList;
    }

    public CalisanlarDao getCalisanlarDao() {
        if (this.calisanlarDao == null) {
            this.calisanlarDao = new CalisanlarDao();
        }

        return calisanlarDao;
    }

    public void setCalisanlarDao(CalisanlarDao calisanlarDao) {
        this.calisanlarDao = calisanlarDao;
    }

    public Calisanlar getCalisanlar() {
        if (this.calisanlar == null) {
            this.calisanlar = new Calisanlar();
        }
        return calisanlar;
    }

    public void setCalisanlar(Calisanlar calisanlar) {
        this.calisanlar = calisanlar;
    }

    public SirketDao getSirketDao() {
        if (this.sirketDao == null) {
            this.sirketDao = new SirketDao();
        }
        return sirketDao;
    }

    public List<Sirket> getSirketList() {
        this.sirketList = this.getSirketDao().findAll(page , pageSize);
        return sirketList;
    }

    public void setSirketList(List<Sirket> sirketList) {
        this.sirketList = sirketList;
    }

    @Override
   public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getCalisanlarDao().count()/(double) pageSize);
        return pageCount;
    }

}

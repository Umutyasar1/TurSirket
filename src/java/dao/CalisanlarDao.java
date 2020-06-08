package dao;

import entity.Calisanlar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Umut
 */
public class CalisanlarDao extends BaseDao {

    private SirketDao sirketDao;

    public List<Calisanlar> findAll(int page,int pageSize) {
        List<Calisanlar> calisanlarList = new ArrayList();
        int start = (page-1)*pageSize;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("Select * from calisanlar order by calisan_id asc limit "+start+","+pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Calisanlar c = new Calisanlar();
                c.setCalisan_id((rs.getLong("calisan_id")));
                c.setCalisan_adi(rs.getString("calisan_adi"));
                c.setCalisan_soyad(rs.getString("calisan_soyad"));
                c.setCalisan_yas(rs.getInt("calisan_yas"));

                c.setSirket(this.getSirketDao().find(rs.getLong("sirket_id")));
                calisanlarList.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return calisanlarList;
    }

    public void create(Calisanlar calisanlar) {
        System.out.println(calisanlar.getCalisan_adi()+ "");
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into calisanlar(calisan_adi,calisan_soyad,calisan_yas,sirket_id) values (?,?,?,?)");
            pst.setString(1, calisanlar.getCalisan_adi());
            pst.setString(2, calisanlar.getCalisan_soyad());
            pst.setInt(3, calisanlar.getCalisan_yas());
            pst.setLong(4, calisanlar.getSirket().getSirket_id());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void update(Calisanlar calisanlar) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update calisanlar set calisan_adi=?,calisan_soyad=?,calisan_yas=?,sirket_id=? where calisan_id=? ");
            pst.setString(1, calisanlar.getCalisan_adi());
            pst.setString(2, calisanlar.getCalisan_soyad());
            pst.setInt(3, calisanlar.getCalisan_yas());
            pst.setLong(4, calisanlar.getSirket().getSirket_id());
            pst.setLong(5, calisanlar.getCalisan_id());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Calisanlar calisanlar) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from calisanlar where calisan_id=?");
            pst.setLong(1, calisanlar.getCalisan_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public SirketDao getSirketDao() {
        if (sirketDao == null) {
            this.sirketDao = new SirketDao();
        }
        return sirketDao;
    }
    
    public int count() {
        int count=0;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("Select count(calisan_id) as calisan_count from calisanlar");
            ResultSet rs = pst.executeQuery();

            rs.next();
            count = rs.getInt("calisan_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return count;
    }

}

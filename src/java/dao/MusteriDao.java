package dao;

import entity.Musteri;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author casper
 */
public class MusteriDao extends BaseDao {

    public List<Musteri> findAll(int page, int pageSize) {
        List<Musteri> musteriList = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("Select * from musteri order by musteri_id asc limit " + start + "," + pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Musteri t = new Musteri();
                t.setMusteri_id((rs.getLong("musteri_id")));
                t.setAd(rs.getString("ad"));
                t.setSoyad(rs.getString("soyad"));
                t.setTelno(rs.getInt("telno"));
                musteriList.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return musteriList;
    }

    public int count() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count(musteri_id) as musteri_count from musteri ");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("musteri_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return count;
    }

    public void create(Musteri musteri) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into musteri(ad,soyad,telno) values ('" + musteri.getAd() + "','" + musteri.getSoyad() + "'," + musteri.getTelno() + ")");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Musteri musteri) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from musteri where musteri_id='" + musteri.getMusteri_id() + "'");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(Musteri musteri) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update musteri set ad= '" + musteri.getAd() + "' , soyad = '" + musteri.getSoyad() + "' , telno = '" + musteri.getTelno() + "' where musteri_id = '" + musteri.getMusteri_id() + "'  ");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Musteri> getMusteriTur(Long tur_id) {
        List<Musteri> musteriTur = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from katilan where tur_id=" + tur_id);
            while (rs.next()) {
                musteriTur.add(this.find(rs.getLong("musteri_id")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return musteriTur;
    }

    public Musteri find(Long id) {
        Musteri m = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from musteri where musteri_id=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            m = new Musteri();
            m.setMusteri_id(rs.getLong("musteri_id"));
            m.setAd(rs.getString("ad"));
            m.setSoyad(rs.getString("soyad"));
            m.setTelno(rs.getInt("telno"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return m;
    }

}

package dao;

import entity.Musteri;
import entity.Turlar;
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
public class TurlarDao extends BaseDao {

    private MusteriDao musteriDao;

    public List<Turlar> findAll(int page, int pageSize) {
        List<Turlar> turlarList = new ArrayList();
        int start = (page - 1) * pageSize;

        try {
//            PreparedStatement pst = this.getConnection().prepareStatement("Select * from turlar order by tur_id asc limit " + start + "," + pageSize);
            PreparedStatement pst = this.getConnection().prepareStatement("select * from turlar ") ;

ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Turlar t = new Turlar();
                t.setTur_id((rs.getLong("tur_id")));
                t.setTur_yeri(rs.getString("tur_yeri"));
                t.setTur_fiyat(rs.getInt("tur_fiyat"));
                t.setMusteriTur(this.getMusteriDao().getMusteriTur(t.getTur_id()));
                turlarList.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return turlarList;
    }

    public int count() {
        int count = 0;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select count(tur_id) as tur_count from turlar ");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("tur_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return count;
    }

    public void create(Turlar turlar) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into turlar (tur_yeri,tur_fiyat) values(?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, turlar.getTur_yeri());
            pst.setInt(2, turlar.getTur_fiyat());

            pst.executeUpdate();

            Long tur_id = null;
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                tur_id = gk.getLong(1);
            }

            for (Musteri m : turlar.getMusteriTur()) {
                pst = this.getConnection().prepareStatement("insert into katilan (musteri_id, tur_id) values(?,?)");
                pst.setLong(1, tur_id);
                pst.setLong(2, m.getMusteri_id());
                pst.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void remove(Turlar turlar) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from katilan where tur_id");
            pst.setLong(1, turlar.getTur_id());
            pst.executeUpdate();

            pst = this.getConnection().prepareStatement("delete from turlar where tur_id=?");
            pst.setLong(1, turlar.getTur_id());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void edit(Turlar turlar) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update turlar set tur_yeri=?,tur_fiyat=? values (?,?) where tur_id=? )");
            pst.setString(1, turlar.getTur_yeri());
            pst.setInt(2, turlar.getTur_fiyat());
            pst.setLong(3, turlar.getTur_id());

            pst.executeUpdate();

            pst = this.getConnection().prepareStatement("delete from katilan where tur_id=?");
            pst.setLong(1, turlar.getTur_id());
            pst.executeUpdate();

            for (Musteri m : turlar.getMusteriTur()) {
                pst = this.getConnection().prepareStatement("insert into katilan (musteri_id, tur_id) values(?,?)");
                pst.setLong(1, turlar.getTur_id());
                pst.setLong(2, m.getMusteri_id());
                pst.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public MusteriDao getMusteriDao() {
        if (this.musteriDao == null) {
            this.musteriDao = new MusteriDao();
        }
        return musteriDao;
    }

}

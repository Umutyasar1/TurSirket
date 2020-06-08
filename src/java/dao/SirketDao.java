package dao;

import entity.Sirket;
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
public class SirketDao extends BaseDao {

    public Sirket find(Long id) {
        Sirket s = null;
        try {
            PreparedStatement st = this.getConnection().prepareStatement("select * from sirket_tur where sirket_id=?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();

            rs.next();
            s = new Sirket();
            s.setSirket_id(rs.getLong("sirket_id"));
            s.setSirket_ad(rs.getString("sirket_ad"));
            s.setHakkimizda(rs.getString("hakkimizda"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return s;
    }

    public List<Sirket> findAll(int page, int pageSize) {
        List<Sirket> sirketList = new ArrayList();
        int start = (page-1)*pageSize;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("Select * from sirket_tur order by sirket_id asc limit "+start+","+pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Sirket s = new Sirket();
                s.setSirket_id((rs.getLong("sirket_id")));
                s.setSirket_ad(rs.getString("sirket_ad"));
                s.setHakkimizda(rs.getString("hakkimizda"));

                sirketList.add(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return sirketList;
    }

    public void create(Sirket sirket) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into sirket_tur(sirket_ad,hakkimizda) values (?,?)");
            pst.setString(1, sirket.getSirket_ad());
            pst.setString(2, sirket.getHakkimizda());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Sirket sirket) {
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from sirket_tur where sirket_id=?");
            pst.setLong(1, sirket.getSirket_id());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Sirket sirket) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update sirket_tur set sirket_ad=?,hakkimizda=? where sirket_id=? ");
            pst.setString(1, sirket.getSirket_ad());
            pst.setString(2, sirket.getHakkimizda());
            pst.setLong(3, sirket.getSirket_id());
            
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public int count() {
        int count=0;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("Select count(sirket_id) as sirket_count from sirket_tur");
            ResultSet rs = pst.executeQuery();

            rs.next();
            count = rs.getInt("sirket_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return count;
    }

}

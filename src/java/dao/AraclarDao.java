
package dao;

import entity.Araclar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AraclarDao extends BaseDao {
      public List<Araclar> findAll() {
        List<Araclar> araclarList = new ArrayList();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("Select * from araclar order by arac_id asc ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Araclar t = new Araclar();
                t.setArac_id((rs.getInt("arac_id")));
                t.setArac_marka(rs.getString("arac_marka"));
                t.setArac_plaka(rs.getString("arac_plaka"));
               
                araclarList.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return araclarList;
    }

    public void create(Araclar araclar) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into araclar(arac_marka,arac_plaka,telno) values ('" + araclar.getArac_marka() + "','" + araclar.getArac_plaka() + "')");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Araclar araclar) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from araclar where arac_id='" + araclar.getArac_id() + "'");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(Araclar araclar) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update araclar set arac_marka= '" + araclar.getArac_marka() + "' , arac_plaka = '" + araclar.getArac_plaka() + "'  where arac_id = '" + araclar.getArac_id() + "'  ");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public Araclar find(Long id) {
        Araclar m = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from araclar where arac_id=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            m = new Araclar();
            m.setArac_id(rs.getInt("arac_id"));
            m.setArac_marka(rs.getString("arac_marka"));
            m.setArac_plaka(rs.getString("arac_plaka"));
           

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return m;
    }

}

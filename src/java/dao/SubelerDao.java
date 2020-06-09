
package dao;

import entity.Subeler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SubelerDao extends BaseDao {
      public List<Subeler> findAll() {
        List<Subeler> subelerList = new ArrayList();
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("Select * from subeler order by sube_id asc ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Subeler s = new Subeler();
                s.setSube_id((rs.getInt("sube_id")));
                s.setSube_il(rs.getString("sube_il"));
                s.setSube_ilce(rs.getString("sube_ilce"));
                s.setSube_isim(rs.getString("sube_isim"));
               
                subelerList.add(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return subelerList;
    }

    public void create(Subeler subeler) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into subeler(sube_il,sube_ilce,sube_isim) values ('" + subeler.getSube_il() + "','" + subeler.getSube_ilce() +"','"+subeler.getSube_isim()+ "')");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Subeler subeler) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from subeler where sube_id='" + subeler.getSube_id() + "'");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(Subeler subeler) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update subeler set sube_il= '" + subeler.getSube_il() + "' , sube_ilce = '" + subeler.getSube_ilce() + "' , sube_isim= '"+subeler.getSube_isim()+"'  where sube_id = '" + subeler.getSube_id() + "'  ");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public Subeler find(Long id) {
        Subeler s = null;
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from subeler where sube_id=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            s = new Subeler();
            s.setSube_id(rs.getInt("sube_id"));
            s.setSube_il(rs.getString("sube_il"));
            s.setSube_ilce(rs.getString("sube_ilce"));
            s.setSube_isim(rs.getString("sube_isim"));
           

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return s;
    }

}

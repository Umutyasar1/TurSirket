
package dao;

import entity.User;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Umut
 */

public class LoginDao extends BaseDao implements Serializable {


    public User validate(String user) {
        Connection con;

        PreparedStatement ps;

        User user2 = null;

        try {
            con = this.getConnection();
            ps = con.prepareStatement("select * from user  where  uname='" + user + "'");

            ResultSet rs = ps.executeQuery();
            rs.next();
            user2 = new User();

            user2.setUsername(rs.getString("uname"));
            user2.setPassword(rs.getString("password"));
            user2.setUturu(rs.getString("userTuru"));
            user2.setC(rs.getLong("c"));
            user2.setR(rs.getLong("r"));
            user2.setU(rs.getLong("u"));
            user2.setD(rs.getLong("d"));

        } catch (SQLException ex) {
            return null;

        }
        return user2;
    }

}

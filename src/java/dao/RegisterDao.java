package dao;

import entity.User;
import util.DBCon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Umut
 */
public class RegisterDao extends BaseDao {

  
    public static  void insert(String uname, String password, String userTuru) {
     //   DBConnection.connect();
         
        DBCon.getConnection();
        try {
             Statement sts = DBCon.getConnection().createStatement();
            String sql = "INSERT INTO user(uname,password,userTuru,c,r,u,d) VALUES('" + uname + "','" + password + "','" + userTuru + "','" +0+ "','" + 0 + "','" + 0 + "','" + 0 + "')";
            sts.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   

    }
    
    
}

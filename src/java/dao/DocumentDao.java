/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Document;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Umut
 */
public class DocumentDao extends BaseDao {

    public List<Document> findAll() {
        List<Document> dList = new ArrayList<>();

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from document");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Document d = new Document();
                d.setId(rs.getLong("id"));
                d.setName(rs.getString("name"));
                d.setPath(rs.getString("path"));
                d.setType(rs.getString("type"));
                dList.add(d);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dList;
    }

    public void insert(Document d) {
        String query = "insert into document (path,name,type) values (?,?,?)";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.executeUpdate();
            pst.setString(1, d.getName());
            pst.setString(2, d.getPath());
            pst.setString(3, d.getType());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

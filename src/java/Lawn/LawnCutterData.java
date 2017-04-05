/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lawn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author c0656308
 */
@Named
@SessionScoped
@ManagedBean
public class LawnCutterData {
    private List<LawnCutter> cutter = new ArrayList<>();
    private LawnCutter currentCutter = new LawnCutter();

    public LawnCutterData() {
    }

    public LawnCutterData(LawnCutter currentCutter) {
        this.currentCutter = currentCutter;
    }

    public List<LawnCutter> getCutter() {
        return cutter;
    }

    public void setCutter(List<LawnCutter> cutter) {
        this.cutter = cutter;
    }

    public LawnCutter getCurrentCutter() {
        return currentCutter;
    }

    public void setCurrentCutter(LawnCutter currentCutter) {
        this.currentCutter = currentCutter;
    }

    
    
    private void refresh() {
        try {
            cutter.clear();
            Connection conn = DBUtils.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM lawncutter");
            while (rs.next()) {
                LawnCutter cut = new LawnCutter(
                        rs.getInt("customerId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("socInsNum"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("province"),
                        rs.getString("country"),
                        rs.getString("postalCode"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"),
                        rs.getDate("birthday")                                 
                ); 
                cutter.add(cut);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LawnCutter.class.getName()).log(Level.SEVERE, null, ex);
            cutter.clear();
        }
    }
    
    private int findOwnerId() {
        int i = 0;
        for (LawnCutter c : cutter) {
            if (c.getCutterId() > i) {
                i = c.getCutterId();
            }
        }
        return i + 1;
    }

    public String newCutter() {
        return addCutter();
    }

    public String addCutter() {

        int num = findOwnerId();
        try (Connection conn = (Connection) DBUtils.getConnection()) {
            String sql = "INSERT INTO lawncutter VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            pstmt.setString(2, currentCutter.getFirstName());
            pstmt.setString(3,currentCutter.getLastName());
            pstmt.setInt(4, currentCutter.getsocInsNum());
            pstmt.setString(5,currentCutter.getAddress());
            pstmt.setString(6,currentCutter.getCity());
            pstmt.setString(7, currentCutter.getProvince());
            pstmt.setString(8,currentCutter.getPostalCode());
            pstmt.setString(9,currentCutter.getCountry());
            pstmt.setString(10, currentCutter.getEmail());
            pstmt.setString(11,currentCutter.getPhoneNumber());
            pstmt.setDate(12,currentCutter.getBirthday());
            pstmt.executeUpdate();
            cutter.add(currentCutter);
            currentCutter = new LawnCutter();
            refresh();
        } catch (SQLException ex) {
            Logger.getLogger(LawnOwner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    } 
    /*
    @PostConstruct
    public void init() {
        currentCutter = new LawnCutter();
    }*/
}

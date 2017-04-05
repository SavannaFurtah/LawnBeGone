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
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author c0656308
 */
@Named
@ApplicationScoped
public class LawnOwnerData {

    private List<LawnOwner> owner = new ArrayList<>();
    private LawnOwner currentOwner = new LawnOwner();

    public LawnOwnerData() {
    }

    public LawnOwnerData(LawnOwner currentOwner) {
        this.currentOwner = currentOwner;
    }

    public List<LawnOwner> getOwner() {
        return owner;
    }

    public void setOwner(List<LawnOwner> owner) {
        this.owner = owner;
    }

    public LawnOwner getCurrentOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(LawnOwner currentOwner) {
        this.currentOwner = currentOwner;
    }

    private void refresh() {
        try {
            owner.clear();
            Connection conn = DBUtils.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM lawnowner");
            while (rs.next()) {
                LawnOwner own = new LawnOwner(
                        rs.getInt("customerId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("province"),
                        rs.getString("country"),
                        rs.getString("postalCode"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"),
                        rs.getInt("creditCardNum"),
                        rs.getInt("securityCode"),
                        rs.getInt("expMonth"),
                        rs.getInt("expYear")
                );
                owner.add(own);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LawnOwner.class.getName()).log(Level.SEVERE, null, ex);
            owner.clear();
        }
    }

    private int findOwnerId() {
        int i = 0;
        for (LawnOwner o : owner) {
            if (o.getCustomerId() > i) {
                i = o.getCustomerId();
            }
        }
        return i + 1;
    }

    public String newOwner() {
        return addOwner();
    }

    public String addOwner() {

        int num = findOwnerId();
        try (Connection conn = (Connection) DBUtils.getConnection()) {
            String sql = "INSERT INTO lawnowner VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            pstmt.setString(2, currentOwner.getFirstName());
            pstmt.setString(3, currentOwner.getLastName());
            pstmt.setString(4, currentOwner.getAddress());
            pstmt.setString(5, currentOwner.getCity());
            pstmt.setString(6, currentOwner.getProvince());
            pstmt.setString(7, currentOwner.getPostalCode());
            pstmt.setString(8, currentOwner.getCountry());
            pstmt.setString(9, currentOwner.getEmail());
            pstmt.setString(10, currentOwner.getPhoneNumber());
            pstmt.setInt(11, currentOwner.getCreditCardNum());
            pstmt.setInt(12, currentOwner.getSecurityCode());
            pstmt.setInt(13, currentOwner.getExpMonth());
            pstmt.setInt(14, currentOwner.getExpYear());

            pstmt.executeUpdate();
            owner.add(currentOwner);
            currentOwner = new LawnOwner();
        } catch (SQLException ex) {
            Logger.getLogger(LawnOwner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }
}

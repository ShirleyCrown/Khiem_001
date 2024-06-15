/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jdbc_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author trieu
 */
public class JDBC_Practice {

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocerystore","root", "2704");
            String sql = "SELECT* FROM USER WHERE USER_PASSWORD = ?";
            PreparedStatement preparableStatement = con.prepareStatement(sql);

            preparableStatement.setString(1, "admin");
            ResultSet resultSet = preparableStatement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("USERNAME");
                String password = resultSet.getString("USER_PASSWORD");

                System.out.println("Username: " +  username + " | " + " Password " + password);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}

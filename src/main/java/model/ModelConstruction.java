/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 *
 * @author Moje
 */
public class ModelConstruction {
    public static int LoadHome(String adress, Double price){
        PreparedStatement ps = null;
        Connection conn;
        int idGenerado = 0;
        try{
            conn = ModelConnection.getConnection();
            ps = conn.prepareStatement("INSERT INTO homeReg (BuildId, Address, Price) VALUES (?, ?,?)",ps.RETURN_GENERATED_KEYS);
            ps.setString(1, "0");
            ps.setString(2, adress);
            ps.setString(3, String.valueOf(price));
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado= rs.getInt(1);
            }
            
            conn.close();
            ps.close();
            rs.close();
            
            return idGenerado;
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se puedo registar.");
            return idGenerado;
        }
    }
    
    public static int LoadBuild(String adress, Double price){
        PreparedStatement ps = null;
        
        boolean r = false;
        int idGenerado = 0;
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/regUsers", "root", "");
            ps = conn.prepareStatement("INSERT INTO buildReg (BuildId, Address, Price) VALUES (?, ?,?)",ps.RETURN_GENERATED_KEYS);
            ps.setString(1, "0");
            ps.setString(2, adress);
            ps.setString(3, String.valueOf(price));
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idGenerado= rs.getInt(1);
            }
            
            conn.close();
            ps.close();
            rs.close();
            
            return idGenerado;
            
        }catch(Exception e){
            e.printStackTrace();
            return idGenerado;
        }
    }
}

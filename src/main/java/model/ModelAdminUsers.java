/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Moje
 */
public class ModelAdminUsers {
    
    public static String pHash(String p){
        String gPswd = "";
        try{
            // Se crea una instancia de MessageDigest con el algoritmo MD5 para calcular el hash.
            MessageDigest md = MessageDigest.getInstance("MD5");
                
            // Se actualiza el digest con los bytes de la cadena de texto de entrada.
            md.update(p.getBytes());
                
            // Se obtienen los bytes del digest resultante.
            byte[] bytes = md.digest();
                
            // Se construye un StringBuilder para almacenar la representación hexadecimal del hash.
            StringBuilder sb = new StringBuilder();
                
            // Se itera sobre cada byte del hash y se convierte a su representación hexadecimal.    
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
                
            // Se asigna el hash resultante a la variable gPswd como una cadena de texto.
            gPswd = sb.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
            
        // Se devuelve el hash pHash como una cadena de texto, seguido de un salto de línea.
        return gPswd;
        }
    
    public static boolean Login(String user,String pswd){
        //Define variables
        Connection conn;
        PreparedStatement ps;
        boolean r = false;
        
        try{
                //Coneccion y definicion de de la query para la base de datos
                conn = ModelConnection.getConnection();
                ps = conn.prepareStatement("SELECT * FROM users WHERE User = ? AND Hash = ?");
                
                //Da los valores a la consulta SQL
                ps.setString(1, user.trim());
                ps.setString(2, pHash(pswd));
                
                //Ejecuta la consulta SQL
                ResultSet rs = ps.executeQuery();
                
                //Verifica si fue exitoso
                if (rs.next()){
                    r = true;
                }else{
                    r = false;
                }
                
                // Cierra los recursos
                rs.close();
                ps.close();
                conn.close();
                
                //Retorna el resultado del inicio de sesión
                return r;
            }catch(Exception e){
                // En caso de error, muestra un mensaje y devuelve el resultado por defecto (falso)
                JOptionPane.showMessageDialog(null,"Error al conectarse con la base de datos.");
                e.printStackTrace();
                return r;
            } 
    }
    
    public static boolean RestorePswd(String user,String pswd,String nPswd){
        Connection conn;
        PreparedStatement ps;
        boolean r = false;
        try{
            conn = ModelConnection.getConnection();
            ps = conn.prepareStatement("SELECT Id FROM users WHERE User = ? AND Hash = ?");
            ps.setString(1, user);
            ps.setString(2, pswd);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int idUsuario = rs.getInt("Id");
                
                PreparedStatement rs1 = conn.prepareStatement("UPDATE users SET Hash = ? WHERE Id = ?");
                rs1.setString(1, pHash(nPswd));
                rs1.setString(2, String.valueOf(idUsuario));
                rs1.executeUpdate();
                
                r = true;
            } else {
                r = false;
            }
            return r;
        }catch(Exception e){
            
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cambiar la contraseña.");
            return r;
        }
    }
    
    public static boolean singUp(String user,String pswd){
        Connection conn;
        PreparedStatement ps;
        boolean r = false;
        try{
            conn = ModelConnection.getConnection();
            ps = conn.prepareStatement("INSERT INTO users(Id,User,Hash) VALUES(?,?,?)");
            ps.setString(1, "0");
            ps.setString(2, user.trim());
            ps.setString(3, pHash(pswd));

            ps.executeUpdate();
            
            
            
            return r;
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al registar.");
            return r;
        }
    }
    
}

package model;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ModelConnection {
    public static Connection getConnection(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/regUsers", "root", "");
            return conn;
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos");
            return null;    
        }
    }
}


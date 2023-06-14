package controller;
import java.sql.Connection;

public class ControllerConnection {
    public static Connection getConnectionController(){
        return model.ModelConnection.getConnection();
    }
}
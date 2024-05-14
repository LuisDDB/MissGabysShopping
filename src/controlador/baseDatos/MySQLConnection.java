/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alexi
 */
public class MySQLConnection {
    
    /**
     * Connect to database
     * @return the connection
     */
    public static Connection get(){
        Connection connection =null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda?allowPublicKeyRetrieval=true&useSSL=false","Luis Daniel","Luis2004");
        }catch(Exception ex){
            System.err.print("Error: "+ex.getMessage());
        }
        return connection;
    }
    
    
}

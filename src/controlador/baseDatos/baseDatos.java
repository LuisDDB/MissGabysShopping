/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuisD
 */
public class baseDatos {
    
    private Connection _connection = null;

    public baseDatos() {
        

        String _url = "jdbc:mysql://localhost:3306/tienda?allowPublicKeyRetrieval=true&useSSL=false";
        
        String _user = "root";

        String _password="12425Gra";
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this._connection = DriverManager.getConnection(_url, _user, _password);
            
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
    
    public Connection getConnection(){
        return this._connection;
    }
    
    public void closeConnection(){
        
        if(this._connection!=null){
            try {
                this._connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(baseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}
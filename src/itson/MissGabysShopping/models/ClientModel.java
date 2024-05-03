/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.MissGabysShopping.models;
import controlador.baseDatos.MySQLConnection;
import controlador.baseDatos.baseDatos;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import itson.MissGabysShopping.entidades.Client;

/**
 *
 * @author alexi
 */
public class ClientModel {
    
    
    /**
     * Get the Client object with the id enter
     * @param id of the client to search
     * @return the requested client
     */
    public static Client getClient(int id){
        
        Client client = new Client();
        try {
            baseDatos _baseDatos = new baseDatos();
            Connection connection = _baseDatos.getConnection();
            PreparedStatement statement = connection.prepareStatement("Select * FROM cliente where idCliente=?;");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                client.setId(resultSet.getInt(1));
                client.setName(resultSet.getString(2));
                client.setAddress(resultSet.getString(3));
                client.setEmail(resultSet.getString(4));
                client.setPhone(resultSet.getString(5));
                client.setContact(resultSet.getString(6));
                client.setRfc(resultSet.getString(7));
                client.setRemoved(resultSet.getBoolean(8));
            }
            _baseDatos.closeConnection();
        } catch (SQLException ex) {
            System.err.println("Error: "+ex.getMessage());
        }
    return client;
    }
    
    /**
     * Gets a list of all Client where their name matches the filter
     * @param filter with which matches will be searched in the database
     * @return returns a list of Client that match the entered filter
     */
    public static List<Client> getAll(String filter){
        List<Client> clients = new ArrayList();
        try {
            
            Connection connection = MySQLConnection.get();
            PreparedStatement statement = connection.prepareStatement("Select * FROM tienda.cliente where nombre like ?;");
            statement.setString(1, "%"+filter+"%");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                Client c = new Client();
                c.setId(resultSet.getInt(1));
                c.setName(resultSet.getString(2));
                c.setAddress(resultSet.getString(3));
                c.setEmail(resultSet.getString(4));
                c.setPhone(resultSet.getString(5));
                c.setContact(resultSet.getString(6));
                c.setRfc(resultSet.getString(7));
                c.setRemoved(resultSet.getBoolean(8));
                clients.add(c);
                
            }
            
            connection.close();
            
            
        } catch (SQLException ex) {
            System.err.println("Error: "+ex.getMessage());
        }
        return clients;
    }
    
    /**
     * Add a new client to the database
     * @param name of the new Client
     * @param address of the new Client
     * @param email of the new Client
     * @param phone of the new Client
     * @param contact of the new Client
     * @param  rfc of the new Client
     * @return boolean where if true, a new client has been successfully added to the database and if false, a failure has occurred
     */
    public static boolean save(String name, String address, String email, String phone, String contact, String rfc){
        boolean result = false;
        try {
            Connection connection = MySQLConnection.get();
            String query ="INSERT INTO cliente (nombre, direccion, correoElectronico, telefono, contacto, rfc) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement statament = connection.prepareStatement(query);
            statament.setString(1, name);
            statament.setString(2, address);
            statament.setString(3, email);
            statament.setString(4, phone);
            statament.setString(5, contact);
            statament.setString(6, rfc);
            statament.execute();
            
            result = statament.getUpdateCount() == 1;
            connection.close();
        } catch (SQLException ex) {
            System.err.print("Error: "+ex.getMessage());
        }

        return result;
    }
    
    
    /**
     * Update a client to the database
     * @param id of the Client to edit
     * @param name of the Client to edit
     * @param address of the Client to edit
     * @param email of the Client to edit
     * @param phone of the Client to edit
     * @param contact of the Client to edit
     * @param rfc of the Client to edit
     * @param removed of the Client to edit
     * @return boolean where if true, the edit was successful, if false, an error occurred
     */
    public static boolean Update(int id, String name, String address, String email, String phone, String contact, String rfc, boolean removed){
        boolean result = false;
        try {
            Connection connection = MySQLConnection.get();
            String query ="UPDATE cliente SET nombre=?, direccion=?, correoElectronico=?, telefono=?, contacto=?, rfc=?, eliminado=? WHERE idCliente=?;";
            PreparedStatement statament = connection.prepareStatement(query);
            statament.setString(1, name);
            statament.setString(2, address);
            statament.setString(3, email);
            statament.setString(4, phone);
            statament.setString(5, contact);
            statament.setString(6, rfc);
            statament.setBoolean(id, removed);
            statament.setInt(8, id);
            statament.execute();
            
            result = statament.getUpdateCount() == 1;
            connection.close();
        } catch (SQLException ex) {
            System.err.print("Error: "+ex.getMessage());
        }

        return result;
    }
    
    /**
     * Delete a client to the database
     * @param id of the client to delete
     * @return  boolean where if true the client was deleted and if false an error occurred
     */
    public static boolean delete(int id){
        boolean result = false;
        
        try {
            Connection connection = MySQLConnection.get();
            String query = "DELETE FROM cliente WHERE idCliente=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();
            result = statement.getUpdateCount()==1;
            connection.close();
   
        } catch (SQLException ex) {
            System.err.print("Error: "+ ex.getMessage());
        }
        
        
        return result;
    }
    
    
}

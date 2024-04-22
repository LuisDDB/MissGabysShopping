/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.cliente;

/**
 *
 * @author LuisD
 */
public class clienteDAOImplement {

    private final Connection _connection;

    public clienteDAOImplement(Connection _connection) {
        this._connection = _connection;
    }
    
    
    public boolean agregar(Object _object) {
    
        cliente _cliente = (cliente) _object;
        
        boolean _respuesta = false;
        
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("INSERT INTO tienda.cliente ")
            .append("( nombre, direccion, correoElectronico, telefono, contacto, rfc, eliminado ) ")
            .append("VALUES (?, ?, ?, ?, ?, ?, ?);");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setString(1, _cliente.getNombre());
            _statement.setString(2, _cliente.getDireccion());
            _statement.setString(3, _cliente.getCorreoElectronico());
            _statement.setString(4, _cliente.getTelefono());
            _statement.setString(5, _cliente.getContacto());
            _statement.setString(6, _cliente.getRfc());
            _statement.setBoolean(7, _cliente.isEliminado());
            
            _respuesta = _statement.execute();
            
        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de agregar el cliente a la base de datos, error: " + ex.getMessage());
        }
        
        return _respuesta;
    }

    public boolean eliminar(int _object) {
        
        boolean _respuesta = false;
        
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("DELETE FROM tienda.cliente c WHERE c.idCliente = ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setInt(1, _object);
            
            _respuesta = _statement.execute();
            
        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de eliminar el cliente a la base de datos, error: " + ex.getMessage());
        }
        
        return _respuesta;
        
    }

    public boolean modificar(Object _object) {
        
        cliente _cliente = (cliente) _object;
        
        boolean _respuesta = false;
        
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("UPDATE tienda.cliente c ")
            .append("SET ")
                .append("nombre = ?, ")
                .append("direccion = ?, ")
                .append("correoElectronico = ?, ")
                .append("telefono = ?, ")
                .append("contacto = ?, ")
                .append("rfc = ?, ")
                .append("eliminado = ? ")
            .append("WHERE c.idCliente = ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setString(1, _cliente.getNombre());
            _statement.setString(2, _cliente.getDireccion());
            _statement.setString(3, _cliente.getCorreoElectronico());
            _statement.setString(4, _cliente.getTelefono());
            _statement.setString(5, _cliente.getContacto());
            _statement.setString(6, _cliente.getRfc());
            _statement.setBoolean(7, _cliente.isEliminado());
            _statement.setInt(8, _cliente.getIdCliente());
            
            _respuesta = _statement.execute();
            
        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de modificar el cliente a la base de datos, error: " + ex.getMessage());
        }
        
        return _respuesta;
    }

    public Object buscarPorId(int _id) {
                
        cliente _cliente = null;
        
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("SELECT ")
                .append("c.idCliente, ")
                .append("c.nombre, ")
                .append("c.direccion, ")
                .append("c.correoElectronico, ")
                .append("c.telefono, ")
                .append("c.contacto, ")
                .append("c.rfc, ")
                .append("c.eliminado ")
            .append("FROM tienda.cliente c ")
            .append("WHERE c.idCliente = ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setInt(1, _id);
            
            ResultSet _respuesta = _statement.executeQuery();
            
            if (_respuesta.next()){
                
                _cliente = new cliente();
                
                _cliente.setIdCliente(_respuesta.getInt("idCliente"));
                _cliente.setNombre(_respuesta.getString("nombre"));
                _cliente.setDireccion(_respuesta.getString("direccion"));
                _cliente.setCorreoElectronico(_respuesta.getString("correoElectronico"));
                _cliente.setTelefono(_respuesta.getString("telefono"));
                _cliente.setContacto(_respuesta.getString("contacto"));
                _cliente.setRfc(_respuesta.getString("rfc"));
                _cliente.setEliminado(_respuesta.getBoolean("eliminado"));
                
                
            }
            
        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de buscar el cliente en la base de datos, error: " + ex.getMessage());
        }
        
        return _cliente;
        
    }

    public Object buscarPor(String _campo, String _dato) {
        
        List<cliente> _listaClientes = new ArrayList<cliente>();
                
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("SELECT  ")
                .append("c.idCliente, ")
                .append("c.nombre, ")
                .append("c.direccion, ")
                .append("c.correoElectronico, ")
                .append("c.telefono, ")
                .append("c.contacto, ")
                .append("c.rfc, ")
                .append("c.eliminado ")
            .append("FROM tienda.cliente c ")
            .append("WHERE " + _campo + " LIKE ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setString(1, _dato);
            
            ResultSet _respuesta = _statement.executeQuery();
            
            while (_respuesta.next()){
                
                cliente _cliente = new cliente();
                
                _cliente.setIdCliente(_respuesta.getInt("idCliente"));
                _cliente.setNombre(_respuesta.getString("nombre"));
                _cliente.setDireccion(_respuesta.getString("direccion"));
                _cliente.setCorreoElectronico(_respuesta.getString("correoElectronico"));
                _cliente.setTelefono(_respuesta.getString("telefono"));
                _cliente.setContacto(_respuesta.getString("contacto"));
                _cliente.setRfc(_respuesta.getString("rfc"));
                _cliente.setEliminado(_respuesta.getBoolean("eliminado"));
                
                _listaClientes.add(_cliente);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de buscar el cliente en la base de datos, error: " + ex.getMessage());
        }
        
        return _listaClientes;
        
    }

    public Object buscarTodo() {
        List<cliente> _listaClientes = new ArrayList<cliente>();
                
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("SELECT  ")
                .append("c.idCliente, ")
                .append("c.nombre, ")
                .append("c.direccion, ")
                .append("c.correoElectronico, ")
                .append("c.telefono, ")
                .append("c.contacto, ")
                .append("c.rfc, ")
                .append("c.eliminado ")
            .append("FROM tienda.cliente c ");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
            
            ResultSet _respuesta = _statement.executeQuery();
            
            while (_respuesta.next()){
                
                cliente _cliente = new cliente();
                
                _cliente.setIdCliente(_respuesta.getInt("idCliente"));
                _cliente.setNombre(_respuesta.getString("nombre"));
                _cliente.setDireccion(_respuesta.getString("direccion"));
                _cliente.setCorreoElectronico(_respuesta.getString("correoElectronico"));
                _cliente.setTelefono(_respuesta.getString("telefono"));
                _cliente.setContacto(_respuesta.getString("contacto"));
                _cliente.setRfc(_respuesta.getString("rfc"));
                _cliente.setEliminado(_respuesta.getBoolean("eliminado"));
                
                _listaClientes.add(_cliente);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de buscar el cliente en la base de datos, error: " + ex.getMessage());
        }
        
        return _listaClientes;
    }
    


    
    
}

package controlador.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itson.missgabysshopping.entidades.Empleado;


/**
 *
 * @author LuisD
 */
public class EmpleadoDAOIimplement {

    private final Connection _connection;

    public EmpleadoDAOIimplement(Connection _connection) {
        this._connection = _connection;
    }
    
    
    public boolean agregar(Object _object) {
    
        Empleado _empleado = (Empleado) _object;
        
        boolean _respuesta = false;
        
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("INSERT INTO tienda.empleado ")
            .append("( nombre, direccion, nss, telefono, puesto, rfc, eliminado, sueldo ) ")
            .append("VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setString(1, _empleado.getNombre());
            _statement.setString(2, _empleado.getDireccion());
            _statement.setString(3, _empleado.getNss());
            _statement.setString(4, _empleado.getTelefono());
            _statement.setString(5, _empleado.getPuesto());
            _statement.setString(6, _empleado.getRfc());
            _statement.setDouble(6, _empleado.getSueldo());
            _statement.setBoolean(7, _empleado.isEliminado());
            
            _respuesta = _statement.execute();
            
        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de agregar al empleado a la base de datos, error: " + ex.getMessage());
        }
        
        return _respuesta;
    }

    public boolean eliminar(int _object) {
        
        boolean _respuesta = false;
        
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("DELETE FROM tienda.empleado e WHERE e.idempleado = ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setInt(1, _object);
            
            _respuesta = _statement.execute();
            
        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de eliminar al empleado a la base de datos, error: " + ex.getMessage());
        }
        
        return _respuesta;
        
    }
       public boolean eliminar(String campo, String objetivo) {

        boolean _respuesta = false;

        StringBuilder _sql = new StringBuilder();

        _sql.append("DELETE FROM tienda.empleado WHERE Empleado." + campo + " = ?;");

        PreparedStatement _statement;

        try {
            _statement = this._connection.prepareStatement(_sql.toString());

            _statement.setString(1, objetivo);

            _respuesta = _statement.execute();

        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de eliminar el cliente a la base de datos, error: " + ex.getMessage());
        }

        return _respuesta;

    }
     public boolean modificar(Empleado _empleado, int idEmpleado) {

        
        boolean _respuesta = false;

        StringBuilder _sql = new StringBuilder();

        _sql.append("UPDATE tienda.empleado e ")
            .append("SET ")
                .append("nombre = ?, ")
                .append("direccion = ?, ")
                .append("nss = ?, ")
                .append("telefono = ?, ")
                .append("puesto = ?, ")
                .append("rfc = ?, ")
                .append("sueldo = ?, ")
                .append("eliminado = ? ")
            .append("WHERE e.idEmpleado = ?;");
        

        PreparedStatement _statement;

        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setString(1, _empleado.getNombre());
            _statement.setString(2, _empleado.getDireccion());
            _statement.setString(3, _empleado.getNss());
            _statement.setString(4, _empleado.getTelefono());
            _statement.setString(5, _empleado.getPuesto());
            _statement.setString(6, _empleado.getRfc());
            _statement.setDouble(7, _empleado.getSueldo());
            _statement.setBoolean(8, _empleado.isEliminado());
            _statement.setInt(9, idEmpleado);
            
            
            _respuesta = _statement.execute();
            
        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de modificar al empleado a la base de datos, error: " + ex.getMessage());
        }
        

        return _respuesta;
    }

    public Empleado buscarPorId(int _id) {
                
        Empleado _empleado = null;
        
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("SELECT ")
                .append("e.idEmpleado, ")
                .append("e.nombre, ")
                .append("e.direccion, ")
                .append("e.nss, ")
                .append("e.telefono, ")
                .append("e.puesto, ")
                .append("e.rfc, ")
                .append("e.sueldo, ")
                .append("e.eliminado ")
            .append("FROM tienda.empleado e ")
            .append("WHERE e.idEmpleado = ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setInt(1, _id);
            
            ResultSet _respuesta = _statement.executeQuery();
            
            if (_respuesta.next()){
                
                
                _empleado.setIdEmpleado(_respuesta.getInt("idEmpleado"));
                _empleado.setNombre(_respuesta.getString("nombre"));
                _empleado.setDireccion(_respuesta.getString("direccion"));
                _empleado.setNss(_respuesta.getString("nss"));
                _empleado.setTelefono(_respuesta.getString("telefono"));
                _empleado.setPuesto(_respuesta.getString("puesto"));
                _empleado.setRfc(_respuesta.getString("rfc"));
                _empleado.setEliminado(_respuesta.getBoolean("eliminado"));
                
                
            }
            
        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de buscar al empleado en la base de datos, error: " + ex.getMessage());
        }
        
        return _empleado;
        
    }

    public List<Empleado> buscarPor(String _campo, String _dato) {
        
        List<Empleado> _listaEmpleados = new ArrayList<Empleado>();
                
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("SELECT  ")
                .append("e.idEmpleado, ")
                .append("e.nombre, ")
                .append("e.direccion, ")
                .append("e.correoElectronico, ")
                .append("e.telefono, ")
                .append("e.contacto, ")
                .append("e.rfc, ")
                .append("e.eliminado ")
            .append("FROM tienda.empleado e ")
            .append("WHERE " + _campo + " LIKE ?;");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
        
            _statement.setString(1, _dato);
            
            ResultSet _respuesta = _statement.executeQuery();
            
            while (_respuesta.next()){
                
                Empleado _empleado = new Empleado();
                
                _empleado.setIdEmpleado(_respuesta.getInt("idEmpleado"));
                _empleado.setNombre(_respuesta.getString("nombre"));
                _empleado.setDireccion(_respuesta.getString("direccion"));
                _empleado.setNss(_respuesta.getString("correoElectronico"));
                _empleado.setTelefono(_respuesta.getString("telefono"));
                _empleado.setPuesto(_respuesta.getString("contacto"));
                _empleado.setRfc(_respuesta.getString("rfc"));
                _empleado.setEliminado(_respuesta.getBoolean("eliminado"));
                
                _listaEmpleados.add(_empleado);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de buscar al empleado en la base de datos, error: " + ex.getMessage());
        }
        
        return _listaEmpleados;
        
    }

    public Object buscarTodo() {
        List<Empleado> _listaEmpleados = new ArrayList<Empleado>();
                
        StringBuilder _sql = new StringBuilder();
        
        _sql.append("SELECT  ")
                .append("e.idCliente, ")
                .append("e.nombre, ")
                .append("e.direccion, ")
                .append("e.correoElectronico, ")
                .append("e.telefono, ")
                .append("e.contacto, ")
                .append("e.rfc, ")
                .append("e.eliminado ")
            .append("FROM tienda.empleado e ");
        
        PreparedStatement _statement;
        
        try {
            _statement = this._connection.prepareStatement(_sql.toString());
            
            ResultSet _respuesta = _statement.executeQuery();
            
            while (_respuesta.next()){
                
                Empleado _empleado = new Empleado();
                
                _empleado.setIdEmpleado(_respuesta.getInt("idCliente"));
                _empleado.setNombre(_respuesta.getString("nombre"));
                _empleado.setDireccion(_respuesta.getString("direccion"));
                _empleado.setNss(_respuesta.getString("correoElectronico"));
                _empleado.setTelefono(_respuesta.getString("telefono"));
                _empleado.setPuesto(_respuesta.getString("contacto"));
                _empleado.setRfc(_respuesta.getString("rfc"));
                _empleado.setEliminado(_respuesta.getBoolean("eliminado"));
                
                _listaEmpleados.add(_empleado);
                
            }
            
        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de buscar al empleado en la base de datos, error: " + ex.getMessage());
        }
        
        return _listaEmpleados;
    }
    


    
    
}
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
                .append("( nombre, direccion, nss, telefono, puesto, rfc, sueldo ) ")
                .append("VALUES (?, ?, ?, ?, ?, ?, ?);");

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

            _respuesta = _statement.execute();

        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de agregar al empleado a la base de datos, error: " + ex.getMessage());
        }

        return _respuesta;
    }

    public boolean eliminar(int _object) {

        boolean _respuesta = false;

        StringBuilder _sql = new StringBuilder();

        _sql.append("DELETE FROM tienda.empleado  WHERE empleado.idEmpleado = ?;");

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
            System.out.println("miTienda: Ha ocurrido un error al momento de eliminar al empleado a la base de datos, error: " + ex.getMessage());
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
                .append("sueldo = ? ")
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
            _statement.setInt(8, idEmpleado);

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
                .append("empleado.idEmpleado, ")
                .append("empleado.nombre, ")
                .append("empleado.direccion, ")
                .append("empleado.nss, ")
                .append("empleado.telefono, ")
                .append("empleado.puesto, ")
                .append("empleado.rfc, ")
                .append("empleado.sueldo ")
                .append("FROM tienda.empleado ")
                .append("WHERE empleado.idEmpleado = ?;");

        PreparedStatement _statement;

        try {
            _statement = this._connection.prepareStatement(_sql.toString());

            _statement.setInt(1, _id);

            ResultSet _respuesta = _statement.executeQuery();

            if (_respuesta.next()) {

                _empleado = new Empleado(
                        _respuesta.getInt("idEmpleado"),
                        _respuesta.getString("nombre"),
                        _respuesta.getString("direccion"),
                        _respuesta.getString("nss"),
                        _respuesta.getString("telefono"),
                        _respuesta.getString("rfc"),
                        _respuesta.getString("puesto"),
                        _respuesta.getDouble("sueldo"));

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
                .append("empleado.idEmpleado, ")
                .append("empleado.nombre, ")
                .append("empleado.direccion, ")
                .append("empleado.nss, ")
                .append("empleado.telefono, ")
                .append("empleado.puesto, ")
                .append("empleado.rfc, ")
                .append("empleado.sueldo ")
                .append("FROM tienda.empleado  ")
                .append("WHERE " + _campo + " LIKE ?;");

        PreparedStatement _statement;

        try {
            _statement = this._connection.prepareStatement(_sql.toString());

            _statement.setString(1, "%" + _dato + "%");

            ResultSet _respuesta = _statement.executeQuery();
            Empleado _empleado;
            while (_respuesta.next()) {

                _empleado = new Empleado(
                        _respuesta.getInt("idEmpleado"),
                        _respuesta.getString("nombre"),
                        _respuesta.getString("nss"),
                        _respuesta.getString("rfc"),
                        _respuesta.getString("telefono"),
                        _respuesta.getString("direccion"),
                        _respuesta.getString("puesto"),
                        _respuesta.getDouble("sueldo"));

                _listaEmpleados.add(_empleado);

            }

        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de buscar al empleado en la base de datos, error: " + ex.getMessage());
        }

        return _listaEmpleados;

    }

    public List<Empleado> buscarTodo() {
        List<Empleado> _listaEmpleados = new ArrayList<Empleado>();

        StringBuilder _sql = new StringBuilder();

        _sql.append("SELECT  ")
                .append("empleado.idEmpleado, ")
                .append("empleado.nombre, ")
                .append("empleado.direccion, ")
                .append("empleado.nss, ")
                .append("empleado.telefono, ")
                .append("empleado.puesto, ")
                .append("empleado.rfc, ")
                .append("empleado.sueldo ")
                .append("FROM tienda.empleado ");

        PreparedStatement _statement;

        try {
            _statement = this._connection.prepareStatement(_sql.toString());

            ResultSet _respuesta = _statement.executeQuery();

            while (_respuesta.next()) {

                Empleado _empleado;
                _empleado = new Empleado(
                        _respuesta.getInt("idEmpleado"),
                        _respuesta.getString("nombre"),
                        _respuesta.getString("nss"),
                        _respuesta.getString("rfc"),
                        _respuesta.getString("telefono"),
                        _respuesta.getString("direccion"),
                        _respuesta.getString("puesto"),
                        _respuesta.getDouble("sueldo"));

                _listaEmpleados.add(_empleado);

            }

        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de buscar al empleado en la base de datos, error: " + ex.getMessage());
        }

        return _listaEmpleados;
    }
    
   

}

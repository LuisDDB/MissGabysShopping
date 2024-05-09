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
import mx.itson.missgabysshopping.entidades.Producto;

/**
 *
 * @author luisd
 */
public class ProductoDAOImplement {

    private final Connection _connection;

    public ProductoDAOImplement(Connection _connection) {
        this._connection = _connection;
    }

    /**
     * Agrega un objeto a la base de datos
     *
     * @param _object Objeto que se agregara a la base de datos
     * @return boolean se agregó o no
     */
    public boolean agregar(Producto producto) {

        boolean _respuesta = false;

        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO tienda.producto ")
                .append("( nombre, existencia, precioUnitario, descripcion, caducidad, marca, categoria, unidadMedida ) ")
                .append("VALUES (?, ?, ?, ?, ?, ?, ?, ?);");

        PreparedStatement _statement;

        try {
            _statement = this._connection.prepareStatement(sql.toString());

            _statement.setString(1, producto.getNombre());
            _statement.setInt(2, producto.getExistencia());
            _statement.setDouble(3, producto.getPrecioUnitario());
            _statement.setString(4, producto.getDescripcion());
            _statement.setDate(5, producto.getCaducidad());
            _statement.setString(6, producto.getMarca());
            _statement.setString(7, producto.getCategoria());
            _statement.setString(8, producto.getUnidadMedida());

            _respuesta = _statement.execute();

        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de agregar el cliente a la base de datos, error: " + ex.getMessage());
        }

        return _respuesta;
    }

    /**
     * Se elimina un objeto de la base de datos en base al obvetivo
     *
     * @param campo de la base de datos
     * @param objetivo que se eliminara de la base de datos
     * @return true si se pudo o false sino se pudo
     */
    public boolean eliminar(String campo, String objetivo) {

        boolean _respuesta = false;

        StringBuilder _sql = new StringBuilder();

        _sql.append("DELETE FROM tienda.producto WHERE producto." + campo + " = ?;");

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

    /**
     * Se elimina un objeto de la base de dato en base al id
     *
     * @param _object ID del objeto
     * @return true si se pudo o false sino se pudo
     */
    public boolean eliminar(int _object) {

        boolean _respuesta = false;

        StringBuilder _sql = new StringBuilder();

        _sql.append("DELETE FROM tienda.producto WHERE producto.idProducto = ?;");

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

    /**
     * Metodo que se encarga de sobreescribir informacion en la base de datos
     *
     * @param producto los nuevos datos
     * @param objetivo El objeto que sera remplazado
     * @return si fue posible hacer la operación
     */
    public boolean modificar(Producto producto, int objetivo) {

        

        boolean _respuesta = false;

        StringBuilder _sql = new StringBuilder();

        _sql.append("UPDATE tienda.producto")
                .append("SET ")
                .append("nombre = ?, ")
                .append("existencia = ?, ")
                .append("precioUnitario = ?, ")
                .append("descripcion = ?, ")
                .append("caducidad = ?, ")
                .append("marca = ? ")
                .append("categoria = ? ")
                .append("unidadMedida = ?, ")
                .append("WHERE producto.idProducto= ?;");

        PreparedStatement _statement;

        try {
            _statement = this._connection.prepareStatement(_sql.toString());

            _statement.setString(1, producto.getNombre());
            _statement.setInt(2, producto.getExistencia());
            _statement.setDouble(3, producto.getPrecioUnitario());
            _statement.setString(4, producto.getDescripcion());
            _statement.setDate(5, producto.getCaducidad());
            _statement.setString(6, producto.getMarca());
            _statement.setString(7, producto.getCategoria());
            _statement.setString(8, producto.getUnidadMedida());
            _statement.setInt(9, objetivo);

            _respuesta = _statement.execute();

        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de modificar el cliente a la base de datos, error: " + ex.getMessage());
        }

        return _respuesta;
    }

    /**
     * Busca informacion de la base de datos
     *
     * @param _id a buscar
     * @return un objeto tipo producto
     */
    public Producto buscarxId(int _id) {

        Producto producto = null;

        StringBuilder _sql = new StringBuilder();

        _sql.append("SELECT ")
                .append("producto.idProducto, ")
                .append("producto.nombre, ")
                .append("producto.existencia, ")
                .append("producto.precioUnitario, ")
                .append("producto.descripcion, ")
                .append("producto.caducidad, ")
                .append("producto.marca, ")
                .append("producto.categoria, ")
                .append("producto.unidadMedida ")
                .append("FROM tienda.producto ")
                .append("WHERE producto.idProducto = ?;");

        PreparedStatement _statement;

        try {
            _statement = this._connection.prepareStatement(_sql.toString());

            _statement.setInt(1, _id);

            ResultSet _respuesta = _statement.executeQuery();

            if (_respuesta.next()) {

                producto = new Producto(
                        _respuesta.getInt("idProducto"),
                        _respuesta.getString("nombre"),
                        _respuesta.getInt("existencia"),
                        _respuesta.getDouble("precioUnitario"),
                        _respuesta.getString("descripcion"),
                        _respuesta.getDate("caducidad"),
                        _respuesta.getString("marca"),
                        _respuesta.getString("categoria"),
                        _respuesta.getString("unidadMedida"));

            }

        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de buscar el cliente en la base de datos, error: " + ex.getMessage());
        }

        return producto;

    }

    /**
     * Buscador de objetos
     *
     * @param campo por el se buscara
     * @param dato filtro que se usa para buscar
     * @return
     */
    public List<Producto> buscarxCampo(String campo, String dato) {

        List<Producto> productos = new ArrayList<Producto>();

        StringBuilder _sql = new StringBuilder();

        _sql.append("SELECT ")
                .append("producto.idProducto, ")
                .append("producto.nombre, ")
                .append("producto.existencia, ")
                .append("producto.precioUnitario, ")
                .append("producto.descripcion, ")
                .append("producto.caducidad, ")
                .append("producto.marca, ")
                .append("producto.categoria, ")
                .append("producto.unidadMedida ")
                .append("FROM tienda.producto ")
                .append("WHERE producto." + campo + " = ?;");

        PreparedStatement _statement;

        try {
            _statement = this._connection.prepareStatement(_sql.toString());

            _statement.setString(1, dato);

            ResultSet _respuesta = _statement.executeQuery();

            while (_respuesta.next()) {

                productos.add(new Producto(
                        _respuesta.getInt("idProducto"),
                        _respuesta.getString("nombre"),
                        _respuesta.getInt("existencia"),
                        _respuesta.getDouble("precioUnitario"),
                        _respuesta.getString("descripcion"),
                        _respuesta.getDate("caducidad"),
                        _respuesta.getString("marca"),
                        _respuesta.getString("categoria"),
                        _respuesta.getString("unidadMedida")));

            }

        } catch (SQLException ex) {
            System.out.println("miTienda: Ha ocurrido un error al momento de buscar el cliente en la base de datos, error: " + ex.getMessage());
        }

        return productos;

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.missgabysshopping.entidades;

import controlador.DAO.ProductoDAOImplement;
import controlador.baseDatos.baseDatos;
import java.sql.Date;



/**
 *
 * @author luisd
 */
public class Producto {
    private int id=0;
    private String nombre="";
    private int existencia=0;
    private double precioUnitario=0;
    private String descripcion="";
    private Date caducidad=new Date(0, 0, 0);
    private String marca="";
    private String categoria="";
    private String unidadMedida="";

   
    public Producto(int id, String nombre, int existencia, double precioUnitario, String descripcion, Date caducidad, String marca, String categoria, String unidadMedida) {
    this.id=id;
    this.nombre=nombre;
    this.existencia=existencia;
    this.precioUnitario=precioUnitario;
    this.descripcion=descripcion;
    this.caducidad=caducidad;
    this.marca=marca;
    this.categoria=categoria;
    this.unidadMedida=unidadMedida;
    
    }
    public Producto(String nombre, int existencia, double precioUnitario, String descripcion, Date caducidad, String marca, String categoria, String unidadMedida) {
    this.nombre=nombre;
    this.existencia=existencia;
    this.precioUnitario=precioUnitario;
    this.descripcion=descripcion;
    this.caducidad=caducidad;
    this.marca=marca;
    this.categoria=categoria;
    this.unidadMedida=unidadMedida;
    
    }
    
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the existencia
     */
    public int getExistencia() {
        return existencia;
    }

    /**
     * @param existencia the existencia to set
     */
    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    /**
     * @return the precioUnitario
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * @param precioUnitario the precioUnitario to set
     */
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the caducidad
     */
    public Date getCaducidad() {
        return caducidad;
    }

    /**
     * @param caducidad the caducidad to set
     */
    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the unidadMedida
     */
    public String getUnidadMedida() {
        return unidadMedida;
    }

    /**
     * @param unidadMedida the unidadMedida to set
     */
    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
    public boolean ingresarDatos (Producto producto){
        baseDatos conexion = new baseDatos();
        ProductoDAOImplement ingresar = new ProductoDAOImplement(conexion.getConnection());
        return ingresar.agregar(producto);
        
    }
    
   
    
    
    
    
}

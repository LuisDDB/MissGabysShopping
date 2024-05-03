/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.MissGabysShopping.entidades;

import java.util.Date;

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
    private Date caducidad= new Date();
    private String marca="";

   
    public Producto(int id,String nombre, int existencia, double precioUnitario, String descripcion, Date caducidad, String marca) {
    this.id=id;
    this.nombre=nombre;
    this.existencia=existencia;
    this.precioUnitario=precioUnitario;
    this.descripcion=descripcion;
    this.caducidad=caducidad;
    this.marca=marca;
    
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
    
}

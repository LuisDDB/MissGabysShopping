/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.missgabysshopping.entidades;


/**
 *
 * @author Aletz
 */
public class DetalleDeVenta {

    /**
     * @return the idDetalleVenta
     */
    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    /**
     * @param idDetalleVenta the idDetalleVenta to set
     */
    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    /**
     * @return the idVenta
     */
    public Venta getIdVenta() {
        return idVenta;
    }

    /**
     * @param idVenta the idVenta to set
     */
    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    /**
     * @return the idProducto
     */
    public Producto getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
    private int idDetalleVenta;
    private Venta idVenta;
    private Producto idProducto;
    private int cantidad;
    private double precioUnitario;
    
}

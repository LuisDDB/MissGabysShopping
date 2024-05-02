/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.missgabysshopping.entidades;

import java.sql.Date;
import mx.itson.missgabysshopping.enums.Tipo;

/**
 *
 * @author luisd
 */
public class Venta {
    int idVenta;
    /*
    Empresa empresaVenta;
    Empleado empleadoVenta;
    Cliente clienteVenta;
    */
    Date fechaVenta;
    double SubTotal;
    double impuesto;
    Tipo tipoPago;
    
}

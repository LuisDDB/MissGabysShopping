/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import controlador.DAO.ProductoDAOImplement;
import controlador.baseDatos.baseDatos;
import java.sql.Date;

/**
 *
 * @author sergi
 */
public class Empleado {

    /**
     * @return the sueldo
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * @param sueldo the sueldo to set
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Empleado() {
    }
    
    private int idEmpleado = 0;
    private String nombre = new String();
    private String direccion = new String();
    private String nss = new String();
    private String telefono = new String();
     private String puesto = new String();
    private String rfc = new String();
    private boolean eliminado = false;
    private double sueldo;
   
   

    public Empleado(String nombre, String direccion, String CorreoElectronico, String telefono, String rfc, String contacto,double sueldo) {
    this.nombre=nombre;
    this.direccion=direccion;
    this.puesto=contacto;
    this.nss=nss;
    this.telefono=telefono;
    this.rfc=rfc;
    this.sueldo=this.sueldo;
    }
   

    /**
     * @return the idEmpleado
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the nss
     */
    public String getNss() {
        return nss;
    }

    /**
     * @param nss the nss to set
     */
    public void setNss(String nss) {
        this.nss = nss;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the puesto
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * @param puesto the puesto to set
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * @return the rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * @return the eliminado
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * @param eliminado the eliminado to set
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
}

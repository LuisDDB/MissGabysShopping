
import controlador.baseDatos.baseDatos;
import java.util.HashMap;
import java.util.Map;
import javax.swing.WindowConstants;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author LuisD
 */
public class miTienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        baseDatos _baseDatos = new baseDatos();
        
        try {
            
//        clienteDAOImplement _clienteDAOImplement = new clienteDAOImplement(_baseDatos.getConnection());
//        
//        cliente _cliente = new cliente();
        
        // Agregar registro
//        _cliente.setNombre("Pedro Sola");
//        _cliente.setDireccion("ITSON Guaymas");
//        _cliente.setCorreoElectronico("pedro.sola@gmail.com");
//        _cliente.setRfc("AML20240306122");
//        _cliente.setContacto("Gato sonriente");
//        _cliente.setTelefono("6221234567");
//        _cliente.setEliminado(true);
//        
//        boolean _estado = _clienteDAOImplement.agregar(_cliente);
                
        // Elimnar registro 200
//        boolean _estado = _clienteDAOImplement.eliminar(218);

        // Modificar dato
//        _cliente.setIdCliente(100);
//        _cliente.setNombre("Alicia");
//        _cliente.setDireccion("ITSON Guaymas");
//        _cliente.setCorreoElectronico("alicia.maravillas@gmail.com");
//        _cliente.setRfc("AML20240306122");
//        _cliente.setContacto("Gato sonriente");
//        _cliente.setTelefono("6221234567");
//        _cliente.setEliminado(true);
//        
//        boolean _estado = _clienteDAOImplement.modificar(_cliente);
        
        // Mostar registro
        
//        List<cliente> _listaClientes = (List<cliente>) _clienteDAOImplement.buscarTodo();
        
//        List<cliente> _listaClientes = (List<cliente>) _clienteDAOImplement.buscarPor("nombre", "Alicia");
        
//        System.out.println("No. \t Nombre del cliente");
//        System.out.println("-------------------------------------------");
//        
//        for(cliente _c : _listaClientes){
//            
//            System.out.println(_c.getIdCliente() + " \t " + _c.getNombre());
//            
//        }
        
            String _fileName = "C:\\Users\\alumnog\\Documents\\NetBeansProjects\\miTienda\\src\\reportes\\clientesReport.jrxml";

            Map _parametros = new HashMap();
            
            _parametros.put("eliminado", 0);
            
            JasperReport _jasperReport = JasperCompileManager.compileReport(_fileName);

            JasperPrint jasperPrint = JasperFillManager.fillReport(_jasperReport, _parametros, _baseDatos.getConnection());
            
            JasperViewer.viewReport(jasperPrint,false);


        } catch (Exception ex) {
            
            System.out.println("Error: " + ex.getMessage());
            
        }finally{
            _baseDatos.closeConnection();
        }

        
    }
    
}

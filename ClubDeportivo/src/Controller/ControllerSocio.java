/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Bd.Conexion;
import Models.Socio;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.Statement;
/**
 *
 * @author Cetecom
 */
public class ControllerSocio {
    Conexion cx;
    public ControllerSocio() {
        cx = new Conexion();
        cx.conectar();
    }
    public void bucarSocio(int rut, String nombre, String fechaNacimiento, String direccion, boolean membresia){
        String query = "INSERT TO 'Socio'(Rut,Nombre,fechaNacimiento,direccion,membresia) VALUES (?,?)";
        try {
            PreparedStatement ps = cx.getConnection().prepareStatement(query);
            ps.setInt(1,rut);
            ps.setString(2,nombre);
            ps.setString(3,direccion);
            ps.setBoolean(4,membresia);
           
                 
        } catch (Exception e) {
            System.out.println("ERROR No se a podido Obtener el Socio " + e.getMessage());
        }
    }
    public Socio encontrarSocio(int rut){
        Socio sc = null;
        String query = "SELECT * FROM socio WHERE rut = " + rut;
        try {
            ResultSet rs = cx.EjecutarQuery(query);
            if (rs.next()){
                sc = new Socio();
                sc.setRut(rs.getInt("rut"));
                sc.setNombre(rs.getString("nombre"));
                sc.setDireccion(rs.getString("direccion"));
                sc.setMembresia(rs.getBoolean("membresia"));
               
                
            }
        } catch (Exception e) {
            System.out.println("ERROR No se a podido Encontrar al Socio " + e.getMessage());

        }
        return sc;
    }
    public List<Socio> obtenerSocio(){
        List<Socio> sc = new ArrayList();
        try {
            ResultSet rs = cx.EjecutarQuery("SELECT * FROM Socio");
            while(rs.next()){
                sc.add(new Socio(
                rs.getInt("rut"),
                rs.getString("nombre"),
                rs.getString("fechaNacimiento"),
                rs.getString("direccion"),
                rs.getBoolean("membresia")
                ));
                        }
        } catch (Exception e) {
        }
        return null;
    }
   public boolean modificarSocio(int rut, String nombre, String fechaNacimiento, String direccion, boolean membresia){
       String query = "UPDATE socio = '" + nombre + "', fechaNacimiento = " + fechaNacimiento + ", direccion = " + direccion + ", membresia = " + membresia;
       System.out.println(query);
       try {
           Socio Encontrado = encontrarSocio(rut);
           if (Encontrado != null) {
               Statement st = cx.getConnection().createStatement();
               int filasModificadas = st.executeUpdate(query);
               System.out.println("socios modificados");
               
              
           }else{
               
           }
           
       } catch (Exception e) {
               System.out.println("ERROR No se a podido Encontrar al Socio " + e.getMessage());

       }
        return false;
   }
}    
      
        
   
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clubdeportivo;

import Bd.Conexion;
import Views.MenuPrincipal;

/**
 *
 * @author Cetecom
 */
public class ClubDeportivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion cx = new Conexion();
        cx.conectar();
        MenuPrincipal m = new MenuPrincipal();
        m.setVisible(true);
        
        
        
    }
    
    
}

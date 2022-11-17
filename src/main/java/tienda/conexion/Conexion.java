/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class Conexion {
    private static String url="jdbc:mysql://localhost/bd_negocios";
    private static String usuario="root";
    private static String clave="";
    private static Connection cn;
    
    public static Connection abrir(){
        try {
            //registrar driver para la conexion al servidor mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection(url,usuario,clave);
        } catch (Exception e) {
            return null;
        }

        return cn;
    }
    
}

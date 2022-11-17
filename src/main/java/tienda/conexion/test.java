/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.conexion;

import java.sql.Connection;

/**
 *
 * @author Andres
 */
public class test {
    public static void main(String[] args) {
        Connection cn=Conexion.abrir();   
        System.out.println("funciono "+cn);
    }
    
}

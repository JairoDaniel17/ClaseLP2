package tienda.modelo.dao;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.conexion.Conexion;
import tienda.modelo.bean.Empleado;

public class EmpleadoDAO {

    public static Empleado login(int idemp) {
        String sql = "SELECT * FROM empleado where idempleado=?";
        Empleado emp = null; //variable que retorna
        //Realizar la conexion
        Connection cn = Conexion.abrir();

        try
        {
            //Preparar la sentencia para ejecutar instrucciones sql
            PreparedStatement ps = cn.prepareStatement(sql);
            //asignar valor al  parametro ? 
            ps.setInt(1, idemp);
            //ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {

                emp = new Empleado(rs.getInt("idempleado"),
                        rs.getString("nombre"),
                        rs.getString("apaterno"),
                        rs.getString("amaterno"),
                        rs.getString("cargo"));
            }
        } catch (Exception ex)
        {
            return null;
        }

        return emp;
    }

    public static Empleado listar() {
        String sql = "SELECT * FROM empleado where idempleado=?";
        Empleado emp = null; //variable que retorna
        //Realizar la conexion
        Connection cn = Conexion.abrir();
        try
        {
            //Preparar la sentencia para ejecutar instrucciones sql
            PreparedStatement ps = cn.prepareStatement(sql);
            //ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {

                emp = new Empleado(rs.getInt("idempleado"),
                        rs.getString("nombre"),
                        rs.getString("apaterno"),
                        rs.getString("amaterno"),
                        rs.getString("cargo"));
            }
        } catch (Exception ex)
        {
            return null;
        }

        return emp;
    }

    public static ArrayList<Empleado> buscarNombre(String nom) {
        String sql = "SELECT * FROM empleado where like ?";
        Empleado emp = null; //variable que retorna
        ArrayList<Empleado> lista = new ArrayList<>();
//Realizar la conexion
        Connection cn = Conexion.abrir();

        try
        {
            //Preparar la sentencia para ejecutar instrucciones sql
            PreparedStatement ps = cn.prepareStatement(sql);
            //asignar valor al  parametro ? 
            ps.setString(1, nom + "%");
            //ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {

                emp = new Empleado(rs.getInt("idempleado"),
                        rs.getString("nombre"),
                        rs.getString("apaterno"),
                        rs.getString("amaterno"),
                        rs.getString("cargo"));
                lista.add(emp);
            }
        } catch (Exception ex)
        {
            return null;
        }

        return lista;
    }

    public static String datosJson() {
        String sql = "SELECT * FROM empleado";
        Empleado emp = null; //variable que retorna
        ArrayList<Empleado> lista = new ArrayList<>();
        Connection cn = Conexion.abrir();
        String jsonString = null;
        try
        {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {

                emp = new Empleado(rs.getInt("idempleado"),
                        rs.getString("nombre"),
                        rs.getString("apaterno"),
                        rs.getString("amaterno"),
                        rs.getString("cargo"));
                lista.add(emp);
            }
            Gson gson = new Gson();
            jsonString = gson.toJson(lista);

        } catch (Exception e)
        {
            return null;
        }
        return jsonString;
    }
}

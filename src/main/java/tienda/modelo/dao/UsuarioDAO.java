package tienda.modelo.dao;

import tienda.conexion.Conexion;
import tienda.modelo.bean.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public static Usuario login(String us, String cl) {
        String sql = "SELECT * FROM USUARIO WHERE usuario =? and clave =?";
        Usuario user = null;
        //Conexion
        Connection cn = Conexion.abrir();
        try {
            //ejecutar instrucciones sql
            PreparedStatement ps = cn.prepareStatement(sql);
            //asignar valor a los parametros ?,?
            ps.setString(1, us);
            ps.setString(2, cl);
            //ejecutar la consulta
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //se encapsula los valores del registro de la tabla usuario
                //en el objeto Usuario user
                user = new Usuario(
                        rs.getInt("idusuario"),
                        rs.getString("usuario"),
                        rs.getString("clave"),
                        rs.getString("estado"),
                        rs.getInt("idempleado"));
            }
        } catch (Exception e) {
            return null;
        }

        return user;
    }
}
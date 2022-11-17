/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.modelo.bean;

/**
 *
 * @author Andres
 */
public class Usuario {
    private int idus;
    private String usuario;
    private String clave;
    private String estado;
    private int idemp;
    //constructor

    public Usuario() {
    }

    public Usuario(int idus, String usuario, String clave, String estado, int idemp) {
        this.idus = idus;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
        this.idemp = idemp;
    }

    public int getIdus() {
        return idus;
    }

    public void setIdus(int idus) {
        this.idus = idus;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdemp() {
        return idemp;
    }

    public void setIdemp(int idemp) {
        this.idemp = idemp;
    }

   
}

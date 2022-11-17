
package tienda.modelo.bean;


public class Empleado {
    //Atributos
    private int idempleado;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String cargo;
    
    //Constructores

    public Empleado() {
    }

    public Empleado(int idempleado, String nombre, String apaterno, String amaterno, String cargo) {
        this.idempleado = idempleado;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.cargo = cargo;
    }
    
    //getters and setters

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
}

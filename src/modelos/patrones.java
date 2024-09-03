package modelos;

import java.util.ArrayList;

public class patrones {
    
    public ArrayList<patrones> agregarPatron;
    private String codigo;
    private String nombre;

    public patrones(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setAgregarPatron(ArrayList<patrones> agregarPatron) {
        this.agregarPatron = agregarPatron;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}


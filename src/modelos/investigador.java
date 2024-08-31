package modelos;


import java.io.Serializable;
import java.util.ArrayList;

public class investigador implements Serializable{
    private static final long serialVersionUID = 1L;
   
    public ArrayList<investigador> agregarInves;
    private String Codigo;
    private String nombre;
    private String genero;
    private String Contrasena;


  
        
  
    public investigador(String Codigo, String nombre, String genero, String Contrasena) {
        this.Codigo = Codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.Contrasena = Contrasena;
    }

    public String getCodigo() {
        return Codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getContrasena() {
        return Contrasena;
    }
}


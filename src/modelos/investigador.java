package modelos;


import java.io.Serializable;
import java.util.ArrayList;

public class investigador implements Serializable{
    private static final long serialVersionUID = 1L;
   
    public ArrayList<investigador> agregarInves;
    private String Codigo;
    private String nombre;
    private String genero;
    private String experimento;
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

    public String getExperimento() {
        return experimento;
    }
    

    public String getContrasena() {
        return Contrasena;
    }

    public void setAgregarInves(ArrayList<investigador> agregarInves) {
        this.agregarInves = agregarInves;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setExperimento(String experimento) {
        this.experimento = experimento;
    }
        
    
    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }


    
}


package modelos;

import java.io.FileWriter;
import java.util.ArrayList;

public class investigador {
   
    String archivoCSV = "C:\\Users\\cardo\\OneDrive\\Escritorio\\baseInves.csv"; 
    
    private ArrayList<investigador> agregarInves;
    private String Codigo;
    private String nombre;
    private String genero;
    private String Contrasena;
    

    /* public investigador(String Addclient, ArrayList<investigador> agregarInves, String codigo, String nombre, String genero, String contrasena) {
    
    try {
    String addinves = "";
    FileWriter addinves = new FileWriter(agreagarInves, true); // En el caso que no exista el archivo lo crea y si ya existe el archivo lo sobreescribe
    Addclient.write(agregarInves + "\n");
    Addclient.close();
    System.out.println("Contenido agregado correctamente");
    
    
    
    } catch (Exception e) {
    System.out.println(e);
    }
    }*/
    
    void agregarInv(String InvesNew, String route){
        try {
            FileWriter archivo = new FileWriter(route, true); // En el caso que no exista el archivo lo crea y si ya existe el archivo lo sobreescribe
            archivo.write(InvesNew + "\n");
            archivo.close();
            System.out.println("Contenido agregado correctamente");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
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


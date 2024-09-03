
package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import modelos.investigador;



public class ControladorArchivoBinInves {
    
    
    
    public void agregarContenido(String ruta_archivo, investigador inves){
        try {
            // Se obtiene el listado de investigador
            List<investigador> listadoinves = this.obtenerContenido(ruta_archivo);
            listadoinves.add(inves);

            FileOutputStream salidaArchivo = new FileOutputStream(ruta_archivo);
            ObjectOutputStream salidaObjeto = new ObjectOutputStream(salidaArchivo);
            salidaObjeto.writeObject(listadoinves);
            salidaArchivo.close();
            salidaObjeto.close();
        } catch (Exception e) {
            System.out.println("Error al agregar contenido: " + e.getMessage());
        }  
    }
        
        
    public void modificarContenido(String ruta_archivo, String codigo, investigador investigadorModMetod){
        try {
            // Se obtiene el listado de investigador
            List<investigador> listado_investigador = this.obtenerContenido(ruta_archivo);
            
            for (investigador invest : listado_investigador) {
                if (invest.getCodigo().equals(codigo)) {
                    invest.setNombre(investigadorModMetod.getNombre());
                    invest.setGenero(investigadorModMetod.getGenero());
                    invest.setContrasena(investigadorModMetod.getContrasena()); 
                }
            }

            FileOutputStream salidaArchivo = new FileOutputStream(ruta_archivo);
            ObjectOutputStream salidaObjeto = new ObjectOutputStream(salidaArchivo);
            salidaObjeto.writeObject(listado_investigador);
            salidaArchivo.close();
            salidaObjeto.close();
        } catch (Exception e) {
            System.out.println("Error al agregar contenido: " + e.getMessage());
        }  
    }
    
    public void eliminarContenido(String ruta_archivo, String codigo){
        try {
            // Se obtiene el listado de investigador
            List<investigador> listado_investigador = this.obtenerContenido(ruta_archivo);
            
            for (int i = 0; i < listado_investigador.size(); i++) {
                if (listado_investigador.get(i).getCodigo().equals(codigo)) {
                    listado_investigador.remove(i);
                }
            }

            FileOutputStream salidaArchivo = new FileOutputStream(ruta_archivo);
            ObjectOutputStream salidaObjeto = new ObjectOutputStream(salidaArchivo);
            salidaObjeto.writeObject(listado_investigador);
            salidaArchivo.close();
            salidaObjeto.close();
        } catch (Exception e) {
            System.out.println("Error al agregar contenido: " + e.getMessage());
        }  
    }        
       
    public ArrayList<investigador> obtenerContenido(String ruta_archivo){
        ArrayList<investigador> respuesta = new ArrayList<>();
        try {
            // Verificar si el archivo existe
            File archivo = new File(ruta_archivo);            
            if (archivo.exists()) {
                FileInputStream entradaArchivo = new FileInputStream(ruta_archivo);
                ObjectInputStream entradaObjeto = new ObjectInputStream(entradaArchivo);
                respuesta = (ArrayList<investigador>)entradaObjeto.readObject();
                entradaArchivo.close();
                entradaObjeto.close();
            }            
        } catch (Exception e) {
            System.out.println("Error al obtener el contenido: " + e.getMessage());
        }
        return respuesta;
    }
    
    
    public void leerCSV(String ruta_archivo){
        try {
            BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\cardo\\OneDrive\\Escritorio\\baseInves.csv")); //ruta del archivo de texto plano a leer
            String linea;
            lector.readLine();
            ControladorArchivoBinInves archivo = new ControladorArchivoBinInves();
            while ((linea = lector.readLine()) != null) {              
                String[] contenido = linea.split(",");
                System.out.println("Codigo: " + contenido[0]);
                System.out.println("Nombre: " + contenido[1]);
                System.out.println("Genero: " + contenido[2]);
                System.out.println("Experimientos: " + contenido[3]);
                System.out.println("Contrasenia: " + contenido[4]);
            
                archivo.agregarContenido("investigador.bin", new investigador(contenido[0],contenido[1],contenido[2],contenido[3])); //ruta del .bin donde se guardara lo leido del csv
            }
            lector.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
   
 

    public investigador buscarInvestigador(String codigo, String contrasena, String ruta_archivo) {
            ArrayList<investigador> investigadores = obtenerContenido(ruta_archivo);
            for (investigador inv : investigadores) {
                if (inv.getCodigo().equals(codigo) && inv.getContrasena().equals(contrasena)) {
                    return inv; // Devuelve el investigador si lo encuentra
                }
            }
            return null; // Si no encuentra al investigador
    }
    
    
    
    
    
    
    
    
}
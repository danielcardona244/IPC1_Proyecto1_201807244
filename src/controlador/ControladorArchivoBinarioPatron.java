package controlador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import modelos.patrones;

public class ControladorArchivoBinarioPatron {

    
    
    // metodo para verificar si el código ya existe
    public boolean codigoExiste(String rutaArchivo, String codigo) {
        ArrayList<patrones> patrones = obtenerContenidoPatrones(rutaArchivo);
        for (patrones patron : patrones) {
            if (patron.getCodigo().equals(codigo)) {
                return true; 
            }
        }
        return false; 
    }
    
    
    //metodo para agregar patrones
    public void agregarContenidoPatrones(String rutaArchivo, patrones patr) {
        List<patrones> listadoPatrones = obtenerContenidoPatrones(rutaArchivo);
        listadoPatrones.add(patr);

        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            salida.writeObject(listadoPatrones);
        } catch (IOException e) {
            System.out.println("Error al agregar contenido: " + e.getMessage());
        }
    }

    
    public void eliminarPatron(String rutaArchivo, String codigo) {
        List<patrones> listadoPatrones = obtenerContenidoPatrones(rutaArchivo);
        listadoPatrones.removeIf(patron -> patron.getCodigo().equals(codigo));

        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            salida.writeObject(listadoPatrones);
        } catch (IOException e) {
            System.out.println("Error al eliminar patrón: " + e.getMessage());
        }
    }

    // metodo para obtener el contenido de los archivos
    @SuppressWarnings("unchecked") //para que no me genere advertencias
    public ArrayList<patrones> obtenerContenidoPatrones(String rutaArchivo) {
        ArrayList<patrones> patrones = new ArrayList<>();

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            patrones = (ArrayList<patrones>) entrada.readObject();
        } catch (FileNotFoundException e) {
            // Si el archivo no existe, retornamos una lista vacía
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return patrones;
    }
    
    
    //metodo para leer los patrones en los archivos csv
    public void leerCSV(String ruta_archivo){
        try {
            BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\cardo\\OneDrive\\Escritorio\\patronescsv.csv")); //ruta del archivo de texto plano a leer
            String linea;
            lector.readLine();
            ControladorArchivoBinarioPatron archivo = new ControladorArchivoBinarioPatron();
            while ((linea = lector.readLine()) != null) {              
                String[] contenido = linea.split(",");
 
            
                archivo.agregarContenidoPatrones("patrones.bin", new patrones(contenido[0],contenido[1])); //ruta del .bin donde se guardara lo leido del csv
            }
            lector.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
        
        
}

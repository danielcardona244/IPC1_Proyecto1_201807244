package controlador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import modelos.muestras;

public class ControladorArchivoBinarioMues {
    
    
    // Método para agregar una muestra 
    public void agregarContenidoMues(String ruta_archivo, muestras mues) {
        ArrayList<muestras> listaMuestras = obtenerContenidoMues(ruta_archivo);
        listaMuestras.add(mues);
        try (ObjectOutputStream salidaObjeto = new ObjectOutputStream(new FileOutputStream(ruta_archivo))) {
            salidaObjeto.writeObject(listaMuestras);
        } catch (IOException e) {
            System.out.println("Error al agregar contenido: " + e.getMessage());
        }
    }
    
    // Método para obtener todas las muestras del archivo binario
    @SuppressWarnings("unchecked") // lo use por recomendacion de chat
    public ArrayList<muestras> obtenerContenidoMues(String ruta_archivo) {
        ArrayList<muestras> listaMuestras = new ArrayList<>();
        try (ObjectInputStream entradaObjeto = new ObjectInputStream(new FileInputStream(ruta_archivo))) {
            listaMuestras = (ArrayList<muestras>) entradaObjeto.readObject();
        } catch (FileNotFoundException e) {
          
        } catch (IOException | ClassNotFoundException e) {
          
        }
        return listaMuestras;
    }
    
              
    // Método para cargar datos desde un archivo CSV y guardarlos en un archivo binario
    public void leerCSV(String ruta_archivo){
        try {
            BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\cardo\\OneDrive\\Escritorio\\muestrascsv.csv")); //ruta del archivo de texto plano a leer
            String linea;
            lector.readLine();
            ControladorArchivoBinarioMues archivo = new ControladorArchivoBinarioMues();
            while ((linea = lector.readLine()) != null) {              
                String[] contenido = linea.split(",");  
                archivo.agregarContenidoMues("muestras.bin", new muestras(contenido[0],contenido[1],"ingresado")); //ruta del .bin donde se guardara lo leido del csv
            }
            lector.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    //lo uso en la asignacion de experimetnos
    public muestras buscarMuestraPorCodigo(String codigo, String ruta_archivo) {
    ArrayList<muestras> listaMuestras = obtenerContenidoMues(ruta_archivo);
    for (muestras m : listaMuestras) {
        if (m.getCodigo().equals(codigo)) {
            return m;
        }
    }
    return null;
}

    
    
    public void guardarContenidoMues(String rutaArchivo, ArrayList<muestras> listaMuestras) {
    try (ObjectOutputStream salidaObjeto = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
        salidaObjeto.writeObject(listaMuestras);
    } catch (IOException e) {
        System.out.println("Error al guardar contenido: " + e.getMessage());
    }
}

}

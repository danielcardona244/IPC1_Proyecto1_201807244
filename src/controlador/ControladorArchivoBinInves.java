
package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    
    public ArrayList<investigador> obtenerContenido(String ruta_archivo){
        ArrayList<investigador> respuesta = new ArrayList<>();
        try {
            // Verificar si el archivo existe
            File archivo = new File(ruta_archivo);            
            if (archivo.exists()) {
                FileInputStream entradaArchivo = new FileInputStream(ruta_archivo);
                ObjectInputStream entradaObjeto = new ObjectInputStream(entradaArchivo);
                respuesta = (ArrayList<investigador>)entradaObjeto.readObject();
            }            
        } catch (Exception e) {
            System.out.println("Error al obtener el contenido: " + e.getMessage());
        }
        return respuesta;
    }
    
    
}

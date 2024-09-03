package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import modelos.patrones;

public class ControladorArchivoCsvPatron {

    public ArrayList<patrones> obtenerContenidoPatrones(String rutaArchivo) {
        ArrayList<patrones> patrones = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) { 
                    String codigo = datos[0];
                    String nombre = datos[1];
                    patrones.add(new patrones(codigo, nombre));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return patrones;
    }
}
 
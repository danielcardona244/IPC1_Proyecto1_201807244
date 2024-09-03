package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import java.util.ArrayList;


import modelos.patrones;

public class ControladorArchivoCsvPatron {
    
    
      public void agregarContenidoPatrones(String rutaArchivo, patrones patr) {
        try (FileWriter writer = new FileWriter(rutaArchivo, true)) { // true para agregar al final del archivo
            writer.append(patr.getCodigo()).append(",");
            writer.append(patr.getNombre()).append("\n");
        } catch (IOException e) {
            System.out.println("Error al agregar contenido: " + e.getMessage());
        }
    }

    public void eliminarPatron(String rutaArchivo, String codigo) {
        ArrayList<patrones> listadoPatrones = this.obtenerContenidoPatrones(rutaArchivo);
        boolean encontrado = false;

        // Se crea una lista para almacenar las líneas que se mantendrán
        ArrayList<patrones> patronesActualizados = new ArrayList<>();

        for (patrones patron : listadoPatrones) {
            if (!patron.getCodigo().equals(codigo)) {
                patronesActualizados.add(patron); // Mantener los patrones que no se eliminan
            } else {
                encontrado = true;
            }
        }

        if (encontrado) {
            // Volver a escribir el archivo CSV con el contenido actualizado
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
                for (patrones patron : patronesActualizados) {
                    bw.write(patron.getCodigo() + "," + patron.getNombre());
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Patrón con el código " + codigo + " no encontrado.");
        }
}

      
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
 
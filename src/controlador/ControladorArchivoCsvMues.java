/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import modelos.muestras;

public class ControladorArchivoCsvMues {
    
    public ArrayList<muestras> obtenerContenidoMues(String ruta_archivo) {
        ArrayList<muestras> respuesta = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta_archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {  // Verificar que tenga 3 columnas
                    muestras mues = new muestras(datos[0], datos[1], datos[2]);
                    respuesta.add(mues);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el contenido: " + e.getMessage());
        }
        return respuesta;
    }
}
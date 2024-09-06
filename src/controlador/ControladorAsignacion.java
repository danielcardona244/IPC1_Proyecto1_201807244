package controlador;

import java.util.ArrayList;
import modelos.investigador;
import modelos.muestras;
import javax.swing.JComboBox;

public class ControladorAsignacion {
  
 
    private ControladorArchivoBinInves controladorInves;
    private ControladorArchivoBinarioMues controladorMuestras;

    public ControladorAsignacion() {
        controladorInves = new ControladorArchivoBinInves();
        controladorMuestras = new ControladorArchivoBinarioMues();
    }

    public void cargarComboBoxes(JComboBox<String> jComboBoxInvestigadores, JComboBox<String> jComboBoxMuestras) {
    ArrayList<investigador> investigadores = controladorInves.obtenerContenido("investigador.bin");
    ArrayList<muestras> muestras = controladorMuestras.obtenerContenidoMues("muestras.bin");
    
    System.out.println("Número de muestras: " + muestras.size());
    
    jComboBoxInvestigadores.removeAllItems();
    jComboBoxMuestras.removeAllItems();
    
    for (investigador inv : investigadores) {
        jComboBoxInvestigadores.addItem(inv.getCodigo());
    }
    
    int contador = 0;
    for (muestras m : muestras) {
        System.out.println("Código de muestra: " + m.getCodigo() + ", Estado: " + m.getEstado());
        if ("en ingreso".equals(m.getEstado())) {
            jComboBoxMuestras.addItem(m.getCodigo());
            contador++;
        }
    }
    System.out.println("Número de muestras añadidas al JComboBox: " + contador);
}

    public boolean asignarExperimento(String codigoInvestigador, String codigoMuestra) {
    if (codigoInvestigador == null || codigoMuestra == null) {
        return false;
    }

    // Buscar y modificar el investigador
    investigador inv = controladorInves.buscarInvestigadorPorCodigo(codigoInvestigador, "investigador.bin");
    if (inv != null) {
        inv.setExperimento(codigoMuestra); // Asignar el experimento
        controladorInves.modificarContenido("investigador.bin", codigoInvestigador, inv); // Modificar el archivo binario
 
    } else {
        return false;
    }

    // Buscar y modificar la muestra
    muestras m = controladorMuestras.buscarMuestraPorCodigo(codigoMuestra, "muestras.bin");
    if (m != null) {
        m.setEstado("en proceso"); // Cambiar el estado de la muestra
        controladorMuestras.agregarContenidoMues("muestras.bin", m); // Guardar los cambios en el archivo binario

    } else {
        return false;
    }

    return true;
}

}
    
    


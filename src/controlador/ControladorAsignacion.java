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
    
    
    
    jComboBoxInvestigadores.removeAllItems();
    jComboBoxMuestras.removeAllItems();
    
    for (investigador inv : investigadores) {
        jComboBoxInvestigadores.addItem(inv.getCodigo());
    }
    
    int contador = 0;
    for (muestras m : muestras) {
      
        if ("en ingreso".equals(m.getEstado())) {
            jComboBoxMuestras.addItem(m.getCodigo());
            contador++;
        }
    }
  
}

    public boolean asignarExperimento(String codigoInvestigador, String codigoMuestra) {
    ControladorArchivoBinInves controladorInves = new ControladorArchivoBinInves();
    ControladorArchivoBinarioMues controladorMues = new ControladorArchivoBinarioMues();
    
    // Buscar el investigador por código
    ArrayList<investigador> investigadores = controladorInves.obtenerContenido("investigador.bin");
    investigador invEncontrado = null;
    
    for (investigador inv : investigadores) {
        if (inv.getCodigo().equals(codigoInvestigador)) {
            inv.setExperimento(codigoMuestra); // Asignar el experimento al investigador
            invEncontrado = inv;
            break;
        }
    }
    
    if (invEncontrado == null) {
        System.out.println("Investigador no encontrado");
        return false;
    }
    
    // Actualizar archivo binario de investigadores
    controladorInves.guardarContenido("investigador.bin", investigadores);

    // Cambiar estado de la muestra a "en proceso"
    ArrayList<muestras> muestras = controladorMues.obtenerContenidoMues("muestras.bin");
    for (muestras m : muestras) {
        if (m.getCodigo().equals(codigoMuestra)) {
            m.setEstado("en proceso"); // Cambiar el estado de la muestra
            break;
        }
    }
    
    // Actualizar archivo binario de muestras
    controladorMues.guardarContenidoMues("muestras.bin", muestras);
    
    return true;
}


}
    
    


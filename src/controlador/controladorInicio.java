package controlador;


import javax.swing.JOptionPane;
import vista.modUsuario;

import modelos.investigador;
import vista.modAdmin;
import vista.modInves;




public class controladorInicio {

    // Método para iniciar sesión
    public void iniciarSesion(String codigo, String contrasena) {
        if ("admin".equals(codigo) && "admin".equals(contrasena)) {
            modAdmin MA = new modAdmin();
            MA.setVisible(true);
            return;
        }
        
        ControladorArchivoBinInves controladorArchivoBinInves = new ControladorArchivoBinInves();
        investigador inv = controladorArchivoBinInves.buscarInvestigador(codigo, contrasena, "investigador.bin");
        if (inv != null) {
            modInves MI = new modInves();
            MI.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Información", JOptionPane.WARNING_MESSAGE);
        }
    }
}


    


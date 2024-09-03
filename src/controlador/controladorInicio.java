package controlador;


import javax.swing.JOptionPane;
import vista.modUsuario;

import modelos.investigador;
import vista.modAdmin;
import vista.modInves;




public class controladorInicio {

    // Método para iniciar sesión
    public void iniciarSesion(String codigo, String contrasena) {
        // Verificación de administrador
        if ("admin".equals(codigo) && "admin".equals(contrasena)) {
            modAdmin MA = new modAdmin();
            MA.setVisible(true);
            return; // Sale del método para no seguir verificando
        }

        // Verificación de investigador
        ControladorArchivoBinInves controladorArchivoBinInves = new ControladorArchivoBinInves();
        investigador inv = controladorArchivoBinInves.buscarInvestigador(codigo, contrasena, "investigador.bin");

        if (inv != null) {
            // Si el investigador existe, redirige al módulo de investigador
            modInves MI = new modInves();
            MI.setVisible(true);
        } else {
            // Mostrar mensaje de error si no se encuentra el investigador
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Información", JOptionPane.WARNING_MESSAGE);
        }
    }
}

    


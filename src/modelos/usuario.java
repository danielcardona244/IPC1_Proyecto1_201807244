
package modelos;

import java.util.ArrayList;
        
public class usuario {
  
    
    private ArrayList<usuario> baseDatos;
    private String codigo;
    private String contrasenia;


    
    public usuario() {
    this.baseDatos = new ArrayList<usuario>();
    }

    
    public usuario(String codigo, String contrasenia) {
        this.codigo = codigo;
        this.contrasenia = contrasenia;
    }

    public String getcodigo() {
        return codigo;
    }

    public void setcodigo(String nombreUsuario) {
        // Se valida que la longitud del nombre de usuario sea mayor o igual 5
        if(nombreUsuario.length() >= 4){
            this.codigo = nombreUsuario;
        }else{
            throw new IllegalArgumentException("El nombre de usuario debe de tener, por lo menos, 4 caracteres");
        }        
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    
    public void guardarUsuario(usuario usuario){
        this.baseDatos.add(usuario);
    }
    
    /**
     * Metodo que se encarga de verificar si existe el usuario en la base de datos.
     * Si retorna 'true' es porque existe el usuario.
     */
    public boolean verificarUsuario(String usuario, String contrasenia){
        for (usuario fila : this.baseDatos) {
            if(fila.getcodigo().equals(usuario) && fila.getContrasenia().equals(contrasenia)){
                return true;
            }
        }       
        return false;
    }

    
    
}  


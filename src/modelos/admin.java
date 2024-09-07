package modelos;


public class admin {
    String Codigo = "admin";
    String Contrasena = "admim";

    public admin(String Codigo, String contrasena) {
        this.Codigo = Codigo;
        this.Contrasena = Contrasena;
    }

    public String getCodigo() {
        return Codigo;
    }

    public String getContrasena() {
        return Contrasena;
    }
    
    
}

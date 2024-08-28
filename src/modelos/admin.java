/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author cardo
 */
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

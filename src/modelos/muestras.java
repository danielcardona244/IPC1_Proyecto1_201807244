/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;

/**
 *
 * @author cardo
 */
public class muestras {
    
    public ArrayList<muestras> agregarMuestras;
    private String Codigo;
    private String Descripcion;
    private String Estado;

    public muestras(String Codigo, String Descripcion, String Estado) {
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    public String getCodigo() {
        return Codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getEstado() {
        return Estado;
    }


    public void setAgregarMuestras(ArrayList<muestras> agregarMuestras) {
        this.agregarMuestras = agregarMuestras;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    
}

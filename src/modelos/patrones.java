package modelos;

import java.io.Serializable;

public class patrones implements Serializable {
    private static final long serialVersionUID = 1L; // Agregar serialVersionUID

    private String codigo;
    private String nombre;

    public patrones(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}



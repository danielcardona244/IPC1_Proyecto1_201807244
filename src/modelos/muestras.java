package modelos;

import java.io.Serializable;
import java.util.ArrayList;

public class muestras implements Serializable {
    
    private static final long serialVersionUID = 1L;

    
    private String Codigo;
    private String Descripcion;
    private String Estado;

    public muestras(String Codigo, String Descripcion, String Estado) {
        this.Codigo = Codigo;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    public muestras() {
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


package co.edu.itm.Model;

import java.util.Date;

public class Estado {
    private Date fechaCreacion;
    private String descripcion;

    public Estado(Date fechaCreacion, String descripcion) {
        this.fechaCreacion = fechaCreacion;
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

package co.edu.itm.Model;

import java.time.LocalDate;
import java.util.Date;

public class Estado {
    private LocalDate fechaCreacion;
    private String descripcion;

    public Estado(LocalDate fechaCreacion, String descripcion) {
        this.fechaCreacion = fechaCreacion;
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "fechaCreacion=" + fechaCreacion +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public String toStore(){
        return fechaCreacion.toString()+","+descripcion;
    }
}

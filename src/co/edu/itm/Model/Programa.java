package co.edu.itm.Model;

import java.util.List;

public class Programa {
    private String nombre;
    private String codigo;
    private String ciclo;
    private List<TrabajoDeGrado> trabajoDeGrados;

    public Programa(String nombre, String codigo, String ciclo, List<TrabajoDeGrado> trabajoDeGrados) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.ciclo = ciclo;
        this.trabajoDeGrados = trabajoDeGrados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public List<TrabajoDeGrado> getTrabajoDeGrados() {
        return trabajoDeGrados;
    }

    public void setTrabajoDeGrados(List<TrabajoDeGrado> trabajoDeGrados) {
        this.trabajoDeGrados = trabajoDeGrados;
    }
}

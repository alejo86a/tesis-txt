package co.edu.itm.Model;

import java.util.List;

public class TrabajoDeGrado {
    private String titulo;
    private String codigo;
    private String modalidad;
    private Asesor asesor;
    private List<Estudiante> estudiantes;
    private List<Estado> estados;

    public TrabajoDeGrado(String titulo, String codigo, String modalidad, Asesor asesor, List<Estudiante> estudiantes, List<Estado> estados) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.modalidad = modalidad;
        this.asesor = asesor;
        this.estudiantes = estudiantes;
        this.estados = estados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
}

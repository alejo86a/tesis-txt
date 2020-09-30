package co.edu.itm.Model;

public class Estudiante extends Persona {
    private String semestre;

    public Estudiante(String nombres, String apellidos, String identificacion, String carne, String semestre) {
        super(nombres, apellidos, identificacion, carne);
        this.semestre = semestre;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}

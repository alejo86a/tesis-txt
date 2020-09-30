package co.edu.itm.Model;

public class Asesor extends Persona{
    private int nroTrabajos;

    public Asesor(String nombres, String apellidos, String identificacion, String carne, int nroTrabajos) {
        super(nombres, apellidos, identificacion, carne);
        this.nroTrabajos = nroTrabajos;
    }

    public int getNroTrabajos() {
        return nroTrabajos;
    }

    public void setNroTrabajos(int nroTrabajos) {
        this.nroTrabajos = nroTrabajos;
    }
}

package co.edu.itm.Controller;

import co.edu.itm.Utils.FileIn;

public class Main {

    public static void main(String args[]) {
        FileIn fileIn =new FileIn();
        AsesorCtrl asesorCtrl = new AsesorCtrl(fileIn.readTxt("asesor.txt"));
        EstudianteCtrl estudianteCtrl = new EstudianteCtrl(fileIn.readTxt("estudiante.txt"));
        EstadoCtrl estadoCtrl = new EstadoCtrl(fileIn.readTxt("estado.txt"));
        TrabajoDeGradoCtrl trabajoDeGradoCtrl = new TrabajoDeGradoCtrl(fileIn.readTxt("asesor.txt"), estudianteCtrl.getEstudiantes(), estadoCtrl.getEstados(), asesorCtrl.getAsesores());;
        ProgramaCtrl programaCtrl = new ProgramaCtrl(fileIn.readTxt("asesor.txt"), trabajoDeGradoCtrl.getTrabajosDeGrado());
    }
}

package co.edu.itm.Controller;

import co.edu.itm.Utils.FileIn;
import co.edu.itm.Utils.FileOut;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        FileIn fileIn = new FileIn();
        FileOut fileOut = new FileOut();
        AsesorCtrl asesorCtrl = new AsesorCtrl(fileIn.readTxt("asesor.txt"));
        EstudianteCtrl estudianteCtrl = new EstudianteCtrl(fileIn.readTxt("estudiante.txt"));
        EstadoCtrl estadoCtrl = new EstadoCtrl(fileIn.readTxt("estado.txt"));
        TrabajoDeGradoCtrl trabajoDeGradoCtrl = new TrabajoDeGradoCtrl(fileIn.readTxt("trabajoDeGrado.txt"), estudianteCtrl.getEstudiantes(), estadoCtrl.getEstados(), asesorCtrl.getAsesores());;
        ProgramaCtrl programaCtrl = new ProgramaCtrl(fileIn.readTxt("programa.txt"), trabajoDeGradoCtrl.getTrabajosDeGrado());

        int response=1;
        while (response!=0){
            System.out.println("Para ingresar data selecciona alguna de las siguientes opciones: \n" +
                    "1 para ingresar un Asesor\n" +
                    "2 para ingresar un Estudiante\n" +
                    "3 para ingresar un Estado\n" +
                    "4 para ingresar un Trabajo de grado (recuerda que debe existir por lo menos un asesor, estudiante, estado para crear un trabajo de grado)\n" +
                    "5 para ingresar un Programa (recuerda que debe existir por lo menos un trabajo de grado para crear un programa)\n" +
                    "6 para imprimir los asesores\n" +
                    "7 para imprimir los estudiantes\n" +
                    "8 para imprimir los estados\n" +
                    "9 para imprimir los trabajos de grado\n" +
                    "10 para imprimir los programas\n" +
                    "0 para salir del programa y guardar la informacion");
            Scanner teclado = new Scanner(System.in);
            response = teclado.nextInt();
            switch (response){
                case 1:
                    System.out.println("Se ingresara un asesor...");
                    asesorCtrl.ingresarAsesor();
                    break;
                case 2:
                    System.out.println("Se ingresara un estudiante...");
                    estudianteCtrl.ingresarEstudiante();
                    break;
                case 3:
                    System.out.println("Se ingresara un estado...");
                    estadoCtrl.ingresarEstado();
                    break;
                case 4:
                    System.out.println("Se ingresara un trabajo de grado...");
                    trabajoDeGradoCtrl.ingresarTrabajoDeGrado();
                    break;
                case 5:
                    System.out.println("Se ingresara un programa...");
                    programaCtrl.ingresarPrograma();
                    break;
                case 6:
                    System.out.println("Se imprimiran los asesores...");
                    asesorCtrl.imprimirAsesores();
                    break;
                case 7:
                    System.out.println("Se imprimiran los estudiantes...");
                    estudianteCtrl.imprimirEstudiantes();
                    break;
                case 8:
                    System.out.println("Se imprimiran los estados...");
                    estadoCtrl.imprimirEstados();
                case 9:
                    System.out.println("Se imprimiran los trabajos de grado...");
                    trabajoDeGradoCtrl.imprimirTrabajosDeGrado();
                    break;
                case 10:
                    System.out.println("Se imprimiran los programas...");
                    programaCtrl.imprimirProgramas();
                    break;
                case 0:
                    System.out.println("Se almacenaran los datos en los respectivos archivos txt \n ----Adios----");
                    break;
                default:
                    System.out.println("Se ha ingresado una opcion invalida, vuelvelo a intentar.");
                    break;
            }
        }
        System.out.println(".\n.\n.\n.");
        fileOut.imprimirTxt("asesor", asesorCtrl.getAsoresToStore());
        fileOut.imprimirTxt("estudiante", estudianteCtrl.getEstudiantesToStore());
        fileOut.imprimirTxt("estado", estadoCtrl.getEstadosToStore());
        fileOut.imprimirTxt("trabajoDeGrado", trabajoDeGradoCtrl.getTrabajosDeGradoToStore());
        fileOut.imprimirTxt("programa", programaCtrl.getProgramasToStore());
    }
}

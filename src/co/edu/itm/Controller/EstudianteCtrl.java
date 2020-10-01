package co.edu.itm.Controller;

import co.edu.itm.Model.Estudiante;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EstudianteCtrl {
    private List<Estudiante> estudiantes = new ArrayList<Estudiante>();

    public EstudianteCtrl(String dataAEstudiante){
        String[] dataAEstudiantesSplited = dataAEstudiante.split(";");
        String[] estudianteSplited;
        if(dataAEstudiante!=""){
            for (int i = 0; i < dataAEstudiantesSplited.length; i++) {
                if(dataAEstudiantesSplited[i]!=null){
                    estudianteSplited = dataAEstudiantesSplited[i].split(",");
                    estudiantes.add(new Estudiante(estudianteSplited[0],
                            estudianteSplited[1],
                            estudianteSplited[2],
                            estudianteSplited[3],
                            estudianteSplited[4]));
                }
            }
        }
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void ingresarEstudiante(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa el nombre del estudiante");
        String nombre = teclado.nextLine();
        System.out.println("Ingresa el apellido del estudiante");
        String apellido = teclado.nextLine();
        System.out.println("Ingresa la identificacion del estudiante");
        String identificacion = teclado.nextLine();
        System.out.println("Ingresa el carne del estudiante");
        String carne = teclado.nextLine();
        System.out.println("Ingresa el semestre del estudiante");
        String semestre = teclado.nextLine();
        this.estudiantes.add(new Estudiante(nombre,apellido,identificacion,carne,semestre));
    }
}

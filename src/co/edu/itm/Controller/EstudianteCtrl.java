package co.edu.itm.Controller;

import co.edu.itm.Model.Estudiante;

import java.util.List;

public class EstudianteCtrl {
    private List<Estudiante> estudiantes;

    public EstudianteCtrl(String dataAEstudiante){
        String[] dataAEstudiantesSplited = dataAEstudiante.split(";");
        String[] estudianteSplited;
        for (int i = 0; i < dataAEstudiantesSplited.length; i++) {
            estudianteSplited = dataAEstudiantesSplited[i].split(",");
            estudiantes.add(new Estudiante(estudianteSplited[0],
                    estudianteSplited[1],
                    estudianteSplited[2],
                    estudianteSplited[3],
                    estudianteSplited[4]));
        }
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}

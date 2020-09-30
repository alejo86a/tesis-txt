package co.edu.itm.Controller;

import co.edu.itm.Model.Asesor;
import co.edu.itm.Model.Estado;
import co.edu.itm.Model.Estudiante;
import co.edu.itm.Model.TrabajoDeGrado;

import java.util.List;

public class TrabajoDeGradoCtrl {
    private List<TrabajoDeGrado> trabajosDeGrado;

    public TrabajoDeGradoCtrl(String dataTrabajosDeGrado, List<Estudiante> estudiantes, List<Estado> estados, List<Asesor> asesores){
        String[] dataTrabajosDeGradoSplited = dataTrabajosDeGrado.split(";");
        String[] trabajoDeGradoSplited;
        for (int i = 0; i < dataTrabajosDeGradoSplited.length; i++) {
            trabajoDeGradoSplited = dataTrabajosDeGradoSplited[i].split(",");
            trabajosDeGrado.add(new TrabajoDeGrado(trabajoDeGradoSplited[0],
                    trabajoDeGradoSplited[1],
                    trabajoDeGradoSplited[2],
                    getAsesorPorIdentificacion(asesores, trabajoDeGradoSplited[3]),
                    getEstudiantesPorIdentificacion(estudiantes, trabajoDeGradoSplited[4]),
                    getEstadosPorDescripcion(estados, trabajoDeGradoSplited[5])));
        }
    }

    private List<Estudiante> getEstudiantesPorIdentificacion(List<Estudiante> estudiantes, String identificaciones){
        List<Estudiante> estudiantesTemp = null;
        String[] ids = identificaciones.split("-");
        for (int i = 0; i < estudiantes.size(); i++) {
            for (int j = 0; j < ids.length; j++) {
                if(estudiantes.get(i).getIdentificacion()==ids[j]){
                    estudiantesTemp.add(estudiantes.get(i));
                }
            }
        }
        return estudiantesTemp;
    }

    private List<Estado> getEstadosPorDescripcion(List<Estado> estados, String descripciones){
        List<Estado> estadosTemp = null;
        String[] des = descripciones.split("-");
        for (int i = 0; i < estados.size(); i++) {
            for (int j = 0; j < des.length; j++) {
                if(estados.get(i).getDescripcion()==des[j]){
                    estadosTemp.add(estados.get(i));
                }
            }
        }
        return estadosTemp;
    }

    private Asesor getAsesorPorIdentificacion(List<Asesor> asesores, String identificacion){
        Asesor asesor = null;
        for (int i = 0; i < asesores.size(); i++) {
            if(asesores.get(i).getIdentificacion()==identificacion){
                asesor= asesores.get(i);
            }
        }
        return asesor;
    }

    public List<TrabajoDeGrado> getTrabajosDeGrado() {
        return trabajosDeGrado;
    }
}

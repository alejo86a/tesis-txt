package co.edu.itm.Controller;

import co.edu.itm.Model.Estado;
import co.edu.itm.Model.Programa;
import co.edu.itm.Model.TrabajoDeGrado;

import java.util.List;

public class ProgramaCtrl {

    private List<Programa> programas;

    public ProgramaCtrl(String dataProgramas, List<TrabajoDeGrado> trabajosDeGrado){
        String[] dataProgramasSplited = dataProgramas.split(";");
        String[] programaSplited;
        for (int i = 0; i < dataProgramasSplited.length; i++) {
            programaSplited = dataProgramasSplited[i].split(",");
            programas.add(new Programa(
               programaSplited[0],
               programaSplited[1],
               programaSplited[2],
               getTrabajosDeGradoPorCodigo(trabajosDeGrado, programaSplited[4])
            ));
        }
    }

    private List<TrabajoDeGrado> getTrabajosDeGradoPorCodigo(List<TrabajoDeGrado> trabajosDeGrado, String codigos){
        List<TrabajoDeGrado> trabajosDeGradoTemp = null;
        String[] cos = codigos.split("-");
        for (int i = 0; i < trabajosDeGrado.size(); i++) {
            for (int j = 0; j < cos.length; j++) {
                if(trabajosDeGrado.get(i).getCodigo()==cos[j]){
                    trabajosDeGradoTemp.add(trabajosDeGrado.get(i));
                }
            }
        }
        return trabajosDeGradoTemp;
    }
}

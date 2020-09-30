package co.edu.itm.Controller;

import co.edu.itm.Model.Asesor;

import java.util.List;

public class AsesorCtrl {
    private List<Asesor> asesores;

    public AsesorCtrl(String dataAsesor){
        String[] dataAsesoresSplited = dataAsesor.split(";");
        String[] asesorSplited;
        for (int i = 0; i < dataAsesoresSplited.length; i++) {
            asesorSplited = dataAsesoresSplited[i].split(",");
            asesores.add(new Asesor(asesorSplited[0],
                    asesorSplited[1],
                    asesorSplited[2],
                    asesorSplited[3],
                    Integer.parseInt(asesorSplited[4])));
        }
    }

    public List<Asesor> getAsesores() {
        return asesores;
    }
}

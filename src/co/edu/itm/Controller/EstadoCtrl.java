package co.edu.itm.Controller;

import co.edu.itm.Model.Estado;

import java.util.Date;
import java.util.List;

public class EstadoCtrl {
    private List<Estado> estados;

    public EstadoCtrl(String dataEstado){
        String[] dataEstadoesSplited = dataEstado.split(";");
        String[] estadoSplited;
        for (int i = 0; i < dataEstadoesSplited.length; i++) {
            estadoSplited = dataEstadoesSplited[i].split(",");
            estados.add(new Estado(new Date(estadoSplited[0]),
                    estadoSplited[0]));
        }
    }

    public List<Estado> getEstados() {
        return estados;
    }
}

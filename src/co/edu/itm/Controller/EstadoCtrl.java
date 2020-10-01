package co.edu.itm.Controller;

import co.edu.itm.Model.Estado;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EstadoCtrl {
    private List<Estado> estados = new ArrayList<Estado>();

    public EstadoCtrl(String dataEstado){
        String[] dataEstadoesSplited = dataEstado.split(";");
        String[] estadoSplited;
        if(dataEstado!=""){
            for (int i = 0; i < dataEstadoesSplited.length; i++) {
                if(dataEstadoesSplited[i]!=null){
                    estadoSplited = dataEstadoesSplited[i].split(",");
                    estados.add(new Estado(new Date(estadoSplited[0]),
                            estadoSplited[1]));
                }
            }
        }
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void ingresarEstado(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa la fecha de creacion del estado (en formato dd/mm/aaaa)");
        Date fecha = new Date(teclado.nextLine());
        System.out.println("Ingresa la descripcion del estado");
        String descripcion = teclado.nextLine();
        this.estados.add(new Estado(fecha,descripcion));
    }
}

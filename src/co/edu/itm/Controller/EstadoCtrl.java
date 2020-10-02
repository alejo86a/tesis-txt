package co.edu.itm.Controller;

import co.edu.itm.Model.Estado;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EstadoCtrl {
    private List<Estado> estados = new ArrayList<Estado>();

    public EstadoCtrl(String dataEstado){
        String[] dataEstadoesSplited = dataEstado.split(";");
        String[] estadoSplited;
        if(dataEstado!=""){
            for (int i = 0; i < dataEstadoesSplited.length; i++) {
                if(dataEstadoesSplited[i]!=null){
                    estadoSplited = dataEstadoesSplited[i].split(",");
                    String[] splitedDate = estadoSplited[0].split("-");
                    estados.add(new Estado(LocalDate.of(Integer.parseInt(splitedDate[0]),
                                    Integer.parseInt(splitedDate[1]),
                                    Integer.parseInt(splitedDate[2])),
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
        System.out.println("Ingresa la fecha de creacion del estado (en formato aaaa-mm-dd)");
        String[] splitedDate = teclado.nextLine().split("-");
        LocalDate fecha = LocalDate.of(Integer.parseInt(splitedDate[0]),
                Integer.parseInt(splitedDate[1]),
                Integer.parseInt(splitedDate[2]));
        System.out.println("Ingresa la descripcion del estado");
        String descripcion = teclado.nextLine();
        this.estados.add(new Estado(fecha,descripcion));
    }

    public void imprimirEstados() { estados.stream().forEach(estado->System.out.println(estado.toString()));    }

    public Object[] getEstadosToStore(){
        List<String> estadosToStore = estados.stream().map(estado -> estado.toStore()).collect(Collectors.toList());
        return estadosToStore.toArray();
    }
}

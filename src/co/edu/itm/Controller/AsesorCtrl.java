package co.edu.itm.Controller;

import co.edu.itm.Model.Asesor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AsesorCtrl {
    private List<Asesor> asesores= new ArrayList<Asesor>();

    public AsesorCtrl(String dataAsesor){
        String[] dataAsesoresSplited = dataAsesor.split(";");
        String[] asesorSplited;
        if (dataAsesor!=""){
            for (int i = 0; i < dataAsesoresSplited.length; i++) {
                if(dataAsesoresSplited[i]!=null){
                    asesorSplited = dataAsesoresSplited[i].split(",");
                    asesores.add(new Asesor(asesorSplited[0],
                            asesorSplited[1],
                            asesorSplited[2],
                            asesorSplited[3],
                            Integer.parseInt(asesorSplited[4])));
                }
            }
        }
    }

    public List<Asesor> getAsesores() {
        return asesores;
    }

    public void ingresarAsesor(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa el nombre del asesor");
        String nombre = teclado.nextLine();
        System.out.println("Ingresa el apellido del asesor");
        String apellido = teclado.nextLine();
        System.out.println("Ingresa la identificacion del asesor");
        String identificacion = teclado.nextLine();
        System.out.println("Ingresa el carne del asesor");
        String carne = teclado.nextLine();
        System.out.println("Ingresa el numero de trabajos del asesor");
        int nroTrabajos = teclado.nextInt();
        this.asesores.add(new Asesor(nombre,apellido,identificacion,carne,nroTrabajos));
    }
}

package co.edu.itm.Controller;

import co.edu.itm.Model.Estado;
import co.edu.itm.Model.Programa;
import co.edu.itm.Model.TrabajoDeGrado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProgramaCtrl {

    private List<Programa> programas = new ArrayList<Programa>();
    private List<TrabajoDeGrado> trabajosDeGrado;

    public ProgramaCtrl(String dataProgramas, List<TrabajoDeGrado> trabajosDeGrado){
        this.trabajosDeGrado = trabajosDeGrado;
        String[] dataProgramasSplited = dataProgramas.split(";");
        String[] programaSplited;
        if(dataProgramas!=""){
            for (int i = 0; i < dataProgramasSplited.length; i++) {
                if (dataProgramasSplited[i]!=null){
                    programaSplited = dataProgramasSplited[i].split(",");
                    programas.add(new Programa(
                            programaSplited[0],
                            programaSplited[1],
                            programaSplited[2],
                            getTrabajosDeGradoPorCodigo(programaSplited[3])
                    ));
                }
            }
        }
    }

    private List<TrabajoDeGrado> getTrabajosDeGradoPorCodigo(String codigos){
        List<TrabajoDeGrado> trabajosDeGradoTemp = new ArrayList<TrabajoDeGrado>();
        String[] cos = codigos.split("-");
        for (int i = 0; i < trabajosDeGrado.size(); i++) {
            for (int j = 0; j < cos.length; j++) {
                if(trabajosDeGrado.get(i).getCodigo().equals(cos[j])){
                    trabajosDeGradoTemp.add(trabajosDeGrado.get(i));
                }
            }
        }
        return trabajosDeGradoTemp;
    }

    public void ingresarPrograma(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa el nombre del programa");
        String nombre = teclado.nextLine();
        System.out.println("Ingresa el codigo del programa");
        String codigo = teclado.nextLine();

        //listar e ingresar ciclo (por ejemplo: tecnología o ingeniería)
        String[] opcionesCiclo = {"tecnología", "ingeniería"};
        System.out.println("Ingresa el ciclo para el programa");
        for (int i = 0; i < opcionesCiclo.length; i++) {
            System.out.println(i+" para: "+ opcionesCiclo[i]);
        }
        String ciclo = opcionesCiclo[teclado.nextInt()];

        // listar e ingresar al menos 1 trabajo de grado
        System.out.println("Cuantos trabajos de grado desea ingresar?");
        int cantTrabajosDeGrado = teclado.nextInt();
        List<TrabajoDeGrado> trabajosDeGradoTemp = new ArrayList<TrabajoDeGrado>();
        for (int i = 0; i < cantTrabajosDeGrado; i++) {
            System.out.println("Seleccione el trabajo de grado numero "+(i+1));
            for (int j = 0; j < trabajosDeGrado.size(); j++) {
                System.out.println(j+" para "+trabajosDeGrado.get(j).getTitulo());
            }
            trabajosDeGradoTemp.add(trabajosDeGrado.get(teclado.nextInt()));
        }
        this.programas.add(new Programa(nombre,codigo,ciclo,trabajosDeGradoTemp));

    }

    public void imprimirProgramas() {
        programas.stream().forEach(programa->System.out.println(programa.toString()));
    }

    public Object[] getProgramasToStore(){
        List<String> programasToStore = programas.stream().map(programa -> programa.toStore()).collect(Collectors.toList());
        return programasToStore.toArray();
    }
}

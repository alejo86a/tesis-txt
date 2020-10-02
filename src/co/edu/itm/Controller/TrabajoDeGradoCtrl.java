package co.edu.itm.Controller;

import co.edu.itm.Model.Asesor;
import co.edu.itm.Model.Estado;
import co.edu.itm.Model.Estudiante;
import co.edu.itm.Model.TrabajoDeGrado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TrabajoDeGradoCtrl {
    private List<TrabajoDeGrado> trabajosDeGrado = new ArrayList<TrabajoDeGrado>();
    private List<Estudiante> estudiantes;
    private List<Estado> estados;
    private List<Asesor> asesores;

    public TrabajoDeGradoCtrl(String dataTrabajosDeGrado, List<Estudiante> estudiantes, List<Estado> estados, List<Asesor> asesores){
        this.estudiantes = estudiantes;
        this.estados = estados;
        this.asesores = asesores;
        String[] dataTrabajosDeGradoSplited = dataTrabajosDeGrado.split(";");
        String[] trabajoDeGradoSplited;
        if(dataTrabajosDeGrado!=""){
            for (int i = 0; i < dataTrabajosDeGradoSplited.length; i++) {
                if(dataTrabajosDeGradoSplited[i]!=null){
                    trabajoDeGradoSplited = dataTrabajosDeGradoSplited[i].split(",");
                    trabajosDeGrado.add(new TrabajoDeGrado(trabajoDeGradoSplited[0],
                            trabajoDeGradoSplited[1],
                            trabajoDeGradoSplited[2],
                            getAsesorPorIdentificacion(trabajoDeGradoSplited[3]),
                            getEstudiantesPorIdentificacion(trabajoDeGradoSplited[4]),
                            getEstadosPorDescripcion(trabajoDeGradoSplited[5])));
                }
            }
        }
    }

    private List<Estudiante> getEstudiantesPorIdentificacion(String identificaciones){
        List<Estudiante> estudiantesTemp = new ArrayList<Estudiante>();
        String[] ids = identificaciones.split("-");
        for (int i = 0; i < estudiantes.size(); i++) {
            for (int j = 0; j < ids.length; j++) {
                if(estudiantes.get(i).getIdentificacion().equals(ids[j])){
                    estudiantesTemp.add(estudiantes.get(i));
                }
            }
        }
        return estudiantesTemp;
    }

    private List<Estado> getEstadosPorDescripcion(String descripciones){
        List<Estado> estadosTemp = new ArrayList<Estado>();
        String[] des = descripciones.split("-");
        for (int i = 0; i < estados.size(); i++) {
            for (int j = 0; j < des.length; j++) {
                if(estados.get(i).getDescripcion().equals(des[j])){
                    estadosTemp.add(estados.get(i));
                }
            }
        }
        return estadosTemp;
    }

    private Asesor getAsesorPorIdentificacion(String identificacion){
        Asesor asesor = null;
        for (int i = 0; i < asesores.size(); i++) {
            if(asesores.get(i).getIdentificacion().equals(identificacion)){
                asesor= asesores.get(i);
            }
        }
        return asesor;
    }

    public List<TrabajoDeGrado> getTrabajosDeGrado() {
        return trabajosDeGrado;
    }

    public void ingresarTrabajoDeGrado(){
        //validacion de que haya por lo menos 1 estado, 1 estudiante, 1 asesor
        if(estados.size()==0 || estudiantes.size()==0 || asesores.size()==0){
            System.out.println("Debe existir por lo menos 1 estado, 1 estudiante y 1 asesor para crear un trabajo de grado");
            return;
        }
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa el titulo del trabajo de grado");
        String titulo = teclado.nextLine();
        System.out.println("Ingresa el codigo del trabajo de grado");
        String codigo = teclado.nextLine();


        //listar e ingresar modalidad (por ejemplo: producto de laboratorio, proyecto de grado, etc.)
        String[] opcionesModalidad = {"práctica profesional", "producto de laboratorio", "proyecto de grado"};
        System.out.println("Ingresa la modalidad del trabajo de grado");
        for (int i = 0; i < opcionesModalidad.length; i++) {
            System.out.println(i+" para: "+ opcionesModalidad[i]);
        }
        String modalidad = opcionesModalidad[teclado.nextInt()];

        //listar e ingresar estudiantes, de 1 a 3
        System.out.println("Cuantos estudiantes realizan este trabajo de grado? ingrese un numero entre 1 y 3");
        int cantEstudiantes = teclado.nextInt();
        List<Estudiante> estudiantesTemp = new ArrayList<Estudiante>();
        for (int i = 0; i < cantEstudiantes; i++) {
            System.out.println("Seleccione el estudiante numero "+(i+1));
            for (int j = 0; j < estudiantes.size(); j++) {
                System.out.println(j+" para "+estudiantes.get(j).getNombres()+" "+estudiantes.get(j).getApellidos());
            }
            estudiantesTemp.add(estudiantes.get(teclado.nextInt()));
        }

        //listar e ingresar 1 asesor
        System.out.println("Ingrese el asesor del trabajo de grado");
        for (int i = 0; i < asesores.size(); i++) {
            System.out.println(i+" para "+asesores.get(i).getNombres()+" "+asesores.get(i).getApellidos());
        }
        Asesor asesorTemp = asesores.get(teclado.nextInt());

        // listar e ingresar al menos 1 estado
        System.out.println("Cuantos estados desea ingresar?");
        int cantEstados = teclado.nextInt();
        List<Estado> estadosTemp = new ArrayList<Estado>();
        for (int i = 0; i < cantEstados; i++) {
            System.out.println("Seleccione el estado numero "+(i+1));
            for (int j = 0; j < estados.size(); j++) {
                System.out.println(j+" para "+estados.get(j).getDescripcion());
            }
            estadosTemp.add(estados.get(teclado.nextInt()));
        }
        this.trabajosDeGrado.add(new TrabajoDeGrado(titulo, codigo, modalidad, asesorTemp, estudiantesTemp, estadosTemp));
    }

    public void imprimirTrabajosDeGrado() {
        trabajosDeGrado.stream().forEach(trabajoDeGrado->System.out.println(trabajoDeGrado.toString()));
    }

    public Object[] getTrabajosDeGradoToStore(){
        List<String> trabajosDeGradoToStore = trabajosDeGrado.stream().map(trabajoDeGrado->trabajoDeGrado.toStore()).collect(Collectors.toList());;
        return trabajosDeGradoToStore.toArray();
    }
}

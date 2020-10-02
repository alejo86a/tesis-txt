package co.edu.itm.Utils;

import java.io.*;

public class FileOut {
    public void imprimirTxt(String archivo, Object[] data){
        try{
            FileOutputStream os = new FileOutputStream((new File("file").getAbsolutePath())+archivo+".txt");
            PrintStream ps = new PrintStream(os);
            String separator = ";";
            for (int i = 0; i < data.length; i++) {
                separator = i==data.length-1?"":";";
                ps.print(data[i]+separator);
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
}

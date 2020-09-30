package co.edu.itm.Utils;

import java.io.*;

public class FileOut {
    public void imprimirTxt(String archivo, String[] data){
        try{
            FileOutputStream os = new FileOutputStream((new File("file").getAbsolutePath())+archivo+".txt");
            PrintStream ps = new PrintStream(os);
            for (int i = 0; i < data.length; i++) {
                ps.println(data[i]);
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
}

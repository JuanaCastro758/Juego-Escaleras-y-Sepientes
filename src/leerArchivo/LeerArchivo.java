/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerArchivo;

/**
 *
 * @author Chiko malo
 */
import java.io.*;
public class LeerArchivo {
        private String[] leer(File archivo){
            int lineasTotales=0;
        try{
            if(archivo.exists()){
                BufferedReader leerArchivo=new BufferedReader(new FileReader(archivo));
                String lineaLeida="";
                while((lineaLeida = leerArchivo.readLine())!=null){
                    String[] palabras=lineaLeida.split(" ");
                    return palabras;
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage()+" Error");  
        }
        return null;
    }
}



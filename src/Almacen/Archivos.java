/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Almacen;

import Infomacion.Convertir;
import Infomacion.Datos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shack
 */
public class Archivos {
    List<Datos> contenido = new ArrayList<>();
    
    public List<Datos> Leer(){
        String linea;
        Datos datos;
        if(verifica()){
        try {
            FileReader archivo = new FileReader("DATOS.txt");
            BufferedReader br = new BufferedReader(archivo);
            
            while((linea = br.readLine())!= null){
                datos = new Datos();
                Convertir convertir = new Convertir();
                datos = convertir.aclass(linea);
                System.out.println("valor de linea" +linea );
                contenido.add(datos);
            }
            br.close();
            archivo.close();
            if(!(contenido.size()>=1)){
                contenido = null ;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        }else{
            contenido=null;
        }
        return contenido;
    }
    public boolean grabar(List<Datos> lista){
        Convertir convertir= new Convertir();
        boolean estado= true;
        FileWriter archivo;
        try {
            archivo = new FileWriter("DATOS.txt", true);
            BufferedWriter bw = new BufferedWriter(archivo);
            for(Datos cadena:lista)
            bw.write(convertir.ajson(cadena)+"\n");
            bw.close();
            archivo.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            estado = false;
        } 
        return estado;
    }
    
    private boolean verifica(){
        File archivo = new File("Datos.txt");
        if(archivo.exists())
            return true;
        else
            return false;
    }
}

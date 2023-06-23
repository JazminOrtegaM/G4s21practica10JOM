/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infomacion;

import com.google.gson.Gson;

/**
 *
 * @author shack
 */
public class Convertir {
    public Datos aclass(String cadena){
        Gson gson= new Gson();
        return gson.fromJson(cadena, Datos.class);
    }
    
    public String ajson(Datos datos){
        Gson gson= new Gson();
        return gson.toJson(datos);
        
    }

    public String adJson(Datos cadena) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

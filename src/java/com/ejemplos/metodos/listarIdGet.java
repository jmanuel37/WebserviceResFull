/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplos.metodos;

import com.ejemplo.model.Persona;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Optional;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;

/**
 *
 * @author POLAKO
 */
public class listarIdGet {
     public static void main(String[] args) {
     String urlstr="http://localhost:8080/ws_persona/";//http://localhost:8080/ws_persona/query?edad=20
        try{
            String id ="3";
            URL url = new  URL(urlstr+id);
            InputStream is = url.openStream();
            JsonReader rdr=Json.createReader(new InputStreamReader(is, "UTF-8"));
           JsonStructure results = rdr.read();
//            JsonStructure results ;
//             if(rdr.readArray().equals(null)){
//                System.out.println("No hay Datos");
//            }else{
//            results = rdr.readArray();
//            System.out.println("Datos"+results.toString());
//            }
             
             
            if(results.equals(null)){
                System.out.println("No hay Datos");
            }else{
            System.out.println("Datos"+results.toString());
            }
//            JsonArray results= rdr.readArray();
//            Iterator<?> iterator = results.iterator();
//            while(iterator.hasNext()){
//                JsonObject jsonObject = (JsonObject) iterator.next();
//                System.out.println("JSON-> El id es: "+jsonObject.get("id").toString().toUpperCase()+", el nombre es: "+jsonObject.get("nombre").toString().toUpperCase()+", el apellido es: "+jsonObject.get("apellido").toString().toUpperCase());
//            }
//            if(results.size()== 0){
//                System.out.println("No hay Datos");
//            }
        }catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
       }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplos.metodos;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author POLAKO
 */
public class listarJsonGet {
      public static void main(String[] args) {
     String urlstr="http://localhost:8080/ws_persona/listar";
        try{
            URL url = new  URL(urlstr);
            InputStream is = url.openStream();
            JsonReader rdr=Json.createReader(new InputStreamReader(is, "UTF-8"));
            JsonArray results= rdr.readArray();
            Iterator<?> iterator = results.iterator();
            while(iterator.hasNext()){
                JsonObject jsonObject = (JsonObject) iterator.next();
                System.out.println("JSON-> El id es: "+jsonObject.get("id").toString().toUpperCase()+", el nombre es: "+jsonObject.get("nombre").toString().toUpperCase()+", el apellido es: "+jsonObject.get("apellido").toString().toUpperCase());
            }
        }catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
       }
      //deuele xml
      /*
      public void listarXML(){
        String url="http://localhost:8080/JavaWebServiceServerCRUDRestful/restful/empleados/xml/listarempleados";
        try{
            URL urlObj=new URL(url);
            //abrimos la conexion
            HttpURLConnection conexion=(HttpURLConnection)urlObj.openConnection();
            conexion.setRequestProperty("Accept-Language", "UTF-8");
            conexion.setRequestMethod("GET");
            conexion.connect();
            //Almacenamos la respuesta
            InputSource resultado=new InputSource(conexion.getInputStream());

            //convertimos la respuesta que viene en binario a un archivo xml
            Document xmlDoc=DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(resultado);
            conexion.disconnect();//desconecto la url

            XPath xpath=XPathFactory.newInstance().newXPath();

            Boolean nodoStatusBool=(Boolean)xpath.evaluate("/collection/empleado",xmlDoc, XPathConstants.BOOLEAN);
            if(nodoStatusBool){
                NodeList nodoStatus=(NodeList)xpath.evaluate("/collection/empleado",xmlDoc, XPathConstants.NODESET);
                for (int i = 0; i < nodoStatus.getLength(); i++) {
                    Node nodeId=(Node)xpath.evaluate("/collection/empleado["+(i+1)+"]/id",xmlDoc, XPathConstants.NODE);
                    String id=nodeId.getTextContent().toUpperCase();

                    Node nodeNombre=(Node)xpath.evaluate("/collection/empleado["+(i+1)+"]/nombre",xmlDoc, XPathConstants.NODE);
                    String nombre=nodeNombre.getTextContent().toUpperCase();

                    Node nodePuesto=(Node)xpath.evaluate("/collection/empleado["+(i+1)+"]/puesto",xmlDoc, XPathConstants.NODE);
                    String puesto=nodePuesto.getTextContent().toUpperCase();
                    System.out.println("XML-> El id es: "+id+", el nombre es: "+nombre+", el puesto es: "+puesto);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
      */
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplos.metodos;

import com.ejemplo.model.Persona;
import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;




/**
 *
 * @author POLAKO
 */
public class eliminarJsonDelete {

    public static void main(String[] args) {

     String res = "";
        //String URL = "http://172.28.45.81/PS.CGP.PublicInterface/api/PIN/";
        String URL = "http://localhost:8080/ws_persona/eliminar/";
                    //http://localhost:8080/ws_persona/guardar
        
        try {
//Creamos el cliente de conexión al API Restful
            Client client = ClientBuilder.newClient();
            String id = "5";

//Creamos el target lo cuál es nuestra URL junto con el nombre del método a llamar
            //WebTarget target = client.target(URL + "GetAccountInfo");
            WebTarget target = client.target(URL+id);

//Creamos nuestra solicitud que realizará el request
            Invocation.Builder solicitud = target.request();
            //solicitud.header("Authorization", accessToken);

          
//Enviamos nuestro json vía post al API Restful
            //Response post = solicitud.post(Entity.json(jsonString));
            Response delete = solicitud.delete();

//Recibimos la respuesta y la leemos en una clase de tipo String, en caso de que el json sea tipo json y no string, debemos usar la clase de tipo JsonObject.class en lugar de String.class
            String responseJson = delete.readEntity(String.class);
            res = responseJson;

//Imprimimos el status de la solicitud
            System.out.println("Estatus: " + delete.getStatus());

            switch (delete.getStatus()) {
                case 200:
                    res = responseJson;
                    break;
                default:
                    res = "Error";
                    break;
            }

        } catch (Exception e) {
//En caso de un error en la solicitud, llenaremos res con la exceptión para verificar que sucedió
            res = e.toString();
        }
//Imprimimos la respuesta del API Restful
        System.out.println(res);
    }
    
    
    
    
}

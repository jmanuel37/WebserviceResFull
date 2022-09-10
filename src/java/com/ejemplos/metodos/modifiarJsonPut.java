/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplos.metodos;
import com.ejemplo.model.Persona;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;
/**
 *
 * @author POLAKO
 */
public class modifiarJsonPut {
      public static void main(String[] args) {
//Esta variable res la usaremos únicamente para dar un respuesta final
        String res = "";
        //String URL = "http://172.28.45.81/PS.CGP.PublicInterface/api/PIN/";
        String URL = "http://localhost:8080/ws_persona/actualizar";
                    //http://localhost:8080/ws_persona/guardar
        
        try {
//Creamos el cliente de conexión al API Restful
            Client client = ClientBuilder.newClient();

//Creamos el target lo cuál es nuestra URL junto con el nombre del método a llamar
            //WebTarget target = client.target(URL + "GetAccountInfo");
            WebTarget target = client.target(URL);

//Creamos nuestra solicitud que realizará el request
            Invocation.Builder solicitud = target.request();
            //solicitud.header("Authorization", accessToken);
//Creamos y llenamos nuestro objeto BaseReq con los datos que solicita el API
           /*
            BaseReq req = new BaseReq();
            req.setHostId("Z+W8pqkq/2DbF58Eo2dUcZMUTcGU6t4eouRhllHA");
            req.setOperationId("31e32-8f53ed89");
            req.setClientIPAddress("127.0.0.1");
            req.setCultureCode("ES-CR");
            req.setAccountNumber("CR00081411111111111111");
             */
           Persona req=new Persona();
            req.setId(6);
            req.setApellido("campos3");
            req.setNombre("lilian3");
            req.setEdad(30);
            //req.setAccountNumber("CR00081411111111111111");
//Convertimos el objeto req a un json
            Gson gson = new Gson();
            String jsonString = gson.toJson(req);
            System.out.println(jsonString);

//Enviamos nuestro json vía post al API Restful
            //Response post = solicitud.post(Entity.json(jsonString));
            Response put = solicitud.put(Entity.json(jsonString));

//Recibimos la respuesta y la leemos en una clase de tipo String, en caso de que el json sea tipo json y no string, debemos usar la clase de tipo JsonObject.class en lugar de String.class
            String responseJson = put.readEntity(String.class);
            res = responseJson;

//Imprimimos el status de la solicitud
            System.out.println("Estatus: " + put.getStatus());

            switch (put.getStatus()) {
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

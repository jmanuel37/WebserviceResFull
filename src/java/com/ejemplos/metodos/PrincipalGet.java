/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplos.metodos;

/**
 *
 * @author POLAKO
 */

import com.ejemplo.model.Persona;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class PrincipalGet {

    public static void main(String[] args) {

        Client cliente = ClientBuilder.newClient();
        Persona p = cliente.target("http://localhost:8080/ws_persona/listar")
                .request(MediaType.APPLICATION_JSON_TYPE).get(Persona.class);

        System.out.println(p.getId());
        System.out.println(p.getNombre());
        System.out.println(p.getApellido());
        System.out.println(p.getEdad());

    }
}

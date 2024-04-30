/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.carlospriego.Dto;

import org.carlospriego.Models.Clientes;

/**
 *
 * @author informatica
 */
public class ClienteDTO {
    private static ClienteDTO instance;
    
    private Clientes cliente;
    
    private ClienteDTO(){
    
    }
    
    public static ClienteDTO getClienteDTO(){
        if (instance == null) {
            instance = new ClienteDTO();
        }
        return instance;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    
    
}

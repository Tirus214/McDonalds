/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 *
 * @author Jean Paul
 */
public class Restaurante {
    public Menu menu;
    public Produccion produccion;
    public LinkedList<Cliente> colaCliente;
    public LinkedList<Cliente> colaPendientes;
    
    public Restaurante(){
        menu = new Menu();
        produccion = new Produccion();
        colaCliente = new LinkedList<Cliente>();
        colaPendientes = new LinkedList<Cliente>();
        leerMenu();
        crearClientes();
    }
    
    public void crearClientes(){
        int cantClientes = getRandom(20, 5);
        for (int i = 0; i < cantClientes; i++) {
            colaCliente.addLast(new Cliente());
        }
    }
    
    public void leerMenu(){
        
        String json = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("src\\modelo\\Recetas.json"));
            
            String linea = "";
            while ((linea = br.readLine()) != null){
                json += linea;
            }
            br.close();
            
        } catch(Exception e){
            System.out.println("Ocurrio un error");
        }
        
        //System.out.println(json);
        
        //Gson gson = new Gson();
    }
    
    public static int getRandom(int menor, int mayor){
        return (int)Math.floor(Math.random()*(mayor - menor + 1) + menor);
    }
    
    public void ordenarProductos(Cliente cliente){
        int rand = getRandom(menu.productos.size(), 1);
        for (int i = 0; i < rand; i++) {
            int rand2 = getRandom(menu.productos.size(), 1);
            cliente.pedidoProductos.add(menu.productos.get(rand2));
        }
    }
    
    public void checkearCombos(Cliente cliente){
        
    }
    
    public void thick(){
        if(colaCliente.getFirst().contador == 0){
            colaPendientes.addLast(colaCliente.removeFirst());
        }else
            colaCliente.getFirst().decrementarContador();
        
        if(!colaPendientes.isEmpty()){
            ordenarProductos(colaPendientes.getFirst());
            checkearCombos(colaPendientes.getFirst());
        
            produccion.producir(colaPendientes.getFirst());
            colaPendientes.getFirst().decrementarContadorPaciencia();
            
            colaPendientes.removeFirst();
        }
        
    }
}

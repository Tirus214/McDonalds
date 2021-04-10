/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Mauricio
 */
public class Produccion {
    int contador;
    ArrayList<Cliente> clientes; 
    ArrayList<Producto> productos;
    public Produccion(){
        clientes = new ArrayList<Cliente>();
        productos = new ArrayList<Producto>();
        
    }
    public void seguir(){
        for (int i = 0; i < clientes.size(); i++) {
            clientes.get(i).contadorPaciencia--;
            
        }
        for (int i = 0; i < productos.size(); i++) {
            productos.get(i).tiempoProduccion--;
            
        }
    }
    
}

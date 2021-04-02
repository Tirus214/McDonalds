/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jean Paul
 */
public class Cliente {
    
    public ArrayList<Producto> pedidoProductos;
    public ArrayList<Combo> pedidoCombos;
    public int contador;
    public boolean clienteEspecial;
    public int contadorPaciencia;
    
    public Cliente(){
        pedidoCombos = new ArrayList<Combo>();
        pedidoProductos = new ArrayList<Producto>();
        this.contador = Restaurante.getRandom(60, 10);
        isEspecial();
    }
    
    public void isEspecial(){
        int rand = (int)Math.floor(Math.random()*(3));
        if(rand == 0){
            this.clienteEspecial = true;
            this.contadorPaciencia = Restaurante.getRandom(60, 10);
        }
        else {
            this.clienteEspecial = false;
            this.contadorPaciencia = 0;
        }
    }
    
    public void decrementarContador(){
        for (int i = 0; i < contador; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException ex) {}
            contador--;
        }
    }
    
    public void decrementarContadorPaciencia(){
        if(clienteEspecial)
            for (int i = 0; i < contadorPaciencia; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException ex) {}
                contadorPaciencia--;
            }
    }
 }

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
import static modelo.Restaurante.getRandom;

/**
 *
 * @author Jean Paul
 */
public class Cliente {
    
    public ArrayList<Producto> pedidoProductos;
    public ArrayList<Combo> pedidoCombos;
    public int codigo;
    public int contador;
    public boolean clienteEspecial;
    public int contadorPaciencia;
    
    public Cliente(){
        this.codigo = 0;
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
    
    public void ordenarProductos(Menu menu){
        int rand = getRandom(5, 1);
        for (int i = 0; i < rand; i++) {
            int rand2 = getRandom(menu.productos.size(), 1);
            pedidoProductos.add(menu.productos.get(rand2));
        }
        compararCombos(menu);
    }
    
    public void compararCombos(Menu menu){
        for (int i = 0; i < menu.combos.size(); i++)
            if (checkearCombo(menu.combos.get(i)))
                eliminarProductos(menu.combos.get(i));
    }
    
    private boolean checkearCombo(Combo combo){
        int match = 0;
        for (int i = 0; i < pedidoProductos.size(); i++) {
            if(pedidoProductos.get(i).nombre == combo.principal.nombre)
                match++;
            else if(pedidoProductos.get(i).nombre == combo.bebida.nombre)
                match++;
            else if(pedidoProductos.get(i).nombre == combo.acomp.nombre)
                match++;
            
            if(match == 3){
                return true;
            }
        }
        return false;
    }
    
    private void eliminarProductos(Combo combo){
        int match = 3;
        for (int i = 0; i < pedidoProductos.size(); i++) {
            if(pedidoProductos.get(i).nombre == combo.principal.nombre)
                match--;
            else if(pedidoProductos.get(i).nombre == combo.bebida.nombre)
                match--;
            else if(pedidoProductos.get(i).nombre == combo.acomp.nombre)
                match--;
            
            if(match == 0)
                break;
        }
    }
    
 }

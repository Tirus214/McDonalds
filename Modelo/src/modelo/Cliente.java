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
    public boolean finalizado;
    
    public Cliente(){
        this.codigo = 0;
        pedidoCombos = new ArrayList<Combo>();
        pedidoProductos = new ArrayList<Producto>();
        this.contador = Restaurante.getRandom(10, 60);
        this.finalizado = false;
        isEspecial();
    }
    
    public void isEspecial(){
        int rand = getRandom(0, 4);
        if(rand == 0){
            this.clienteEspecial = true;
            this.contadorPaciencia = Restaurante.getRandom(10, 60);
        }
        else {
            this.clienteEspecial = false;
            this.contadorPaciencia = 0;
        }
    }
    
    
    public void ordenarProductos(Menu menu){
        int rand = getRandom(1,2);
        for (int i = 0; i < rand; i++) {
            Acompanamiento a1 = menu.acompanamientos.get(getRandom(0, menu.acompanamientos.size()-1)).clonacion();
            pedidoProductos.add(a1);
        }
        rand = Restaurante.getRandom(1,2);
        for (int i = 0; i < rand; i++) {
            Bebida b1 = menu.bebidas.get(getRandom(0, menu.bebidas.size()-1)).clonacion();
            pedidoProductos.add(b1);
        }
        rand = getRandom(1,2);
        for (int i = 0; i < rand; i++) {
            PlatoFuerte p1 = menu.principales.get(getRandom(0, menu.principales.size()-1)).clonacion();
            pedidoProductos.add(p1);
        }
        compararCombos(menu);
        marcarProductos();
    }
    
    private void marcarProductos(){
        for (int i = 0; i < pedidoProductos.size(); i++) 
            pedidoProductos.get(i).codigo = this.codigo;
        
        for (int i = 0; i < pedidoCombos.size(); i++)
            pedidoCombos.get(i).codigo = this.codigo;

    }
    
    public void compararCombos(Menu menu){
        for (int i = 0; i < menu.combos.size(); i++)
            if (checkearCombo(menu.combos.get(i))){
                pedidoCombos.add(menu.combos.get(i).clonacion());
                eliminarProductos(menu.combos.get(i));
            }
                
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
            
            if(match == 3) return true;
        }
        return false;
    }
    
    private void eliminarProductos(Combo combo){
        int match = 3;
        for (int i = 0; i < pedidoProductos.size(); i++) {
            if(pedidoProductos.get(i).nombre == combo.principal.nombre){
                pedidoProductos.remove(i);
                match--;
            }
            else if(pedidoProductos.get(i).nombre == combo.bebida.nombre){
                pedidoProductos.remove(i);
                match--;
            }
            else if(pedidoProductos.get(i).nombre == combo.acomp.nombre){
                pedidoProductos.remove(i);
                match--;
            }
            
            if(match == 0)
                return;
        }
    }
    
    public boolean revisarPedidos(){
        for (int i = 0; i < pedidoCombos.size(); i++) {
            if (!pedidoCombos.get(i).entregado)
                return false;
        }
            
        for (int i = 0; i < pedidoProductos.size(); i++) {
            if (!pedidoProductos.get(i).entregado)
                return false;         
        }
        return true;
    }
    
    
 }

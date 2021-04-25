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
    private int match;
    public int gasto;
    
    public Cliente(){
        pedidoCombos = new ArrayList<Combo>();
        pedidoProductos = new ArrayList<Producto>();
        contador = Restaurante.getRandom(10, 30);
        finalizado = false;
        match = 0;
        gasto = 0;
        isEspecial();
    }
    
    public void isEspecial(){
        int rand = getRandom(0, 4);
        if(rand == 0){
            this.clienteEspecial = true;
            this.contadorPaciencia = Restaurante.getRandom(10, 30);
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
        
        imprirmiProductos();
        //checkearCombo2(menu);
        //compararCombos(menu);
        imprirmiProductos();
        
        marcarProductos();
    }
    
    private void marcarProductos(){
        for (int i = 0; i < pedidoProductos.size(); i++){
            pedidoProductos.get(i).codigo = this.codigo;
            gasto += pedidoProductos.get(i).precio;
        }
              
        for (int i = 0; i < pedidoCombos.size(); i++){
            pedidoCombos.get(i).codigo = this.codigo;
            gasto += pedidoCombos.get(i).precio;
        }
    }
    
    public void compararCombos(Menu menu){
        for (int i = 0; i < menu.combos.size(); i++){
            
            if (checkearCombo(menu.combos.get(i))){
                eliminarProductos(menu.combos.get(i));
                Combo nuevo = menu.combos.get(i).clonacion();
                nuevo.codigo = this.codigo;
                pedidoCombos.add(nuevo);
                System.out.println(pedidoCombos.size());
            }
        }
                
    }
    
    private boolean checkearCombo(Combo combo){
        
        for (int i = 0; i < pedidoProductos.size(); i++) {
            
            if(pedidoProductos.get(i).nombre == combo.principal.nombre)
                match++;
            else if(pedidoProductos.get(i).nombre == combo.bebida.nombre)
                match++;
            else if(pedidoProductos.get(i).nombre == combo.acomp.nombre)
                match++;
            
            if(match == 3) {
                match = 0;
                return true;
            }
        }
        return false;
    }
    
    private void checkearCombo2(Menu menu){
        for (int i = 0; i < menu.combos.size(); i++) {
            
            if(buscarProducto(menu.combos.get(i).principal.nombre))
                if(buscarProducto(menu.combos.get(i).acomp.nombre))
                    if(buscarProducto(menu.combos.get(i).bebida.nombre)){
                        
                        pedidoCombos.add(menu.combos.get(i).clonacion());
                        eliminarProducto(menu.combos.get(i).principal.nombre);
                        eliminarProducto(menu.combos.get(i).acomp.nombre);
                        eliminarProducto(menu.combos.get(i).bebida.nombre);
                    }
            
        }
    }
    
    private void eliminarProductos(Combo combo){
        int match2 = 3;
        for (int i = 0; i < pedidoProductos.size(); i++) {
            if(pedidoProductos.get(i).nombre == combo.principal.nombre){
                pedidoProductos.remove(i);
                match2--;
            }
            else if(pedidoProductos.get(i).nombre == combo.bebida.nombre){
                pedidoProductos.remove(i);
                match2--;
            }
            else if(pedidoProductos.get(i).nombre == combo.acomp.nombre){
                pedidoProductos.remove(i);
                match2--;
            }
            
            if(match2 <= 0)
                return;
        }
    }
    
    public boolean revisarPedidos(){
        /*for (int i = 0; i < pedidoCombos.size(); i++) {
            if (!pedidoCombos.get(i).entregado)
                return false;
        }*/
            
        for (int i = 0; i < pedidoProductos.size(); i++) {
            if (!pedidoProductos.get(i).entregado)
                return false;         
        }
        return true;
    }
    
    public void imprirmiProductos(){
        for (int i = 0; i < pedidoProductos.size(); i++) {
            System.out.println(pedidoProductos.get(i).nombre);
        }
        System.out.println("\n");
    }
    
    public boolean buscarProducto(String nombre){
        for (int i = 0; i < pedidoProductos.size(); i++) 
            if(pedidoProductos.get(i).nombre == nombre)
                return true;
        return false;
    }
    
    public void eliminarProducto(String nombre){
        for (int i = 0; i < pedidoProductos.size(); i++) 
            if(pedidoProductos.get(i).nombre == nombre){
                pedidoProductos.remove(i);
                return;
            }       
    }
 }

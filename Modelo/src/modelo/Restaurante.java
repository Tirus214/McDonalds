/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static java.lang.Thread.sleep;
import java.util.LinkedList;

/**
 *
 * @author Jean Paul
 */
public class Restaurante {
    public Menu menu;
    public LinkedList<Cliente> colaCliente;
    public LinkedList<Cliente> colaClientePendiente;
    public LinkedList<Producto> colaOrdenesPendientes;
    public LinkedList<Combo> combos;
    private jsonClass json;
    public int cantIdos;
    public int cantDesechados;
    public int cantCorrectos;
    public Pantalla pantalla;
    public Produccion produccion;
    public String suceso;
    public int ganancias = 0;
    public Boolean finalizado = false;

    
    public Restaurante(Pantalla pantalla){
        menu = new Menu();
        colaCliente = new LinkedList<Cliente>();
        colaClientePendiente = new LinkedList<Cliente>();
        colaOrdenesPendientes = new LinkedList<Producto>();
        combos = new LinkedList<Combo>();
        this.pantalla = pantalla;
        cantDesechados = 0;
        cantIdos = 0;
        cantCorrectos = 0;
        suceso = "";
        produccion = new Produccion(colaOrdenesPendientes, combos);
        json = new jsonClass();
        setMenu();
        crearClientes();
        
    }
    
    public void setMenu(){
        json.readJson();
        menu.principales = json.principales;
        menu.acompanamientos = json.acompanamientos;
        menu.bebidas = json.bebidas;
        for (int i = 0; i < 6; i++) {
            menu.CrearCombo();
        }
    }
    
    public void crearClientes(){
        int cantClientes = getRandom(5,20);
        for (int i = 0; i < cantClientes; i++) {
            Cliente c = new Cliente();
            c.codigo = i;
            colaCliente.add(c);
        }
    }
    
    public static int getRandom(int menor, int mayor){
        return (int)Math.floor(Math.random()*(mayor - menor + 1) + menor);
    }
    
    
    public void tick(){
        if(!colaCliente.isEmpty()){
            if (colaCliente.getFirst().contador > 0){

                colaCliente.getFirst().contador--;
                //System.out.println("contador > 0 es true siempre, linea 86 de restaurante");
            }   
            else{
                colaCliente.getFirst().ordenarProductos(menu);
                produccion.agregarOrden(colaCliente.getFirst());
                colaClientePendiente.add(colaCliente.removeFirst());
            }
        }
        //else if(colaCliente.isEmpty()) return;
        produccion.procesar(0);
        for (int j = 0; j < colaClientePendiente.size(); j++) {
           
                esperar();
                //si es cliente especial...
                if(colaClientePendiente.get(j).clienteEspecial){
                    colaClientePendiente.get(j).contadorPaciencia--;
                    if(colaClientePendiente.get(j).contadorPaciencia <= 0){
                        colaClientePendiente.get(j).finalizado = true;
                        suceso += "El cliente " + colaClientePendiente.get(j).codigo + " se ha ido \n";
                        contarDesechos(colaClientePendiente.get(j));
                        produccion.eliminarOrden(colaClientePendiente.get(j));
                        colaClientePendiente.remove(j);
                        cantIdos++;
                        return;
                    }
                }
                
                //System.out.println("Cliente:    " + colaClientePendiente.getLast().codigo);
                //System.out.println("cant1   " + colaClientePendiente.getLast().pedidoProductos.size());
                //System.out.println("cant2   " + colaClientePendiente.getLast().pedidoProductos.size());
                //System.out.println("");
                
                if(colaClientePendiente.getFirst().revisarPedidos()){
                    colaClientePendiente.getFirst().finalizado = true;
                    suceso += "El cliente " + colaClientePendiente.getFirst().codigo + " pagó " + 
                            colaClientePendiente.getFirst().gasto + "\n";
                    ganancias += colaClientePendiente.getFirst().gasto;
                    colaClientePendiente.removeFirst();
                    cantCorrectos++;
                }                  
            }
        
            if(colaCliente.isEmpty() && colaClientePendiente.isEmpty() && !finalizado) {
                suceso += "La simulación ha finalizado\n";
                pantalla.imprimirPedidosPendientes();
                finalizado = true;
            }

        }
    
    public void contarDesechos(Cliente clienteActual){
        cantDesechados += clienteActual.pedidoProductos.size();
        cantDesechados += clienteActual.pedidoCombos.size() * 3;
    }
    
    public static void esperar(){
        try {
            sleep(0);
        } catch (InterruptedException ex) {
        }
    }
}

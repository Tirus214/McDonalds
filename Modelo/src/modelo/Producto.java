/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jean Paul
 */
public class Producto {
    
    public String nombre;
    public int precio;
    public int tiempoProduccion;

    public Producto(String nombre, int precio, int tiempoProduccion) {
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoProduccion = tiempoProduccion;
    }
    
    public void Imprimir(){
        System.out.println(nombre + "\n Precio: " + precio + "\nTiempo de producción: "+ tiempoProduccion + 's');
    }
}

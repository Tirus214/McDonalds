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
public class Producto{
    
    public String nombre;
    public int precio;
    public int tiempoProduccion;
    public int clasificacion;
    public boolean entregado = false;
    public int codigo;
    public int valor;
    

    public Producto(String nombre, int precio, int tiempoProduccion) {
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoProduccion = tiempoProduccion;
        this.clasificacion = 0;
    }
    
    public void Imprimir(){
        System.out.println(nombre + "\n Precio: " + precio + "\nTiempo de producción: "+ tiempoProduccion + 's');
    }
}

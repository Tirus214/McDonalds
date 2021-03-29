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
public class Acompanamiento extends Producto{
    
    public String tipo;     //salado o dulce

    public Acompanamiento(String nombre, int precio, double tiempoProduccion, String tipo) {
        super(nombre, precio, tiempoProduccion);
        this.tipo = tipo;
    }
    
}

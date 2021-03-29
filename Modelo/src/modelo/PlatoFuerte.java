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
public class PlatoFuerte extends Producto{
    
    public String tamano;   //entero o mediano

    public PlatoFuerte(String nombre, int precio, double tiempoProduccion, String tamano) {
        super(nombre, precio, tiempoProduccion);
        this.tamano = tamano;
    }
}

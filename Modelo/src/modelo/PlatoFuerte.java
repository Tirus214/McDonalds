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

    public PlatoFuerte(String nombre, int precio, int tiempoProduccion, String tamano) {
        super(nombre, precio, tiempoProduccion);
        this.tamano = tamano;
        this.clasificacion = 1;
        this.valor = 3;
    }

    public String ImprimirPlato(){
        return(nombre + "\n Precio: " + precio + "\nTiempo de producción: "+ tiempoProduccion + 's' + "\nTamaño: "+ tamano);
    }
   
    public PlatoFuerte clonacion(){
        PlatoFuerte p = new PlatoFuerte(nombre, precio, tiempoProduccion, tamano);
        p.clasificacion = clasificacion;
        p.codigo = codigo;
        p.entregado = entregado;
        p.valor = valor;
        return p;
    }
}


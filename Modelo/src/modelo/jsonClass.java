/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static javax.management.Query.gt;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author Jean Paul
 */
public class jsonClass {
    
    public ArrayList<PlatoFuerte> principales;
    public ArrayList<Bebida> bebidas;
    public ArrayList<Acompanamiento> acompanamientos;
    
    public jsonClass(){
        principales = new ArrayList<PlatoFuerte>();
        bebidas = new ArrayList<Bebida>();
        acompanamientos = new ArrayList<Acompanamiento>();
    }
    
    public void readJson(){
        
        JSONParser jsonP = new JSONParser();

        try(FileReader reader = new FileReader("src\\modelo\\Recetas.json")){
            //Read JSON File
            Object obj = jsonP.parse(reader);
            JSONObject recetario = (JSONObject) obj;

            JSONObject receta0 = (JSONObject) recetario.get("receta0");
            insertarProducto(receta0);
         
            JSONObject receta1 = (JSONObject) recetario.get("receta1");
            insertarProducto(receta1);
            
            JSONObject receta2 = (JSONObject) recetario.get("receta2");
            insertarProducto(receta2);
            
            JSONObject receta3 = (JSONObject) recetario.get("receta3");
            insertarProducto(receta3);
            
            JSONObject receta4 = (JSONObject) recetario.get("receta4");
            insertarProducto(receta4);
            
            JSONObject receta5 = (JSONObject) recetario.get("receta5");
            insertarProducto(receta5);
            
            JSONObject receta6 = (JSONObject) recetario.get("receta6");
            insertarProducto(receta6);
            
            JSONObject receta7 = (JSONObject) recetario.get("receta7");
            insertarProducto(receta7);
            
            JSONObject receta8 = (JSONObject) recetario.get("receta8");
            insertarProducto(receta8);
            
            JSONObject receta9 = (JSONObject) recetario.get("receta9");
            insertarProducto(receta9);
            
            JSONObject receta10 = (JSONObject) recetario.get("receta10");
            insertarProducto(receta10);
            
            JSONObject receta11 = (JSONObject) recetario.get("receta11");
            insertarProducto(receta11);
        }
        catch (Exception e) {
            System.out.println("Error al leer el json");
        }
    }
    
    private void insertarProducto(JSONObject receta){
        String nombre = (String) receta.get("nombre");
        int precio = Integer.parseInt((String) receta.get("precio"));
        int tiempo = Integer.parseInt((String) receta.get("tiempo"));
        
        switch(Integer.parseInt((String) receta.get("clasificacion"))){
            case 1:
                String tamano = (String) receta.get("tamano");
                principales.add(new PlatoFuerte(nombre, precio, tiempo, tamano));
                break;
            case 2:
                String tipo = (String) receta.get("tipo");
                acompanamientos.add(new Acompanamiento(nombre, precio, tiempo, tipo));
                break;
            case 3:
                int tamano2 = Integer.parseInt((String) receta.get("tamano"));
                String tipo2 = (String) receta.get("tipo");
                bebidas.add(new Bebida(nombre, precio, tiempo, tipo2, tamano2));
            default:
                break;
        }
    }
    
}

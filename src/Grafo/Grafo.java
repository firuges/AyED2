/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Hash.Hash;
import ListaSimpleGeneric.ListaSimpleGeneric;

/**
 *
 * @author Maxi
 */
public class Grafo {
    public Hash ListaAdyacencia;
    public ListaSimpleGeneric[] ListaAristas;
    private int nroAristas;
    public Grafo(int cant){
        ListaAdyacencia = new Hash <Vertice>(cant);
    }
    public void agregarVertice(Grafo g, Vertice v){
        /*if(!existeVertice(v)){
            for (int i = 0; i < ListaAdyacencia.; i++) {
                Vertice elVertice = (Vertice)ListaAdyacencia[i].getDato();
                if (elVertice.getNombAeropuerto() == null) { // si el vertice esta vacio
                    elVertice.setNombAeropuerto(v.getNombAeropuerto());
                    ListaAdyacencia[i].setDato(elVertice);
                    System.out.println("Se agrego Correctamente tu Aeropuerto: " + String.valueOf(ListaAdyacencia[i].getDato())  );
                    break;
                }
            }
        }else{
            System.out.println("El Vertice que has intentado agregar ya Existe!");
                
         }*/
        
        
    }
    
    public  void agregarArista(Grafo g, Arista a){
        
    }
    public void borrarVertice(Grafo g, Vertice v){
        
    }
    
    public  boolean borrarArista(Grafo g, Arista a){
        return true;
    }
    public  Boolean esVacio(Grafo g){
        return true;
    }
    /*public  Hash[] VerticesAdyacentes(Grafo g, Vertice v){
        return ListaAdyacencia;
       
    }*/
    public static Boolean sonAdyacentes(Vertice a, Vertice b){
        return true;
    }
    /*public  Boolean existeVertice (Vertice v){
        for(int i = 0; i < ListaAdyacencia.length; i++){
            Vertice aux = (Vertice)ListaAdyacencia[i].getDato();
            if(aux.getNombAeropuerto()!= null)
                if(aux.getNombAeropuerto().equals(v.getNombAeropuerto()))
                    return true;
            else
                    return false;
        }
        return false;
    }*/
}

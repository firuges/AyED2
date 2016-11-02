/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Hash.Hash;
import ListaSimpleGeneric.ListaSimpleGeneric;
import Grafo.Vertice;
/**
 *
 * @author Maxi
 */
public class Grafo{
    public Hash ListaAdyacencia;
    public ListaSimpleGeneric[] ListaAristas;
    private static int nroAristas;
    public Grafo(int cant){
        ListaAdyacencia = new Hash(cant);
        nroAristas = 0;
    }
    public void agregarVertice(Grafo g, Vertice v){
        if(!existeVertice(v)){
            ListaAdyacencia.Insertar(v);
            nroAristas++;
        }
            
        
        else
            System.out.println("El Vertice que has intentado agregar ya Existe!");
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
    public  Boolean existeVertice (Vertice v){
        if(ListaAdyacencia.Pertenece(v)){
            return true;
        }
        return false;
    }
}

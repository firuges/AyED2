/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Hash.Hash;
import ListaSimpleGeneric.ListaSimpleGeneric;
import Grafo.Vertice;
import java.util.ArrayList;
/**
 *
 * @author Maxi
 */
public class Grafo{
    public Hash ListaAdyacencia;
    public ArrayList<Arista> ListaAristas;
    private static int nroAristas;
    public Grafo(){
        ListaAdyacencia = new Hash(100);
        ListaAristas = new ArrayList<Arista>();
        nroAristas = 0;
    }
    public void agregarVertice(Vertice v){
        if(!existeVertice(v)){
            ListaAdyacencia.Insertar(v);
            nroAristas++;
        }
    }
    
    public  boolean agregarArista(Grafo g, Arista a){
        if(!existeArista(a)){
            ListaAristas.add(a);
        }
        return true;
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
    public  Boolean existeArista (Arista v){
        if(ListaAristas.size() > 0){
            for(Arista laArista: ListaAristas){
            if(laArista != null){
                if(laArista.getOrigen().equals(v.getOrigen()) && laArista.getDestino().equals(v.getDestino()) ){
                    return true;
                }
            }
        }
        }
        return false;
    }
}

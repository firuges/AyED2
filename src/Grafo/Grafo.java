/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Common.Viaje;
import Hash.Hash;
import ListaSimple.ListaSimple;
import Grafo.Vertice;
import arbol.ABB;
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
    public Vertice agregarVertice(Vertice v){
        Vertice auxiliar = existeVertice(v);
        if(auxiliar == null){
            v = ListaAdyacencia.Insertar(v);
            nroAristas++;
        }
        return v;
    }
    
    public  boolean agregarArista(Grafo g, Arista a){
        if(!existeArista(a)){
            ListaAristas.add(a);
            return true;
        }
        return false;
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
    public  Vertice existeVertice (Vertice v){
        Vertice miV = ListaAdyacencia.Pertenece(v);
        if(miV != null){
            return miV;
        }
        return null;
    }
    public  Boolean existeArista (Arista v){
        if(ListaAristas.size() > 0){
            for(Arista laArista: ListaAristas){
                if(laArista != null){
                    //IDA // y // VUELTA
                    if(laArista.getOrigen().getNombreEstacion().equalsIgnoreCase(v.getOrigen().getNombreEstacion()) && laArista.getDestino().getNombreEstacion().equalsIgnoreCase(v.getDestino().getNombreEstacion()) || laArista.getDestino().getNombreEstacion().equalsIgnoreCase(v.getOrigen().getNombreEstacion()) && laArista.getOrigen().getNombreEstacion().equalsIgnoreCase(v.getDestino().getNombreEstacion())){
                        return true;
                    }
                 }
        
            }
        
        }
        return false;
    }
    public  char estacionPerteneceAlinea (String estacion){
        if(ListaAristas.size() > 0){
            for(Arista laArista: ListaAristas){
                if(laArista != null){
                    //IDA // y // VUELTA
                    if(laArista.getOrigen().getNombreEstacion().equalsIgnoreCase(estacion) || laArista.getDestino().getNombreEstacion().equalsIgnoreCase(estacion) || laArista.getDestino().getNombreEstacion().equalsIgnoreCase(estacion) && laArista.getOrigen().getNombreEstacion().equalsIgnoreCase(estacion)){
                        return laArista.getLinea();
                    }
                 }
        
            }
        
        }
        return 'z';
        
    }
    public Boolean existenEstacionesDeLaLinea(Viaje viaje){
        //boolean existeEstacion = losViajes.
        String Origen = viaje.getvOrigen().getNombreEstacion();
        String Destino = viaje.getvDestino().getNombreEstacion();
        char Linea1 = estacionPerteneceAlinea(viaje.getvOrigen().getNombreEstacion());
        char Linea2 = estacionPerteneceAlinea(viaje.getvDestino().getNombreEstacion());
        if(Linea1 != Linea2 || Linea1 == 'z' || Linea2 == 'z'){
            return false;
        }
        return true;
    }
}

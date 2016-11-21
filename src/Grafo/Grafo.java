/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Cola.Cola;
import Common.Viaje;
import Hash.Hash;
import ListaSimple.ListaSimple;
import Grafo.Vertice;
import Hash.IndicadorEstado;
import Hash.IndicadorEstado.TipoRet;
import Hash.NodoHash;
import ListaSimpleGneric.ListaSimpleGeneric;
import ListaSimpleGneric.NodoListaSimple;
import arbol.ABB;
import static java.lang.Integer.MAX_VALUE;
import java.util.ArrayList;
/**
 *
 * @author Maxi
 */
public class Grafo{
    public Hash ListaAdyacencia;
    public ArrayList<Arista> ListaAristas;
    
    public static float[] distancia;
    public static boolean[]visitado;
    public static NodoHash[]Vertices;
    public static NodoHash[]Previo;
    
    private static int nroVertices;
    public Grafo(){
        ListaAdyacencia = new Hash(100);
        ListaAristas = new ArrayList<Arista>();
        nroVertices = 0;
    }
    public Vertice agregarVertice(Vertice v){
        Vertice auxiliar = existeVertice(v);
        if(auxiliar == null){
            v = ListaAdyacencia.Insertar(v);
            nroVertices++;
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
    
    public void initTablasDisjktra(){
        initArrays();
        Hash hash = new Hash(nroVertices);
        hash.setTablaHash(ListaAdyacencia.getTablaHash());
        ListaSimpleGeneric list = new ListaSimpleGeneric();
        
        for(int j = 0; j < ListaAdyacencia.getTablaHash().length; j++){
            if(ListaAdyacencia.getTablaHash()[j].getEstado().equals(TipoRet.OCUPADO)){
                list.insertarInicio(ListaAdyacencia.getTablaHash()[j]);
            }
                 
        }
        NodoListaSimple nodo = list.getInicio();
        NodoHash nodohash = (NodoHash)nodo.getDato();
        for( int i = 0 ; i < nroVertices ; ++i ){
            Vertices[i] = new NodoHash();
            Vertices[i] = (NodoHash)nodohash;
            distancia[ i ] = -1;  //inicializamos todas las distancias con valor infinito
            visitado[i] = false; //inicializamos todos los vértices como no visitado
            Previo[ i ] = new NodoHash();      //inicializamos el previo del vértice i con -1
            if(nodo.getSiguiente()!= null){
                nodo = nodo.getSiguiente();
                nodohash = (NodoHash)nodo.getDato();
            }
            
        }
    }
    private void initArrays(){
        distancia = new float[nroVertices];
        visitado = new boolean[nroVertices];
        Vertices = new NodoHash[nroVertices];
        Previo = new NodoHash[nroVertices];
    }
    /*public void Ponderado(Vertice s)
    {
            Vertice v, w;
            v = new Vertice();
            w = new Vertice();
            Cola c = new Cola(); // creo una cola
            
            c.enqueue(s); // meto el elemento s
            while(!c.IsEmpty())
            {
                
                v = (Vertice)c.front().getElem();
                c.dequeue();
                visitado[this.getPosVertice(v)] = true;
                for(int i = 0 ; i < Vertices.length; i++){
                    NodoHash aux = new NodoHash();
                    aux = Vertices[i].getSiguiente();
                    while(aux != null){
                        w = aux.getDato();
                        if(distancia[getPosVertice(w)] == -1)
                        {
                            distancia[getPosVertice(v)] += aux.getPesoAlSiguiente().getDistancia();
                            NodoHash nodo = new NodoHash(w);
                            Previo[getPosVertice(v)] = nodo;
                            c.enqueue(w);
                            
                        }
                        aux = aux.getSiguiente();
                    }
                    
                }
            }
    }*/
    private int getPosVertice(Vertice v){
        for( int i = 0 ; i < nroVertices ; ++i ){
            if(Vertices[i].getDato().getNombreEstacion().equalsIgnoreCase(v.getNombreEstacion())){
                return i;
            }
        }
        return -1;
    }
    
}

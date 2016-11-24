/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Cola.Cola;
import Common.Ponderada;
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
import ayed2obligatorio2016.Sistema;
import static java.lang.Integer.MAX_VALUE;
import java.util.ArrayList;
/**
 *
 * @author Maxi
 */
public class Grafo{
    public Hash ListaAdyacencia;
    public ArrayList<Arista> ListaAristas;
    public static Vertice[] TablaCaminoCorto;
    private static int nroVertices;
    public Grafo(){
        ListaAdyacencia = new Hash(100);
        ListaAristas = new ArrayList<Arista>();
        TablaCaminoCorto = new Vertice[100];
        nroVertices = 0;
    }
    public Vertice agregarVertice(Vertice v){
        Vertice auxiliar = existeVertice(v);
        if(auxiliar == null){
            v = ListaAdyacencia.Insertar(v);
            nroVertices++;
            return v;
        }else{
            return auxiliar;
        }
        
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
    /*public  Hash[] VerticesAdyacentes(Grafo g, Vertice Actual){
        return ListaAdyacencia;
       
    }*/
    public static Boolean sonAdyacentes(Vertice a, Vertice b){
        return true;
    }
    public  Vertice existeVertice (Vertice v){
        return ListaAdyacencia.Pertenece(v);
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
    public void initArrays(Vertice Inicial){
        int largo = Sistema.MetroLineas.ListaAdyacencia.getTablaHash().length;
        NodoHash [] tabla = Sistema.MetroLineas.ListaAdyacencia.getTablaHash();
        for(int i = 0; i < largo; i++){
            if(Inicial.getIdHash() == i){
                TablaCaminoCorto[i] =  new Vertice();
                TablaCaminoCorto[i] = tabla[i].getDato();
                TablaCaminoCorto[i] =  tabla[i].getDato();
                TablaCaminoCorto[i].setConocido(false);
                TablaCaminoCorto[i].setDistancia(0);
                TablaCaminoCorto[i].setPrecio(0);
                TablaCaminoCorto[i].setPv(null);
            }else{
                TablaCaminoCorto[i] =  new Vertice();
                TablaCaminoCorto[i] = tabla[i].getDato();
                TablaCaminoCorto[i].setConocido(false);
                TablaCaminoCorto[i].setDistancia(Integer.MAX_VALUE);
                TablaCaminoCorto[i].setPrecio(0);
                TablaCaminoCorto[i].setPv(null);
            }
            
            
        }
        Ponderado(TablaCaminoCorto, Inicial);
    }
    public void Ponderado(Vertice[] T, Vertice actual){
        Vertice v, w;
        Hash hash = this.ListaAdyacencia;
        w = new Vertice();
        NodoHash [] tabla = Sistema.MetroLineas.ListaAdyacencia.getTablaHash();
	for(int i=0; i < nroVertices; i++){
		v = verticeConDistanciaMasCortaDesconocido();
                T[v.getIdHash()].setConocido(true);
                //capturo las aristas del vertice
                ListaSimpleGeneric list = v.getLasAristas();
                int cantAdyacentes = v.cantAristas(list);
                //for(w = Actual.getSiguiente(); w != null; w = w.getSiguiente())
                NodoHash nodo = new NodoHash();
                nodo = tabla[hash.H(v.getNombreEstacion())];
                for(int j = 0; j < cantAdyacentes; j ++)
                {
                    nodo = nodo.getSiguiente();
                    w = nodo.getDato();
                    if(T[hash.H(w.getNombreEstacion())].isConocido() == false && T[hash.H(v.getNombreEstacion())].getDistancia() + this.c(v, w, v.getLasAristas()) < T[hash.H(w.getNombreEstacion())].getDistancia()){
                        T[hash.H(w.getNombreEstacion())].setDistancia(T[hash.H(v.getNombreEstacion())].getDistancia() + this.c(v, w, v.getLasAristas()));
                        T[hash.H(w.getNombreEstacion())].setPv(v);
                    }
                    
                    
            }

        }
    }
    private float c(Vertice v, Vertice w, ListaSimpleGeneric aristas){
        NodoListaSimple nodo = new NodoListaSimple();
        nodo.setDato(aristas.getInicio().getDato());
        while(nodo != null){
            Arista laArista = new Arista();
            laArista = (Arista)nodo.getDato();
            if(laArista.getOrigen().getNombreEstacion().equalsIgnoreCase(v.getNombreEstacion()) && laArista.getDestino().getNombreEstacion().equalsIgnoreCase(w.getNombreEstacion()) || laArista.getDestino().getNombreEstacion().equalsIgnoreCase(w.getNombreEstacion()) && laArista.getOrigen().getNombreEstacion().equalsIgnoreCase(v.getNombreEstacion())){
                        return laArista.getDistancia();
                    }
           nodo = nodo.getSiguiente();
        }
         return -1;
    }
        
    
    public Vertice verticeConDistanciaMasCortaDesconocido(){
        float distancia = 0;
        for(int i=0; i < TablaCaminoCorto.length; i++){
            if(TablaCaminoCorto[i].getDistancia() < Integer.MAX_VALUE && !TablaCaminoCorto[i].isConocido()){
                return TablaCaminoCorto[i];
                
            }
        }
        return null;
    }
    
    private void imprimir(){
        for(int i = 0 ; i < TablaCaminoCorto.length; i++){
            if(TablaCaminoCorto[i].getPv() == null){
                System.out.println("Null");
            }else
                System.out.println("" + TablaCaminoCorto[i].getPv().toString());
            System.out.println("" + TablaCaminoCorto[i].getDistancia());
            System.out.println("" + TablaCaminoCorto[i].getPrecio());
        }
    }
    
}

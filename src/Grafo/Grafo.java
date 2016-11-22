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
    public static Ponderada[] TablaCaminoCorto;
    private static int nroVertices;
    public Grafo(){
        ListaAdyacencia = new Hash(100);
        ListaAristas = new ArrayList<Arista>();
        TablaCaminoCorto = new Ponderada[100];
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
        for(int i = 0; i < largo; i++){
            if(Inicial.getIdHash() == i){
                TablaCaminoCorto[i] =  new Ponderada();
                TablaCaminoCorto[i].setConocido(true);
                TablaCaminoCorto[i].setDistancia(0);
                TablaCaminoCorto[i].setPrecio(0);
                TablaCaminoCorto[i].setPv(null);
            }else{
                TablaCaminoCorto[i] =  new Ponderada();
                TablaCaminoCorto[i].setConocido(false);
                TablaCaminoCorto[i].setDistancia(Integer.MAX_VALUE);
                TablaCaminoCorto[i].setPrecio(0);
                TablaCaminoCorto[i].setPv(null);
            }
            
            
        }
        Ponderado(TablaCaminoCorto, Inicial);
    }
    public void Ponderado( Ponderada[] T, Vertice actual)
    {
            Vertice Actual, w;
            Actual = new Vertice();
            w = new Vertice();
            Cola c = new Cola(); // creo una cola
            
            c.enqueue(actual); // meto el elemento s
            while(!c.IsEmpty())
            {
                //Vertice actual
                Actual = (Vertice)c.front().getElem();
                //Quitarlo de la cola
                c.dequeue();
                //Hacer el Vertice actual como conocido
                T[Actual.getIdHash()].setConocido(true);
                //capturo las aristas del vertice
                ListaSimpleGeneric list = Actual.getLasAristas();
                //capturo la primera arista
                NodoListaSimple nodo = list.getInicio();
                //capturo la primera arista
                Arista arista = (Arista)nodo.getDato();
                //recorro cada Vertice Destino de las aristas
                int cantAdyacentes = Actual.cantAristas(list);
                //for(w = Actual.getSiguiente(); w != null; w = w.getSiguiente())
                for(int i = 0; i < cantAdyacentes; i ++)
                {
                    Arista aux = new Arista();
                    //Vertice Adyacente
                    w = arista.getDestino();
                    if(T[w.getIdHash()].getDistancia() == Integer.MAX_VALUE)
                    {
                        T[w.getIdHash()].setDistancia(T[Actual.getIdHash()].getDistancia() + arista.getDistancia());
                        T[w.getIdHash()].setConocido(true);
                        T[w.getIdHash()].setPv(actual);
                        c.enqueue(w);
                    }else{
                        if(arista.getDistancia() < aux.getDistancia()){
                            T[w.getIdHash()].setDistancia(T[Actual.getIdHash()].getDistancia() - aux.getDistancia());
                            T[w.getIdHash()].setDistancia(T[Actual.getIdHash()].getDistancia() + arista.getDistancia());
                            T[w.getIdHash()].setConocido(true);
                            T[w.getIdHash()].setPv(actual);
                            c.enqueue(w);
                        }
                    }
                    aux = arista;
                    nodo = nodo.getSiguiente();
                    if(nodo != null){
                        arista = (Arista)nodo.getDato();
                        w = arista.getDestino();
                        
                    }
                    
                }
            }
            imprimir();
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

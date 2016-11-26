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
    public Vertice[] initArrays(Vertice Inicial){
        TablaCaminoCorto = new Vertice[100];
        int largo = Sistema.MetroLineas.ListaAdyacencia.getTablaHash().length;
        NodoHash [] tabla = Sistema.MetroLineas.ListaAdyacencia.getTablaHash();
        for(int i = 0; i < largo; i++){
            if(Inicial.getIdHash() == i){
                TablaCaminoCorto[i] =  new Vertice();
                TablaCaminoCorto[i] = tabla[i].getDato();
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
        return Ponderado(TablaCaminoCorto);
    }
    public Vertice[] Ponderado(Vertice[] T){
        Vertice v, w;
        Hash hash = this.ListaAdyacencia;
        w = new Vertice();
        NodoHash [] tabla = Sistema.MetroLineas.ListaAdyacencia.getTablaHash();
	for(int i=0; i < nroVertices; i++){
                
		v = verticeConDistanciaMasCortaDesconocido();
                T[v.getIdHash()].setConocido(true);
                /*System.out.println("Padre: " + v.getNombreEstacion());
                System.out.println("-------------------------");*/
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
                    //Extras para detectar Fayas
                    float Dist_VerticeW = T[hash.H(w.getNombreEstacion())].getDistancia();
                    float Dist_VerticeV = T[hash.H(v.getNombreEstacion())].getDistancia();
                    float Precio_DeV = T[hash.H(v.getNombreEstacion())].getPrecio();
                    boolean W_esDesconocido = T[hash.H(w.getNombreEstacion())].isConocido();
                    //                                             Dist Entre W y V
                    if(W_esDesconocido == false && Dist_VerticeV + this.Dist_Entre(v, w, v.getLasAristas()) < Dist_VerticeW){
                        
                        T[hash.H(w.getNombreEstacion())].setDistancia(Dist_VerticeV + this.Dist_Entre(v, w, v.getLasAristas()));
                        T[hash.H(w.getNombreEstacion())].setPrecio(Precio_DeV + this.Precio_Entre(v, w, v.getLasAristas()));
                        T[hash.H(w.getNombreEstacion())].setPv(v);
                    }
                    //System.out.print("Adyacente: " + w.getNombreEstacion() + "  → Estacion Anterior: ");
                    /*if(w.getPv() != null)
                        System.out.print(w.getPv().getNombreEstacion().toString());
                    else{
                        System.out.print("Null");
                    }
                    System.out.println("\n ");*/
                    
            }
            //System.out.println("-------------------------");
        }
        //imprimir(); pruebas
        return TablaCaminoCorto;
    }
    private float Dist_Entre(Vertice v, Vertice w, ListaSimpleGeneric aristas){
        NodoListaSimple nodo = new NodoListaSimple();
        nodo = aristas.getInicio();
        while(nodo != null){
            Arista laArista = new Arista();
            laArista = (Arista)nodo.getDato();
            if(laArista.getOrigen().getNombreEstacion().equalsIgnoreCase(v.getNombreEstacion()) && laArista.getDestino().getNombreEstacion().equalsIgnoreCase(w.getNombreEstacion())){
                        return laArista.getDistancia();
                    }
           nodo = nodo.getSiguiente();
        }
         return -1;
    }
    private float Precio_Entre(Vertice v, Vertice w, ListaSimpleGeneric aristas){
        NodoListaSimple nodo = new NodoListaSimple();
        nodo = aristas.getInicio();
        while(nodo != null){
            Arista laArista = new Arista();
            laArista = (Arista)nodo.getDato();
            if(laArista.getOrigen().getNombreEstacion().equalsIgnoreCase(v.getNombreEstacion()) && laArista.getDestino().getNombreEstacion().equalsIgnoreCase(w.getNombreEstacion())){
                        return laArista.getPrecio();
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
        System.out.println("Imprimiendo Tabla");
        System.out.println("||Vertice   ||Conocido||Distancia||      PV     ||");
        for(int i = 0 ; i < TablaCaminoCorto.length; i++){
            if(TablaCaminoCorto[i].getDistancia() < Integer.MAX_VALUE){
                 
                 System.out.print("   " + TablaCaminoCorto[i].getNombreEstacion()+ " ");
                 System.out.print("   " + TablaCaminoCorto[i].isConocido() + " ");
                 System.out.print("         " + TablaCaminoCorto[i].getDistancia()+"      ");
                if(TablaCaminoCorto[i].getPv() == null){
                    System.out.print("   Null   ");
                }else{
                    System.out.print(TablaCaminoCorto[i].getPv().toString());
                }

                System.out.println(" ");
            }
        }
    }
    public float Camino_Mas_Corto(Vertice[] T, Vertice v){
        float precioFinal;
        Hash hash = this.ListaAdyacencia;
	if(T[hash.H(v.getNombreEstacion())].getPv() != null){
          Camino_Mas_Corto(T, T[hash.H(v.getNombreEstacion())].getPv());
		System.out.print(" a →");
	}
        
	System.out.print("Estacion: '" + v.getNombreEstacion() +"' '"+ v.getDistancia()+"km', Valor: " + v.getPrecio() + "\n");
        return precioFinal = v.getPrecio();
    }
    public float Precio_a_Destino(Vertice[] T, Vertice v){
        float precioFinal;
        Hash hash = this.ListaAdyacencia;
	if(T[hash.H(v.getNombreEstacion())].getPv() != null){
          Camino_Mas_Corto(T, T[hash.H(v.getNombreEstacion())].getPv());
	}
        
        if(v.getNombreEstacion().equalsIgnoreCase(T[hash.H(v.getNombreEstacion())].getPv().getNombreEstacion())){
            precioFinal = v.getPrecio();
            return precioFinal;
        }
	return 0;
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Grafo.Arista;
import Grafo.Vertice;
import ListaSimpleGneric.ListaSimpleGeneric;
import ListaSimpleGneric.NodoListaSimple;

/**
 *
 * @author Maxi
 */
public class Linea implements Comparable{
    private char nombre;
    private ListaSimpleGeneric Estaciones;
    public Linea(){
        Estaciones = new ListaSimpleGeneric();
    }
    public Linea(char pNombre){
        nombre = pNombre;
        Estaciones = new ListaSimpleGeneric();
    }
    /**
     * @return the nombre
     */
    public char getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(char nombre) {
        this.nombre = nombre;
    }
    
    public boolean EstacionExisteEnLinea(Vertice estacion, ListaSimpleGeneric lst){
        NodoListaSimple nodo = lst.getInicio();
        while(nodo != null){
            Vertice aux = new Vertice();
            aux = (Vertice)nodo.getDato();
            if(aux.getNombreEstacion().equalsIgnoreCase(estacion.getNombreEstacion())){
                return true;
            }
            nodo = nodo.getSiguiente();
        }
        return false;
    }

    /**
     * @return the Estaciones
     */
    public ListaSimpleGeneric getEstaciones() {
        return Estaciones;
    }

    /**
     * @param Estaciones the Estaciones to set
     */
    public void setEstaciones(ListaSimpleGeneric Estaciones) {
        this.Estaciones = Estaciones;
    }

    @Override
    public int compareTo(Object o) {
        Linea unaLinea = (Linea)o;
        int i= ((Comparable) this.nombre).compareTo(unaLinea.getNombre()); 
        return  i;
    }
    public Linea EsPunteroDe(Vertice a){
        ListaSimpleGeneric lst = a.getLasAristas();
        NodoListaSimple nodo = lst.getInicio();
        Vertice aux = new Vertice();
        Arista arista = new Arista();
        ListaSimpleGeneric<Linea>  listLineas = new ListaSimpleGeneric();
        Linea l = null;
        int contador = 0;
        //cargo todas las lineas que tienen las aristas del VERTICE que TRAIGO de Utilidades
        while(nodo != null){
            l = new Linea();
            arista = (Arista)nodo.getDato();
            l.setNombre(arista.getLinea());
            listLineas.insertarInicio(l);
            nodo = nodo.getSiguiente();
        }
        NodoListaSimple nodoLineas = listLineas.getInicio();
        //Recorrere todas las Lineas que cargue previamente para contar cual solo existe 1 vez
        while(nodoLineas != null){
            Linea auxiliar = new Linea();
            auxiliar = (Linea)nodoLineas.getDato();
            NodoListaSimple nodoLineas2 = listLineas.getInicio();
            //comparo todas las lineas con cada una de afuera
            while(nodoLineas2 != null){
                Linea auxiliar2 = new Linea();
                auxiliar2 = (Linea)nodoLineas2.getDato();
                String linea1 = String.valueOf(auxiliar.getNombre());
                String linea2 = String.valueOf(auxiliar2.getNombre());
                //si es igual a la linea de afguera cuento 1
                if(linea1.equalsIgnoreCase(linea2)){
                   contador++;
                   
                }
                nodoLineas2 = nodoLineas2.getSiguiente();
                if(contador > 1){
                       nodoLineas2 = null;
                 }
                if(nodoLineas2 == null && contador < 2){
                    return auxiliar;
                }
            }
            nodoLineas = nodoLineas.getSiguiente();
        }
        return null;
    }
}

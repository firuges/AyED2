/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

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
}

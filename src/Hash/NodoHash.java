/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

import Grafo.Arista;
import Grafo.Vertice;
import Hash.IndicadorEstado.TipoRet;
import ListaSimpleGneric.ListaSimpleGeneric;

/**
 *
 * @author Maxi
 */
public class NodoHash  implements Comparable {
    private String nombEstacion;
    private ListaSimpleGeneric  losServicios;
    private int IdHash;
    private ListaSimpleGeneric  LasAristas;
    private TipoRet estado;
    private Vertice dato;
    private NodoHash  siguiente;

    public NodoHash(Vertice dato) {
        this.estado = IndicadorEstado.TipoRet.VACIO;
        this.dato = dato;
        this.siguiente = null;
    }

    public NodoHash() {
        this.estado = TipoRet.VACIO;
        this.dato = null;
        this.siguiente = null;
    }

    public Vertice getDato() {
        return dato;
    }

    public void setDato(Vertice dato) {
        this.dato = dato;
    }

    public NodoHash getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHash siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the estado
     */
    public TipoRet getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(TipoRet estado) {
        this.estado = estado;
    }

    @Override
    public int compareTo(Object o) {
        return  ((Comparable) this.getDato()).compareTo(o); 
    }
    
    
}

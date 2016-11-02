/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

import Hash.IndicadorEstado.TipoRet;

/**
 *
 * @author Maxi
 */
public class NodoHash <T> implements Comparable<T> {
    
    private TipoRet estado;
    private T dato;
    private NodoHash <T> siguiente;

    public NodoHash(T dato) {
        this.estado = IndicadorEstado.TipoRet.VACIO;
        this.dato = dato;
        this.siguiente = null;
    }

    public NodoHash() {
        this.estado = TipoRet.VACIO;
        this.dato = null;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoHash getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHash <T> siguiente) {
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
    public int compareTo(T o) 
    {
    return  ((Comparable<T>) this.getDato()).compareTo(o); 
    }
    
    
}

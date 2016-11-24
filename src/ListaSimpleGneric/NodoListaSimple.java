/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaSimpleGneric;

/**
 *
 * @author Alen
 */
public class NodoListaSimple <T> implements Comparable<T>{
    
    private T dato;
    private NodoListaSimple <T> siguiente;

    public NodoListaSimple(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public NodoListaSimple() {
        dato = null;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoListaSimple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaSimple <T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public int compareTo(T o) {
        return  ((Comparable<T>) this.getDato()).compareTo(o); 
    }
    
    
    
}

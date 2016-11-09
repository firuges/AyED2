/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaSimple;

/**
 *
 * @author Maxi
 */
public class NodoLista <T> {
    
    private T dato;
    private NodoLista <T> siguiente;

    public NodoLista(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista <T> siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pila;

/**
 *
 * @author Maxi
 */
public class NodoPila <T>{
    T elem;
    NodoPila<T> siguiente;
     public NodoPila(T Dato) {
        this.elem = Dato;
        this.siguiente = null;
    }
     public T getElem() {
        return elem;
    }
     public void setDato(T dato) {
        this.elem = dato;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(NodoPila<T> siguiente) {
        this.siguiente = siguiente;
    }
}

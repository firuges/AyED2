/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cola;

/**
 *
 * @author Maxi
 */
public class Nodo <T> {
    T elem;
    private Nodo<T> siguiente;
    
     public Nodo(T Dato) {
        this.elem = Dato;
        this.siguiente = null;
    }
     public T getElem() {
        return elem;
    }
     public void setDato(T dato) {
        this.elem = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}

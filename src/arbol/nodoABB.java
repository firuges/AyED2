/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author Maxi
 */
public class nodoABB <T> implements Comparable<T>{
    private T dato;
    private nodoABB izq;
    private nodoABB der;
    
    public nodoABB (T dato){
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }
    
    public nodoABB(T dato, nodoABB izq,nodoABB der){
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    /**
     * @return the dato
     */
    public T getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * @return the izq
     */
    public nodoABB getIzq() {
        return izq;
    }

    /**
     * @param izq the izq to set
     */
    public void setIzq(nodoABB izq) {
        this.izq = izq;
    }

    /**
     * @return the der
     */
    public nodoABB getDer() {
        return der;
    }

    /**
     * @param der the der to set
     */
    public void setDer(nodoABB der) {
        this.der = der;
    }

    @Override
    public int compareTo(T o) 
    {
    return  ((Comparable<T>) this.getDato()).compareTo(o); 
    }
    
}

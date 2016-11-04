/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaSimpleGeneric;

import Grafo.Vertice;
import Hash.NodoHash;

/**
 *
 * @author Maxi
 */
public class ListaSimpleGeneric  implements IListaSimpleGeneric{
    
    private NodoHash inicio;
    public NodoHash getInicio(){
        return this.inicio;
    }
    public ListaSimpleGeneric() {
        this.inicio = null;
    }

    @Override
    public void insertarInicio(Vertice n) {
        NodoHash nuevo = new NodoHash(n);
        nuevo.setSiguiente(inicio);
        this.inicio = nuevo;
    }

    @Override
    public boolean esVacia() {
        return this.inicio == null;
    }
    
    @Override
    public void imprimir(Vertice n) {
        if(this.esVacia())
            System.out.println("LISTA VACIA");
        else{
            NodoHash aux = this.inicio;
            while(aux != null){
                System.out.println(aux.getDato());
                aux = aux.getSiguiente();
            }
        }
    }
     
    @Override
    public void borrarInicio() {
        if(!this.esVacia())
            this.inicio = this.inicio.getSiguiente();
            
    }

    @Override
    public void vaciarLista() {
        while(this.inicio != null)
            this.borrarInicio();
    }
    
    
    
}


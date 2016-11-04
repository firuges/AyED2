/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaSimpleGeneric;

import Grafo.Vertice;

/**
 *
 * @author Maxi
 */
public interface IListaSimpleGeneric {
    
    public void insertarInicio(Vertice n);
    
    public boolean esVacia();
    
    public void imprimir(Vertice n);
    
    public void borrarInicio();
    
    public void vaciarLista();
    
}

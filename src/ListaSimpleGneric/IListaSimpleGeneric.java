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
public interface IListaSimpleGeneric <T> {
    
    public void insertarInicio(T n);
    
    public boolean esVacia();
    
    public void imprimir(T n);
    
    public void borrarInicio();
    
    public void vaciarLista();
    
}

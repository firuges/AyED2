/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

import Grafo.Vertice;
import Hash.IndicadorEstado.TipoRet;

/**
 *
 * @author Maxi
 */
public class Hash<T> implements IHash <T> {
    private NodoHash[] tablaHash;
    public Hash Vacio() {
        return null;
    }

    @Override
    public void Insertar(T i) {
        int dato = Integer.parseInt(i.toString());
        int hash = this.H(dato);
        int a = -1;
        if( tablaHash[hash].getEstado() == TipoRet.OCUPADO ){
            NodoHash aux = new NodoHash(tablaHash[hash]);
            tablaHash[hash].setDato(dato);
            tablaHash[hash].setSiguiente(aux);
            tablaHash[hash].setEstado(TipoRet.OCUPADO);
        }else{
            tablaHash[hash].setDato(dato);
            tablaHash[hash].setEstado(TipoRet.OCUPADO);
        }
        
    }
    public void ImprimirHash(){
        for(int i = 0; i < tablaHash.length; i++){
            if(tablaHash[i].getSiguiente()!= null){
                NodoHash aux = tablaHash[i];
                while(aux != null){
                     System.out.println("Hash: " + i + ": "+ aux.getDato());
                     aux = aux.getSiguiente();
                }
               
            }else{
                System.out.println("Hash: " + i + ": "+ tablaHash[i].getDato());
            }
        }
    }
    public NodoHash encontrarNull(NodoHash elNodo){
        while(elNodo != null){
            if(elNodo.getSiguiente() == null){
                return elNodo;
            }
            elNodo.getSiguiente();
        }
        return null;
    }
    @Override
    public boolean EsVacio() {
        return false;
    }

    @Override
    public boolean Pertenece(T i) {
        Vertice Abc = (Vertice)i;
        for(int j = 0; j < tablaHash.length; j++){
            if(tablaHash[j].getEstado() ==  TipoRet.OCUPADO && tablaHash[j].equals(Abc)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean Borrar(T i) {
        return false;
    }
    public Hash (int Cant){
        this.tablaHash = new NodoHash[Cant];
        for(int i = 0; i < tablaHash.length; i++){
            tablaHash[i] = new NodoHash <T>();
        }
    }
    public int H(int Dato){
        int devolver = 0;
        devolver = Dato % tablaHash.length;
        return devolver;
    }
}


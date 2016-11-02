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
public class Hash <T extends Comparable<T>> implements IHash <T> {
    private NodoHash<T> [] tablaHash;
    public Hash Vacio() {
        return null;
    }
    @Override
    public void Insertar(T i) {
        Vertice dato = (Vertice)i;
        int hash = this.H(dato.getNombAeropuerto());
        int a = -1;
        if( tablaHash[hash].getEstado() == TipoRet.OCUPADO ){
            NodoHash aux = new NodoHash(tablaHash[hash]);
            tablaHash[hash].setDato(i);
            tablaHash[hash].setSiguiente(aux);
            tablaHash[hash].setEstado(TipoRet.OCUPADO);
        }else{
            tablaHash[hash].setDato(i);
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
        int hash = H(Abc.getNombAeropuerto());
        if(tablaHash[hash].getDato().compareTo(i) == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean Borrar(T i) {
        return false;
    }
    ///CONSTRUCTOR
    public Hash (int Cant){
        this.tablaHash = new NodoHash[Cant];
        for(int i = 0; i < tablaHash.length; i++){
            tablaHash[i] = new NodoHash <T>();
        }
    }
    public int H(String Dato){
        int devolver = 0;
        devolver = hallarValorASCII(Dato) % tablaHash.length;
        return devolver;
    }
    private int hallarValorASCII(String pString){
        int sumaASCII = 0;
        for (int x=0;x< pString.length();x++){
            sumaASCII += pString.codePointAt(x);
            System.out.println(pString.charAt(x) + " = " + pString.codePointAt(x));
        }
        return sumaASCII;
    }
}


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
public class Hash implements IHash  {
    private NodoHash [] tablaHash;
    public Hash Vacio() {
        return null;
    }
    @Override
    public void Insertar(Vertice i) {
        Vertice dato = null;
        int hashPosition = this.H(i.getNombreEstacion());
        int a = -1;
        if( tablaHash[hashPosition].getEstado() == TipoRet.OCUPADO ){
            dato = (Vertice)tablaHash[hashPosition].getDato();
            NodoHash aux = new NodoHash(dato);
            tablaHash[hashPosition].setDato(i);
            tablaHash[hashPosition].setSiguiente(aux);
            tablaHash[hashPosition].setEstado(TipoRet.OCUPADO);
        }else{
            tablaHash[hashPosition].setDato(dato);
            tablaHash[hashPosition].setEstado(TipoRet.OCUPADO);
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
    public boolean Pertenece(Vertice i) {
        Vertice Abc = null;
        int hash = H(i.getNombreEstacion());
        Abc = tablaHash[hash].getDato();
        if(Abc != null)
            if(Abc.getNombreEstacion() != null)
                if(Abc.getNombreEstacion().equals(i.getNombreEstacion())){
                    return true;
                }
        return false;
    }

    @Override
    public boolean Borrar(Vertice i) {
        Vertice Abc = null;
        int hash = H(i.getNombreEstacion());
        Abc = tablaHash[hash].getDato();
        
        NodoHash aux = tablaHash[hash];
        if(Abc.equals(i)){
            tablaHash[hash] = tablaHash[hash].getSiguiente();
            return true;
        }
        return false;
    }
    ///CONSTRUCTOR
    public Hash (int Cant){
        this.tablaHash = new NodoHash[Cant];
        for(int i = 0; i < tablaHash.length; i++){
            Vertice a = new Vertice();
            tablaHash[i] = new NodoHash(a);
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
            sumaASCII += (int)pString.codePointAt(x);
            //System.out.println(pString.charAt(x) + " = " + pString.codePointAt(x));
        }
        return sumaASCII;
    }
}


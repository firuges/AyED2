/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed2obligatorio2016;

import Common.Linea;
import Grafo.Arista;
import Grafo.Grafo;
import Grafo.Vertice;
import Grafo.Vertice.Tipo;
import Hash.Hash;
import Hash.IndicadorEstado;
import Hash.IndicadorEstado.TipoRet;
import Hash.NodoHash;
import ListaSimpleGneric.ListaSimpleGeneric;
import ListaSimpleGneric.NodoListaSimple;
import arbol.nodoABB;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Maxi
 */
public class Utilidades {
    public static boolean DistanciaCorrecta(float distancia){
        if(distancia <= 0){
            return false;
        }
        return true;
    }
    public static boolean TarifaCorrecta(float tarifa){
        if(tarifa <= 0){
            return false;
        }
        return true;
    }
    public static boolean FormatoCedula(int cedula){
        String largo = String.valueOf(cedula);
        int check = largo.length();
        if(check == 8){
            return true;
        }
        return false;
    }
    public static String ParsearDateTimeToDate(String fechax) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            String año = String.valueOf(fechax.charAt(0)) + String.valueOf(fechax.charAt(1)) + String.valueOf(fechax.charAt(2))  + String.valueOf(fechax.charAt(3));
            String Mes = String.valueOf(fechax.charAt(5)) + String.valueOf(fechax.charAt(6));
            String dia = String.valueOf(fechax.charAt(8)) + String.valueOf(fechax.charAt(9));
            String fecha = año + "/" + Mes + "/" + dia;
            return fecha;
        } catch (Exception e) {
            return "";
        }
    }
    
    public static void SetearPosicionEstaciones(Grafo g){
        Hash listaAdyacencia = g.ListaAdyacencia;
        NodoHash [] tablaHash = listaAdyacencia.getTablaHash();
        for(int i = 0; i < tablaHash.length ; i++){
            if(tablaHash[i].getEstado().equals(TipoRet.OCUPADO)){
                Vertice v = tablaHash[i].getDato();
                //si tiene mas de un adyacente y no pertenece a mas de una linea
                if(v.cantAristas(v.getLasAristas())>1){ //tiene mas de un adyacente
                    v.setPosMapa(Tipo.MEDIO);
                    //System.out.println("Medio  " + v.getNombreEstacion());
                }else{
                    v.setPosMapa(Tipo.PUNTA);
                    //System.out.println("Punta  " + v.getNombreEstacion());
                }
            }
        }
    }
    
}

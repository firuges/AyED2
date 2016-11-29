/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Common.Servicio;
import ListaSimple.ListaSimple;
import ListaSimpleGneric.ListaSimpleGeneric;
import ListaSimpleGneric.NodoListaSimple;
import arbol.ABB;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Maxi
 */
public class Vertice {
    private int IdHash;
    private boolean conocido;
    private float Distancia; 
    private Vertice Pv;
    private float precio;
    private Tipo PosMapa;
    private String nombEstacion;
    private ABB  losServicios;
    private ListaSimpleGeneric  LasAristas;
    
    public Vertice(String pNombreEstacion){
        this.nombEstacion = pNombreEstacion;
        this.losServicios = new ABB ();
        this.IdHash = 0;
        this.LasAristas = new ListaSimpleGeneric();
    }

    public Vertice() {
        this.nombEstacion = null;
        this.losServicios = new ABB ();
        this.IdHash = 0;
        this.LasAristas = new ListaSimpleGeneric();
    }

    /**
     * @return the PosMapa
     */
    public Tipo getPosMapa() {
        return PosMapa;
    }

    /**
     * @param PosMapa the PosMapa to set
     */
    public void setPosMapa(Tipo PosMapa) {
        this.PosMapa = PosMapa;
    }
    public enum Tipo {
        PUNTA, MEDIO
    };
    /**
     * @return the nombEstacion
     */
    public String getNombreEstacion() {
        return nombEstacion;
    }

    /**
     * @param nombEstacion the nombEstacion to set
     */
    public void setNombAeropuerto(String nombEstacion) {
        this.nombEstacion = nombEstacion;
    }
    @Override
    public String toString(){
        return this.nombEstacion;
    }

    /**
     * @return the losServicios
     */
    public ABB getLosServicios() {
        return losServicios;
    }

    /**
     * @param unServicio the losServicios to set
     */
    public void setLosServicios(ABB unServicio) {
        this.losServicios = unServicio;
    }

    /**
     * @return the IdHash
     */
    public int getIdHash() {
        return IdHash;
    }

    /**
     * @param IdHash the IdHash to set
     */
    public void setIdHash(int IdHash) {
        this.IdHash = IdHash;
    }

    /**
     * @return the LasAristas
     */
    public ListaSimpleGeneric getLasAristas() {
        return LasAristas;
    }

    /**
     * @param LasAristas the LasAristas to set
     */
    public void setLasAristas(ListaSimpleGeneric LasAristas) {
        this.LasAristas = LasAristas;
    }
    public int cantAristas(ListaSimpleGeneric LasAristas){
        int cant = 0;
        NodoListaSimple aux = LasAristas.getInicio();
        while(aux != null){
            cant++;
            aux = aux.getSiguiente();
        }
        return cant;
    }

    /**
     * @return the conocido
     */
    public boolean isConocido() {
        return conocido;
    }

    /**
     * @param conocido the conocido to set
     */
    public void setConocido(boolean conocido) {
        this.conocido = conocido;
    }

    /**
     * @return the Distancia
     */
    public float getDistancia() {
        return Distancia;
    }

    /**
     * @param Distancia the Distancia to set
     */
    public void setDistancia(float Distancia) {
        this.Distancia = Distancia;
    }

    /**
     * @return the Pv
     */
    public Vertice getPv() {
        return Pv;
    }

    /**
     * @param Pv the Pv to set
     */
    public void setPv(Vertice Pv) {
        this.Pv = Pv;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }
}

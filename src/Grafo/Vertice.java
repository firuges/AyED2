/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Common.Servicio;
import ListaSimple.ListaSimple;
import ListaSimpleGneric.ListaSimpleGeneric;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Maxi
 */
public class Vertice {
    private String nombEstacion;
    private ListaSimpleGeneric  losServicios;
    public Vertice(String pNombreEstacion){
        this.nombEstacion = pNombreEstacion;
        this.losServicios = new ListaSimpleGeneric ();
    }

    public Vertice() {
        this.nombEstacion = null;
        this.losServicios = new ListaSimpleGeneric ();
    }

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
    public ListaSimpleGeneric getLosServicios() {
        return losServicios;
    }

    /**
     * @param unServicio the losServicios to set
     */
    public void setLosServicios(ListaSimpleGeneric unServicio) {
        this.losServicios = unServicio;
    }
    
}

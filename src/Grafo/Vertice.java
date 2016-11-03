/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Maxi
 */
public class Vertice implements Comparable {
    private String nombEstacion;
    public Vertice(String pNombreEstacion){
        this.nombEstacion = pNombreEstacion;
    }

    public Vertice() {
        this.nombEstacion = "";
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

    @Override
    public int compareTo(Object o) {
        return  ((Comparable) this.getNombreEstacion()).compareTo(o); 
    }
}

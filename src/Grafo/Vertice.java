/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Common.Servicio;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Maxi
 */
public class Vertice {
    private String nombEstacion;
    private Servicio unServicio;
    public Vertice(String pNombreEstacion){
        this.nombEstacion = pNombreEstacion;
    }

    public Vertice() {
        this.nombEstacion = null;
        this.unServicio = new Servicio();
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
     * @return the unServicio
     */
    public Servicio getUnServicio() {
        return unServicio;
    }

    /**
     * @param unServicio the unServicio to set
     */
    public void setUnServicio(Servicio unServicio) {
        this.unServicio = unServicio;
    }
}

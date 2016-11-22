/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Grafo.Vertice;
import Hash.NodoHash;

/**
 *
 * @author Maxi
 */
public class Ponderada {
    private boolean conocido;
    private float Distancia; 
    private Vertice Pv;
    private float precio;
    

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
}

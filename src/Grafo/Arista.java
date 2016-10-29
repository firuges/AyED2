/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

/**
 *
 * @author Maxi
 */
public class Arista {
    private Vertice Origen;
    private Vertice Destino;
    private double Distancia;//peso

    /**
     * @return the Origen
     */
    public Vertice getOrigen() {
        return Origen;
    }

    /**
     * @param Origen the Origen to set
     */
    public void setOrigen(Vertice Origen) {
        this.Origen = Origen;
    }

    /**
     * @return the Destino
     */
    public Vertice getDestino() {
        return Destino;
    }

    /**
     * @param Destino the Destino to set
     */
    public void setDestino(Vertice Destino) {
        this.Destino = Destino;
    }
    @Override
    public String toString(){
        return this.Destino + " " + this.Origen;
    }
    public Arista(){}
    public Arista(Vertice pOrigen, Vertice pDestino){
        this.Origen = pOrigen;
        this.Destino = pDestino;
    }
}

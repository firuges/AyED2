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
    private char Linea;
    private float Precio;
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
    public Arista(){}
    public Arista(Vertice pOrigen, Vertice pDestino, char linea, float precio){
        this.Linea = linea;
        this.Origen = pOrigen;
        this.Destino = pDestino;
        this.Precio = precio;
    }

    /**
     * @return the Linea
     */
    public char getLinea() {
        return Linea;
    }

    /**
     * @param Linea the Linea to set
     */
    public void setLinea(char Linea) {
        this.Linea = Linea;
    }

    /**
     * @return the Precio
     */
    public float getPrecio() {
        return Precio;
    }

    /**
     * @param Precio the Precio to set
     */
    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }
}

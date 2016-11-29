/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Grafo.Arista;
import Grafo.Vertice;
import ListaSimpleGneric.ListaSimpleGeneric;
import java.time.LocalDateTime;
/**
 *
 * @author Maxi
 */
public class Viaje implements Comparable{
    private Vertice vOrigen;
    private Vertice vDestino;
    private Cliente cCliente;
    private LocalDateTime fechaHora;
    public Viaje(){
        
    }
    public Viaje(Vertice pOrigen, Vertice pDestino, Cliente pCli, LocalDateTime pFecha){
        this.vOrigen = pOrigen;
        this.vDestino = pDestino;
        this.cCliente = pCli;
        this.fechaHora = pFecha;
    }
    /**
     * @return the vOrigen
     */
    public Vertice getvOrigen() {
        return vOrigen;
    }

    /**
     * @param vOrigen the vOrigen to set
     */
    public void setvOrigen(Vertice vOrigen) {
        this.vOrigen = vOrigen;
    }

    /**
     * @return the vDestino
     */
    public Vertice getvDestino() {
        return vDestino;
    }

    /**
     * @param vDestino the vDestino to set
     */
    public void setvDestino(Vertice vDestino) {
        this.vDestino = vDestino;
    }

    /**
     * @return the cCliente
     */
    public Cliente getcCliente() {
        return cCliente;
    }

    /**
     * @param cCliente the cCliente to set
     */
    public void setcCliente(Cliente cCliente) {
        this.cCliente = cCliente;
    }

    /**
     * @return the fechaHora
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * @param fechaHora the fechaHora to set
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
    public String toString(){
        return "Origen: <" + vOrigen.getNombreEstacion() +"> " + vDestino.getNombreEstacion();
    }
    @Override
    public int compareTo(Object o) {
        Viaje unViaje = (Viaje)o;
        int i = ((Comparable) this.getvOrigen().getNombreEstacion()).compareTo(unViaje.getvOrigen().getNombreEstacion());
        if(i != 0)
            return i;
        int j = ((Comparable) this.getvDestino().getNombreEstacion()).compareTo(unViaje.getvDestino().getNombreEstacion());
        if(j != 0)
            return j;
        
        return 1;
        //return  ((Comparable) this).compareTo(unViaje); 
    }
}
//String origen, String destino, int ciCliente, LocalDateTime fechaHora
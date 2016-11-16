/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Grafo.Arista;
import java.time.LocalDateTime;
/**
 *
 * @author Maxi
 */
public class Viaje {
    private Arista vOrigen;
    private Arista vDestino;
    private Cliente cCliente;
    private LocalDateTime fechaHora;
    public Viaje(){
        
    }
    public Viaje(Arista pOrigen, Arista pDestino, Cliente pCli, LocalDateTime pFecha){
        this.vOrigen = pOrigen;
        this.vDestino = pDestino;
        this.cCliente = pCli;
        this.fechaHora = pFecha;
    }
    /**
     * @return the vOrigen
     */
    public Arista getvOrigen() {
        return vOrigen;
    }

    /**
     * @param vOrigen the vOrigen to set
     */
    public void setvOrigen(Arista vOrigen) {
        this.vOrigen = vOrigen;
    }

    /**
     * @return the vDestino
     */
    public Arista getvDestino() {
        return vDestino;
    }

    /**
     * @param vDestino the vDestino to set
     */
    public void setvDestino(Arista vDestino) {
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
}
//String origen, String destino, int ciCliente, LocalDateTime fechaHora
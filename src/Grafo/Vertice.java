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
public class Vertice implements Comparable {
    private String nombEstacion;
    public Vertice(String pAeropuerto){
        this.nombEstacion = pAeropuerto;
    }

    public Vertice() {
        this.nombEstacion = null;
    }

    /**
     * @return the nombEstacion
     */
    public String getNombAeropuerto() {
        return nombEstacion;
    }

    /**
     * @param nombAeropuerto the nombEstacion to set
     */
    public void setNombAeropuerto(String nombAeropuerto) {
        this.nombEstacion = nombAeropuerto;
    }
    @Override
    public String toString(){
        return this.nombEstacion;
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

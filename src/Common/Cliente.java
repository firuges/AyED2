/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Pila.Pila;

/**
 *
 * @author Maxi
 */
public class Cliente implements Comparable{
    private int cedula;
    private String nombre;
    private Pila Viajes;
    public Cliente(int pCedula, String pNombre) {
        this.cedula = pCedula;
        this.nombre = pNombre;
        Viajes = new Pila();
    }
    public Cliente(){
        Viajes = new Pila();
    }
    public Cliente(int pCedula) {
        this.cedula = pCedula;
        Viajes = new Pila();
    }

    /**
     * @return the cedula
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    public String toString(){
        return "Nombre: " + this.getNombre() + " - CI:" + this.getCedula();
    }
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Object o) {
        Cliente unCli = (Cliente)o;
        return  ((Comparable) this.getCedula()).compareTo(unCli.cedula); 
    }

    /**
     * @return the Viajes
     */
    public Pila getViajes() {
        return Viajes;
    }

    /**
     * @param Viajes the Viajes to set
     */
    public void setViajes(Pila Viajes) {
        this.Viajes = Viajes;
    }
}

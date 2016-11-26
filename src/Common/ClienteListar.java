/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

/**
 *
 * @author Maxi
 */
public class ClienteListar implements Comparable{
    private int cedula;
    private String nombre;

    public ClienteListar(int pCedula, String pNombre) {
        this.cedula = pCedula;
        this.nombre = pNombre;
    }
    public ClienteListar(){}
    public ClienteListar(int pCedula) {
        this.cedula = pCedula;
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
        ClienteListar unCli = (ClienteListar)o;
        return  ((Comparable) this.getNombre()).compareTo(unCli.nombre); 
    }
}
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
public class Servicio implements Comparable{
    private String nombre;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Servicio(){
        this.nombre = null;
    }
    public String toString(){
        return "♦ " + this.getNombre();
    }
    @Override
    public int compareTo(Object o) {
        Servicio serv = (Servicio)o;
        int i= ((Comparable) this.nombre).compareTo(serv.getNombre()); 
        return  i;
    }
}

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
public abstract class ClaseAbstract<T> {
    public int compareToN(Object o) {
        Cliente unCli = (Cliente)o;
        return  ((Comparable) this).compareTo(unCli); 
    }
    public int compareToC(Object o) {
        Cliente unCli = (Cliente)o;
        return  ((Comparable) this).compareTo(unCli); 
    }
}

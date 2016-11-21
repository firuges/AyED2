/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cola;

/**
 *
 * @author Maxi
 */
public interface ICola<T> {
    public boolean IsEmpty(); // check vacio
    public T dequeue();// quitar un elemento de la cola, el primero en entrar el primero en salir
    public Nodo<T> front(); //obtener el de enfrente sin borrarlo
    public Nodo <T> last();//  obtener el de ultimo sin borrarlo 
    public void empty();// Crear una Vacia
    public void imprimir(T n);
    
}

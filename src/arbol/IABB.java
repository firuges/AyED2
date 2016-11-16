/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author Maxi
 */
public interface IABB <T> {

    boolean eliminar(T dato);

    void imprimirInOrder();

    void imprimirPostOrder();

    void imprimirPreOrder();

    boolean insertar(T dato);

    boolean isEmpty();

    int cantDeNodos(nodoABB a);
    
     void borrarMinimo(nodoABB nodo);
}

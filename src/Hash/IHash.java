/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

import Grafo.Vertice;

/**
 *
 * @author Maxi
 */
public interface IHash {
    void Insertar (Vertice i);
    boolean EsVacio ();
    boolean Pertenece (Vertice i);
    boolean Borrar (Vertice i);
}

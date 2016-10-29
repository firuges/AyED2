/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hash;

/**
 *
 * @author Maxi
 */
public interface IHash <T> {
    void Insertar (T i);
    boolean EsVacio ();
    boolean Pertenece (T i);
    boolean Borrar (T i);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pila;

/**
 *
 * @author Maxi
 */
public interface IPila <T> {
    public void Empty();
    public void push(T elem);
    public boolean IsEmpty();
    public T Pop();
    public T Top();
    public void imprimirComentarios(T n);
}

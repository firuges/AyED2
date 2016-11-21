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
public class Cola<T> implements ICola<T> {
    private Nodo <T> inicio;
    Nodo <T> fin;
    public void enqueue (T elem){ // aniade un elemento
        Nodo<T> nuevo = new Nodo<T>(elem);
        if(IsEmpty()){
            fin = nuevo;
            inicio = nuevo;
        }else{
            nuevo.setSiguiente(null);
        fin = (nuevo);
        }
        
    }
    
    @Override
    public boolean IsEmpty() {
        return this.fin == null;// Compara y devuelve Boolean
    }
    @Override
    public T dequeue(){ // quitar un elemento de la cola, el primero en entrar el primero en salir
        Nodo<T> aux = inicio;
        if(!IsEmpty()){
            inicio = inicio.getSiguiente();
            return aux.getElem();
        }else{
            System.out.println("La Lista ya esta Vacia");
            return null;
        }
        

    }
    @Override
    public Nodo <T> front(){
        return inicio;
        
    }
    @Override
    public Nodo <T> last(){
        return fin;
        
    }
    @Override
    public void empty(){
        fin = null;
        inicio = null;
        
    }
    @Override
    public void imprimir(T n) {
        int cont = 1;
        if(this.IsEmpty())
            System.out.println("LISTA VACIA");
        else{
            Nodo aux = this.inicio;
            while(aux != null){
                System.out.println(cont + ". " + aux.getElem());
                cont++;
                aux = aux.getSiguiente();
            }
        }
    }
    
}

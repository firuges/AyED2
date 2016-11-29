/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

import Common.Cliente;
import Common.ClienteListar;
import Common.Linea;
import Common.Viaje;
import Grafo.Arista;
import Grafo.Vertice;
import Grafo.Vertice.Tipo;
import ListaSimpleGneric.ListaSimpleGeneric;
import ListaSimpleGneric.NodoListaSimple;
import Pila.NodoPila;
import ayed2obligatorio2016.Sistema;
import ayed2obligatorio2016.Utilidades;

/**
 *
 * @author Maxi
 */
public class ABB <T extends Comparable<T>> implements IABB <T>{
    private nodoABB raiz;
    public ABB(){
        this.raiz = null;
    }
    public ABB(nodoABB raiz){
        this.raiz = raiz;
    }
    /**
     * @return the raiz
     */
    public nodoABB getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(nodoABB raiz) {
        this.raiz = raiz;
    }
    
    @Override
    public boolean isEmpty(){
        return (this.raiz == null);
    }
    @Override
    public boolean insertar(T x){
        boolean agregado = false;
        if(isEmpty()){
            nodoABB nuevo = new nodoABB(x);
            raiz = nuevo;
            agregado = true;
        }else{
            agregado = insertar(x,raiz);
        }
        return agregado;
    }
    
    private boolean insertar(T dato, nodoABB nodo){
       if(nodo != null){
           //Inicializo el Nodo con el dato que traigo
           nodoABB elNodo = new nodoABB(dato);
           //Pregunto
           if(elNodo.compareTo(nodo.getDato()) > 0){
               if(nodo.getDer() == null){
                   nodoABB nuevo = new nodoABB(dato);
                   nodo.setDer(nuevo);
                   return true;
               }else{
                   return insertar(dato, nodo.getDer());
               }
           }else if(elNodo.compareTo(nodo.getDato()) < 0){
               if(nodo.getIzq() == null){
                   nodoABB nuevo = new nodoABB(dato);
                   nodo.setIzq(nuevo);
                   return true;
               }else{
                   return insertar(dato, nodo.getIzq());
               }
           }else{
               return false;
           }
       }
       return false;
    }
    
    @Override
    public boolean eliminar(T dato){
        return eliminar(dato, this.raiz);
    }
    private boolean eliminar(T dato, nodoABB nodo){
        if(nodo == null){
            System.out.println("No se encuentra el nodo");
            return false;
        }else{
            nodoABB elNodo = new nodoABB(dato);
            if(elNodo.compareTo(nodo.getDato()) < 0){ // el dato es menor que el nodo
                return eliminar(dato, nodo.getIzq());
            }else if(elNodo.compareTo(nodo.getDato()) > 0 ){// el dato es mayor que el nodo
                return eliminar(dato, nodo.getDer());
            }else{
                if(nodo.getDer() != null && nodo.getIzq() != null){
                   eliminarCon2Hijos(nodo);
                }else if(nodo.getDer() == null){// El dato del hijo izquierdo se lo pongo en el nodo
                    nodo.setDato(nodo.getIzq());
                    return true;
                }else if(nodo.getIzq() == null){
                    nodo.setDato(nodo.getDer());
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean eliminarCon2Hijos(nodoABB nodo){
        nodoABB min = buscarMin(nodo.getDer());
        nodo.setDato(min.getDato());
        T dato = (T) min.getDato();
        return eliminar(dato, nodo.getDer());
        
    }
    private nodoABB buscarMin(nodoABB nodo){
        if(nodo.getIzq() == null){
            return nodo;
        }
        return buscarMin(nodo.getIzq());
    }
    @Override
    public void borrarMinimo(nodoABB nodo1){
        if(nodo1.getIzq() != null){
//            nodoABB aux = new nodoABB(nodo.getDato());
            borrarMinimo(nodo1);
        }else{
            raiz = raiz.getDer();
        }
    }
    
    private void borrarMinimo2(nodoABB nodo){
        
            if(nodo.getIzq().getIzq() == null){
                 nodo.setIzq(nodo.getIzq().getDer());
            }else{
                borrarMinimo(nodo.getIzq());
            }
    }
    @Override
    public void imprimirPreOrder(){
            imprimirPreOrder(this.raiz);
    }

    public void imprimirPreOrder(nodoABB a){
        if (a!=null){
            //raiz
            System.out.println(a.getDato()+" - ");
            //izq
            imprimirPreOrder(a.getIzq());
            //der
            imprimirPreOrder(a.getDer());
        }
    }
    
    @Override
    public void imprimirPostOrder(){
		imprimirPostOrder(this.raiz);
    }
    public void imprimirPostOrder(nodoABB a){
            if (a!=null){
                imprimirPostOrder(a.getIzq());
                imprimirPostOrder(a.getDer());
                System.out.println(a.getDato()+" - ");
           }
    }
    @Override
    public void imprimirInOrder(){
        imprimirInOrder(this.raiz);
    }
    public void imprimirInOrder(nodoABB a){
            if (a!=null){
                imprimirInOrder(a.getIzq());
                System.out.println(a.getDato()+" - ");
                imprimirInOrder(a.getDer());
                
             }
    }
    @Override
    public nodoABB existeNodo(T dato){
	return existeNodo(dato, this.raiz);
    }
    public nodoABB existeNodo(T dato, nodoABB a){
        nodoABB elNodo = new nodoABB(dato);
        
        while (a!=null){
            if(elNodo.compareTo(a.getDato()) > 0){
                a = a.getDer();
            }
            else if(elNodo.compareTo(a.getDato()) < 0){
                a = a.getIzq();
            }else{
                return a;
            }
            /*existeNodo(dato, a.getIzq());
            existeNodo(dato, a.getDer());
            if(elNodo.compareTo(a.getDato()) == 0){
                return a;
            }*/
        }
        return null;
    }
    @Override
    public boolean imprimirViajesDeClientePostOrder(Cliente unCli){
        
        return imprimirViajesDeClientePostOrder(this.raiz, unCli);
        
    }
    public boolean imprimirViajesDeClientePostOrder(nodoABB a, Cliente unCli){
            boolean ninguno = false;
            if (a!=null){
                Viaje aux = (Viaje)a.getDato();
                if(aux.getcCliente().getCedula() == unCli.getCedula()){
                    ninguno = true;
                    aux.getcCliente().setNombre(unCli.getNombre());
                    System.out.println(Utilidades.ParsearDateTimeToDate(aux.getFechaHora().toString())+" - " +aux.getvOrigen().getNombreEstacion()+" - " + aux.getvDestino().getNombreEstacion() +".");
                }
                imprimirViajesDeClientePostOrder(a.getIzq(), unCli);
                imprimirViajesDeClientePostOrder(a.getDer(),  unCli);
                
           }
            return ninguno;
    }//
    @Override
    public boolean imprimirLineasInOrder(){
        
        return imprimirLineasInOrder(this.raiz);
        
    }
    public boolean imprimirLineasInOrder(nodoABB a){
            boolean ninguno = false;
            int cont = 0;
            Vertice Origen = new Vertice();
            Vertice Destino = new Vertice();
            Linea l = new Linea();
            if (a!=null){
                imprimirLineasInOrder(a.getIzq());
                Linea aux = (Linea)a.getDato();
                Vertice estacion = new Vertice();
                NodoListaSimple nodo = (NodoListaSimple)aux.getEstaciones().getInicio();
                //mientras hallan estaciones en la linea buscare todos los punteros
                System.out.println((char)27 +  "[34;43mLinea: " + aux.getNombre());
                while(nodo != null){
                    estacion = (Vertice)nodo.getDato();
                    //si es Puntero entro
                    if(estacion.getPosMapa().equals(Tipo.PUNTA)&& estacion.getPunteroDeLinea() == aux.getNombre() && cont > 0){
                        Destino = estacion;
                        cont++;
                    }
                    if(estacion.getPosMapa().equals(Tipo.PUNTA)&& estacion.getPunteroDeLinea() == aux.getNombre() && cont < 1){
                        Origen = estacion;
                        cont++;
                    }
                    
                    nodo = nodo.getSiguiente();
                }
                //inicializo los array teniendo el Origen
                Vertice [] T = Sistema.MetroLineas.initArrays(Origen);
                //creo el camino mas Corto 
                float PrecioFinal = Sistema.MetroLineas.EstacionesDeLinea(T, Destino);
                
                imprimirLineasInOrder(a.getDer());
                
           }
            return ninguno;
    }//
    
    @Override
    public void imprimirInOrderClientes(){
        imprimirInOrderClientes(this.raiz);
    }
    public void imprimirInOrderClientes(nodoABB a){
            boolean ninguno;
            if (a!=null){
                
                imprimirInOrderClientes(a.getIzq());
                imprimirInOrderClientes(a.getDer());
                ClienteListar c = (ClienteListar)a.getDato();
                try{
                    NodoPila n = (NodoPila)c.getViajes().getTop();
                    Viaje v = new Viaje();
                    v = (Viaje)n.getElem();
                    System.out.println(a.getDato()+" - Ultimo Viaje: " + v.getvOrigen() + " - "+ v.getvDestino());
                }catch(Exception ex){
                    System.out.println(a.getDato()+" - Ultimo Viaje: Sin Viajes.");
                }
                
             }
            
    }
    public int cantDeNodos(nodoABB a){
    if (a!=null){
        return ( 1 + cantDeNodos(a.getIzq())) + (cantDeNodos(a.getDer()));

     }
    return 0;
    }
    
    

}

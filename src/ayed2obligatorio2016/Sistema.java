/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ayed2obligatorio2016;

import Common.Cliente;
import Common.Servicio;
import Common.Viaje;
import Grafo.Arista;
import Grafo.Grafo;
import Grafo.Vertice;
import ListaSimpleGneric.ListaSimpleGeneric;
import arbol.ABB;
import arbol.nodoABB;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class Sistema implements IMetro {
    public static Grafo MetroLineas; 
    public static ABB ListaDeClientes;
    public static ABB ListaViajes;
    public enum TipoRet {
        OK, ERROR_1, ERROR_2, ERROR_3, ERROR_4, NO_IMPLEMENTADA
    };

    public TipoRet crearMetro() {
        if(MetroLineas == null){
            MetroLineas = new Grafo();
            ListaDeClientes = new ABB();
            ListaViajes = new ABB();
        }
        return TipoRet.OK;
    }

    public TipoRet destruirMetro() {
        if(MetroLineas != null){
            MetroLineas = null;
        }
                return TipoRet.OK;
    }

    public TipoRet altaTramo(char linea, String origen, String destino, float distancia, float tarifa) {
        //Agregar Estacion 1
        Vertice Origen = new Vertice();
        Origen.setNombAeropuerto(origen);
        //Agregar Estacion 2
        Vertice Destino = new Vertice();
        Destino.setNombAeropuerto(destino);
        
        //AgregarArista
        
        Arista arista = new Arista(Origen, Destino, linea ,distancia, tarifa);
        Arista aristaRegreso = new Arista(Destino, Origen, linea ,distancia, tarifa);
        //Agregar Vertices
        
        Origen = MetroLineas.agregarVertice(Origen);
        Destino = MetroLineas.agregarVertice(Destino);
        Origen.getLasAristas().insertarInicio(arista);
        Destino.getLasAristas().insertarInicio(aristaRegreso);
        if(Utilidades.DistanciaCorrecta(distancia)){
            if(Utilidades.TarifaCorrecta(tarifa)){
                boolean agregada = MetroLineas.agregarArista(MetroLineas, arista);
                if(agregada){
                    boolean AgregarAdyacente = MetroLineas.ListaAdyacencia.AgregarAdyacente(arista);
                    boolean AgregarAdyacente2 = MetroLineas.ListaAdyacencia.AgregarAdyacente(aristaRegreso);
                    return TipoRet.OK;
                }else{
                    return TipoRet.ERROR_1;
                }
            }else{
                return TipoRet.ERROR_3;
            }
        }else{
            return TipoRet.ERROR_2;
        }
        
                
    }

    public TipoRet agregarViaje(String origen, String destino, int ciCliente, LocalDateTime fechaHora) {
        Vertice Origen = new Vertice(origen);
        Vertice Destino = new Vertice(destino);
        Arista OriDesti = new Arista(Origen, Destino);
        Cliente unCli = new Cliente(ciCliente);
        if(Utilidades.FormatoCedula(ciCliente)){
            nodoABB aux = ListaDeClientes.existeNodo(unCli);
            if(aux!= null){
                Viaje unViaje = new Viaje(Origen, Destino, unCli, fechaHora);
                if(MetroLineas.existenEstacionesDeLaLinea(unViaje)){
                    
                    unViaje.setcCliente((Cliente)aux.getDato());
                    boolean agregado = false;
                    agregado = Sistema.ListaViajes.insertar(unViaje);
                    if(agregado){
                       return TipoRet.OK;
                    }
                    
                }else{
                    return TipoRet.ERROR_1;
                }
            }else{
                return TipoRet.ERROR_2;
            }
        }
        return TipoRet.ERROR_3;
        
    }

    public TipoRet agregarServicio(String estacion, String servicio) {
        Vertice unaEstacion = new Vertice();
        unaEstacion.setNombAeropuerto(estacion);
        unaEstacion = this.MetroLineas.existeVertice(unaEstacion);
        if(unaEstacion != null){
            Servicio serv = new Servicio();
            if(unaEstacion.getLosServicios()!= null){
                unaEstacion.getLosServicios().insertarInicio(serv);
                return TipoRet.OK;
            }
        }
         return TipoRet.ERROR_1;
        
                
    }

    public TipoRet listarClientes() {
        nodoABB nodo = Sistema.ListaDeClientes.getRaiz();
        if(nodo != null)
            Sistema.ListaDeClientes.imprimirPreOrder();
        return TipoRet.OK;
    }

    public TipoRet listarViajesCliente(int ciCliente) {
        nodoABB nodo = Sistema.ListaViajes.getRaiz();
        if(Utilidades.FormatoCedula(ciCliente)){
            Cliente unCli = new Cliente();
            unCli.setCedula(ciCliente);
            nodoABB elNodo = new nodoABB(unCli);
            elNodo = Sistema.ListaDeClientes.existeNodo(unCli);
            
            if(elNodo != null){
                unCli = (Cliente)elNodo.getDato();
                if(nodo != null){
                    boolean ninguno = false;
                    System.out.println("Cliente: " + unCli.getCedula() + " - " + unCli.getNombre());
                    ninguno = Sistema.ListaViajes.imprimirViajesDeClientePostOrder(unCli);
                    if(!ninguno){
                        System.out.println("Sin Viajes Registrados");
                    }
                }
                
                return TipoRet.OK;
            }else{
                return TipoRet.ERROR_1;
            }
            
        }else{
            return TipoRet.ERROR_2;
        }
            
            
            
        
        
    }

    public TipoRet listarServiciosEstacion(String estacion) {
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet listarLineas() {
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet caminoMasCorto(String origen, String destino) {
        
        Vertice unVertice = new Vertice();
        unVertice.setNombAeropuerto(origen);
        unVertice = Sistema.MetroLineas.existeVertice(unVertice);
        if(unVertice != null){
            Sistema.MetroLineas.initArrays(unVertice);
        }
        
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet precioBoleto(String origen, String destino) {
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet altaCliente(int cedula, String nombre) {
        Cliente unCli = new Cliente(cedula, nombre);
        boolean agregado = false;
        if(!Utilidades.FormatoCedula(cedula)){
            return TipoRet.ERROR_2;
        }else{
            agregado = Sistema.ListaDeClientes.insertar(unCli);
            if(!agregado){
               return TipoRet.ERROR_1;
            }
        }
        return TipoRet.OK;       
    }

    public TipoRet bajaCliente(int cedula) {
        Cliente unCli = new Cliente(cedula);
        boolean eliminado = false;
        if(!Utilidades.FormatoCedula(cedula)){
            return TipoRet.ERROR_2;
        }
        eliminado = Sistema.ListaDeClientes.eliminar(unCli);
        
        if(eliminado){
            return TipoRet.OK;
        }
        return TipoRet.ERROR_1;
                
    }
}

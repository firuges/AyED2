/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ayed2obligatorio2016;

import Common.Cliente;
import Common.ClienteListar;
import Common.Linea;
import Common.Servicio;
import Common.Viaje;
import Grafo.Arista;
import Grafo.Grafo;
import Grafo.Vertice;
import Hash.Hash;
import ListaSimpleGneric.ListaSimpleGeneric;
import ListaSimpleGneric.NodoListaSimple;
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
    public static ABB ListaDeClientesXcedula;
    public static ABB ListaDeClientesXnombre;
    public static ABB ListaViajes;
    public static ABB LasLineas;
    public enum TipoRet {
        OK, ERROR_1, ERROR_2, ERROR_3, ERROR_4, NO_IMPLEMENTADA
    };

    public TipoRet crearMetro() {
        if(MetroLineas == null){
            MetroLineas = new Grafo();
            ListaDeClientesXcedula = new ABB();
            ListaDeClientesXnombre = new ABB();
            LasLineas = new ABB();
            ListaViajes = new ABB();
        }
        return TipoRet.OK;
    }

    public TipoRet destruirMetro() {
        if(MetroLineas != null){
            MetroLineas = null;
            ListaDeClientesXcedula = new ABB();
            ListaDeClientesXnombre = new ABB();
            LasLineas = new ABB();
            ListaViajes = new ABB();
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
        Origen = MetroLineas.agregarVertice(Origen);
        Destino = MetroLineas.agregarVertice(Destino);
        
        Arista arista = new Arista(Origen, Destino, linea ,distancia, tarifa);
        Arista aristaRegreso = new Arista(Destino, Origen, linea ,distancia, tarifa);
        //Agregar Vertices
        
        
        //
        Linea laLinea = new Linea(linea);
        //nodo de arbol
        nodoABB nAbb = new nodoABB(laLinea);
        //compruebo si existe
        nAbb = LasLineas.existeNodo(laLinea);
        if(nAbb == null){
            //le agrego las estaciones a la lista
            laLinea.getEstaciones().insertarInicio(Origen);
            laLinea.getEstaciones().insertarInicio(Destino);
            LasLineas.insertar(laLinea);
            
        }else{
            laLinea = (Linea)nAbb.getDato();
            //chequeo que ya no tenga estas estaciones
            boolean exist = laLinea.EstacionExisteEnLinea(Origen, laLinea.getEstaciones());
            boolean exist2 = laLinea.EstacionExisteEnLinea(Destino, laLinea.getEstaciones());
            //
            if(!exist)
                laLinea.getEstaciones().insertarInicio(Origen);
            if(!exist2)
                laLinea.getEstaciones().insertarInicio(Destino);
        }
        //*************************************************
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
        ClienteListar unCli2 = new ClienteListar(ciCliente);
        if(Utilidades.FormatoCedula(ciCliente)){
            nodoABB aux = ListaDeClientesXcedula.existeNodo(unCli);
            
            if(aux!= null){
                Viaje unViaje = new Viaje(Origen, Destino, unCli, fechaHora);
                Origen = MetroLineas.existeVertice(Origen);
                Destino = MetroLineas.existeVertice(Destino);
                
                if(Origen != null && Destino != null){
                    
                    Vertice [] T = Sistema.MetroLineas.initArrays(Origen);
                
                    float PrecioFinal = Sistema.MetroLineas.Precio_a_Destino(T, Destino);
                    if(PrecioFinal > 0)
                    {
                        unViaje.setcCliente((Cliente)aux.getDato());
                        boolean agregado = false;
                        agregado = Sistema.ListaViajes.insertar(unViaje);
                        unCli = (Cliente)aux.getDato();
                        unCli.getViajes().push(unViaje);
                        unCli2.setNombre(unCli.getNombre());
                        nodoABB aux2 = ListaDeClientesXnombre.existeNodo(unCli2);
                        unCli2 = (ClienteListar)aux2.getDato();
                        unCli2.getViajes().push(unViaje);
                        if(agregado){
                           return TipoRet.OK;
                        }
                    }else{
                        return TipoRet.ERROR_1;
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
            serv.setNombre(servicio);
            
            if(unaEstacion.getLosServicios()!= null){
                unaEstacion.getLosServicios().insertar(serv);
                return TipoRet.OK;
            }
        }
         return TipoRet.ERROR_1;
        
                
    }

    public TipoRet listarClientes() {
        nodoABB nodo = Sistema.ListaDeClientesXnombre.getRaiz();
        if(nodo.getDato() != null)
            Sistema.ListaDeClientesXnombre.imprimirInOrder();
        else{
            System.out.println((char)27 + "[30;31m No existen Clientes Registrados");
        }
        return TipoRet.OK;
    }

    public TipoRet listarViajesCliente(int ciCliente) {
        nodoABB nodo = Sistema.ListaViajes.getRaiz();
        if(Utilidades.FormatoCedula(ciCliente)){
            Cliente unCli = new Cliente();
            unCli.setCedula(ciCliente);
            nodoABB elNodo = new nodoABB(unCli);
            elNodo = Sistema.ListaDeClientesXcedula.existeNodo(unCli);
            
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
        Vertice Estacion = new Vertice(estacion);
        Estacion = Sistema.MetroLineas.existeVertice(Estacion);
        if(Estacion != null){
            System.out.println("Estacion: "+Estacion.getNombreEstacion());
            Estacion.getLosServicios().imprimirInOrder();
            return TipoRet.OK;
        }else{
            return TipoRet.ERROR_1;
        }
    }

    public TipoRet listarLineas() {
        Utilidades.SetearPosicionEstaciones(Sistema.MetroLineas);
        if(LasLineas.getRaiz() == null){
            System.out.println("No hay Líneas en el Metro.");
        }else{
            LasLineas.imprimirLineasInOrder();
        }
        
        return TipoRet.OK;
    }

    public TipoRet caminoMasCorto(String origen, String destino) {
        
        Vertice Origen = new Vertice();
        Origen.setNombAeropuerto(origen);
        Vertice Destino = new Vertice();
        Destino.setNombAeropuerto(destino);
        Origen = Sistema.MetroLineas.existeVertice(Origen);
        Destino = Sistema.MetroLineas.existeVertice(Destino);
        if(Origen == null){
            return TipoRet.ERROR_1;
        }
        if(Destino == null){
            return TipoRet.ERROR_2;
        }
        Vertice [] T = Sistema.MetroLineas.initArrays(Origen);
        System.out.println((char)27 + "[30;31m Imprimiendo Camino mas Corto desde: " + Origen.getNombreEstacion() + " a "+ Destino.getNombreEstacion());
        float PrecioFinal = Sistema.MetroLineas.Camino_Mas_Corto(T, Destino);
        return TipoRet.OK;
    }
    

    public TipoRet precioBoleto(String origen, String destino) {
        Vertice Origen = new Vertice();
        Origen.setNombAeropuerto(origen);
        Vertice Destino = new Vertice();
        Destino.setNombAeropuerto(destino);
        Origen = Sistema.MetroLineas.existeVertice(Origen);
        Destino = Sistema.MetroLineas.existeVertice(Destino);
        if(Origen == null){
            return TipoRet.ERROR_1;
        }
        if(Destino == null){
            return TipoRet.ERROR_2;
        }
        Vertice [] T = Sistema.MetroLineas.initArrays(Origen);
        float PrecioFinal = Sistema.MetroLineas.Precio_a_Destino(T, Destino);
        System.out.println((char)27 + "[30;31m Precio del boleto de "+ origen +" a "+destino +" es: "+ PrecioFinal);
        return TipoRet.OK;
    }

    public TipoRet altaCliente(int cedula, String nombre) {
        Cliente unCli = new Cliente(cedula, nombre);
        ClienteListar unCli2 = new ClienteListar(cedula,nombre);
        boolean agregado = false;
        boolean agregado2 = false;
        if(!Utilidades.FormatoCedula(cedula)){
            return TipoRet.ERROR_2;
        }else{
            agregado = Sistema.ListaDeClientesXnombre.insertar(unCli2);// POR NOMBRE
            agregado2 = Sistema.ListaDeClientesXcedula.insertar(unCli);//POR CEDULA
            if(!agregado || !agregado2){
               return TipoRet.ERROR_1;
            }
        }
        return TipoRet.OK;       
    }

    public TipoRet bajaCliente(int cedula) {
        if(!Utilidades.FormatoCedula(cedula)){
            return TipoRet.ERROR_2;
        }
        Cliente unCli = new Cliente(cedula);
        ClienteListar unCli2 = new ClienteListar(cedula);
        nodoABB nodo = new nodoABB();
        nodo.setDato(unCli);
        nodo = ListaDeClientesXcedula.existeNodo(nodo);
        boolean eliminado = false;
        boolean eliminado2 = false;
        if(nodo != null){
            unCli = (Cliente) nodo.getDato();
            unCli2.setCedula(unCli.getCedula());
            unCli2.setNombre(unCli.getNombre());
            eliminado2 = Sistema.ListaDeClientesXcedula.eliminar(unCli); //POR CEDULA
            eliminado = Sistema.ListaDeClientesXnombre.eliminar(unCli2); // POR NOMBRE
        }
        if(eliminado){
            return TipoRet.OK;
        }else{
            return TipoRet.ERROR_1;
        }
        
                
    }
}

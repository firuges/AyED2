/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ayed2obligatorio2016;

import Common.Cliente;
import Common.Servicio;
import Grafo.Arista;
import Grafo.Grafo;
import Grafo.Vertice;
import ListaSimpleGneric.ListaSimpleGeneric;
import java.time.LocalDateTime;

/**
 *
 * @author Daniel
 */
public class Sistema implements IMetro {
    private static Grafo MetroLineas; 
    public enum TipoRet {
        OK, ERROR_1, ERROR_2, ERROR_3, ERROR_4, NO_IMPLEMENTADA
    };

    public TipoRet crearMetro() {
        if(MetroLineas == null){
            MetroLineas = new Grafo();
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
        //Agregar Vertices
        MetroLineas.agregarVertice(Origen);
        MetroLineas.agregarVertice(Destino);
        
        
        //AgregarArista
        
        Arista arista = new Arista(Origen, Destino, linea, tarifa);
        
        if(Utilidades.DistanciaCorrecta(distancia)){
            if(Utilidades.TarifaCorrecta(tarifa)){
                boolean agregada = MetroLineas.agregarArista(MetroLineas, arista);
                if(agregada){
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
        
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet agregarServicio(String estacion, String servicio) {
        Vertice unaEstacion = new Vertice();
        unaEstacion.setNombAeropuerto(estacion);
        if(this.MetroLineas.existeVertice(unaEstacion)){
            Servicio serv = new Servicio();
            if(unaEstacion.getLosServicios()!= null){
                unaEstacion.getLosServicios().insertarInicio(serv);
                return TipoRet.OK;
            }
        }
         return TipoRet.ERROR_1;
        
                
    }

    public TipoRet listarClientes() {
        return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet listarViajesCliente(int ciCliente) {
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet listarServiciosEstacion(String estacion) {
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet listarLineas() {
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet caminoMasCorto(String origen, String destino) {
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet precioBoleto(String origen, String destino) {
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet altaCliente(int cedula, String nombre) {
        Cliente unCli = new Cliente(cedula, nombre);
        
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet bajaCliente(int cedula) {
                return TipoRet.NO_IMPLEMENTADA;
    }
}

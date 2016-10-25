/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ayed2obligatorio2016;

import java.time.LocalDateTime;

/**
 *
 * @author Daniel
 */
public class Sistema implements IMetro {

    public enum TipoRet {
        OK, ERROR_1, ERROR_2, ERROR_3, ERROR_4, NO_IMPLEMENTADA
    };

    public TipoRet crearMetro() {
        return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet destruirMetro() {
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet altaTramo(char linea, String origen, String destino, float distancia, float tarifa) {
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet agregarViaje(String origen, String destino, int ciCliente, LocalDateTime fechaHora) {
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet agregarServicio(String estacion, String servicio) {
                return TipoRet.NO_IMPLEMENTADA;
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
                return TipoRet.NO_IMPLEMENTADA;
    }

    public TipoRet bajaCliente(int cedula) {
                return TipoRet.NO_IMPLEMENTADA;
    }
}

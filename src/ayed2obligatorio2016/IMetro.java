/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed2obligatorio2016;

import ayed2obligatorio2016.Sistema.TipoRet;
import java.time.LocalDateTime;

/**
 *
 * @author Danny
 */
public interface IMetro {
    TipoRet crearMetro();
     
    TipoRet destruirMetro();
      
    TipoRet altaTramo(char linea, String origen, String destino, float distancia, float tarifa);
    
    TipoRet altaCliente(int cedula, String nombre);
    
    TipoRet bajaCliente(int cedula);
    
    TipoRet agregarViaje(String origen, String destino, int ciCliente, LocalDateTime fechaHora);
    
    TipoRet agregarServicio(String estacion, String servicio); 
    
    TipoRet listarClientes();
    
    TipoRet listarLineas(); 
     
    TipoRet listarServiciosEstacion(String estacion); 

    TipoRet listarViajesCliente(int ciCliente); 
    
    TipoRet caminoMasCorto(String origen, String destino); 
    
    TipoRet precioBoleto(String origen, String destino); 

}

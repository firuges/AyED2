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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sistema s = new Sistema();
        Prueba p = new Prueba();

        //-----------------------PRUEBAS OK---------------------------//

            PruebaOK_1(s,p);
            PruebaOK_2(s,p);
            PruebaOK_3(s,p);
            PruebaOK_4(s,p);
            PruebaOK_5(s,p);
            
        //-----------------------PRUEBAS ERROR------------------------//

            PruebaERROR_1(s,p);
            PruebaERROR_2(s,p);
            PruebaERROR_3(s,p);
            PruebaERROR_4(s,p);
            PruebaERROR_5(s,p);

        p.imprimirResultadosPrueba();
    }

    //-------------PRUEBAS OK-----------------//
    public static void PruebaOK_1(Sistema s, Prueba p){
        s.crearMetro();
        System.out.println("Se crea el Metro Vacio");
        tituloPrueba("PRUEBA 1: REGISTRAR TRAMOS Y CLIENTES");
        crearTramosLineaA(p, s);
        crearClientes(p, s);
        s.listarClientes();
        s.listarLineas();
        s.destruirMetro();
        finPrueba(" Fin PRUEBA 1");
    }

    public static void PruebaOK_2(Sistema s, Prueba p){
        s.crearMetro();
        System.out.println("Se crea el Metro Vacio");
        tituloPrueba("PRUEBA 2: BAJA CLIENTE");
        p.ver(s.altaCliente(11111111, "Lucas Hussey"), Sistema.TipoRet.OK, "Se agrega el cliente Lucas Hussey");
        p.ver(s.bajaCliente(11111111), Sistema.TipoRet.OK, "Se elimina el cliente Lucas Hussey");
        s.listarClientes();
        s.destruirMetro();
        finPrueba(" Fin PRUEBA 2");
    }

    public static void PruebaOK_3(Sistema s, Prueba p){
        s.crearMetro();
        System.out.println("Se crea el Metro Vacio");
        tituloPrueba("PRUEBA 3: AGREGAR VIAJE DE CLIENTE");
        crearTramosLineaA(p, s);
        crearTramosLineaB(p, s);
        crearTramosLineaC(p, s);
        LocalDateTime hoy = LocalDateTime.now();
        p.ver(s.agregarViaje("Constitucion", "Avenida de Mayo", 11111111, hoy), Sistema.TipoRet.OK, "Se agrega el viaje Constitucion-Avenida de Mayo para el Cliente Lucas Hussey");
        s.listarViajesCliente(11111111);
        s.destruirMetro();
        finPrueba(" Fin PRUEBA 3");
    }

    public static void PruebaOK_4(Sistema s, Prueba p){
        s.crearMetro();
        System.out.println("Se crea el Metro Vacio");
        tituloPrueba("PRUEBA 4: SERVICIOS");
        crearTramosLineaB(p, s);
        crearTramosLineaC(p, s);
        p.ver(s.agregarServicio("Constitucion", "Servicios Higienicos"), Sistema.TipoRet.OK, "Se agrega el servicio Servicios Higienicos en la estacion Constitucion");
        p.ver(s.agregarServicio("Constitucion", "Wifi"), Sistema.TipoRet.OK, "Se agrega el servicio Wifi en la estacion Constitucion");
        p.ver(s.agregarServicio("Retiro", "Telefono Publico"), Sistema.TipoRet.OK, "Se agrega el servicio Telefono Publico en la estacion Retiro");
        p.ver(s.agregarServicio("Avenida de Mayo", "Wifi"), Sistema.TipoRet.OK, "Se agrega el servicio Wifi en la estacion Avenida de Mayo");
        p.ver(s.agregarServicio("Medrano", "Comida Rapida"), Sistema.TipoRet.OK, "Se agrega el servicio Comida Rapida en la estacion Medrano");
        s.listarServiciosEstacion("Constitucion");
        s.listarServiciosEstacion("San Juan");
        s.destruirMetro();
        finPrueba(" Fin PRUEBA 4");
    }

    public static void PruebaOK_5(Sistema s, Prueba p){
        s.crearMetro();
        System.out.println("Se crea el Metro Vacio");
        tituloPrueba("PRUEBA 5: LINEAS");
        crearTramosLineaA(p, s);
        crearTramosLineaB(p, s);
        crearTramosLineaC(p, s);
        crearTramosLineaH(p, s);
        s.caminoMasCorto("Constitucion", "Once");
        s.precioBoleto("Constitucion", "Once");
        s.destruirMetro();
        finPrueba(" Fin PRUEBA 5");
    }

    //-------------PRUEBAS ERROR-----------------//
    public static void PruebaERROR_1(Sistema s, Prueba p){
        s.crearMetro();
        System.out.println("Se crea el Metro Vacio");
        tituloPrueba("PRUEBA ERROR 1: REGISTRAR TRAMOS Y CLIENTES - ERRORES");
        crearTramosLineaA(p, s);
        crearClientes(p, s);
        System.out.println("ERRORES");
        p.ver(s.altaTramo('A',"Congreso", "Once", .2f, .5f), Sistema.TipoRet.ERROR_1, "Error, Ya existe el tramo Congreso - Once");
        p.ver(s.altaTramo('A',"Tribunales", "Callao", 0, .5f), Sistema.TipoRet.ERROR_2, "Error, La distancia no puede ser Cero");
        p.ver(s.altaTramo('A',"Tribunales", "Callao", .6f, 0), Sistema.TipoRet.ERROR_3, "Error, La tarifa no puede ser Cero");
        p.ver(s.altaCliente(11111111, "Ernesto Melgar"), Sistema.TipoRet.ERROR_1, "Error, Ya existe un cliente con ese nro de C.I.");
        p.ver(s.altaCliente(3333333, "Marcus Bremen"), Sistema.TipoRet.ERROR_2, "Error, La C.I. no respeta el formato");
        s.destruirMetro();
        finPrueba(" Fin PRUEBA ERROR 1");
    }

    public static void PruebaERROR_2(Sistema s, Prueba p){
        s.crearMetro();
        System.out.println("Se crea el Metro Vacio");
        tituloPrueba("PRUEBA ERROR 2: BAJA CLIENTE - ERRORES");
        p.ver(s.altaCliente(11111111, "Lucas Hussey"), Sistema.TipoRet.OK, "Se agrega el cliente Lucas Hussey");
        System.out.println("ERRORES");
        p.ver(s.bajaCliente(22222222), Sistema.TipoRet.ERROR_1, "Error, No existe ningun cliente registrado en el metro con ese nro de C.I.");
        p.ver(s.bajaCliente(1111111), Sistema.TipoRet.ERROR_2, "Error, La C.I. no respeta el formato");
        s.destruirMetro();
        finPrueba(" Fin PRUEBA ERROR 2");
    }

    public static void PruebaERROR_3(Sistema s, Prueba p){
        s.crearMetro();
        System.out.println("Se crea el Metro Vacio");
        tituloPrueba("PRUEBA ERROR 3: AGREGAR VIAJE A CLIENTE - ERRORES");
        crearClientes(p, s);
        crearTramosLineaA(p, s);
        System.out.println("ERRORES");
        p.ver(s.agregarViaje("Constitucion", "Retiro", 11111111, LocalDateTime.now()), Sistema.TipoRet.ERROR_1, "Error, no existe conexiones entre Constitucion y Retiro");
        p.ver(s.agregarViaje("Congreso", "Once", 12345678, LocalDateTime.now()), Sistema.TipoRet.ERROR_2, "Error, no existe un cliente con esa C.I.");
        p.ver(s.agregarViaje("Congreso", "Once", 123456, LocalDateTime.now()), Sistema.TipoRet.ERROR_3, "Error, la C.I. del cliente no cumple con el formato establecido");
        s.destruirMetro();
        finPrueba(" Fin PRUEBA ERROR 3");
    }

    public static void PruebaERROR_4(Sistema s, Prueba p){
        s.crearMetro();
        System.out.println("Se crea el Metro Vacio");
        tituloPrueba("PRUEBA ERROR 4: SERVICIOS - ERRORES");
        crearTramosLineaA(p, s);
        System.out.println("ERRORES");

        p.ver(s.agregarServicio("Tribunales", "Wifi"), Sistema.TipoRet.ERROR_1, "Error, La estacion no existe en el Metro");
        s.destruirMetro();
        finPrueba(" Fin PRUEBA ERROR 4");
    }

    public static void PruebaERROR_5(Sistema s, Prueba p){
        s.crearMetro();
        System.out.println("Se crea el Metro Vacio");
        tituloPrueba("PRUEBA ERROR 5: LISTADOS");
        crearClientes(p, s);
        crearTramosLineaC(p, s);
        System.out.println("ERRORES");
        
        p.ver(s.listarViajesCliente(12345678), Sistema.TipoRet.ERROR_1, "Error, el nro de C.I. del cliente no existe");
        p.ver(s.listarViajesCliente(123458), Sistema.TipoRet.ERROR_2, "Error, La C.I. del cliente no respeta el formato establecido");

        p.ver(s.listarServiciosEstacion("Tribunales"), Sistema.TipoRet.ERROR_1, "Error, La estacion no existe");

        p.ver(s.caminoMasCorto("Tribunales", "Constitucion"), Sistema.TipoRet.ERROR_1, "Error, La estacion origen no existe");
        p.ver(s.caminoMasCorto("Constitucion", "Tribunales"), Sistema.TipoRet.ERROR_2, "Error, La estacion destino no existe");

        p.ver(s.precioBoleto("Tribunales", "Constitucion"), Sistema.TipoRet.ERROR_1, "Error, La estacion origen no existe");
        p.ver(s.precioBoleto("Constitucion", "Tribunales"), Sistema.TipoRet.ERROR_2, "Error, La estacion destino no existe");
        s.destruirMetro();
        finPrueba(" Fin PRUEBA ERROR 5");
    }

    public static void tituloPrueba(String s){
        System.out.println("****************************************************************");
        System.out.println("  "+ s );
        System.out.println("*****************************************************************");
    }

    public static void finPrueba(String s){
        System.out.println("******************* " + s +" ***********************");
        System.out.println("****************************************************");
        System.out.println();
    }


    private static void crearTramosLineaA(Prueba p, Sistema s) {
        p.ver(s.altaTramo('A', "Diagonal Norte", "Congreso", 0.6f,  5.5f), Sistema.TipoRet.OK, "Se agrega el tramo Diagonal Norte - Congreso");
        p.ver(s.altaTramo('A', "Congreso", "Once", 0.4f,  4.5f), Sistema.TipoRet.OK, "Se agrega el tramo Congreso - Once");
        p.ver(s.altaTramo('A', "Peru", "Diagonal Norte", 0.8f,  6.5f), Sistema.TipoRet.OK, "Se agrega el tramo Peru - Diagonal Norte");
    }

    private static void crearTramosLineaB(Prueba p, Sistema s) {
        p.ver(s.altaTramo('B', "Diagonal Norte", "Uruguay", 0.5f,  5f), Sistema.TipoRet.OK, "Se agrega el tramo Diagonal Norte - Uruguay");
        p.ver(s.altaTramo('B', "Uruguay", "Medrano", 0.4f,  4.5f), Sistema.TipoRet.OK, "Se agrega el tramo Uruguay - Medrano");
        p.ver(s.altaTramo('B', "Uruguay", "Carlos Pellegrini", 0.8f,  6.5f), Sistema.TipoRet.OK, "Se agrega el tramo Uruguay - Carlos Pellegrini");
        p.ver(s.altaTramo('B', "Medrano", "Corrientes", 0.8f,  7.5f), Sistema.TipoRet.OK, "Se agrega el tramo Medrano - Corrientes");
    }

    private static void crearTramosLineaC(Prueba p, Sistema s) {
        p.ver(s.altaTramo('C', "Constitucion", "San Juan", 0.5f,  5f), Sistema.TipoRet.OK, "Se agrega el tramo Constitucion - San Juan");
        p.ver(s.altaTramo('C', "San Juan", "Avenida de Mayo", 0.4f,  4.5f), Sistema.TipoRet.OK, "Se agrega el tramo San Juan - Avenida de Mayo");
        p.ver(s.altaTramo('C', "Avenida de Mayo", "Diagonal Norte", 0.8f,  6.5f), Sistema.TipoRet.OK, "Se agrega el tramo San Juan - Diagonal Norte");
    }

    private static void crearTramosLineaH(Prueba p, Sistema s) {
        p.ver(s.altaTramo('H', "Once", "Venezuela", 0.5f,  5f), Sistema.TipoRet.OK, "Se agrega el tramo Once - Venezuela");
        p.ver(s.altaTramo('H', "Venezuela", "Jujuy", 0.4f,  4.5f), Sistema.TipoRet.OK, "Se agrega el tramo Venezuela - Jujuy");
        p.ver(s.altaTramo('H', "Once", "Corrientes", 0.8f,  6.5f), Sistema.TipoRet.OK, "Se agrega el tramo Once - Corrientes");
    }
    
    private static void crearClientes(Prueba p, Sistema s) {
        p.ver(s.altaCliente(11111111, "Lucas Hussey"), Sistema.TipoRet.OK, "Se agrega el cliente Lucas Hussey ");
        p.ver(s.altaCliente(22222222, "Ernesto Melgar"), Sistema.TipoRet.OK, "Se agrega el cliente Ernesto Melgar");
        p.ver(s.altaCliente(33333333, "Marcus Bremen"), Sistema.TipoRet.OK, "Se agrega el cliente Marcus Bremen");
    }

}

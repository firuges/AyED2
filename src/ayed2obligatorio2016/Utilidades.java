/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayed2obligatorio2016;

/**
 *
 * @author Maxi
 */
public class Utilidades {
    public static boolean DistanciaCorrecta(float distancia){
        if(distancia <= 0){
            return false;
        }
        return true;
    }
    public static boolean TarifaCorrecta(float tarifa){
        if(tarifa <= 0){
            return false;
        }
        return true;
    }
    public static boolean FormatoCedula(int cedula){
        String largo = String.valueOf(cedula);
        if(largo.length() == 7){
            return true;
        }
        return false;
    }
}

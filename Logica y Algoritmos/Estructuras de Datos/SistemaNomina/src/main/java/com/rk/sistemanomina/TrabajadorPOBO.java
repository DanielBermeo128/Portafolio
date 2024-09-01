/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rk.sistemanomina;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * 
 * @author Daniel Bermeo
 */
public class TrabajadorPOBO {

    
    private int numTrabajador, horasEx, sueldoBase, anhoIngreso, anhoActual;
    private String nombre, apPat, apMat;
    private final double HORA_EXTRA = 276.5;
    
    // Obtenemos el año de la pc
    Date dia = new Date();
    ZoneId zonaHoraria = ZoneId.systemDefault();
    LocalDate horaLocal = dia.toInstant().atZone(zonaHoraria).toLocalDate();
    
    

    public TrabajadorPOBO(int numTrabajador, int horasEx, int sueldoBase, int anhoIngreso, String nombre, String ApPat, String ApMat) {
        this.numTrabajador = numTrabajador;
        this.horasEx = horasEx;
        this.sueldoBase = sueldoBase;
        this.anhoIngreso = anhoIngreso;
        this.nombre = nombre;
        this.apPat = ApPat;
        this.apMat = ApMat;
    }

    public double calcularSueldo(){
        anhoActual = horaLocal.getYear();
        int antiguedad = anhoActual-anhoIngreso;
        return sueldoBase + (sueldoBase * (antiguedad*0.03)) + (horasEx * HORA_EXTRA);
    }
    
    @Override
    public String toString() {
        return String.format("%d \t %s %s %s", numTrabajador, nombre,apPat, apMat );
    }
  
    public int getNumTrabajador() {
        return numTrabajador;
    }

    public void setNumTrabajador(int numTrabajador) {
        this.numTrabajador = numTrabajador;
    }

    public int getHorasEx() {
        return horasEx;
    }

    public void setHorasEx(int horasEx) {
        this.horasEx = horasEx;
    }

    public int getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(int sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getAnhoIngreso() {
        return anhoIngreso;
    }

    public void setAnhoIngreso(int anhoIngreso) {
        this.anhoIngreso = anhoIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPat() {
        return apPat;
    }

    public void setApPat(String ApPat) {
        this.apPat = ApPat;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String ApMat) {
        this.apMat = ApMat;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rk.sistemanomina;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Daniel Bermeo
 */
public class NominaADT {

    ArrayList<String[]> lista = new ArrayList<>();
    ArregloADT arrayTrabajadores;
            
    public NominaADT(String ruta){
        try{
            
            String txt;
            BufferedReader brrr = new BufferedReader(new FileReader(ruta));
            
            
            txt = brrr.readLine();
            while(txt!=null){
                lista.add(txt.split(","));
                txt = brrr.readLine();
            }
            
            lista.remove(0);
            
            arrayTrabajadores = new ArregloADT(lista.size());
            for(int i=0; i<arrayTrabajadores.getLongitud(); i++){
                String[] array = lista.get(i);                
                arrayTrabajadores.setElemento(new TrabajadorPOBO(Integer.parseInt(array[0]), Integer.parseInt(array[4]), 
                        Integer.parseInt(array[5]), Integer.parseInt(array[6]), array[1], array[2], array[3]), i);
            }  
            
            
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(NominaADT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(NominaADT.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void listarSueldos(){
        
        System.out.println("\nId\tTrabajador\t\t\t\tSueldo\n");
        for(int i = 0;i<arrayTrabajadores.getLongitud();i++){
            TrabajadorPOBO trabaja = (TrabajadorPOBO) arrayTrabajadores.getElemento(i);
            System.out.printf("%d\t%s %s %s\t\t\t$%s\n",trabaja.getNumTrabajador(), trabaja.getNombre(), trabaja.getApPat(),trabaja.getApMat(), String.valueOf(trabaja.calcularSueldo()));
        }
    }
    
    public void mayorAntiguedad(){
        int mayor = 2023;
        int index = 0;
        for(int i = 0;i<arrayTrabajadores.getLongitud();i++){
            TrabajadorPOBO trabaja = (TrabajadorPOBO) arrayTrabajadores.getElemento(i);
            if(trabaja.getAnhoIngreso()< mayor){
                mayor = trabaja.getAnhoIngreso();
                index = i;
            }
        }
        System.out.println("\n\nTrabajador/es con mayor antiguedad: ");
        for(int i = 0;i<arrayTrabajadores.getLongitud();i++){
            TrabajadorPOBO trabaja = (TrabajadorPOBO) arrayTrabajadores.getElemento(i);
            if(trabaja.getAnhoIngreso()==mayor){
                System.out.println(trabaja);
            }
        }
    }
    
    public void menorAntiguedad(){
        int menor = 0;
        int index = 0;
        for(int i = 0;i<arrayTrabajadores.getLongitud();i++){
            TrabajadorPOBO trabaja = (TrabajadorPOBO) arrayTrabajadores.getElemento(i);
            if(trabaja.getAnhoIngreso()> menor){
                menor = trabaja.getAnhoIngreso();
                index = i;
            }
        }
        System.out.println("\n\nTrabajador/es con menor antiguedad: ");
        for(int i = 0;i<arrayTrabajadores.getLongitud();i++){
            TrabajadorPOBO trabaja = (TrabajadorPOBO) arrayTrabajadores.getElemento(i);
            if(trabaja.getAnhoIngreso()== menor){
                System.out.println(trabaja);
            }
        }
    }
}

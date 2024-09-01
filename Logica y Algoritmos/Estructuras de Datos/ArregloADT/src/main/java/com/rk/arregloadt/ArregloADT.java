/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rk.arregloadt;

import java.util.ArrayList;


/**
 * 
 * @author Daniel Bermeo
 */
public class ArregloADT <T>{

    private int tamanio;
    private ArrayList<T> lista = new ArrayList<T>() ;
  
    
    public ArregloADT(int tamanio){
        this.tamanio = tamanio;
        for(int i = 0; i<tamanio;i++){
            lista.add((T) "");
        }
    }
    
    public T getElemento(int indice ){
        
        if(comprobarIndice(indice)){
            return lista.get(indice);
        }
        return null;
    }
    
    public void setElemento(T dato,int indice){
        if(comprobarIndice(indice)){
            lista.set(indice, dato);
        }
        
    }
    
    public int getLongitud(){
        
        return lista.size();
    }
    
    public void limpiar(T dato){
        int cont=0;
        for(T i:lista){
            lista.set(cont, dato);
            cont++;
        }
    }

    @Override
    public String toString() {
        return String.format("\nTamaño del Arreglo: %d, \nArreglo: %s",this.tamanio, this.lista );
    }
    
    

    
    
    private boolean comprobarIndice(int indice){
        if(indice>=0 && indice<tamanio){
            return true;
        }else{
            return false;
        }
    }
}

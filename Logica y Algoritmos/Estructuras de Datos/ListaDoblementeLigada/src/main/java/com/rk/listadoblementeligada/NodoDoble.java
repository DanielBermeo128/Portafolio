/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rk.listadoblementeligada;

/**
 * 
 * @author Daniel Bermeo
 */
public class NodoDoble<T> {

    private T dato;
    private NodoDoble<T> siguiente;
    private NodoDoble<T> anterior;
    
    public NodoDoble() {
        this.dato = null;
        this.siguiente = null;
        this.anterior = null;
    }
    
    public NodoDoble(T dato){
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
    
    public NodoDoble(T dato, NodoDoble siguiente){
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = null;
    }
    
    public NodoDoble(T dato, NodoDoble siguiente, NodoDoble anterior){
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoDoble<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "|"+dato+"|->";
    }
    
 
    public String toString(boolean desicion) {
        if(desicion){
            return "|"+dato+"|->";
        }else{
            return "<-|"+dato+"|";
        }
    }
    
}

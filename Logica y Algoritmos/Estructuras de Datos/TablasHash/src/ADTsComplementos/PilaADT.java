/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADTsComplementos;

import ADTsComplementos.ListaDobleLigadaADT;


/**
 *
 * @author Daniel Bermeo
 */
public class PilaADT<T> {

    private int tamanhio, capacidad;
    private ListaDobleLigadaADT<T> pila;
    private boolean isLimitada;

    public PilaADT() {
        pila = null;
        tamanhio = 0;
    }

    // Permite limitar la pila a una capacidad de carga
    public PilaADT(int capacidad) {
        pila = null;
        tamanhio = 0;
        this.capacidad = capacidad;
    }

    public boolean isEmpty() {
        return tamanhio == 0;
    }

    public int getLenght() {
        return tamanhio;
    }

    public T pop() {

        T dato = null;
        if (!pila.estaVacia())
        {
            dato = pila.getLast();
            pila.eliminarAlFinal();
        }

        tamanhio = pila.getTamanhio();
        return dato;
        

    }

    public T peek() {
        T dato = pila.getLast();

        return dato;
    }

    public void push(T dato) {

        if(pila==null){
            pila = new ListaDobleLigadaADT();
        }
        if (isLimitada)
        {
            if (tamanhio < capacidad)
            {
                pila.agregarAlFinal(dato);
            }
        } else
        {
            pila.agregarAlFinal(dato);
        }
        tamanhio = pila.getTamanhio();

    }
    
    public boolean isFull(){
        return tamanhio == capacidad; 
    }

    @Override
    public String toString() {
        String estado="";
        
        String[] separados = pila.toString().split(",");
        for(String dato: separados){
            estado =  dato + "\n----------\n" + estado ; 
        }
        
        return estado;
    }
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Colas;

import java.util.ArrayList;

/**
 * 
 * @author Daniel Bermeo
 */


public class ColaSimple<T>{

    private ArrayList<T> cola;
    
    public ColaSimple(){
        cola = new ArrayList();
    }
    
    public boolean isEmpty(){
        return cola.isEmpty();
    }
    
    public int lenght(){
        return cola.size();
    }
    
    public void enqueue(T dato){
        cola.add(dato);
    }
    
    public T dequeue(){
        T dato;
        if(isEmpty()){
            dato = null;
        }else{
            dato = cola.get(0);
            cola.remove(0);
        }
        return dato;
    }

    @Override
    public String toString() {
        return "ColaSimple{" + "cola=" + cola + '}';
    }
    
    
    
}

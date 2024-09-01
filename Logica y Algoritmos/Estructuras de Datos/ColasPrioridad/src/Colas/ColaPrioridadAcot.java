/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Colas;

/**
 * 
 * @author Daniel Bermeo
 */
public class ColaPrioridadAcot <T>{

    private ColaSimple[] cola;
    private int length, levels;
    
    public ColaPrioridadAcot(int niveles){
        cola = new ColaSimple[niveles];
        for(int i = 0; i < niveles; i++){
            cola[i] = new ColaSimple();
        }
        levels = niveles;
        length = 0;
    }
    
    public boolean isEmpty(){
        return length == 0;
    }
    
    public int length(){
        return length;
    }
    
    public void enqueue(int prioridad, T dato) throws PrioridadFueraDeRango{
        if (prioridad < 0)
        {
            prioridad = 0;
        }
        if (prioridad < levels){
            cola[prioridad].enqueue(dato);
            length++;
        }else{
            throw new PrioridadFueraDeRango();
        }
    }
    
    public T dequeue(){
        
        boolean centinela = true;
        T dato = null;
        
        for( int i = 0; centinela && length > 0 ; i++){
            if(!cola[i].isEmpty()){
                dato = (T) cola[i].dequeue();
                centinela = false;
            }
        }
        
        length--;
        return dato;
    }

    @Override
    public String toString() {
        return "ColaPrioridadAcot{" + "cola=" + getElementos() + ", length=" + length + ", levels=" + levels + '}';
    }

    private String getElementos() {
       String cadena="";
       
       for(int i = 0; i < levels; i++){
            cadena = cadena + cola[i];
        }
       
       return cadena;
    }
    
    
}

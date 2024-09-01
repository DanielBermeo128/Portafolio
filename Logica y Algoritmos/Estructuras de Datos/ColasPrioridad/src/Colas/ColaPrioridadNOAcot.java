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
public class ColaPrioridadNOAcot<T> {

    private ArrayList<ColaSimple> cola;
    private int lenght;

    public ColaPrioridadNOAcot() {
        cola = new ArrayList(0);
        lenght = 0;
    }

    public boolean isEmpty() {
        return lenght == 0;
    }

    public int lenght() {
        return lenght;
    }

    public void enqueue(int prioridad, T dato) {
        if (prioridad < 0)
        {
            prioridad = 0;
        }

        if (prioridad >= cola.size())
        {
            int iteraciones = prioridad + 1 - cola.size();
            for (int i = 0; i <= iteraciones; i++)
            {
                cola.add(new ColaSimple());
            }
        }

        ColaSimple tmp = cola.get(prioridad);
        tmp.enqueue(dato);
        lenght++;
    }

    public T dequeue() {
        T dato=null;
        boolean centinela = true;
                
        for (int i = 0; centinela && i<cola.size(); i++)
        {
            ColaSimple tmp = cola.get(i);
            if(!tmp.isEmpty()){
                centinela = false;
                dato = (T) tmp.dequeue();
            }
        }

        lenght--;
        return dato;
    }

    @Override
    public String toString() {
        return "ColaPrioridadNOAcot{" + "cola=" + cola + ", lenght=" + lenght + '}';
    }
    
    
}

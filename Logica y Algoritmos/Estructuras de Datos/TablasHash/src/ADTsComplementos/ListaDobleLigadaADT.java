/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADTsComplementos;

import ADTsComplementos.NodoDoble;

/**
 *
 * @author Daniel Bermeo
 */
public class ListaDobleLigadaADT<T> {

    private NodoDoble<T> head;
    private NodoDoble<T> tail;
    private int tamanhio;

    public ListaDobleLigadaADT() {

        head = null;
        tail= null;
        tamanhio = 0;

    }

    public boolean estaVacia() {
        return this.head == null;

    }

    public int getTamanhio() {
        return this.tamanhio;
    }

    public void agregarAlFinal(T dato) {

        NodoDoble<T> tmp = head;
        if (this.estaVacia())
        {
            this.head = new NodoDoble(dato);
            this.tail = head;
        } else
        {
            while (tmp.getSiguiente() != null)
            {
                tmp = tmp.getSiguiente();
            }
            tail = new NodoDoble(dato, null, tmp);
            tmp.setSiguiente(tail);

        }
        tamanhio++;
    }

    public void agregarAlInicio(T dato) {

        NodoDoble tmp = head;
        head = new NodoDoble(dato, tmp);
        if (tmp != null)
        {
            tmp.setAnterior(head);
        }

        tamanhio++;
    }

    public void agregarDespuesDe(int posicion, T dato) {
        if (posicion > 0 && posicion <= tamanhio)
        {
            NodoDoble tmp = head;
            for (int i = 1; i < posicion; i++)
            {
                tmp = tmp.getSiguiente();
            }
            NodoDoble guardar = tmp.getSiguiente();
            NodoDoble agregado = new NodoDoble(dato, guardar, tmp);
            if (guardar != null)
            {
                guardar.setAnterior(agregado);
            }
            tmp.setSiguiente(agregado);
            
            if(posicion==tamanhio){
                tail = agregado;
            }

            tamanhio++;
        }
    }

    public void eliminar(int posicion) {
        if (tamanhio > 0)
        {
            NodoDoble tmp = head;
            if (posicion > 1 && posicion != tamanhio)
            {
                for (int i = 1; i < posicion; i++)
                {
                    tmp = tmp.getSiguiente();
                }

                NodoDoble limpieza = tmp.getSiguiente();
                NodoDoble salto = tmp.getSiguiente().getSiguiente();
                tmp.setSiguiente(salto);
                if (salto != null)
                {
                    salto.setAnterior(tmp);
                }
                limpieza.setDato(null);
                limpieza.setSiguiente(null);
                tamanhio--;
            } else if (posicion == tamanhio)
            {

                eliminarAlFinal();
            } else
            {
                eliminarElPrimero();
            }
        }
    }

    public void eliminarElPrimero() {
        if (tamanhio > 0)
        {
            NodoDoble limpieza = head;
            NodoDoble salto = head.getSiguiente();
            head = salto;
            head.setAnterior(null);
            limpieza.setDato(null);
            limpieza.setSiguiente(null);
            tamanhio--;
        }
    }

    public void eliminarAlFinal() {
        if (tamanhio > 0)
        {
            NodoDoble tmp = head;
            for (int i = 1; i < tamanhio - 1; i++)
            {
                tmp = tmp.getSiguiente();
            }
            
            tmp.setSiguiente(null);
            tail = tmp;
            tamanhio--;
        }

    }

    public int buscar(T dato) {

        NodoDoble tmp = head;
        boolean centinela = true;
        int indice = 1;

        while (centinela && indice < tamanhio + 1)
        {
            if (tmp.getDato() != dato)
            {
                tmp = tmp.getSiguiente();
                indice++;
            } else
            {
                centinela = false;
            }
        }

        return indice;
    }

    public void actualizar(T busqueda, T dato) {

        int posicion = buscar(busqueda);

        if (posicion <= tamanhio)
        {
            NodoDoble tmp = head;
            for (int i = 1; i < posicion; i++)
            {
                tmp = tmp.getSiguiente();
            }

            tmp.setDato(dato);
        }
    }

    public void transversal(boolean direccion) {

        // true ascendente, false descendente
        NodoDoble tmp = head;
        if (direccion)
        {
            while (tmp.getSiguiente() != null)
            {
                System.out.print(tmp + "->");
                tmp = tmp.getSiguiente();
            }
            System.out.print(tmp);
        } else
        {
            tmp = tail; 
            while (tmp.getAnterior() != null)
            {
                System.out.print("<-" + tmp);
                tmp = tmp.getAnterior();
            }
            System.out.print(tmp);
        }
    }

    // Realizamos un toString para obtener los valores que contiene las lista separados por comas
    @Override
    public String toString() {
        String cadena = null;
        NodoDoble tmp = head; 
        if(!estaVacia()){
            cadena = head.getDato() + ",";
            while(tmp.getSiguiente()!=null){
                tmp = tmp.getSiguiente();
                cadena = cadena + tmp.getDato() + ",";
            }
        }
    
        return cadena;
    }
    
    
    
    public T getLast(){
        return this.tail.getDato();
    }

}

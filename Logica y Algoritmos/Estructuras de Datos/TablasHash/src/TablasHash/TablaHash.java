/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TablasHash;


import ADTsComplementos.PilaADT;
import ADTsComplementos.ColaSimple;
import java.util.ArrayList;

/**
 *
 * @author Daniel Bermeo
 */
public class TablaHash<T> {

    private ArrayList<ColaSimple> tabla;

    public TablaHash(int tamanhoTabla) throws ExepcionNoPrimo {
        if (esPrimo(tamanhoTabla))
        {
            tabla = new ArrayList();
            for (int i = 0; i < tamanhoTabla; i++)
            {
                tabla.add(new ColaSimple());
            }
        } else
        {
            throw new ExepcionNoPrimo();
        }
    }

    public void Add(int llave, T dato) {
        ColaSimple tmp = tabla.get(TablaHash.this.getKey(llave));
        tmp.enqueue(new SlotInt(llave, dato));
    }

    public void Add(String llave, T dato) {
        ColaSimple tmp = tabla.get(getKey(llave));
        tmp.enqueue(new SlotString(llave, dato));
    }

    public T valueOf(int llave) {

        T dato = null;
        ColaSimple tmp = tabla.get(getKey(llave));
        ColaSimple guardar = new ColaSimple();
        SlotInt actual = (SlotInt) tmp.dequeue();
        guardar.enqueue(actual);
        boolean centinela = true;

        while (centinela)
        {
            if (actual.getLlave() == llave || guardar.isEmpty())
            {
                centinela = false;
                if (!guardar.isEmpty())
                {
                    dato = (T) actual.getDato();
                }
            } else
            {
                actual = (SlotInt) tmp.dequeue();
                guardar.enqueue(actual);
            }
        }

        while (!guardar.isEmpty())
        {
            tmp.enqueue(guardar.dequeue());
        }

        return dato;
    }

    public T valueOf(String llave) {

        T dato = null;
        ColaSimple tmp = tabla.get(getKey(llave));
        ColaSimple guardar = new ColaSimple();
        SlotString actual = (SlotString) tmp.dequeue();
        guardar.enqueue(actual);
        boolean centinela = true;

        while (centinela)
        {
            if (actual.getLlave() == llave || guardar.isEmpty())
            {
                centinela = false;
                if (!guardar.isEmpty())
                {
                    dato = (T) actual.getDato();
                }
            } else
            {
                actual = (SlotString) tmp.dequeue();
                guardar.enqueue(actual);
            }
        }

        while (!guardar.isEmpty())
        {
            tmp.enqueue(guardar.dequeue());
        }

        return dato;
    }

    public void remove(int llave) {

        ColaSimple tmp = tabla.get(getKey(llave));
        PilaADT guardar = new PilaADT();
        boolean centinela = true;

        SlotInt actual = null;
        try
        {
            actual = (SlotInt) tmp.dequeue();
            guardar.push(actual);
        } catch (ClassCastException e)
        {
            centinela = false;
        }

        while (centinela)
        {
            if (actual.getLlave() == llave || guardar.isEmpty())
            {
                centinela = false;
                if (!guardar.isEmpty())
                {
                    guardar.pop();
                }
            } else
            {
                actual = (SlotInt) tmp.dequeue();
                guardar.push(actual);
            }
        }

        while (!guardar.isEmpty())
        {
            tmp.enqueue(guardar.pop());
        }
    }

    public void remove(String llave) {
        ColaSimple tmp = tabla.get(getKey(llave));
        PilaADT guardar = new PilaADT();
        boolean centinela = true;
        SlotString actual = null;
        try
        {
            actual = (SlotString) tmp.dequeue();
            guardar.push(actual);
        } catch (ClassCastException e)
        {
            centinela = false;
        }

        while (centinela)
        {
            if (actual.getLlave() == llave || guardar.isEmpty())
            {
                centinela = false;
                if (!guardar.isEmpty())
                {
                    guardar.pop();
                }
            } else
            {
                actual = (SlotString) tmp.dequeue();
                guardar.push(actual);
            }
        }

        while (!guardar.isEmpty())
        {
            tmp.enqueue(guardar.pop());
        }
    }

    private int getKey(int llave) {
        return llave % tabla.size();
    }

    private int getKey(String llave) {
        return sumarCaracteres(llave) % tabla.size();
    }

    private boolean esPrimo(int numero) {
        boolean resultado = true;

        if (numero == 0 || numero == 1 || numero == 4)
        {
            resultado = false;
        } else
        {
            for (int i = 2; i < numero / 2; i++)
            {
                if (numero % i == 0)
                {
                    resultado = false;
                }
            }
        }

        return resultado;
    }

    private int sumarCaracteres(String llave) {
        int total = 0;
        for (int i = 0; i < llave.length(); i++)
        {
            total += Character.getNumericValue(llave.charAt(i));
        }
        return total;
    }

    @Override
    public String toString() {
        return "TablaHash{" + "tabla=" + tabla + '}';
    }

}

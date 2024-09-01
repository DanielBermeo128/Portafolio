/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TablasHash;

/**
 *
 * @author Daniel Bermeo
 */
public class SlotInt<T>{

    private int llave;
    private T dato;

    public SlotInt(int llave, T dato) {

        this.llave = llave;
        this.dato = dato;
    }

    public int getLlave() {
        return llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "llave=" + llave + ", dato=" + dato ;
    }
    
    

}

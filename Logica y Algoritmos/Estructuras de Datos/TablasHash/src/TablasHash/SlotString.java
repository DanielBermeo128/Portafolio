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
public class SlotString<T>{

    private String llave;
    private T dato;

    public SlotString(String llave, T dato) {

        this.llave = llave;
        this.dato = dato;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
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

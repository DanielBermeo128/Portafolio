/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rk.arregloadt;

import java.util.Iterator;
import javax.swing.JPanel;


/**
 *
 * @author Daniel Bermeo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
   
        ArregloADT prueba = new ArregloADT(10);
        
        String[] s ={"pruebas", "fin"};
        System.out.println("Estado inicial del objeto:\n" + prueba.toString());
        System.out.println("\n\nTamaño del arreglo: " + prueba.getLongitud());       
        prueba.setElemento(new ArregloADT(5) , 5);
        prueba.setElemento(s, 7);
        prueba.setElemento(new JPanel(), 1);
        System.out.println("\n\nSe añanaden los siguientes elementos a la lista: ");
        System.out.println(prueba.getElemento(5));
        System.out.println(prueba.getElemento(0));
        System.out.println(prueba.getElemento(7));
        System.out.println(prueba.getElemento(1));
        System.out.println("\n\nEl arreglo se encuentra de la siguiente manera:");
        System.out.println("Estado operado del objeto: " + prueba.toString());
        System.out.println("\n\nSe limpia el arreglo!! ");
        prueba.limpiar(null);       
        System.out.println("\n\nEstado final del objeto:\n" + prueba.toString());
        
         
    }
    
    
    
}

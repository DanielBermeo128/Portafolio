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
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ListaDobleLigadaADT lista = new ListaDobleLigadaADT();
        
        
        lista.agregarAlInicio("Segundo");
        lista.agregarAlInicio("Primero");
        lista.agregarAlFinal("Tercero");
        lista.agregarDespuesDe(lista.buscar("Tercero"), "Cuarto");
        System.out.println("Estado de la lista Inicial");
        lista.transversal(true);
        System.out.println(lista.getTamanhio());
        
        lista.eliminar(1);
        System.out.println("\nLista eliminando posicion 1");
        lista.transversal(true);
        System.out.println(lista.getTamanhio());
        lista.eliminar(3);
        System.out.println("\nLista eliminando posicion 3");
        lista.transversal(true);
        System.out.println(lista.getTamanhio());
        
        
        System.out.println("\nLista eliminando la primera posicion");
        lista.eliminarElPrimero();
        lista.transversal(true);
        System.out.println(lista.getTamanhio());
        
        lista.agregarAlInicio("Nuevo1");
        lista.agregarDespuesDe(1,"Nuevo2");
        System.out.println("\nLista usando metodos para agregar objetos");
        lista.transversal(true);
        System.out.println(lista.getTamanhio());
        
        lista.actualizar("Nuevo1", "Primero");
        lista.actualizar("Nuevo2", "Segundo");
        System.out.println("\nLista usa metodos de actualizar");
        lista.transversal(true);
        System.out.println(lista.getTamanhio());
        
        System.out.println("\nSe elimina el ultimo y se imprime en sentido contrario");
        lista.eliminarAlFinal();
        lista.transversal(false);
        System.out.println(lista.getTamanhio());
        
        
        
    }
    
}

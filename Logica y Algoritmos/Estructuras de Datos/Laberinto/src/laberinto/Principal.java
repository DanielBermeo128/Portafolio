/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

/**
 *
 * @author Daniel Bermeo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tablero laberinto = new Tablero("CargaTablero2.csv");
        
        System.out.println("El tablero inicial es el siguiente:");
        laberinto.imprimirTablero();
        laberinto.recorrerTablero();
        System.out.println("\n\nLa solucion del laberinto es: \n\n");
        laberinto.imprimirSolucion();
       
    }
    
}

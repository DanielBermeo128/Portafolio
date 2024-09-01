/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import com.rk.eljuegodelavida.Juego;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel Bermeo
 */
public class Menus {

    Scanner sc = new Scanner(System.in);

    public Menus() {

    }

    public void menuPrincipal() {
        
        System.out.println("Seleccione un numero del menu:");
        System.out.println("\n----------------------------\n");
        System.out.println("1 Nuevo Juego");
        System.out.println("2 Salir");
        System.out.println("\n----------------------------\n");
        int seleccion=pasarEntero(sc.nextLine());
        
        if (seleccion==1){
            nuevoJuego();
        }else if(seleccion == 2){
            System.out.println("\n\n-----Salio del programa-----\n\n");
            System.exit(0);
        }else{
            System.out.println("Seleccion fuera de rango");
            menuPrincipal();
        }

    }

    public void nuevoJuego() {

        int xLen, yLen, numGen;
        boolean salida = true;
        ArrayList<int[]> vivos = new ArrayList();
        Juego juego;

        
        // Inicializar parametros del tablero
        System.out.println("Numero de Columnas en el tablero: ");
        xLen = pasarEntero(sc.nextLine());
        System.out.println("Numero de Renglones en el tablero: ");
        yLen = pasarEntero(sc.nextLine());
        System.out.println("Numero de generaciones: ");
        numGen = pasarEntero(sc.nextLine());

        // Lenar coordenadas vivas
        System.out.println("\nTome las coordenadas desde 1 a el valor maximo del tablero\n"
                + "Al igual que el recorrido de coordenadas como el valor absoluto de coordenadas del 4º cuadrante");
        do
        {
            System.out.println("\n----------------------------\n");
            System.out.println("1 Agregar una coordenada");
            System.out.println("Cualquier otro NUMERO salir");
            System.out.println("\n----------------------------\n");
            int desicion = pasarEntero(sc.nextLine());
            if(desicion==1){
                vivos.add(recibirCordenadas(xLen, yLen));
            }else{
                salida = false;
            }
                
        } while (salida);
        
        // Crear e imprimir el juego
        juego = new Juego(yLen, xLen, vivos);
        System.out.println("Tomemos O como celulas vivas y X como celulas muertas");
        System.out.println("\nGeneracion Madre: ");
        System.out.println(juego.getGeneracion());
        for(int cnt = 0; cnt < numGen; cnt++){
            juego.siguienteGen();
            System.out.println("\nGenneracion #" + (cnt+1));
            System.out.println(juego.getGeneracion());
            juego.actualizarVecinos(xLen, yLen);
        }
        menuPrincipal();
    }

    public int pasarEntero(String num) {
        int retorno = 0;
        try
        {
            retorno = Integer.parseInt(num);
        } catch (NumberFormatException e)
        {
            System.out.println("Ingrese solo valores numericos: ");
            retorno = pasarEntero(sc.nextLine());
        }
        return retorno;
    }

    public int[] recibirCordenadas(int xLen, int yLen) {
        int[] temp = new int[2];
        System.out.println("Ingrese las coordenadas: ");
        System.out.println("x: ");
        int x = pasarEntero(sc.nextLine());
        System.out.println("y: ");
        int y = pasarEntero(sc.nextLine());
        

        if ((x > 0 && x <= xLen) && (y > 0 && y <= yLen))
        {
            temp[0] = x-1;
            temp[1] = y-1;
        } else
        {
            System.out.println("Valores fuera de parametros del tablero");
            temp = recibirCordenadas(xLen, yLen);
        }

        return temp;

    }
}

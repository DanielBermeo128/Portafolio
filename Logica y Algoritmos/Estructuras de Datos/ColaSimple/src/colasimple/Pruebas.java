/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasimple;

import java.util.Scanner;

/**
 *
 * @author Daniel Bermeo
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    
    static ColaSimple  cola = new ColaSimple();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        llenarCola();
        
        System.out.println("La cola quedo así: " + cola);
        System.out.println("El tamaño de la cola es: " + cola.lenght());
        
        System.out.println("Vaciaremos la cola: ");
        while(!cola.isEmpty()){
            System.out.println(cola.dequeue());
        }
    }
    
    public static void llenarCola(){
        System.out.println("Ingrese solo numeros, no esta permitido el 666\n(Use el 666 para salir)");
        int meter = pasarEntero(sc.nextLine());
        
        while(meter!=666){
            cola.enqueue(meter);
            meter = pasarEntero(sc.nextLine());
        }
        
    }
    
    public static int pasarEntero(String digitos){
        int numero;
        try{
            numero = Integer.parseInt(digitos);
        }catch(NumberFormatException ex){
            System.out.println("El ingreso no fue un numero, intentelo de nuevo");
            numero = pasarEntero(sc.nextLine());
        }
        
        return numero;
    }
    
}

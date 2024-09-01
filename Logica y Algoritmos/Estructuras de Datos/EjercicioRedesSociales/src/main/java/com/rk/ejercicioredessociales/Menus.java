package com.rk.ejercicioredessociales;


import com.rk.ejercicioredessociales.LecturaArchivo;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Daniel Bermeo
 */
public class Menus {

    
    int respuesta;
    Scanner sc = new Scanner(System.in);
    LecturaArchivo fi = new LecturaArchivo();
    
    
    public void menu(){
        
        
        System.out.println("Seleccione un numero del menu:");
        System.out.println("\n----------------------------\n");
        System.out.println("1 Diferencia de seguidores en Twitter de Enero a Junio");
        System.out.println("2 Seleccionar meses de Diferencia de visualizaciones en Youtube");
        System.out.println("3 Promedio de crecimiento de Twitter y Facebook");
        System.out.println("4 Salir");
        System.out.println("\n----------------------------\n");
        
        
        respuesta = pasarEnteroSeguro(sc.nextLine());
        
        if (respuesta == 1){
            int num, num1;
            
            num = Integer.parseInt(fi.matriz[8][3]);
            num1 = Integer.parseInt(fi.matriz[8][8]);
            System.out.println("\nDiferencia de seguidores en Twitter (Enero-Junio): "+(num1- num)+"\n\n");
            
            menu();
        }else if(respuesta == 2){
            
            int num,num1;
            int primerMes = seleccionMes(0);
            int segundoMes = seleccionMes(primerMes);
            num = Integer.parseInt(fi.matriz[16][primerMes+2]);
            num1 =Integer.parseInt(fi.matriz[16][segundoMes+2]);
            System.out.println("\nDiferencia de visualizaciones en youtube (" +cm(primerMes)
                    +"-" + cm(segundoMes)+"): " +(num1-num)+"\n\n");
            menu();
        }else if(respuesta == 3){
            
            double prom = promedio(2);
            double prom1 = promedio(9);
            
            System.out.println("\nPromedio de crecimiento en Facebook: "+ prom);
            System.out.println("Promedio de crecimiento en Twitter: " + prom1+"\n\n");
                    
            menu();
        } else if(respuesta == 4){
            
            System.exit(0);
        }else{
            System.out.println("Introduzca solo un numero dentro del menu");
            menu();
        }
    }
    
    public int seleccionMes (int mes){
        
        
        System.out.println("Seleccione un numero del menu:");
        System.out.println("\n----------------------------\n");
        System.out.println("1 Enero");
        System.out.println("2 Febrebro");
        System.out.println("3 Marzo");
        System.out.println("4 Abril");
        System.out.println("5 Mayo");
        System.out.println("6 Junio");
        System.out.println("7 Julio");
        System.out.println("8 Agosto");
        System.out.println("9 Septiembre");
        System.out.println("10 Octubre");
        System.out.println("11 Noviembre");
        System.out.println("12 Diciembre");
        System.out.println("\n----------------------------\n");

        respuesta = pasarEnteroSeguro(sc.nextLine());
        
        
        if (respuesta > mes && respuesta < 13)
            return respuesta;
        else{
            System.out.println("Ingrese un mes dentro del menu y mayor al mes ya seleccionado");
            seleccionMes(mes);
            return 0;
        }
        
    }
    
    private int pasarEnteroSeguro(String numero){
        int nu;
        try{
            nu  = Integer.parseInt(numero);
        }catch(NumberFormatException  e){
            System.out.println("Ingrese solo numeros");
            nu = 0;
        }
        return nu;
    }
    
    private double promedio(int a){
        
        double prom = 0;
        for(int i = 3; i<9;i++){
            prom += Double.parseDouble(fi.matriz[a][i]);
        }
        return prom/6.0;
    }
    
    private String cm(int n){
        if(n==1){
            return "Enero";
        }else if(n==2){
            return "Febrero";
        }else if(n==3){
            return "Marzo";
        }else if(n==4){
            return "Abril";
        }else if(n==5){
            return "Mayo";
        }else if(n==6){
            return "Junio";
        }else if(n==7){
            return "Julio";
        }else if(n==8){
            return "Agosto";
        }else if(n==9){
            return "Septiembre";
        }else if(n==10){
            return "Octubre";
        }else if(n==11){
            return "Noviembre";
        }else if(n==12){
            return "Diciembre";
        }else{
            return "fallo01";
        }
    }
}

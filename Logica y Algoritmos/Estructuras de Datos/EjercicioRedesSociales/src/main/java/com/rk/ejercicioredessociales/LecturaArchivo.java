/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rk.ejercicioredessociales;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Daniel Bermeo
 */
public class LecturaArchivo {

    String matriz[][] = new String[19][16];
    String txt, apoyo[];
    
    
    public LecturaArchivo(){
    
        try
        {
            BufferedReader buf = new  BufferedReader(new FileReader("presenciaredes.csv") );
            txt = buf.readLine();
            int cont = 0;
            
            while(txt != null ){
                apoyo = txt.split(",");
                    int j = 0;
                    for(int i=0;i<15;i++){
                        if (apoyo[j].indexOf(34)== -1){
                            matriz[cont][i] = apoyo[j];
                            j++;
                        }else{
                            matriz[cont][i] = apoyo[j].substring(1) + apoyo[j+1].substring(0,apoyo[j+1].length()-1);
                            j+=2;
                        }
                    }
                cont ++;
                txt = buf.readLine();
            }   
            
        } catch (FileNotFoundException ex)
        {
            System.err.println("No se encontro archivo");
            ex.printStackTrace();
        } catch (IOException ex)
        {
            System.err.println("No se pudo leer archivo");
            ex.printStackTrace();
        }
        
        
    }
    
    
    
    
    
}

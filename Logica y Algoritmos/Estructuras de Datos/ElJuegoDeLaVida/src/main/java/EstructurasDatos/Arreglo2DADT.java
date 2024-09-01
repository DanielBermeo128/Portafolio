package EstructurasDatos;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Daniel Bermeo
 */
public class Arreglo2DADT<T> {

    private ArregloADT renglones ; 
    private ArregloADT columnas;
    private int renTamanhio, colTamanhio;
    
    
    public Arreglo2DADT(int ren, int col){
        
        renglones = new ArregloADT(ren);
        columnas  = new ArregloADT(col);
        this.renTamanhio = ren;
        this.colTamanhio = col;
        
        for(int r=0; r<renTamanhio ; r++){
           ArregloADT listaLlenado = new ArregloADT(colTamanhio);
            for(int c=0 ; c<colTamanhio ; c++){
                listaLlenado.setElemento(null,c);
            }
            renglones.setElemento(listaLlenado, r);   
        }
    }
    
    public void limpiar(T t){
        for(int r=0; r<renTamanhio ; r++){
            for(int c=0 ; c<colTamanhio ; c++){
                columnas.setElemento(t,c);
            }
            renglones.setElemento(columnas, r);
        }
    }
    
    public int getTamanhioRen(){
        return this.renTamanhio;
    }
    
    public int getTamanhioCol(){
        return this.colTamanhio;
    }
    
    public void setElemento(int r,int c,T dato){
        if(comprobarLimite(r,c)){
            ArregloADT cambioVariable = (ArregloADT) renglones.getElemento(r);
            cambioVariable.setElemento(dato, c);
            renglones.setElemento(cambioVariable, r);
           
        }
        
    }
    
    public T getElemento(int r, int c){
        if(comprobarLimite(r, c)){
            ArregloADT cambioVariable = (ArregloADT) renglones.getElemento(r);
            return (T) cambioVariable.getElemento(c);
        }else{
            return null;
        }
        
    }
    
    @Override
    public String toString(){
        return renglones.toString();
    }
    
    
    
    private boolean comprobarLimite(int r, int c){
        return (r<this.renTamanhio && c<colTamanhio);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rk.eljuegodelavida;

/**
 * 
 * @author Daniel Bermeo
 */
public class Celula {

    private int vecinos, xCord, yCord;
    private boolean estado;
    
    public Celula(int xCord, int yCord, boolean estado){
        this.xCord = xCord;
        this.yCord = yCord;
        this.estado = estado;

    }

    public void setVecinos(int vecinos) {
        this.vecinos = vecinos;
    }

    public void setxCord(int xCord) {
        this.xCord = xCord;
    }

    public void setyCord(int yCord) {
        this.yCord = yCord;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getVecinos() {
        return vecinos;
    }

    public int getxCord() {
        return xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public boolean isEstado() {
        return estado;
    }
    
    @Override
    public String toString(){
        String es ;
        if(estado){
            es = "   O   ";
        }else{
            es = "   X   ";
        }
        return es;
    }
    
    
}

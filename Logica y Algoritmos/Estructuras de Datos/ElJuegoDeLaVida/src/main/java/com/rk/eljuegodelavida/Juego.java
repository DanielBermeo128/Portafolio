/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rk.eljuegodelavida;

import EstructurasDatos.ArregloADT;
import EstructurasDatos.Arreglo2DADT;
import java.util.ArrayList;

/**
 *
 * @author Daniel Bermeo
 */
public class Juego {

    Arreglo2DADT<Celula> tablero;
    Margen margen;
    ArrayList<int[]> alive;

    public Juego(int r, int c, ArrayList<int[]> alive) {

        tablero = new Arreglo2DADT(r, c);
        margen = new Margen(c, r);
        this.alive = alive;

        for (int x = 0; margen.margenX(x); x++)
        {
            for (int y = 0; margen.margenY(y); y++)
            {
                Celula tmp = new Celula(x, y, isAlive(x, y));
                tablero.setElemento(y, x, tmp);
            }
        }
        actualizarVecinos(tablero.getTamanhioCol(), tablero.getTamanhioRen());

    }
    
    
    // quiza cambie el estado de la generacion actual
    public void siguienteGen(){
        
         for (int x = 0; margen.margenX(x); x++)
        {
            for (int y = 0; margen.margenY(y); y++)
            {
                Celula tmp = tablero.getElemento(y, x);
                if(tmp.getVecinos()>=4 && tmp.isEstado()){
                    tmp.setEstado(false);
                }else if(tmp.getVecinos() >= 2 && tmp.isEstado()){
                    tmp.setEstado(true);
                }else if(tmp.getVecinos()<=1 && tmp.isEstado()){
                    tmp.setEstado(false);
                }else if(tmp.getVecinos() == 3 && !(tmp.isEstado())){
                    tmp.setEstado(true);
                }
            }
        }
        
       
    }
    
    public Arreglo2DADT getGeneracion(){
        return tablero;
    }

    public int numVecinos(int x, int y) {
        int vecinosV = 0;
        Celula tmp;
        if (margen.dentroMargen(x, y))
        {
            for (int x1 = x - 1; x1 <= x + 1; x1++)
            {
                for (int y1 = y - 1; y1 <= y + 1; y1++)
                {
                    tmp = tablero.getElemento(y1, x1);
                   
                    if (tmp.isEstado() && (!(y1 == y && x1 == x)))
                    {
                        
                        vecinosV++;
                    }
                }
              

            }

        } else
        {

            for (int x2 = margen.getContadorX(x, y); x2 < margen.getLimiteX(x, y); x2++)
            {
                for (int y2 = margen.getContadorY(x, y); y2 < margen.getLimiteY(x, y); y2++)
                {
                    tmp = tablero.getElemento(y2, x2);
                   
                    if (tmp.isEstado() && (!(y2 == y && x2 == x)))
                    {
                        vecinosV++;
                    }
                }
               
            }
        }
        return vecinosV;
    }

    public boolean isAlive(int x, int y) {
        boolean estado = false;
        for (int cnt = 0; cnt < alive.size(); cnt++)
        {
            int[] comp = alive.get(cnt);
            if (comp[0] == x && comp[1] == y)
            {
                estado = true;
            }
        }
        return estado;
    }

    public void actualizarVecinos(int xL, int yL) {
        Celula tmp;
        for (int x = 0; margen.margenX(x); x++)
        {
            for (int y = 0; margen.margenY(y); y++)
            {
                tmp = tablero.getElemento(y, x);
                tmp.setVecinos(numVecinos(x, y));
            }
            
        }
    }

}

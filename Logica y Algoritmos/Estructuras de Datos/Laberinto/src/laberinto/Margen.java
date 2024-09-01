
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
public class Margen {
    
    private int xLenght, yLenght;
    
    public Margen(int xL, int yL){
        this.xLenght = xL;
        this.yLenght = yL;
    }
    public boolean margenX(int x){
        return (x>=0&&x<xLenght);
    }
    
    public boolean margenY(int y){
        return (y>=0&&y<yLenght);
    }
    
    public boolean isEsquina(int x, int y){
        
        //if((x==0 && (y==0 || y==yLenght-1))&&((x==xLenght-1)&&(y==0&&y==yLenght-1)))
        return (x==0||(x==xLenght-1)) && (y==0 || y==yLenght-1);
        
    }
    
    public boolean dentroMargen(int x, int y){
        return ((x>0&&x<xLenght-1)&&(y>0&&y<yLenght-1));
        
    }
    
    public boolean isMargen(int x, int y){
        return !((x>0&&x<xLenght-1)&&(y>0&&y<yLenght-1));
    }
    
    public int getContadorX(int x, int y){
        if(x==0){
            return x;
        }else{
            return x-1;
        }
    }
    
    public int getLimiteX(int x, int y){
        if(x==xLenght-1){
            return x+1;
        }else{
            return x+2;
        }
    }
    
    public int getContadorY(int x, int y){
        if(y==0){
            return y;
        }else{
            return y-1;
        }
    }
    
    public int getLimiteY(int x, int y){
        if(y==yLenght-1){
            return y+1;
        }else{
            return y+2;
            
        }
    }
}

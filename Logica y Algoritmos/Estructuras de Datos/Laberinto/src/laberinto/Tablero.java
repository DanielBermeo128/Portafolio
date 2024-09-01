/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberinto;

import ADTs.Arreglo2DADT;
import ADTs.ListaDobleLigadaADT;
import ADTs.PilaADT;
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
public class Tablero {

    private Arreglo2DADT tablero;
    private PilaADT caminoSalida = new PilaADT();
    private int[] salidaCord = new int[2], entradaCord = new int[2];
    private Margen margen;

    public Tablero(String ruta) {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            int col, ren;

            col = Integer.parseInt(br.readLine());
            ren = Integer.parseInt(br.readLine());

            margen = new Margen(col, ren);
            tablero = new Arreglo2DADT(ren, col);

            for (int contRen = 0; contRen < ren; contRen++)
            {
                String lineaActual = br.readLine();
                String[] divisiones = lineaActual.split(",");

                for (int contCol = 0; contCol < col; contCol++)
                {
                    String caracterActual = divisiones[contCol];
                    if (caracterActual.equals("0"))
                    {
                        tablero.setElemento(contRen, contCol, false);
                    } else if (caracterActual.equals("1"))
                    {
                        tablero.setElemento(contRen, contCol, true);
                    } else if (caracterActual.equals("E"))
                    {
                        tablero.setElemento(contRen, contCol, true);
                        entradaCord[0] = contRen;
                        entradaCord[1] = contCol;
                    } else if (caracterActual.equals("S"))
                    {
                        tablero.setElemento(contRen, contCol, true);
                        salidaCord[0] = contRen;
                        salidaCord[1] = contCol;
                    }
                }
            }

        } catch (FileNotFoundException ex)
        {
            System.out.println("Error en la lectura del archivo");
        } catch (IOException ex)
        {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void recorrerTablero() {

        int[] posicionActual = entradaCord, indeterminacion =
        {
            -1, -1
        };
        int[] posicionAnterior = posicionActual;

        boolean centinela = true;

        caminoSalida.push(posicionActual);

        do
        {

            int[] nuevaPosicion = nextStep(posicionActual, posicionAnterior);
            posicionAnterior = posicionActual;
            posicionActual = nuevaPosicion;

            if (compararCordenadas(posicionActual, salidaCord))
            {
                caminoSalida.push(posicionActual);
                centinela = false;
            } else if (compararCordenadas(posicionActual, indeterminacion))
            {

                int[] eliminar = (int[]) caminoSalida.pop();
                tablero.setElemento(eliminar[0], eliminar[1], false);
                posicionActual = (int[]) caminoSalida.pop();
                posicionAnterior = (int[]) caminoSalida.peek();
                caminoSalida.push(posicionActual);

                if (compararCordenadas(eliminar, entradaCord))
                {
                    centinela = false;
                    caminoSalida = null;
                }
            } else
            {
                caminoSalida.push(posicionActual);
            }

        } while (centinela);

    }

    private int[] nextStep(int[] cordActual, int[] cordAnterior) {

        int xCol = cordActual[1], yRen = cordActual[0];
        int[] nuevasCord = null;
        boolean[] dependencia = new boolean[4];
        boolean posicion = false;

        dependencia = saltarCeros(yRen, xCol);
        for (int paso = 0; paso <= 4; paso++)
        {
            if (paso < 4)
            {
                if (dependencia[paso])
                {
                    nuevasCord = aplicarReglas(paso, yRen, xCol);
                    posicion = (boolean) tablero.getElemento(nuevasCord[0], nuevasCord[1]);
                    if (posicion && !compararCordenadas(nuevasCord, cordAnterior))
                    {
                        break;
                    }
                } else
                {
                    continue;
                }
            } else
            {
                nuevasCord[0] = -1;
                nuevasCord[1] = -1;
            }

        }

        return nuevasCord;
    }

    private boolean[] saltarCeros(int ren, int col) {

        boolean[] dependencia =
        {
            true, true, true, true
        };
        if (ren == 0)
        {
            dependencia[1] = false;
        } else if (ren == tablero.getTamanhioRen() - 1)
        {
            dependencia[3] = false;
        }

        if (col == 0)
        {
            dependencia[0] = false;
        } else if (col == tablero.getTamanhioCol() - 1)
        {
            dependencia[2] = false;
        }

        return dependencia;

    }

    public int[] aplicarReglas(int paso, int ren, int col) {
        int[] nuevasCord = new int[2];

        if (paso == 0)
        {

            nuevasCord[0] = ren;
            nuevasCord[1] = col - 1;

        } else if (paso == 1)
        {

            nuevasCord[0] = ren - 1;
            nuevasCord[1] = col;

        } else if (paso == 2)
        {

            nuevasCord[0] = ren;
            nuevasCord[1] = col + 1;

        } else if (paso == 3)
        {

            nuevasCord[0] = ren + 1;
            nuevasCord[1] = col;

        }
        return nuevasCord;
    }

    private boolean compararCordenadas(int[] nuevasCord, int[] cordAnterior) {
        return (nuevasCord[0] == cordAnterior[0]) && (nuevasCord[1] == cordAnterior[1]);
    }

    public void imprimirSolucion() {
        if (caminoSalida == null)
        {
            System.out.println("Sin camino de salida");
        } else
        {
            System.out.printf("La solucion es a %d pasos\n\nCamino de salida:\n\n", caminoSalida.getLenght());
            PilaADT pilaRecargable = new PilaADT();
            while (caminoSalida.getLenght() != 0)
            {
                int[] cord = (int[]) caminoSalida.pop();
                pilaRecargable.push(cord);

                System.out.printf("\t %d,%d \n", cord[0], cord[1]);
                System.out.println("\t_____\t");
            }

            caminoSalida = pilaRecargable;

            System.out.println("\n\n\nGraficamente: ");
            tableroDeSolucion();
            imprimirTablero();
        }
    }

    public void imprimirTablero() {
        for (int contRen = 0; contRen < tablero.getTamanhioRen(); contRen++)
        {
            for (int contCol = 0; contCol < tablero.getTamanhioCol(); contCol++)
            {
                int[] detectarEyS =
                {
                    contRen, contCol
                };

                if ((boolean) tablero.getElemento(contRen, contCol))
                {
                    if (compararCordenadas(entradaCord, detectarEyS))
                    {
                        System.out.print(" E ");
                    } else if (compararCordenadas(salidaCord, detectarEyS))
                    {
                        System.out.print(" S ");
                    } else
                    {
                        System.out.print(" ○ ");
                    }
                } else
                {
                    System.out.print(" ◙ ");
                }
            }
            System.out.println("");
        }
    }

    public void tableroDeSolucion() {
        Arreglo2DADT tableroFinal = new Arreglo2DADT(tablero.getTamanhioRen(), tablero.getTamanhioCol());

        for (int contRen = 0; contRen < tableroFinal.getTamanhioRen(); contRen++)
        {
            

            for (int contCol = 0; contCol < tableroFinal.getTamanhioCol(); contCol++)
            {
                if(enSolucion(contRen,contCol)){
                    tableroFinal.setElemento(contRen, contCol, true);
                }else{
                    tableroFinal.setElemento(contRen, contCol, false);
                }
            }
        }
        
        tablero = tableroFinal;
    }

    private boolean enSolucion(int r,int c){
    
        boolean centinela = false;
        int[] actual = {r,c};
        PilaADT pilaRecargable = new PilaADT();
         
        while(caminoSalida.getLenght()!=0){
            int[] cord = (int[]) caminoSalida.pop();
            pilaRecargable.push(cord);
            if(compararCordenadas(cord,actual)){
                centinela = true;
            }
            
        }
        
        caminoSalida = pilaRecargable;
        return centinela;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlecitytry1;

import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Juanc
 */
public class Tanque {
    Image tanquearriba;
    Image tanqueabajo;
    Image tanquederecha;
    Image tanqueizquierda;
    int balasdisparadas;
    int balalimit = 1;
    //Bala[] balas;
    ArrayList<Bala> balas = new ArrayList<Bala>();
    
    public Tanque(){
        this.tanquearriba = (new ImageIcon("Recursos/TanqueArriba.png")).getImage();
        this.tanqueabajo = (new ImageIcon("Recursos/TanqueAbajo.png")).getImage();
        this.tanquederecha = (new ImageIcon("Recursos/TanqueDerecha.png")).getImage();
        this.tanqueizquierda = (new ImageIcon("Recursos/TanqueIzquierda.png")).getImage();
        this.balasdisparadas = 0;
    }
    /**
     * metodo que dibuja el tanque dependiendo de la direccion a la que
     * mira y de la posicion 
     * @param g
     * @param x
     * @param y
     * @param dir 
     */
    public void drawTanque(Graphics g, int x, int y, int dir){
        
        switch(dir)
        {
            case 1: //Arriba
                g.drawImage(tanquearriba, x, y, 40, 40, null);
                break;
            case 2: //Abajo
                g.drawImage(tanqueabajo, x, y, 40, 40, null);
                break;
            case 3: //Derecha
                g.drawImage(tanquederecha, x, y, 40, 40, null);
                break;
            case 4: //Izquierda
                g.drawImage(tanqueizquierda, x, y, 40, 40, null);
                break;
        }
        
    }
    /**
     * crea una nueva bala para el vector de balas correspondiente 
     * al tanque
     * @param x
     * @param y
     * @param dir 
     */
    public void Disparar(int x, int y, int dir){
        
        //System.out.println(balasdisparadas);
        //balasdisparadas++;
        if(balasdisparadas < balalimit)
        {
            balas.add(new Bala(x,y,dir));
        }
            
    }
    
}

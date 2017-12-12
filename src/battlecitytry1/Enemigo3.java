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
public class Enemigo3 {
    Image enemigoarriba;
    Image enemigoabajo;
    Image enemigoderecha;
    Image enemigoizquierda;
    int x;
    int y;
    int dir;
    boolean vivo;
    boolean act;
    int tact = 4;
    ArrayList<Bala> balas = new ArrayList<Bala>();
    
    public Enemigo3(int stage, boolean act){
        this.enemigoarriba = (new ImageIcon("Recursos/EnemigoArriba.png")).getImage();
        this.enemigoabajo = (new ImageIcon("Recursos/EnemigoAbajo.png")).getImage();
        this.enemigoderecha = (new ImageIcon("Recursos/EnemigoDerecha.png")).getImage();
        this.enemigoizquierda = (new ImageIcon("Recursos/EnemigoIzquierda.png")).getImage();
        this.vivo = true;
        this.act = act;
        switch(stage)
        {
            case 1:
                this.x = 610;
                this.y = 175;
                this.dir = 4;
                break;
            case 2:
                this.x = 610;
                this.y = 225;
                this.dir = 4;
                break;
            case 3:
                this.x = 610;
                this.y = 25;
                this.dir = 2;
                break;
            
        }
        
    }
    
    public void drawEnemigo(Graphics g){
        if(vivo == true)
        {
            switch(dir)
            {
                case 1: //Arriba
                    g.drawImage(enemigoarriba, x, y, 40, 40, null);
                    break;
                case 2: //Abajo
                    g.drawImage(enemigoabajo, x, y, 40, 40, null);
                    break;
                case 3: //Derecha
                    g.drawImage(enemigoderecha, x, y, 40, 40, null);
                    break;
                case 4: //Izquierda
                    g.drawImage(enemigoizquierda, x, y, 40, 40, null);
                    break;
            }
        }
        
    }
    
    public void enemigoLife()
    {
        boolean up;
        boolean down;
        boolean right;
        boolean left;
        if(act == false){
            vivo = false;
            x = 0;
            y = 0;
        }
        else
        {
            if(tact > 5)
            {
                        up = y > 30 && BattleCityTry1.mapa.PuedeEnemigo3(x, y - 1) && BattleCityTry1.mapa.PuedeEnemigo3(x + 39,y - 1);
                        down = y < 580 && BattleCityTry1.mapa.PuedeEnemigo3(x, y + 39 + 1) && BattleCityTry1.mapa.PuedeEnemigo3(x + 39, y + 39 + 1);
                        right = x < 609 && BattleCityTry1.mapa.PuedeEnemigo3(x + 1 + 39, y) && BattleCityTry1.mapa.PuedeEnemigo3(x + 1 + 39, y + 39);
                        left = x > 51 && BattleCityTry1.mapa.PuedeEnemigo3(x - 1, y) && BattleCityTry1.mapa.PuedeEnemigo3(x - 1, y + 39);
                        if(left == true)
                        {
                            x--;
                            dir = 4;

                        }
                        else
                        {
                            if(down == true)
                            {
                                y++;
                                dir = 2;
                            }
                            else
                            {
                                if(up == true)
                                {
                                    y--;
                                    dir = 1;
                                }
                                else
                                {
                                    x++;
                                    dir = 3;
                                }

                            }
                        }
            }
            else
                if(tact > 3 && tact < 5)
                {
                    x = x;
                    y = y;
                    dir = dir;
                }
                else
                {
                    if(tact < 3)
                    {
                        up = y > 30 && BattleCityTry1.mapa.PuedeEnemigo3(x, y - 1) && BattleCityTry1.mapa.PuedeEnemigo3(x + 39,y - 1);
                        down = y < 580 && BattleCityTry1.mapa.PuedeEnemigo3(x, y + 39 + 1) && BattleCityTry1.mapa.PuedeEnemigo3(x + 39, y + 39 + 1);
                        right = x < 609 && BattleCityTry1.mapa.PuedeEnemigo3(x + 1 + 39, y) && BattleCityTry1.mapa.PuedeEnemigo3(x + 1 + 39, y + 39);
                        left = x > 51 && BattleCityTry1.mapa.PuedeEnemigo3(x - 1, y) && BattleCityTry1.mapa.PuedeEnemigo3(x - 1, y + 39);
                        if(left == true)
                        {
                            x--;
                            dir = 4;

                        }
                        else
                        {
                            if(up == true)
                            {
                                y--;
                                dir = 1;
                            }
                            else
                            {
                                if(right == true)
                                {
                                    x++;
                                    dir = 3;
                                }
                                else
                                {
                                    y++;
                                    dir = 2;
                                }

                            }
                        }
                    }

                }
        }
        
    }
    
    public void enemigoTactic()
    {
        
        tact = (int) (Math.random()*10); //0-2
        //System.out.println(tact);
    
    }
    
}

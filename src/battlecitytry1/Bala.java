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
import javax.swing.ImageIcon;

/**
 *
 * @author Juanc
 */
public class Bala {
    int x;
    int y;
    int dir;
    boolean sw;
    //int i;
    
    
    public Bala(int x, int y, int dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.sw = true;
        //this.i = i;
    }
    /**
     * Grafica la bala mientras verifica que pueda seguir por ese camino y disminuye 
     * el contador de balas disparadas.
     * @param g
     * @throws InterruptedException 
     */
    public void drawBala(Graphics g)
    {
        g.setColor(Color.white);
        
        if(sw == true)
        {
            switch(dir)
            {
                case 1:
                    if(y - 1 > 25 && BattleCityTry1.mapa.PuedeBala(x+22, y) == true)
                    {
                        y--;
                        g.fillOval(x+18, y, 5, 5);                    
                    }
                    else
                    {
                        sw = false;
                        BattleCityTry1.tanque.balasdisparadas--;
                        //BattleCityTry1.tanque.balas[i] = null;
                    }              
                    break;

                case 2:
                    if(y + 6 < 575 && BattleCityTry1.mapa.PuedeBala(x+22, y+50) == true)
                    {
                        y++;
                        g.fillOval(x+18, y+40, 5, 5);
                    }
                    else
                    {
                        sw = false;
                        BattleCityTry1.tanque.balasdisparadas--;
                        //BattleCityTry1.tanque.balas[i] = null;
                    } 
                    break;

                case 3:
                    if(x + 6 < 600 && BattleCityTry1.mapa.PuedeBala(x+50, y+22) == true)
                    {
                        x++;
                        g.fillOval(x+40, y+18, 5, 5);
                    }
                    else
                    {
                        sw = false;
                        BattleCityTry1.tanque.balasdisparadas--;
                        //BattleCityTry1.tanque.balas[i] = null;
                    } 
                    break;

                case 4:
                    if(x - 1 > 50 && BattleCityTry1.mapa.PuedeBala(x, y+22) == true)
                    {
                        x--;
                        g.fillOval(x, y+18, 5, 5);
                    }
                    else
                    {
                        sw = false;
                        BattleCityTry1.tanque.balasdisparadas--;
                        //BattleCityTry1.tanque.balas[i] = null;
                    } 
                    break;
            }
        }
            
    }
    /**
     * Grafica la bala mientras verifica que pueda seguir por ese camino y disminuye 
     * el contador de balas disparadas.
     * @param g
     * @throws InterruptedException 
     */
    public void drawBalaEnemiga(Graphics g) throws InterruptedException
    {
        g.setColor(Color.white);
        
        if(sw == true)
        {
            switch(dir)
            {
                case 1:
                    if(y - 1 > 25 && BattleCityTry1.mapa.PuedeBalaEnemiga(x+22, y) == true)
                    {
                        y--;
                        g.fillOval(x+18, y, 5, 5);                    
                    }
                    else
                    {
                        sw = false;
                        BattleCityTry1.enemigo1.balasdisparadas--;
                        //BattleCityTry1.tanque.balas[i] = null;
                    }              
                    break;

                case 2:
                    if(y + 6 < 575 && BattleCityTry1.mapa.PuedeBalaEnemiga(x+22, y+50) == true)
                    {
                        y++;
                        g.fillOval(x+18, y+40, 5, 5);
                    }
                    else
                    {
                        sw = false;
                        BattleCityTry1.enemigo1.balasdisparadas--;
                        //BattleCityTry1.tanque.balas[i] = null;
                    } 
                    break;

                case 3:
                    if(x + 6 < 600 && BattleCityTry1.mapa.PuedeBalaEnemiga(x+50, y+22) == true)
                    {
                        x++;
                        g.fillOval(x+40, y+18, 5, 5);
                    }
                    else
                    {
                        sw = false;
                        BattleCityTry1.enemigo1.balasdisparadas--;
                        //BattleCityTry1.tanque.balas[i] = null;
                    } 
                    break;

                case 4:
                    if(x - 1 > 50 && BattleCityTry1.mapa.PuedeBalaEnemiga(x, y+22) == true)
                    {
                        x--;
                        g.fillOval(x, y+18, 5, 5);
                    }
                    else
                    {
                        sw = false;
                        BattleCityTry1.enemigo1.balasdisparadas--;
                        //BattleCityTry1.tanque.balas[i] = null;
                    } 
                    break;
            }
        }
            
    }
    
    public void drawBalaEnemiga2(Graphics g) throws InterruptedException
    {
        g.setColor(Color.white);
        
        if(sw == true)
        {
            switch(dir)
            {
                case 1:
                    if(y - 1 > 25 && BattleCityTry1.mapa.PuedeBalaEnemiga(x+22, y) == true)
                    {
                        y--;
                        g.fillOval(x+18, y, 5, 5);                    
                    }
                    else
                    {
                        sw = false;
                        BattleCityTry1.enemigo2.balasdisparadas--;
                        //BattleCityTry1.tanque.balas[i] = null;
                    }              
                    break;

                case 2:
                    if(y + 6 < 575 && BattleCityTry1.mapa.PuedeBalaEnemiga(x+22, y+50) == true)
                    {
                        y++;
                        g.fillOval(x+18, y+40, 5, 5);
                    }
                    else
                    {
                        sw = false;
                        BattleCityTry1.enemigo2.balasdisparadas--;
                        //BattleCityTry1.tanque.balas[i] = null;
                    } 
                    break;

                case 3:
                    if(x + 6 < 600 && BattleCityTry1.mapa.PuedeBalaEnemiga(x+50, y+22) == true)
                    {
                        x++;
                        g.fillOval(x+40, y+18, 5, 5);
                    }
                    else
                    {
                        sw = false;
                        BattleCityTry1.enemigo2.balasdisparadas--;
                        //BattleCityTry1.tanque.balas[i] = null;
                    } 
                    break;

                case 4:
                    if(x - 1 > 50 && BattleCityTry1.mapa.PuedeBalaEnemiga(x, y+22) == true)
                    {
                        x--;
                        g.fillOval(x, y+18, 5, 5);
                    }
                    else
                    {
                        sw = false;
                        BattleCityTry1.enemigo2.balasdisparadas--;
                        //BattleCityTry1.tanque.balas[i] = null;
                    } 
                    break;
            }
        }
            
    }
}

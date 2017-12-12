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
public class Mapa {
    Image ladrillo;
    Image ladrilloroto;
    Image acero;
    Image acerodebil;
    Image acerodebil2;
    Image base;
    Image basedestruida;
    Image bosque;
    Image agua;
    Font fuente;
    int[][] stageselected;
    
    int[][] stage1 = new int[][]{
        { 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2 },
        { 1, 3, 1, 0, 0, 0, 1, 1, 1, 1, 0, 2 },
        { 0, 1, 3, 1, 0, 0, 1, 0, 3, 1, 2, 2 },
        { 0, 0, 1, 0, 3, 2, 1, 3, 0, 1, 0, 0 },
        { 0, 0, 0, 0, 2, 0, 1, 2, 1, 1, 0, 0 },
        { 0, 0, 1, 1, 2, 1, 0, 2, 0, 0, 0, 0 },
        { 0, 0, 1, 0, 3, 1, 2, 3, 0, 0, 0, 0 },
        { 2, 2, 2, 3, 0, 1, 0, 0, 1, 1, 0, 0 },
        { 2, 0, 1, 1, 1, 1, 0, 0, 1, 2, 2, 0 },
        { 2, 0, 0, 2, 0, 0, 0, 0, 0, 2, 1, 1 },
        { 3, 2, 2, 2, 0, 1, 1, 1, 0, 0, 1, 2 },
        { 0, 0, 0, 0, 0, 1, 5, 1, 0, 0, 0, 2 }
    };
    
    int[][] stage2 = new int[][]{
        { 4, 4, 0, 4, 0, 4, 4, 4, 4, 0, 4, 4 },
        { 3, 3, 1, 0, 0, 1, 0, 0, 4, 0, 4, 3 },
        { 3, 4, 4, 4, 4, 0, 2, 0, 0, 1, 3, 3 },
        { 3, 3, 0, 4, 0, 0, 4, 0, 4, 4, 4, 4 },
        { 4, 4, 0, 4, 0, 4, 4, 0, 0, 4, 0, 0 },
        { 0, 0, 1, 3, 1, 0, 1, 3, 0, 4, 0, 0 },
        { 0, 4, 4, 3, 4, 4, 4, 4, 0, 3, 1, 0 },
        { 1, 0, 0, 1, 0, 0, 4, 0, 3, 3, 4, 0 },
        { 4, 4, 0, 4, 4, 0, 4, 1, 4, 4, 4, 0 },
        { 0, 0, 1, 0, 3, 3, 0, 0, 3, 4, 0, 0 },
        { 0, 4, 4, 4, 3, 1, 1, 1, 0, 4, 0, 4 },
        { 0, 4, 0, 0, 0, 1, 5, 1, 0, 0, 0, 0 }
    };
    
    int[][] stage3 = new int[][]{
        { 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0 },
        { 3, 0, 0, 3, 1, 3, 1, 3, 0, 0, 3, 0 },
        { 1, 3, 3, 1, 1, 1, 1, 1, 3, 3, 1, 3 },
        { 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 3 },
        { 4, 4, 4, 1, 1, 1, 1, 1, 4, 4, 4, 3 },
        { 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4 },
        { 1, 1, 1, 4, 1, 1, 1, 4, 1, 1, 1, 3 },
        { 1, 1, 4, 4, 4, 1, 4, 4, 4, 1, 1, 4 },
        { 3, 4, 4, 3, 3, 3, 3, 3, 4, 4, 3, 4 },
        { 0, 3, 3, 0, 0, 0, 0, 0, 3, 3, 0, 3 },
        { 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 1, 5, 1, 0, 0, 0, 0 }
    };
    
    public Mapa(int stage){
        this.ladrillo = (new ImageIcon("Recursos/Ladrillo.png")).getImage();
        this.ladrilloroto = (new ImageIcon("Recursos/LadrilloRoto.png")).getImage();
        this.acero = (new ImageIcon("Recursos/Acero.png")).getImage();
        this.acerodebil = (new ImageIcon("Recursos/AceroDebil.png")).getImage();
        this.base = (new ImageIcon("Recursos/Base.png")).getImage();
        this.basedestruida = (new ImageIcon("Recursos/BaseDestruida.png")).getImage();
        this.bosque = (new ImageIcon("Recursos/Bosque.png")).getImage();
        this.agua = (new ImageIcon("Recursos/Agua.png")).getImage();
        this.acerodebil2 = (new ImageIcon("Recursos/AceroDebil2.png")).getImage();
        try {
            GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Recursos/PressStart2P.ttf")));
        } catch (IOException|FontFormatException e) {
            e.printStackTrace();
        }
        this.fuente=new Font("Press Start 2P", Font.PLAIN, 26);
        switch(stage)
        {
            case 1:
                stageselected = stage1;
                break;
            case 2:
                stageselected = stage2;
                break;
            case 3:
                stageselected = stage3;
                break;
        }
    }
    
    public void Marco(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 800, 25); //Superior
        g.fillRect(0, 625, 800, 25); //Inferior
        g.fillRect(0, 0, 50, 650); //Izquierdo
        g.fillRect(650, 0, 150, 650); //Derecho
    }
    /**
     * Metodo que recorre la matriz de escenario para graficar el nivel dependiendo
     * del valor de la celda
     * @param g
     * @throws InterruptedException 
     */
    public void drawStage(Graphics g) throws InterruptedException{
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                switch(stageselected[i][j])
                {
                    case 1:
                        g.drawImage(ladrillo, j*50+50, i*50+25, 50, 50, null);
                        break;
                    case 2:
                        g.drawImage(acero, j*50+50, i*50+25, 50, 50, null);
                        break;
                    case 3:
                        g.drawImage(bosque, j*50+50, i*50+25, 50, 50, null);
                        break;
                    case 4:
                        g.drawImage(agua, j*50+50, i*50+25, 50, 50, null);
                        break;
                    case 5:
                        g.drawImage(base, j*50+50, i*50+25, 50, 50, null);
                        break;
                    case 6:
                        g.drawImage(ladrilloroto, j*50+50, i*50+25, 50, 50, null);
                        break;
                    case 7:
                        g.drawImage(acerodebil, j*50+50, i*50+25, 50, 50, null);
                        break;
                    case 8:
                        g.drawImage(basedestruida, j*50+50, i*50+25, 50, 50, null);
                    case 9:
                        g.drawImage(acerodebil2, j*50+50, i*50+25, 50, 50, null);    
                        
                        break;
                }
            }
        }
    }
    /**
     * Metodo que devuelve un valor booleano que indica si el tanque puede seguir
     * por ese camino
     * @param x
     * @param y
     * @return 
     */
    public boolean Puede(int x, int y){ //PuedeTanque
        boolean Poder;
        
        int j = (x - 50)/50;
        int i = (y - 25)/50;
        if(stageselected[i][j] == 0 || stageselected[i][j] == 3)
        {
            if(((x > BattleCityTry1.enemigo1.x && y > BattleCityTry1.enemigo1.y)
                    && (x < BattleCityTry1.enemigo1.x + 40 && y < BattleCityTry1.enemigo1.y + 40)) 
                    || ((x > BattleCityTry1.enemigo2.x && y > BattleCityTry1.enemigo2.y)
                        && (x < BattleCityTry1.enemigo2.x + 40 && y < BattleCityTry1.enemigo2.y + 40))
                        || ((x > BattleCityTry1.enemigo3.x && y > BattleCityTry1.enemigo3.y)
                            && (x < BattleCityTry1.enemigo3.x + 40 && y < BattleCityTry1.enemigo3.y + 40))){
                Poder = false;
            }else{
                Poder = true;
            }
        }
        else
        {
            Poder = false;
        }    
        
        return Poder;
    }
    /**
     * Metodo para verificar si la bala disparada por el jugador choca con un obstaculo
     * o con un enemigo. Se efectuan las respectivas repercusiones.
     * @param x
     * @param y
     * @return 
     */
    public boolean PuedeBala(int x, int y){
        boolean Poder;
        
        int j = (x - 50)/50;
        int i = (y - 25)/50;
        if(stageselected[i][j] == 0 || stageselected[i][j] == 3 || stageselected[i][j] == 4)
        {
            if(((x > BattleCityTry1.enemigo1.x && y > BattleCityTry1.enemigo1.y)
                    && (x < BattleCityTry1.enemigo1.x + 40 && y < BattleCityTry1.enemigo1.y + 40)) 
                    || ((x > BattleCityTry1.enemigo2.x && y > BattleCityTry1.enemigo2.y)
                        && (x < BattleCityTry1.enemigo2.x + 40 && y < BattleCityTry1.enemigo2.y + 40))
                        || ((x > BattleCityTry1.enemigo3.x && y > BattleCityTry1.enemigo3.y)
                            && (x < BattleCityTry1.enemigo3.x + 40 && y < BattleCityTry1.enemigo3.y + 40))){
                Poder = false;
                
                if((x > BattleCityTry1.enemigo1.x && y > BattleCityTry1.enemigo1.y)
                    && (x < BattleCityTry1.enemigo1.x + 40 && y < BattleCityTry1.enemigo1.y + 40))
                {
                    BattleCityTry1.enemigo1.vivo = false;
                    BattleCityTry1.puntuacion = BattleCityTry1.puntuacion + 500;
                }
                
                if((x > BattleCityTry1.enemigo2.x && y > BattleCityTry1.enemigo2.y)
                    && (x < BattleCityTry1.enemigo2.x + 40 && y < BattleCityTry1.enemigo2.y + 40))
                {
                    BattleCityTry1.enemigo2.vivo = false;
                    BattleCityTry1.puntuacion = BattleCityTry1.puntuacion + 500;
                }
                
                if((x > BattleCityTry1.enemigo3.x && y > BattleCityTry1.enemigo3.y)
                    && (x < BattleCityTry1.enemigo3.x + 40 && y < BattleCityTry1.enemigo3.y + 40))
                {
                    BattleCityTry1.enemigo3.vivo = false;
                    BattleCityTry1.puntuacion = BattleCityTry1.puntuacion + 500;
                }
                
            }else{
                Poder = true;
            }
            
        }
        else
        {
            Poder = false;
            switch(stageselected[i][j])
            {
                case 1:
                    stageselected[i][j] = 6;
                    break;
                case 6:
                    stageselected[i][j] = 0;
                    if(BattleCityTry1.puntuacion > 99)
                    {
                        BattleCityTry1.puntuacion = BattleCityTry1.puntuacion - 100;
                    }
                    
                    break;
                case 2:
                    stageselected[i][j] = 7;
                    
                    break;
                case 7:
                    stageselected[i][j] = 9;
                    if(BattleCityTry1.puntuacion > 99)
                    {
                        BattleCityTry1.puntuacion = BattleCityTry1.puntuacion - 100;
                    }
                    break;
                case 5:
                    stageselected[i][j] = 8;
                    BattleCityTry1.game = 1;
                    BattleCityTry1.puntuacion = 0;
                    BattleCityTry1.y = 475;
                    BattleCityTry1.x = 350;
                    BattleCityTry1.dir = 1;
                    BattleCityTry1.loser = true;
                    break;
                case 9:
                    stageselected[i][j] = 0;
                    if(BattleCityTry1.puntuacion > 99)
                    {
                        BattleCityTry1.puntuacion = BattleCityTry1.puntuacion - 100;
                    }
                    break;
            }   
        }    
        return Poder;
    }
    
    /**
     * Metodo que sirve para verificar si la trayectoria de la bala de un enemigo
     * choca con un obstaculo o con el tanque del jugador. Se efectuan las respectivas
     * repercusiones
     * @param x
     * @param y
     * @return
     * @throws InterruptedException 
     */
    public boolean PuedeBalaEnemiga(int x, int y) throws InterruptedException{
        boolean Poder;
        
        int j = (x - 50)/50;
        int i = (y - 25)/50;
        if(stageselected[i][j] == 0 || stageselected[i][j] == 3 || stageselected[i][j] == 4)
        {
            if(((x > BattleCityTry1.x && y > BattleCityTry1.y)
                    && (x < BattleCityTry1.x + 40 && y < BattleCityTry1.y + 40))){
                Poder = false;
                Thread.sleep(1000);
                BattleCityTry1.game = 1;
                BattleCityTry1.puntuacion = 0;
                BattleCityTry1.y = 475;
                BattleCityTry1.x = 350;
                BattleCityTry1.dir = 1;
                BattleCityTry1.enemies = 1;
                
            }else{
                Poder = true;
            }
            
        }
        else
        {
            Poder = false;
            switch(stageselected[i][j])
            {
                case 1:
                    stageselected[i][j] = 6;
                    break;
                case 6:
                    stageselected[i][j] = 0;
                    break;
                case 2:
                    stageselected[i][j] = 7;
                    break;
                case 7:
                    stageselected[i][j] = 0;
                    break;
                case 5:
                    stageselected[i][j] = 8;
                    BattleCityTry1.game = 1;
                    BattleCityTry1.y = 475;
                    BattleCityTry1.x = 350;
                    BattleCityTry1.dir = 1;
                    BattleCityTry1.puntuacion = 0;
                    BattleCityTry1.loser = true;
                    break;
            }   
        }    
        return Poder;
    }
    
    public boolean PuedeEnemigo1(int x, int y){ //PuedeTanque
        boolean Poder;
        
        int j = (x - 50)/50;
        int i = (y - 25)/50;
        if(stageselected[i][j] == 0 || stageselected[i][j] == 3)
        {
            if(((x > BattleCityTry1.x && y > BattleCityTry1.y)
                    && (x < BattleCityTry1.x + 40 && y < BattleCityTry1.y + 40)) 
                    || ((x > BattleCityTry1.enemigo2.x && y > BattleCityTry1.enemigo2.y)
                        && (x < BattleCityTry1.enemigo2.x + 40 && y < BattleCityTry1.enemigo2.y + 40))
                        || ((x > BattleCityTry1.enemigo3.x && y > BattleCityTry1.enemigo3.y)
                            && (x < BattleCityTry1.enemigo3.x + 40 && y < BattleCityTry1.enemigo3.y + 40))){
                Poder = false;
            }else{
                Poder = true;
            }
        }
        else
        {
            Poder = false;
        }    
        
        return Poder;
    }
    
    public boolean PuedeEnemigo2(int x, int y){ //PuedeTanque
        boolean Poder;
        
        int j = (x - 50)/50;
        int i = (y - 25)/50;
        if(stageselected[i][j] == 0 || stageselected[i][j] == 3)
        {
            if(((x > BattleCityTry1.x && y > BattleCityTry1.y)
                    && (x < BattleCityTry1.x + 40 && y < BattleCityTry1.y + 40)) 
                    || ((x > BattleCityTry1.enemigo1.x && y > BattleCityTry1.enemigo1.y)
                        && (x < BattleCityTry1.enemigo1.x + 40 && y < BattleCityTry1.enemigo1.y + 40))
                        || ((x > BattleCityTry1.enemigo3.x && y > BattleCityTry1.enemigo3.y)
                            && (x < BattleCityTry1.enemigo3.x + 40 && y < BattleCityTry1.enemigo3.y + 40))){
                Poder = false;
            }else{
                Poder = true;
            }
        }
        else
        {
            Poder = false;
        }    
        
        return Poder;
    }
    
    public boolean PuedeEnemigo3(int x, int y){ //PuedeTanque
        boolean Poder;
        
        int j = (x - 50)/50;
        int i = (y - 25)/50;
        if(stageselected[i][j] == 0 || stageselected[i][j] == 3)
        {
            if(((x > BattleCityTry1.x && y > BattleCityTry1.y)
                    && (x < BattleCityTry1.x + 40 && y < BattleCityTry1.y + 40)) 
                    || ((x > BattleCityTry1.enemigo2.x && y > BattleCityTry1.enemigo2.y)
                        && (x < BattleCityTry1.enemigo2.x + 40 && y < BattleCityTry1.enemigo2.y + 40))
                        || ((x > BattleCityTry1.enemigo1.x && y > BattleCityTry1.enemigo1.y)
                            && (x < BattleCityTry1.enemigo1.x + 40 && y < BattleCityTry1.enemigo1.y + 40))){
                Poder = false;
            }else{
                Poder = true;
            }
        }
        else
        {
            Poder = false;
        }    
        
        return Poder;
    }
}

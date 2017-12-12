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
public class Menu {
    Image Imagen;
    Font fuente;
    Font fuente2;
    String HS;
    public Menu(){
        this.Imagen = (new ImageIcon("Recursos/BattleCity_Logo.png")).getImage();
        try {
            GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Recursos/PressStart2P.ttf")));
        } catch (IOException|FontFormatException e) {
            e.printStackTrace();
        }
        this.fuente=new Font("Press Start 2P", Font.PLAIN, 26);
        this.fuente2=new Font("Press Start 2P", Font.PLAIN, 30);
        
        
        
    }
    /**
     * Grafica el logo del juego
     * @param g 
     */
    public void drawLogo(Graphics g){
        g.drawImage(Imagen, 0, 50, null);
        g.setColor(Color.WHITE);
        g.setFont(fuente);
        g.drawString("HIGHSCORE", 175, 450);
        g.drawString("STAGE", 175, 500);
        g.drawString("ENEMIES", 175, 550);
    }
    /**
     * Grafica el indice selector
     * @param g
     * @param opc 
     */
    public void selector(Graphics g, int opc){
        g.setColor(Color.WHITE);
        g.setFont(fuente2);
        switch(opc)
        {
            case 1:
                g.drawString("*", 125, 500);
                break;
            case 2:
                g.drawString("*", 125, 550);
                break;            
        }
    }
    /**
     * Grafica el nivel elegido, la maxima puntuacion y los enemigos a combatir
     * @param g
     * @param stage
     * @param enemies 
     */
    public void Count(Graphics g, int stage, int enemies){
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("Recursos/HIGHSCORE.txt"));
            this.HS = br.readLine();
            br.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        g.setColor(Color.WHITE);
        g.setFont(fuente);
        g.drawString(HS, 550, 450);
        g.drawString(""+stage, 550, 500);
        g.drawString(""+enemies, 550, 550);
    }
}

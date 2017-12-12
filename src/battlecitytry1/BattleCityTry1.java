/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlecitytry1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juanc
 */
public class BattleCityTry1 extends javax.swing.JFrame {

    /**
     * Creates new form BattleCityTry1
     */
    public Thread graficador;
    public Thread enemigo1life;
    public Thread enemigo2life;
    public Thread enemigo3life;
    public static int opc = 1;
    public static int game;
    public static int stage = 1;
    public static int enemies = 1;
    public static int y = 475;
    public static int x = 350;
    public static int dir = 1;
    public static Mapa mapa;
    public static Menu menu;
    public static Tanque tanque;
    public static Enemigo1 enemigo1;
    public static Enemigo2 enemigo2;
    public static Enemigo3 enemigo3;
    public static Graphics g;
    public static boolean loser = false;
    public static String maxpunt;
    public static int maxpuntint;
    public static String sCurrentLine;
    public static int puntuacion;
    
    public BattleCityTry1() {
        initComponents();
        game = 1;
        puntuacion = 0;
        menu = new Menu();
        try{
            BufferedReader br = new BufferedReader(new FileReader("Recursos/HIGHSCORE.txt"));
            while ((sCurrentLine = br.readLine()) != null) {
				maxpunt = sCurrentLine;
			}
            maxpuntint = Integer.parseInt(maxpunt);
            System.out.println(maxpuntint);
        }catch(Exception e){}
        
        canvas1.addKeyListener(new KeyListener()
            {

                @Override
                public void keyTyped(KeyEvent e) {
                        switch(game)
                        {
                            case 1:
                                ControlGame1(e);
                                break;
                            case 2:
                                ControlGame2(e);
                                break;
                        }
                        
                       
                    }

                @Override
                public void keyPressed(KeyEvent e) {
                        if(game == 2)
                        {
                           ControlMotor(e); 
                        }
                    
                    }

                @Override
                public void keyReleased(KeyEvent e) {
                    }
                
            });
        graficador = new Thread(new Runnable()
                  {
                      @Override
                      public void run()
                      {
                          canvas1.setSize(800, 650);
                          canvas1.createBufferStrategy(2);
                          g= canvas1.getBufferStrategy().getDrawGraphics();
                          long ini=System.currentTimeMillis();
                          while(true)
                          {
                              try
                              {
                                  drawBackground(g);
                                  switch(game)
                                  {
                                      case 1:
                                        menu.drawLogo(g);
                                        menu.selector(g, opc);
                                        menu.Count(g, stage, enemies);
                                        System.out.println(maxpuntint);
                                        break;
                                      case 2:
                                        
                                        tanque.drawTanque(g, x, y, dir);
                                        enemigo1.enemigoLife();
                                        enemigo1.drawEnemigo(g);
                                        enemigo2.enemigoLife();
                                        enemigo2.drawEnemigo(g);
                                        enemigo3.enemigoLife();
                                        enemigo3.drawEnemigo(g);
                                        mapa.Marco(g);
                                        mapa.drawStage(g);
                                        for(int i = 1; i < tanque.balas.size(); i++)
                                        {
                                            Bala b = tanque.balas.get(i);
                                            b.drawBala(g);
                                        }
                                        for(int i = 1; i < enemigo1.balas.size(); i++)
                                        {
                                            Bala b = enemigo1.balas.get(i);
                                            b.drawBalaEnemiga(g);
                                        }
                                        for(int i = 1; i < enemigo2.balas.size(); i++)
                                        {
                                            Bala b = enemigo2.balas.get(i);
                                            b.drawBalaEnemiga2(g);
                                        }
                                        if(enemigo1.act == false && enemigo2.act == false && enemigo3.act == false)
                                        {
                                            Thread.sleep(1000);
                                            System.out.println(puntuacion);
                                            if(puntuacion > maxpuntint)
                                            {
                                                maxpuntint = puntuacion;
                                                try
                                                {
                                                    PrintWriter writer = new PrintWriter("Recursos/HIGHSCORE.txt", "UTF-8");
                                                    writer.println(""+maxpuntint);
                                                    
                                                    writer.close();
                                                }catch(Exception e)
                                                {}
                                            }
                                            puntuacion = 0;
                                            game = 1;
                                            y = 475;
                                            x = 350;
                                            dir = 1;
                                            enemies = 1;
                                        }
                                        
                                        break;
                                  }
                                  canvas1.getBufferStrategy().show();
                                  if(loser == true)
                                  {
                                      Thread.sleep(1000);
                                      loser = false;
                                  }
                                  
                              }catch(Exception e)
                              {
                                  e.printStackTrace();
                              }
                          }
                      }
                      
                  });
        enemigo1life = new Thread(new Runnable()
                  {
                      @Override
                      public void run()
                      {
                          try
                          {
                                while(true)
                                {
                                    System.out.println(game);
                                    if(game == 2)
                                    {  
                                        
                                        if(enemigo1.act == true)
                                        {
                                            if(enemigo1.vivo == false)
                                            {
                                                if(enemies > 0)
                                                {
                                                    enemies--;
                                                    Thread.sleep(2000);
                                                    switch(stage)
                                                    {
                                                        case 1:
                                                            enemigo1.x = 50;
                                                            enemigo1.y = 125;

                                                            break;
                                                        case 2:
                                                            enemigo1.x = 50;
                                                            enemigo1.y = 75;
                                                            break;
                                                        case 3:
                                                            enemigo1.x = 50;
                                                            enemigo1.y = 25;
                                                            break;
                                                    }   
                                                    
                                                    enemigo1.vivo = true;
                                                }
                                                else
                                                {
                                                    enemigo1.act = false;
                                                }
                                            }
                                            else
                                            {
                                                enemigo1.enemigoTactic();
                                                Thread.sleep(600);
                                            }
                                        } 
                                    }
                                }
                          }
                          catch(Exception e)
                          {e.printStackTrace();}
                      }
                  });
        
    enemigo2life = new Thread(new Runnable()
                  {
                      @Override
                      public void run()
                      {
                          try
                          {
                                while(true)
                                {
                                    System.out.println(game);
                                    if(game == 2)
                                    {  
                                        
                                        if(enemigo2.act == true)
                                        {
                                            if(enemigo2.vivo == false)
                                            {
                                                if(enemies > 0)
                                                {
                                                    enemies--;
                                                    Thread.sleep(2000);
                                                    switch(stage)
                                                    {
                                                        case 1:
                                                            enemigo2.x = 300;
                                                            enemigo2.y = 25;

                                                            break;
                                                        case 2:
                                                            enemigo2.x = 350;
                                                            enemigo2.y = 75;
                                                            break;
                                                        case 3:
                                                            enemigo2.x = 300;
                                                            enemigo2.y = 25;
                                                            break;
                                                    } 
                                                    
                                                    enemigo2.vivo = true;
                                                }
                                                else
                                                {
                                                    enemigo2.act = false;
                                                }
                                            }
                                            else
                                            {
                                                enemigo2.enemigoTactic();
                                                Thread.sleep(600);
                                            }
                                        } 
                                    }
                                }
                          }
                          catch(Exception e)
                          {e.printStackTrace();}
                      }
                  });
    
    enemigo3life = new Thread(new Runnable()
                  {
                      @Override
                      public void run()
                      {
                          try
                          {
                                while(true)
                                {
                                    System.out.println(game);
                                    if(game == 2)
                                    {  
                                        
                                        if(enemigo3.act == true)
                                        {
                                            if(enemigo3.vivo == false)
                                            {
                                                if(enemies > 0)
                                                {
                                                    enemies--;
                                                    Thread.sleep(2000);
                                                    switch(stage)
                                                    {
                                                        case 1:
                                                            enemigo3.x = 610;
                                                            enemigo3.y = 175;

                                                            break;
                                                        case 2:
                                                            enemigo3.x = 610;
                                                            enemigo3.y = 225;
                                                            break;
                                                        case 3:
                                                            enemigo3.x = 610;
                                                            enemigo3.y = 25;
                                                            break;
                                                    }
                                                    enemigo3.vivo = true;
                                                }
                                                else
                                                {
                                                    enemigo3.act = false;
                                                }
                                            }
                                            else
                                            {
                                                enemigo3.enemigoTactic();
                                                Thread.sleep(600);
                                            }
                                        } 
                                    }
                                }
                          }
                          catch(Exception e)
                          {e.printStackTrace();}
                      }
                  });
        
        
    }
    
    private void drawBackground(Graphics g){
          g.setColor(Color.black);
          g.fillRect(0, 0, canvas1.getWidth(), canvas1.getHeight()); 
          
    }
    
    private void ControlGame1 (KeyEvent e){
        switch(e.getKeyChar())
                       {
                           case 50: //Numero 2 - Flecha Abajo
                               if(opc < 2)
                               {
                                   opc++;
                               }
                               
                               break;
                           case 53: //Numero 5 - Flecha Arriba
                               if(opc > 1)
                               {
                                   opc--;
                               }
                               
                               break;
                           case 49: //Numero 1 - Flecha Izquierda
                               switch(opc)
                               {
                                   case 1:
                                       if(stage > 1)
                                       {
                                           stage--;
                                       }
                                       break;
                                   case 2:
                                       if(enemies > 1)
                                       {
                                           enemies--;
                                       }
                                       break;                                   
                               }
                               break;
                           case 51: //Numero 3 - Flecha Derecha
                               switch(opc)
                               {
                                   case 1:
                                       if(stage < 3)
                                       {
                                           stage++;
                                       }
                                       break;
                                   case 2:
                                       if(enemies < 20)
                                       {
                                           enemies++;
                                       }
                                       break;                                   
                               }
                               break;
                           case 10: //ENTER
                               mapa = new Mapa(stage);
                               tanque = new Tanque();
                               if(enemies < 3)
                               {
                                   switch(enemies)
                                   {
                                       case 1:
                                           System.out.println("caso 1");
                                           enemigo1 = new Enemigo1(stage, true);
                                           enemigo2 = new Enemigo2(stage, false);
                                           enemigo3 = new Enemigo3(stage, false);
                                           enemies = 0;
                                           break;
                                       case 2:
                                           enemigo1 = new Enemigo1(stage, true);
                                           enemigo2 = new Enemigo2(stage, true);
                                           enemigo3 = new Enemigo3(stage, false);
                                           enemies = 0;
                                           break;
                                   }
                               }else{
                                    enemigo1 = new Enemigo1(stage, true);
                                    enemigo2 = new Enemigo2(stage, true);
                                    enemigo3 = new Enemigo3(stage, true);
                                    enemies = enemies - 3;
                               }
                             
                               tanque.Disparar(x, y, dir);
                               game = 2;
                               break;
                           
                       }
                       
                       
        
    }
    
    public void ControlGame2(KeyEvent e){
        switch(e.getKeyChar()){
            case 10:
                game = 1;
                y = 475;
                x = 350;
                dir = 1;
                enemies = 1;
                break;
            case 32:                            
                tanque.Disparar(x, y, dir);
                if(tanque.balasdisparadas < tanque.balalimit)
                {
                    tanque.balasdisparadas++;
                }
                
                System.out.println(tanque.balasdisparadas);
                break;
                
        }
    }
    
    public void ControlMotor(KeyEvent e){
        switch(e.getKeyChar()){
            case 53: //arriba
                if(y > 25 && mapa.Puede(x, y - 4) && mapa.Puede(x + 39,y - 4))
                {
                   y = y - 5; 
                }
                dir = 1;
                break;
            case 50: //abajo
                if(y < 585 && mapa.Puede(x, y + 39 + 4) && mapa.Puede(x + 39, y + 39 + 4))
                {
                    y = y + 5;
                }
                dir = 2;
                break;
            case 51: //derecha
                if(x < 610 && mapa.Puede(x + 4 + 39, y) && mapa.Puede(x + 4 + 39, y + 39))
                {
                    x = x + 5;
                }
                dir = 3;
                break;
            case 49: //izquierda
                if(x > 50 && mapa.Puede(x - 4, y) && mapa.Puede(x - 4, y + 39))
                {
                    x = x - 5;
                }
                dir = 4;
                break;
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new java.awt.Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        BattleCityTry1 BC = new BattleCityTry1();
        BC.setSize(815, 689);
        BC.setDefaultCloseOperation(3);
        BC.setVisible(true);
        BC.graficador.start();
        BC.enemigo1life.start();
        BC.enemigo2life.start();
        BC.enemigo3life.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    // End of variables declaration//GEN-END:variables
}

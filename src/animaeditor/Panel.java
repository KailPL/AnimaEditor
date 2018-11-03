/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animaeditor;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Kail
 */
public class Panel extends JPanel{
    
    
    //int[][] map = new int[500][500];
    int[][] map ;
    ObjectInputStream ois;
    int camx=0;
    int camy=0;
    Image im;
    int bush=0;
    int maxx=500;
    int maxy=500;
    int scale = 2;
    
public Panel(){
        UchwytMyszki sluchacz=new UchwytMyszki();
        addMouseListener(sluchacz);
        UchwytKlawisza sluchacz2=new UchwytKlawisza();
        addKeyListener(sluchacz2);
        UchwytRuchMyszki sluchacz3=new UchwytRuchMyszki();
        addMouseMotionListener(sluchacz3);

        try {
            ois = new ObjectInputStream(new FileInputStream("map.per"));
            map = (int[][]) (ois.readObject());
            ois.close();
        } catch (IOException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("err:ois = new ObjectInputStream(new FileInputStream(\"plik.per\"));");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("err:int[][] ia = (int[][]) (ois.readObject());");
        }
        

                 
               
        
        

        
}
    public boolean isFocusTraversable(){
        return true;
    }

    @Override
    protected  void paintComponent( Graphics g ){
         super.paintComponent( g );
                im = getToolkit().getImage("src/Tlo.jpg");
         g.drawImage(im, 0, 0, 1200, 880, this);  
        for (int i=0; i<55*scale; i++){
             for (int j=0; j<75*scale; j++)
             {      
                 if (((i+camx)<maxx)&&((i+camx)>=0)&&((j+camy)<maxy)&&((j+camy)>=0)){
                 im = getToolkit().getImage("src/"+map[i+camx][j+camy]+".png");
                 g.drawImage(im, j*16/scale, i*16/scale, 16/scale, 16/scale, this);}
             }
        }

     }


        private class UchwytMyszki extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
//        Point2D p;
//        p=e.getPoint();
//        int x=(e.getX()/16);
//        int y=(e.getY()/16);
//        map[y+camx][x+camy]=(map[y+camx][x+camy]+1)%5;
//        repaint();  
        

        }
        @Override
        public void mouseClicked(MouseEvent e){
            

        repaint();
         }
        @Override
        public void mouseReleased(MouseEvent e){

            
            
        repaint();
        }
    }
        
    private class UchwytRuchMyszki implements MouseMotionListener{
        @Override
       public void mouseDragged(MouseEvent e) {
        Point2D p;
        p=e.getPoint();
        int x=(e.getX()/(16/scale));
        int y=(e.getY()/(16/scale));
        //map[y+camx][x+camy]=(map[y+camx][x+camy]+1)%5;
        if (((y+camx<maxx))&&((y+camx>=0))&&((x+camy<maxy))&&(x+camy>=0))
        map[y+camx][x+camy]=bush;
        repaint();  

       }
       @Override
        public void mouseMoved(MouseEvent e) {

            repaint();
            
        }
    }    
        
        
        private class UchwytKlawisza implements KeyListener{
        public void keyPressed(KeyEvent zdarzenie) {
            int kodKlawisza=zdarzenie.getKeyCode();
            if((kodKlawisza==KeyEvent.VK_EQUALS)) {if (scale<16)scale=scale*2;}
            if((kodKlawisza==KeyEvent.VK_MINUS)) {if (scale>1)scale=scale/2;}
            if((kodKlawisza==KeyEvent.VK_LEFT)) camy-=scale; 
            else if((kodKlawisza==KeyEvent.VK_RIGHT)) camy+=scale; 
            if((kodKlawisza==KeyEvent.VK_DOWN)) camx+=scale; 
            else if((kodKlawisza==KeyEvent.VK_UP)) camx-=scale;
            if (kodKlawisza==KeyEvent.VK_F8){
                ObjectOutputStream oos;
                try {
                    oos = new ObjectOutputStream(new FileOutputStream("map.kail"));
                    oos.writeObject(map);
                    oos.close();
                    System.out.printf("zapisano mapke");
           
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
            if((kodKlawisza==KeyEvent.VK_0)) bush=0;
            if((kodKlawisza==KeyEvent.VK_1)) bush=1;
            if((kodKlawisza==KeyEvent.VK_2)) bush=2;
            if((kodKlawisza==KeyEvent.VK_3)) bush=3;
            if((kodKlawisza==KeyEvent.VK_4)) bush=4;
            if((kodKlawisza==KeyEvent.VK_5)) bush=5;
            if((kodKlawisza==KeyEvent.VK_6)) bush=6;
            if((kodKlawisza==KeyEvent.VK_7)) bush=7;
            if((kodKlawisza==KeyEvent.VK_8)) bush=8;
            if((kodKlawisza==KeyEvent.VK_9)) bush=9;
            repaint();
        }
        public void keyReleased(KeyEvent e) {
        }
        public void keyTyped(KeyEvent zdarzenie) {
//            znakKlawisza=zdarzenie.getKeyChar();
//            if(Character.isUpperCase(znakKlawisza)){
//            d*=10;
//            znakKlawisza = Character.toLowerCase(znakKlawisza);
//            }
//            if(kodKlawisza==KeyEvent.VK_A) SendPakiet(); 
//            else if(kodKlawisza==KeyEvent.VK_D) SendPakiet(); 
//            else if(kodKlawisza==KeyEvent.VK_S) SendPakiet(); 
//            else if(kodKlawisza==KeyEvent.VK_W) SendPakiet(); 
        }
        }
      
    
}

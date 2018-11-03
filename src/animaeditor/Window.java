/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animaeditor;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Kail
 */
public class Window extends  JFrame{
    
    
    Toolkit tool=Toolkit.getDefaultToolkit();
    Dimension ekran=tool.getScreenSize();
    int szer=(int)ekran.getWidth();
    int wys=(int)ekran.getHeight();
    //Dodanie panelu
    Panel panel=new Panel();
    Container powZawartosci=getContentPane();
    //Wygląd okna
    public Window(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,880);//75 55 po 16
        setTitle("Kails Map Editor");    
        powZawartosci.add(panel);
        setResizable(false);
    }

}

    
    
    


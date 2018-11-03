/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animaeditor;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 *
 * @author Kail
 */
public class AnimaEditor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    final Window window = new Window();
    window.addComponentListener(new ComponentAdapter() {
        public void componentResized(ComponentEvent e)
        {
            window.repaint();
        }
        });

    window.show();
        
        
    }
    
}

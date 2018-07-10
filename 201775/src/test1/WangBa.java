package test1;

import java.awt.*;  
import java.awt.event.*;  
  
import javax.swing.*;  
  
public class WangBa {  
    public static void main(String[] args) {  
        JFrame w=new JFrame("Œ⁄πÍ”Œ∞°”Œ");  
        w.setSize(1720, 768);  
        w.setBackground(Color.LIGHT_GRAY);  
        Mypan mp=new Mypan();  
        w.add(mp);  
          
        w.addMouseListener(mp);  
        w.addMouseMotionListener(mp);  
          
        w.addKeyListener(mp);  
        mp.addKeyListener(mp);  
          
        Thread ti=new Thread(mp);  
        ti.start();  
        w.show();  
    }  
}  

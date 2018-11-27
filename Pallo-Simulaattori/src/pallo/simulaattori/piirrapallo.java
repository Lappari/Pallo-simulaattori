/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pallo.simulaattori;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;



/**
 *
 * @author Lappari
 */
public class piirrapallo extends JPanel implements ActionListener{
  Timer t = new Timer(5, this);
    //Pallon tiedot
    int x = 0, y = 0, kulmaX = 5, kulmaY = 5 ;
       
    public piirrapallo(int uusx, int uusy, int xnopeus, int ynopeus){
        
        x = uusx;
        y = uusy;
        kulmaX = xnopeus;
        kulmaY = ynopeus;
        
    }
    //Pallon liikuttamiseen käyettävä metodi

   // @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(x,y,20,20);
        g2.setPaint(Color.RED);
        g2.fill(circle);
        t.start();
    
    }
    public void actionPerformed(ActionEvent e){
        if (x < 0 || x > 779){
        kulmaX = -kulmaX;
        }
        if(y < 0 || y > 434){
        kulmaY = -kulmaY;
        }


        x += kulmaX;
        y += kulmaY;
        repaint();
    }
    }
   


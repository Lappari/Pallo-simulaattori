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
import java.util.Random;


/**
 *
 * @author Lappari
 */
public class piirrapallo extends JPanel{
  
    //Pallon tiedot
        private int x = 0, y = 0, kulmaX = 5, kulmaY = 5 ;
        
    //arvotaan pallon väri    
        Random color = new Random();
        private float red = color.nextFloat();
        private float green = color.nextFloat();
        private float blue = color.nextFloat();
      
        
    public piirrapallo(int uusx, int uusy, int xnopeus, int ynopeus){
        
        //piirräpallo muuttuja arvojen alustus
        x = uusx;
        y = uusy;
        kulmaX = xnopeus;
        kulmaY = ynopeus;
        
        //asetetaan ikkunan jossa pallo voiliikkua rajat
        setBounds(0,0,799,454);
        
        //tehdään ylimääräisistä pikseleistä läpinäkyviä
        setOpaque(false);
        
    }
   
    //pallon piirto
    @Override
    public void paint(Graphics g) {
 
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(x,y,20,20);
        g2.setPaint(Color.getHSBColor(red, green, blue));
        g2.fill(circle);
        
    
    }
    //pallon liikkumis metodi
    public void paivita(){
        //tarkistetaan onko pallo kiinni seinässä x akselin suuntaan
        if (x < 0 || x > 779){
        kulmaX = -kulmaX;
        }
        
        //tarkistetaan onko pallo kiinni seinässä y akselin suuntaan
        if(y < 0 || y > 434){
        kulmaY = -kulmaY;
        }
        
        //liikutetaan palloa
        x += kulmaX;
        y += kulmaY;
        
        //päivitetään pallon uusi sijainti ruudulla
        repaint();
    }
    }
   


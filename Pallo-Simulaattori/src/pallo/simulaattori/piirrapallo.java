/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pallo.simulaattori;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Random;


/**
 *
 * @author Lappari
 */

public class piirrapallo extends JPanel{
  
    //Pallon tiedot
        private float x = 0, y = 0, kulmaX = 0, kulmaY = 0,sade = 20, massa = 0, kiX= 0, kiY= 0, gravity = 9, gravityeffect;
        private Ellipse2D.Float circle;
    //arvotaan pallon väri    
        Random color = new Random();
        private float red = color.nextFloat();
        private float green = color.nextFloat();
        private float blue = color.nextFloat();
      
        
    public piirrapallo(float uusx, float uusy, float xnopeus, float ynopeus, float halk, float mass, float kiihX, float kiihY){
        
        //piirräpallo muuttuja arvojen alustus
        x = uusx;
        y = uusy;
        kulmaX = xnopeus;
        kulmaY = ynopeus;
        massa = mass;
        kiX = kiihX;
        kiY = kiihY;
        sade = halk;
        
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
        circle = new Ellipse2D.Float(x,y,sade,sade);
        g2.setPaint(Color.getHSBColor(red, green, blue));
        g2.fill(circle);
        
    
    }
    //getteri pallon muodon tiedoista
    public Ellipse2D.Float getPallo(){
        return circle;
    }
    
    public float GetX(){
        return x;
    }
    
    public float GetY(){
        return y;
    }
    
    public float getSade(){
        return sade/2;
    }
    //pallon liikkumis metodi
    public void paivita(boolean tormays){

        //tarkistetaan onko pallo kiinni seinässä x akselin suuntaan
        if (x < 0 || x > 779 || tormays){
            kulmaX = -kulmaX;
        }
        
        //tarkistetaan onko pallo kiinni seinässä y akselin suuntaan
        if(y < 0 || y > 434 || tormays){
            kulmaY = -kulmaY;
        }
        
        //liikutetaan palloa
        x += kulmaX;
        y += kulmaY;
        //päivitetään pallon uusi sijainti ruudulla
        repaint();
    }
    }
   


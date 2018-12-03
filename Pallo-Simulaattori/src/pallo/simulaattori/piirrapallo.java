/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pallo.simulaattori;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.Random;
import static java.lang.Math.*;



/**
 *
 * @author Lappari
 */
public class piirrapallo extends JPanel{
  
        //Pallon tiedot
        private float x = 0, y = 0, kulmaX = 0, kulmaY = 0,sade = 20, massa = 0, kasvu=2, gravity = (float)9.81, gravityeffect,kulma = 0,kimmoike = 2;
        private Ellipse2D.Float circle;
        private int painoAsetus=1;
        //arvotaan pallon väri    
        Random color = new Random();
        private float red = color.nextFloat();
        private float green = color.nextFloat();
        private float blue = color.nextFloat();
      
        
    public piirrapallo(float uusx, float uusy, float xnopeus, float ynopeus, float halk, float mass, float grav, float grow){
        
        //piirräpallo muuttuja arvojen alustus
        x = uusx;
        y = uusy;
        kulmaX = xnopeus;
        kulmaY = ynopeus;
        massa = mass;
        gravity = grav;
        kasvu = grow;
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
    public void setSade(float uusisade){
        sade = uusisade;
    }
    public float getKasvu(){
        return kasvu;
    }
     public void setPainovoima(int asetus){
        painoAsetus=asetus;
    }
    //pallon liikkumis metodi
    public void paivita(boolean tormays){
        
        switch(painoAsetus){
            
            case 1://Ei painovoimaa asetus
        
            if (x < 0 || x > 779 || tormays){
                kulmaX = -kulmaX;
            
            }
        
            //tarkistetaan onko pallo kiinni seinässä y akselin suuntaan
            if(y < 0 || y>434 || tormays){
                kulmaY = -kulmaY;
            }
          
            //liikutetaan palloa
            x += kulmaX;
            y += kulmaY;
            
            break;
        
            case 2://DYNAAMINEN painovoima
            
            if(kulmaX<0){
                //laskee nopeuksien suuntakulman
                kulma =(float)toDegrees(tanh(kulmaY/kulmaX))+180;
                
                //lasketaan uudet x ja y nopeudet suuntakulman ja painovoiman avulla
                kulmaX = kulmaX*(float)cos(toRadians(kulma));
                kulmaY = -1*(kulmaY*(float)sin(toRadians(kulma)) - gravity);
                
            }else{
                //laskee nopeuksien suuntakulman
                kulma =(float)toDegrees(tanh(kulmaY/kulmaX));
                
                //lasketaan uudet x ja y nopeudet suuntakulman ja painovoiman avulla
                kulmaX = kulmaX*(float)cos(toRadians(kulma));
                kulmaY = -1*(kulmaY*(float)sin(toRadians(kulma)) - gravity);
            }
            
            //tarkistetaan onko pallo kiinni seinässä x akselin suuntaan tai törmäämässä toiseen palloo
            if (x < 0 || x > 779 || tormays){
            kulmaX = -kulmaX;
            
            }
        
            //tarkistetaan onko pallo kiinni seinässä y akselin suuntaan tai törmäämässä toiseen palloo
            if(y < 0 || y>434 || tormays){
            kulmaY = -kulmaY;
            }
            
            //liikutetaan palloa
            x += kulmaX;
            y += kulmaY;
            
            break;
            
           
            case 3://Energy Gravity
            gravityeffect = massa*gravity;
            
            
            if (x-sade/2 < 0 || x+sade/2> 779){
            kulmaX*=(float)0.9;
            kulmaX = -kulmaX;
            }
        
            //tarkistetaan onko pallo kiinni seinässä y akselin suuntaan
            if(y-sade/2 < 0 || y+sade/2 > 434){
            kulmaY*=(float)0.9;
            kulmaY = -kulmaY;
            }
            x+=kulmaX*0.001;
            y+=kulmaY+gravityeffect*0.001;
        
            kulmaY+=kimmoike;
            kulmaX+=kimmoike;
            kimmoike*=0.8;
            
            break;
    
            case 4://Bounce Gravity
                
            if (x < 0 || x > 779 || tormays){
            kulmaX = -kulmaX;
            
            }
        
            //tarkistetaan onko pallo kiinni seinässä y akselin suuntaan
            if(y < 0 || y>434 || tormays){
            kulmaY = -kulmaY;
            }
          
           //lisätää Gvoimia
            kulmaY += gravity*0.1;
            //liikutetaan palloa
            x += kulmaX;
            y += kulmaY;
 
            break;
            }
        
        repaint();//päivitetään pallo

    }
    }
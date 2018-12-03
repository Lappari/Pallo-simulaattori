/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pallo.simulaattori;


import java.awt.geom.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
/**
 *
 * @author Lappari
 */
public class PalloSimulaattori implements ActionListener{
    
    //esitellään timeri
   javax.swing.Timer t = new javax.swing.Timer(33, this);
   
   private MainRuutu ikkuna;
   private piirrapallo pallo;
   private int painovoima=0;
   private float etaisyys,yhtsateet, tarkPalloX, tarkPalloY, muutPalloX, muutPalloY; //käytetään kahden pallo etäisyyden laskennassa
   private boolean tormays;                                  //kahdenpallon yhteenlaskettu sade, tarvittavat kordinaatti muuttuja...
   //luodaan pallo olio lista
   ArrayList<piirrapallo>pallot = new ArrayList();
   

    public PalloSimulaattori(){
        
        //luodaan pääikkuna
        ikkuna = new MainRuutu();
        
        //esitellään kontrolleri pääikkunalle
        ikkuna.kontroller(this);
        
        //esetetaan pääikkuna näkuväksi
        ikkuna.setVisible(true);
        
        //käynnistetään timeri
        t.start();
    }
    
    //luo uuden pallon ruudulle
    public void piirrapallo(float x, float y, float xnop, float ynop, float sade, float mass, float kiX, float kiY){
        
        //luodaan uusi pallo
        pallo = new piirrapallo(x,y,xnop,ynop,sade,mass,kiX,kiY);
        
        //lisätään uusipallo listaan pallot
        pallot.add(pallo);
        
        //lisätään uusipallo ruudulle
        ikkuna.simu.add(pallot.get(pallot.size() - 1));
       
    }
    
    //poistaa kaikki pallot listasta
    public void poistaPallot(){
        pallot.clear();
    }
    
    public void setPainovoima(){
        painovoima++;
        for(piirrapallo pallo: pallot){
            pallo.setPainovoima(painovoima);
        }
        if(painovoima==3){
            painovoima=0;
        }
        
    }
    //päivittää jokaisen pallon timeriin asetetun ajan mukaan.
    public void actionPerformed(ActionEvent e){
      
       
       for(piirrapallo tarkpallo: pallot){
           
           
           //laskee pallon johon muidenpallojen sijaintia verrataan x ja y kordinaatin
           tarkPalloX = tarkpallo.GetX()-((float)Math.sqrt((tarkpallo.getSade()*tarkpallo.getSade())+(tarkpallo.getSade()*tarkpallo.getSade())));
           tarkPalloY = tarkpallo.GetY()-((float)Math.sqrt((tarkpallo.getSade()*tarkpallo.getSade())+(tarkpallo.getSade()*tarkpallo.getSade())));
        
      
        for(piirrapallo muutpallot : pallot){
           //käydään läpi kaikku muuta pallot verrattuna tarkistettavaan palloon
           
           //laskee verrattavanpallon keskipisteen x ja y kordinaatin
           muutPalloX = muutpallot.GetX()-((float)Math.sqrt((muutpallot.getSade()*muutpallot.getSade())+(muutpallot.getSade()*muutpallot.getSade())));
           muutPalloY = muutpallot.GetY()-((float)Math.sqrt((muutpallot.getSade()*muutpallot.getSade())+(muutpallot.getSade()*muutpallot.getSade())));
           
           //lasketaan kahdenpallon etäisyys toisistaan
           etaisyys = (float)Math.sqrt((muutPalloX-tarkPalloX)*(muutPalloX-tarkPalloX)+(muutPalloY-tarkPalloY)*(muutPalloY-tarkPalloY));
           //lasketana pallojen säteiden summa
           yhtsateet = tarkpallo.getSade()+muutpallot.getSade();
           
           //tarkistetaan onko pallojen etäisyys pienempi kuin niiden yhteen lasketty sade
           if(etaisyys <= yhtsateet && etaisyys != 0){
            
               //jos törmäys tapahtuu päivitetään törmätty pallo, sekä muutetaan parametriä niin että törmäävä pallo muuttaa myös suuntaansa
            tormays = true;
            muutpallot.paivita(tormays);
           }else{
            tormays = false;
           }
           
        }
       
       //päivitetään tarkistettava pallo
       tarkpallo.paivita(tormays);
       }
    }
    
    public static void main(String[] args){
        
        new PalloSimulaattori();
        
    }
    
 
   }
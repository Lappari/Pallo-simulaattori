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
    public void piirrapallo(float x, float y, float xnop, float ynop){
        
        //luodaan uusi pallo
        pallo = new piirrapallo(x,y,xnop,ynop);
        
        //lisätään uusipallo listaan pallot
        pallot.add(pallo);
        
        //lisätään uusipallo ruudulle
        ikkuna.simu.add(pallot.get(pallot.size() - 1));
       
    }
    
    //poistaa kaikki pallot listasta
    public void poistaPallot(){
        pallot.clear();
    }
    
    //päivittää jokaisen pallon timeriin asetetun ajan mukaan.
    public void actionPerformed(ActionEvent e){
      
       
       for(piirrapallo tarkpallo: pallot){
           
           //Haetaan pallon muodot tarkistettaviksi
           
           tarkPalloX = tarkpallo.GetX();
           tarkPalloY = tarkpallo.GetY();
        //päivitetään pallon sijainti ja suunta ruudulle
       if(pallot.size()>1){
        for(piirrapallo muutpallot : pallot){
           //käydään läpi kaikku muuta pallot verrattuna tarkistettavaan palloon
           
           muutPalloX = muutpallot.GetX();
           muutPalloY = muutpallot.GetY();
           
           //lasketaan kahdenpallon etäisyys toisistaan
           etaisyys = (float)Math.sqrt((muutPalloX-tarkPalloX)*(muutPalloX-tarkPalloX)+(muutPalloY-tarkPalloY)*(muutPalloY-tarkPalloY));
           //lasketana pallojen säteiden summa
           yhtsateet = tarkpallo.getSade()+muutpallot.getSade();
           
           //tarkistetaan onko pallojen etäisyys pienempi kuin niiden yhteen lasketty sade
           if(etaisyys <= yhtsateet && etaisyys != 0){
         
            tormays = true;
            muutpallot.paivita(tormays);
           }else{
            tormays = false;
           }
           
        }
       }
       tarkpallo.paivita(tormays);
       }
    }
    
    public static void main(String[] args){
        
        new PalloSimulaattori();
        
    }
    
 
   }


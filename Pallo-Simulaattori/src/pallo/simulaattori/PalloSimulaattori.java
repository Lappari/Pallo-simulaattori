package pallo.simulaattori;
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
       
        //päivitetään pallon sijainti ja suunta ruudulle
        for(piirrapallo p : pallot){
           //kutsutaan pallo olion päivitä metodia 
           p.paivita();
        }
    }
    
    public static void main(String[] args){
        
        new PalloSimulaattori();
        
    }
    
 
   }


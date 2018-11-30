package pallo.simulaattori;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
/**
 *
 * @author Lappari
 */
public class PalloSimulaattori implements ActionListener{
   javax.swing.Timer t = new javax.swing.Timer(10, this);
    private MainRuutu ikkuna;
    private piirrapallo pallo;
    ArrayList<piirrapallo>pallot = new ArrayList();
    
    public PalloSimulaattori(){
        
        ikkuna = new MainRuutu();
                
        ikkuna.kontroller(this);
        ikkuna.setVisible(true);
        //this.piirrapallo(0,0,0,0);
       //ikkuna.uusiPallo();
       t.start();
    }
    
    public void piirrapallo(int x, int y, int xnop, int ynop){
        
        pallo = new piirrapallo(x,y,xnop,ynop);
        
        pallot.add(pallo);
        ikkuna.simu.add(pallot.get(pallot.size() - 1));
    }
    
    public void poistaPallot(){
        pallot.clear();
    }
    
    public void actionPerformed(ActionEvent e){
        for(piirrapallo p : pallot){
           p.paivita();
        }
    }
    
    public static void main(String[] args){
        
        new PalloSimulaattori();
        
    }
    
 
   }


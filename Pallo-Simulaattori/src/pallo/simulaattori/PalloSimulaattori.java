/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pallo.simulaattori;

/**
 *
 * @author Lappari
 */
public class PalloSimulaattori {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        /*piirrapallo pallo = new piirrapallo();
        MainRuutu ikkuna = new MainRuutu();
        ikkuna.simu.add(pallo);
        
        ikkuna.setVisible(true);
        int i = 0;
        while(i!=5000){
            pallo.move();
            //pallo.repaint();
            i++;
            System.out.println(i);
            Thread.sleep(10);
        }*/
        
        MainIkkuna ikkuna = new MainIkkuna();
        ikkuna.setVisible(true);
    }
    
}

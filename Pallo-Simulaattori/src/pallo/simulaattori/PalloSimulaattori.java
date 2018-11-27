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
    public static void main(String[] args){
        
        MainRuutu ikkuna = new MainRuutu();
        ikkuna.setVisible(true);
        
        ikkuna.lisaaPallo(10,10,3,3);
        
        ikkuna.lisaaPallo(20,20,1,10);
        
        ikkuna.lisaaPallo(20,20,10,10);
        
        ikkuna.lisaaPallo(20,20,6,6);
        
        ikkuna.lisaaPallo(20,20,7,4);
        
        ikkuna.lisaaPallo(20,20,3,6);
     /* int i = 0;
        while(i!=5000){
            pallo.move();
            //pallo.repaint();
            i++;
            System.out.println(i);
            
        }*/
        
       // MainIkkuna ikkuna = new MainIkkuna();
        //ikkuna.setVisible(true);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pallo.simulaattori;
import javax.swing.JFrame;
/**
 *
 * @author Lappari
 */
public class PalloSimulaattori {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MainIkkuna ikkuna = new MainIkkuna();
        piirrapallo pallo = new piirrapallo();
        ikkuna.setVisible(true);
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pallo.simulaattori;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Lappari
 */
public class MainRuutu extends JFrame{
    private JFrame ikkuna;
    public static JPanel simu;
    
    public MainRuutu(){
    ikkuna = new JFrame();
    setTitle("Pallo-Simulaattori");
    setSize(1024, 512);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    simu = new JPanel();
    setLayout(null);
    simu.setBackground(new java.awt.Color(255, 255, 255));
    simu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    Dimension simu_koko = simu.getPreferredSize();
    simu.setBounds(200,10,799,454);
//simu.setSize(800, 400);
    
    
    add(simu);
    

    }
    
   
}

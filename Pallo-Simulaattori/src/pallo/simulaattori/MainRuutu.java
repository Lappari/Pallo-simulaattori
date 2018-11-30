/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pallo.simulaattori;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author Lappari
 */
public class MainRuutu extends JFrame implements ActionListener{
   
    private PalloSimulaattori ohjain;
    private final JFrame ikkuna;
    public final JPanel simu;
    private final JLabel xkord;
    private final JTextField xkordarv;
    private final JLabel ykord;
    private final JTextField ykordarv;
    private final JLabel xkordnopeus;
    private final JTextField xkordnoparv;
    private final JLabel ykordnopeus;
    private final JTextField ykordnoparv;
    private final JButton lisaaPallo;
    private final JButton tyhjenna;
    
    
    public MainRuutu(){
        
    ikkuna = new JFrame();
    setTitle("Pallo-Simulaattori");
    setSize(1024, 512);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    
    //simulointi paneeli
    simu = new JPanel();
    simu.setLayout(null);
    simu.setBackground(new java.awt.Color(255, 255, 255));
    simu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    simu.setBounds(200,10,799,454);
    
    //x kordinaatti label
    xkord = new JLabel("X Kordinaatti:");
    xkord.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    xkord.setBounds(10, 10, 100, 25);
    
    //x kordinaatti text field
    xkordarv = new JTextField("0");
    xkordarv.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    xkordarv.setBounds(108, 10, 82, 25);
    
    //y kordinaatti label
    ykord = new JLabel("Y Kordinaatti:");
    ykord.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    ykord.setBounds(10, 35, 100, 25);
    
    //y kordinaatti text field
    ykordarv = new JTextField("0");
    ykordarv.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    ykordarv.setBounds(108, 35, 82, 25);
    
    //X suuntanopeus label
    xkordnopeus = new JLabel("X Suuntanopeus:");
    xkordnopeus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    xkordnopeus.setBounds(10, 60, 100, 25);
    
    //X suuntanopeus textfield
    xkordnoparv = new JTextField("5");
    xkordnoparv.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    xkordnoparv.setBounds(108, 60, 82, 25);
    
    //Y suuntanopeus label
    ykordnopeus = new JLabel("Y Suuntanopeus:");
    ykordnopeus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    ykordnopeus.setBounds(10, 85, 100, 25);
    
    //Y suuntanopeus textfield
    ykordnoparv = new JTextField("5");
    ykordnoparv.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    ykordnoparv.setBounds(108, 85, 82, 25);
    
    //lisää painike
    lisaaPallo = new JButton("Lisää");
    lisaaPallo.addActionListener(this);
    lisaaPallo.setBounds(120,437,70,25);
    
    //tyhjennys painike
    tyhjenna = new JButton("Poista");
    tyhjenna.addActionListener(this);
    tyhjenna.setBounds(50,437,70,25);
    
    add(simu);
    add(xkordarv);
    add(xkord);
    add(ykordarv);
    add(ykord);
    add(xkordnopeus);
    add(xkordnoparv);
    add(ykordnopeus);
    add(ykordnoparv);
    add(lisaaPallo);
    add(tyhjenna);
    
    
   }
   
    //lisää pallon simulaatio JPaneeliin.
   public void uusiPallo(){
       
       int xKordi,yKordi,Xvauhti,Yvauhti;
        
       //Hakee kordinaatit tekstikentistä.
       xKordi = Integer.parseInt(xkordarv.getText());
       yKordi = Integer.parseInt(ykordarv.getText());
        
        //Hakee nopeudet tekstikentistä.
       Xvauhti = Integer.parseInt(xkordnoparv.getText());
       Yvauhti = Integer.parseInt(ykordnoparv.getText());
       
       ohjain.piirrapallo(xKordi,yKordi,Xvauhti,Yvauhti); 
       
       
    }
   
    public void actionPerformed(ActionEvent e){
       if(e.getSource() == lisaaPallo){
          
           uusiPallo();
           
        }
        if(e.getSource() == tyhjenna){
            
           
           simu.removeAll();
           simu.updateUI();
           ohjain.poistaPallot();
           
        }
    }
    
    public void kontroller(PalloSimulaattori ohjain){
        this.ohjain = ohjain;
    }
    
}


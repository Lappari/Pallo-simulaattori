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
    private final JLabel halkaisija;
    private final JTextField halkaisijaan;
    private final JLabel massa;
    private final JTextField massaan;
    private final JLabel kiihtyvyysX;
    private final JTextField kiihtyvyyteenX;
    private final JLabel kiihtyvyysY;
    private final JTextField kiihtyvyyteenY;
    
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
    
    //halkaisija label
    halkaisija = new JLabel("Pallon Halkaisija:");
    halkaisija.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    halkaisija.setBounds(10,110, 100 , 25);
    
    //halkaisija TextField
    halkaisijaan = new JTextField("20");
    halkaisijaan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    halkaisijaan.setBounds(108, 110, 82, 25);
    
     //massa label
    massa = new JLabel("Pallon massa:");
    massa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    massa.setBounds(10,135, 100 , 25);
    
    //massa TextField
    massaan = new JTextField("1");
    massaan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    massaan.setBounds(108, 135, 82, 25);
    
     //kiihtyvyys X label
    kiihtyvyysX = new JLabel("Pallon kiihtyvyys X akselilla:");
    kiihtyvyysX.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    kiihtyvyysX.setBounds(10,160, 100 , 25);
    
    //kiihtyvyys X TextField
    kiihtyvyyteenX = new JTextField("0");
    kiihtyvyyteenX.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    kiihtyvyyteenX.setBounds(108, 160, 82, 25);
    
     //Kiihtyvyys Y label
    kiihtyvyysY = new JLabel("Pallon Kiihtyvyys Y akselilla:");
    kiihtyvyysY.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    kiihtyvyysY.setBounds(10,185, 100 , 25);
    
    //Kiihtyvyys Y TextField
    kiihtyvyyteenY = new JTextField("0");
    kiihtyvyyteenY.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    kiihtyvyyteenY.setBounds(108, 185, 82, 25);
    
    
    add(simu);
    add(xkordarv);
    add(xkord);
    add(ykordarv);
    add(ykord);
    add(xkordnopeus);
    add(xkordnoparv);
    add(ykordnopeus);
    add(ykordnoparv);
    add(halkaisija);
    add(halkaisijaan);
    add(massa);
    add(massaan);
    add(kiihtyvyysX);
    add(kiihtyvyysY);
    add(kiihtyvyyteenY);
    add(kiihtyvyyteenX);
    add(lisaaPallo);
    add(tyhjenna);
    
    
   }
   
    //lisää pallon simulaatio JPaneeliin.
   public void uusiPallo(){
       
       float xKordi,yKordi,Xvauhti,Yvauhti,halk,massa,mass,kiihX,kiihY;
        
       //Hakee kordinaatit tekstikentistä.
       xKordi = Float.parseFloat(xkordarv.getText());
       yKordi = Float.parseFloat(ykordarv.getText());
        
        //Hakee nopeudet tekstikentistä.
       Xvauhti = Float.parseFloat(xkordnoparv.getText());
       Yvauhti = Float.parseFloat(ykordnoparv.getText());
       
       //hakee korkeuden ja leveyden
       halk = Float.parseFloat(halkaisijaan.getText());
       
       //hakee massan
       mass = Float.parseFloat(massaan.getText());
       
       //hakee kiihtyvyydet
       kiihX = Float.parseFloat(kiihtyvyyteenX.getText());
       kiihY = Float.parseFloat(kiihtyvyyteenY.getText());
       
       //lähetätään kontrollerille pallon parametrit joka luo uuden pallon piirräpalllo oliolla
       ohjain.piirrapallo(xKordi,yKordi,Xvauhti,Yvauhti,halk,mass,kiihX,kiihY); 
       
       
    }
   
   //actionPerformer napeille lisää ja tyhjennä
    public void actionPerformed(ActionEvent e){
       if(e.getSource() == lisaaPallo){
          
           //kutsuu uusipallo funktion joka lähettää tarvittavat tiedot kontrollerille
           uusiPallo();
           
        }
        if(e.getSource() == tyhjenna){
            
           //tyhjentää simulaattori ikkunan
           simu.removeAll();
           simu.updateUI();
           
           //lähettää kontrollerille komennon tyhjentää kontrollerin arraylistin
           ohjain.poistaPallot();
           
        }
    }
    
    public void kontroller(PalloSimulaattori ohjain){
        //esitellään kontrolleri pääikkunalle
        this.ohjain = ohjain;
    }
    
}

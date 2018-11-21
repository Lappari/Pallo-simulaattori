/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pallo.simulaattori;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.geom.Ellipse2D.Double;


/**
 *
 * @author Lappari
 */
public class piirrapallo extends JPanel{
    
    public void painComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D oval = new Ellipse2D.Double(200,200,40,40);
        g2.fill(oval);
        g2.setPaint(Color.RED);
        g2.draw(oval);
    }
}

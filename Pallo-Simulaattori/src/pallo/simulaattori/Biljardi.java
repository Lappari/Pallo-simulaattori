/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pallo.simulaattori;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Janari
 */
public class Biljardi extends javax.swing.JFrame implements MouseMotionListener, MouseListener {
    
    private BufferedImage bi;
    private Pallo[] pallot = new Pallo[10];
    private Color bgvari = new Color(10,127,10);
    private Timer timer = new Timer();
    
    private class Pallo{
        
        String nimi;
        double r;
        Vektorit p,v,vp;
        Color vari;
        
        public Pallo(String nimi, double px, double py, double vx, double vy, double r, Color vari) {
            this.nimi = nimi;
            this.r = r;
            p = new Vektorit(px, py, Color.BLACK);
            v = new Vektorit(vx, vy, Color.BLACK);
            vp = new Vektorit(0, 0, Color.BLACK);
            this.vari = vari;
    }
        
        public void draw(Graphics g) {
            g.setColor(vari);
            g.fillOval((int) (p.getX() - r / 2), (int) (p.getY() - r / 2), (int) r, (int) r);
            v.piirra(g, p);
            g.setColor(Color.BLACK);
            g.drawString(nimi, (int) p.getX(), (int) p.getY());
        }
        
        public boolean tormays(Pallo b) {
            return p.vahenna(b.p, vari).getKoko() <= (r / 2 + b.r / 2);
        }

        public double tormaysEro(Pallo b) {
            return (p.vahenna(b.p, vari).getKoko() - (r / 2 + b.r / 2));
    }
        
         public void siirraEnergia(Pallo b) {
            
            
            Vektorit nv2 = p.vahenna(b.p, vari);
            nv2.normalisoi();
            nv2.kerro(v.piste(nv2)); 
         
         Vektorit nv1 = v.vahenna(nv2, Color.yellow);
         
         Vektorit nv2b = b.p.vahenna(p, vari);
            nv2b.normalisoi();
            nv2b.kerro(b.v.piste(nv2b));
            
            Vektorit nv1b = b.v.vahenna(nv2b, Color.yellow);

            b.v = nv2.lisaa(nv1b, vari);
            v = nv1.lisaa(nv2b, vari);
        }
         
          public void paivita() {
            p.setX(p.getX() + v.getX());
            p.setY(p.getY() + v.getY());
            for (Pallo b : pallot) {
                if (this != b && tormays(b)) {
                    p.setX(p.getX() - v.getX());
                    p.setY(p.getY() - v.getY());
                    siirraEnergia(b);
                    break;
                
}
}
            Paivitaseiniintormays();
            Otakitkamukaan();
          }
          
private void Paivitaseiniintormays() {
            // borda
            if (p.getX()-r<-getWidth()/2){
                v.setX(Math.abs(v.getX()));
            }
            else if (p.getX()+r>getWidth()/2){
                v.setX(-Math.abs(v.getX()));
            }
            if (p.getY()-r<-getHeight()/2){
                v.setY(Math.abs(v.getY()));
            }
            else if (p.getY()+r>getHeight()/2){
                v.setY(-Math.abs(v.getY()));
            }
}

private void Otakitkamukaan() {
            v.setX(v.getX() * 0.985);
            v.setY(v.getY() * 0.985);
        }

        @Override
        public String toString() {
            return nimi; 
        
        }
    }
    
    public Biljardi() {
        Alustakomponentit();
        
        bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

        pallot[0] = new Pallo("A", 100, 60, 0, 0, 50, Color.BLUE);
        pallot[1] = new Pallo("B", 100, -60, 0, 0, 50, Color.RED);
        pallot[2] = new Pallo("C", 10, 26, 0, 0, 50, Color.ORANGE);
        pallot[3] = new Pallo("D", 10, -26, 0, 0, 50, Color.BLACK);
        pallot[4] = new Pallo("E", -200, 0, 40, 0, 50, Color.WHITE);
        
        pallot[5] = new Pallo("F", -200, 200, 0, 0, 50, new Color(1000));
        pallot[6] = new Pallo("G", -140, 200, 0, 0, 50, new Color(5000));
        pallot[7] = new Pallo("H",  -80, 200, 0, 0, 50, new Color(9000));
        pallot[8] = new Pallo("I",  -20, 200, 0, 0, 50, new Color(13000));
        pallot[9] = new Pallo("J",   40, 200, 0, 0, 50, new Color(17000));

        

    
  addMouseListener(this);
        addMouseMotionListener(this);

        timer.schedule(new MainLoop(), 100, 20);  
}
    
 @SuppressWarnings("unchecked")
                              
    private void Alustakomponentit() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );
        pack();
    }
    
public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Biljardi().setVisible(true);
            }
        });
}

public void update() {
        for (Pallo b : pallot) {
            b.paivita();
        }
    }
    
    @Override
    public void paint(Graphics g) {
        piirra(bi.getGraphics());
        g.drawImage(bi, 0, 0, null);
    }
    
    public void piirra(Graphics g) {
        ((Graphics2D) g).setBackground(bgvari);
        g.clearRect(0, 0, getWidth(), getHeight());
        
        g.drawString("mouse: (" + mousePointer.x + ", " + mousePointer.y + ")", 50, 50);

        g.translate(getWidth() / 2, getHeight() / 2);
        ((Graphics2D) g).scale(1, -1);

        for (Pallo b : pallot) {
            b.draw(g);
        }
        
        //g.setColor(Color.DARK_GRAY);
        //g.drawLine((int) balls[4].p.getX(), (int) balls[4].p.getY(), mousePointer.x, mousePointer.y);
    }

    @Override
    protected void processKeyEvent(KeyEvent e) {
        super.processKeyEvent(e);
        if (e.getKeyCode() == 37) {
            //v1.setX(v1.getX() - 5);
        } else if (e.getKeyCode() == 39) {
            //v1.setX(v1.getX() + 5);
        }

        if (e.getKeyCode() == 38) {
            //v1.setY(v1.getY() + 5);
        } else if (e.getKeyCode() == 40) {
            //v1.setY(v1.getY() - 5);
        }
        repaint();
    }

    private class MainLoop extends TimerTask {

        @Override
        public void run() {
            update();
            try {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        repaint();
                    }
                });
            } catch (Exception ex) {
                Logger.getLogger(Biljardi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // --- Mouse ---
    
    private Point mousePointer = new Point(0, 0);

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousePointer.x = e.getX() - getWidth() / 2;
        mousePointer.y = getHeight() / 2 - e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         Vektorit bm = new Vektorit(mousePointer.x, mousePointer.y, Color.BLACK);
        pallot[4].v = bm.vahenna(pallot[4].p, Color.BLACK);
        //balls[4].v.normalize();
        pallot[4].v.kerro(0.1);
        if (pallot[4].v.getKoko() > 100) {
            pallot[4].v.kerro(100 / pallot[4].v.getKoko());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}

          


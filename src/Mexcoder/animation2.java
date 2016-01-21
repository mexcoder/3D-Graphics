/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import Mexcoder.Graphics.Graphics3D.CubicPrism;
import Mexcoder.Graphics.Graphics3D.Point3D;
import Mexcoder.Graphics.Graphics3D.PolyLine;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author JuanAntonio
 */
public class animation2 extends JVentana {

    BufferedImage buffer;
    Graphics bg;
    PolyLine c,s;
    Timer t;
    boolean show = true;

    // 0 = x, 1 = y; z = 3;
    int dir = 0;
    double scale = 1;

    public animation2() {
        super("polylinea use las teclas X, Y & Z para modificar el eje presione"
                + " ? para ayuda");
    }

    public void init() {

        this.setResizable(false);

        buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        bg = buffer.getGraphics();

        c = new PolyLine(new Point3D(-300, 0, 0), buffer);
        s = new PolyLine(new Point3D(-300, 0, 0), buffer);
        
        double x=0,y=0;
        
        for(int i = 1; i< 3600;i++){
            
            x = Math.toRadians(i)*10;//Math.sin(Math.toRadians(i)) *10;
            y = Math.sin(Math.toRadians(i)) *10;
            
            c.addPoint(new Point3D(x-300,y,0));
            s.addPoint(new Point3D(x-300,y,0));
        }
        
         
        for(int i = 3600; i> 1 ;i--){
            
            x = Math.toRadians(i)*10;//Math.sin(Math.toRadians(i)) *10;
            y = Math.sin(Math.toRadians(i)) *10;
                                   
            s.addPoint(new Point3D(x-300,y,100));
            if( y == -10 || y == 10 || y == 0){ // -10 < y < 10
                s.addPoint(new Point3D(x-300,y,1));
                s.addPoint(new Point3D(x-300,y,100));
            }
        }
        
            s.addPoint(new Point3D(x-300,y,0));
        
        c.pack();
        s.pack();
        
        JPanel frame = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                g.drawImage(buffer, 0, 0, Color.WHITE, this);

            }
        };

        t = new Timer(10, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                bg.fillRect(0, 0, WIDTH, HEIGHT);
                
                if(show)
                    c.draw();
                else
                    s.draw();
                frame.repaint();

            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

                char code = e.getKeyChar();
                //System.out.println(code);
                switch (code) {
                    case 'x':
                        c.rotateX(0.01);
                        s.rotateX(0.01);
                        break;
                    case 'y':
                        c.rotateY(0.01);
                        s.rotateY(0.01);
                        break;
                    case 'z':
                        c.rotateZ(0.01);
                        s.rotateZ(0.01);
                        break;
                    case '+':
                        scale +=.2;
                        c.scale(1.2);
                        s.scale(1.2);
                        break;
                    case '-':
                        if (scale > 0.4) {
                            scale -=.2;
                            c.scale(0.8);
                            s.scale(0.8);
                        }
                        break;
                    case 't':
                        show = !show;
                        break;
                    case 'r':
                        c.restore();
                        s.restore();
                        break;
                            
                    case '?':
                        JOptionPane.showMessageDialog(null, "use r to reset, x,y,z to change the axis of rotation, + / - to change the size,t to toggle between line and sourface");
                        break;

                }

            }

        });

        this.add(frame);
        t.start();
        this.setVisible(true);
    }

    @Override
    protected void appExit() {
        t.stop();
    }

}
    


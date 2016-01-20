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
    PolyLine c;
    Timer t;

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
        
        for(int i = 1; i< 3600;i++){
            
            double x = Math.toRadians(i)*10;//Math.sin(Math.toRadians(i)) *10;
            double y = Math.sin(Math.toRadians(i)) *10;
            double z = x/100;
            
            c.addPoint(new Point3D(x-300,y,z));
        }
        
        c.pack();
        
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
                
                c.draw();
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
                        break;
                    case 'y':
                        c.rotateY(0.01);
                        break;
                    case 'z':
                        c.rotateZ(0.01);
                        break;
                    case '+':
                        scale +=.2;
                        c.scale(1.2);
                        break;
                    case '-':
                        if (scale > 0.4) {
                            scale -=.2;
                            c.scale(0.8);
                        }
                        break;
                    case '?':
                        JOptionPane.showMessageDialog(null, "use x,y,z to change the axis of rotation, + / - to change the size");
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
    


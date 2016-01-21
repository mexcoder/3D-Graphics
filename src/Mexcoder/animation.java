/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder;

import Mexcoder.Graphics.Graphics3D.CubicPrism;
import Mexcoder.Graphics.Graphics3D.Point3D;
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
public class animation extends JVentana {

    BufferedImage buffer;
    Graphics bg;
    CubicPrism c;
    Timer t;

    // 0 = x, 1 = y; z = 3;
    int dir = 0;
    double scale = 1;

    public animation() {
        super("cubo animado use las teclas X, Y & Z para cambiar el eje presione"
                + " ? para ayuda");
    }

    public void init() {

        this.setResizable(false);

        buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        bg = buffer.getGraphics();

        c = new CubicPrism(new Point3D(0, 0, 0), new Point3D(100, 100, 100), buffer);

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
                switch (dir) {
                    case 0:
                        c.rotateX(0.01);
                        break;
                    case 1:
                        c.rotateY(0.01);
                        break;
                    case 2:
                        c.rotateZ(0.01);
                        break;
                }
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
                        if (dir != 0) {
                            dir = 0;
                            /*c.restore();
                            c.scale(scale);*/
                        }
                        break;
                    case 'y':
                        if (dir != 1) {
                            dir = 1;
                            /*c.restore();
                            c.scale(scale);*/
                        }
                        break;
                    case 'z':
                        if (dir != 2) {
                            dir = 2;
                            /*c.restore();
                            c.scale(scale);*/
                        }
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
                    case 'r':
                        c.restore();
                        break;
                    case '?':
                        JOptionPane.showMessageDialog(null, "use r to reset, x,y,z to change the axis of rotation, + / - to change the size");
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

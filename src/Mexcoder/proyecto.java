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
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author JuanAntonio
 */
public class proyecto extends JVentana {

    BufferedImage buffer;
    Graphics bg;
    CubicPrism c, c2;
    PolyLine pl;
    Timer t;

    // 0 = x, 1 = y; z = 3;
    int dir = 0;
    double scale = 1;

    public proyecto() {
        super("proyecto");
    }

    public void init() {

        this.setResizable(false);

        buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        bg = buffer.getGraphics();

        c = new CubicPrism(new Point3D(-25, -25, -25), new Point3D(25, 25, 25), buffer);
        c2 = new CubicPrism(new Point3D(0, 0, 0), new Point3D(50, 50, 50), buffer);

        double sin, cos;
        for (int i = 0; i < 360; i++) {
            sin = Math.sin(Math.toRadians(i));
            cos = Math.cos(Math.toRadians(i));
            Point3D p = new Point3D(sin * 200, cos * 200, (sin * sin) * 200);
            if (pl == null) {
                pl = new PolyLine(p, buffer);
            } else {
                pl.addPoint(p);
            }
        }
        
        pl.pack();

        JPanel frame = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                g.drawImage(buffer, 0, 0, Color.WHITE, this);

            }
        };

        t = new Timer(10, new ActionListener() {

            int i = 0, r = 0;
            double sin, cos;
            Point3D p;

            @Override
            public void actionPerformed(ActionEvent e) {

                bg.fillRect(0, 0, WIDTH, HEIGHT);
                c.restore();

                sin = Math.sin(Math.toRadians(i));
                cos = Math.cos(Math.toRadians(i));

                c2.rotateZ(0.01);
                p = new Point3D(sin * 200, cos * 200, (sin * sin) * 200);
                c.translate(p);
                //pl.addPoint(p);
                //pl.pack();
                pl.draw();
                c.draw();
                c2.draw();
                frame.repaint();
                r += 0.01;
                i++;

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

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
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author JuanAntonio
 */
public class Graphics_test4 extends JVentana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graphics_test4 v = new Graphics_test4();
        v.setResizable(false);
        v.setVisible(true);

    }

    BufferedImage buffer;
    Graphics bg;
    CubicPrism c;

    public void init() {
        this.setResizable(false);
        buffer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        bg = buffer.getGraphics();

        c = new CubicPrism(new Point3D(40, 40, 40), new Point3D(100, 100, 100), buffer);

        c.draw();

        c.setColor(Color.BLUE).scale(2.0).translate(new Point3D(-200, 0, 0))
                .draw();

        c.restore().setColor(Color.red).translate(new Point3D(200, 0, 0))//.draw();
                .rotateZ(Math.toRadians(30)).draw();

        /*uncomment to display the axis guides
        IsometricLine l = new IsometricLine(buffer);
        l.draw(new Point3D(-100, 0, 0), new Point3D(100, 0, 0),Color.RED);
        l.draw(new Point3D(0, -100, 0), new Point3D(0, 100, 0),Color.GREEN);
        l.draw(new Point3D(0, 0, -100), new Point3D(0, 0, 100),Color.blue);*/
        JPanel frame = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {

                g.drawImage(buffer, 0, 0, Color.WHITE, this);

            }
        };

        this.add(frame);

        this.setVisible(true);

        //Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, width, height);
    }

    public Graphics_test4() {
        super("isometrico");
        this.init();
        new animation().init();
        new animation2().init();
    }

}

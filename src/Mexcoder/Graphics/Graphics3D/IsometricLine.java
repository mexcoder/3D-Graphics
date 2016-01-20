package Mexcoder.Graphics.Graphics3D;

import Mexcoder.Graphics.BrensenhamLine;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JuanAntonio
 */
public class IsometricLine extends BrensenhamLine {

    Point3D start, end;
    Point3D proyection;
    Point offset;

    protected final double sin30 = 0.5;
    protected final double cos30 = 0.8660254037844386467637231707529361834714026269051903;

    public IsometricLine(BufferedImage c) {
        super(c);
        start = new Point3D(0, 0, 0);
        end = new Point3D(0, 0, 0);
        offset = new Point(c.getWidth() / 2, c.getHeight() / 2);

    }

    public void draw(Point3D start, Point3D end, Color c) {

        Color tmp = this.c;
        this.setColor(c);
        this.draw(start, end);
        this.setColor(tmp);

    }

    protected void draw(Point3D start, Point3D end) {

        double x0, y0,x1,y1;
        x1 = end.x * cos30 - end.y * sin30;
        y1 = end.x * sin30 + end.y * cos30;

        x0 = start.x * cos30 - start.y * sin30;
        y0 = start.x * sin30 + start.y * cos30;

        // z translates directly to y
        super.draw(offset.x + (int) x0, (int) (offset.y + y0 - start.z),
                   offset.x + (int) x1, (int) (offset.y + y1 - end.z));

    }

    public void setCenter(int x, int y) {
        this.offset.x = x;
        this.offset.y = y;
    }

    protected Point translateCordinates(Point3D p) {

        double x, y;

        x = p.x * cos30 - p.y * sin30;
        y = p.x * sin30 + p.y * cos30;

        return new Point((int) x, (int) (y + p.z));
    }

}

package Mexcoder.Graphics.Graphics3D;

import Mexcoder.Graphics.BrensenhamLine;
import Mexcoder.Graphics.Graphics3D.Pixel;
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

    protected void draw(double x0, double y0, double z0, double x1, double y1, double z1) {

        _draw(new Point3D(x0, y0, z0), new Point3D(x1, y1, z1));

    }

    protected void _draw(Point3D start, Point3D end) {

        double x, y;
        x = end.x * cos30 - end.y * sin30;
        y = end.x * sin30 + end.y * cos30;

        end.x = x;
        end.y = y;

        x = start.x * cos30 - start.y * sin30;
        y = start.x * sin30 + start.y * cos30;

        // z translates directly to y
        super.draw(offset.x + (int) x, (int) (offset.y + y - start.z),
                offset.x + (int) end.x, (int) (offset.y + end.y - end.z));

    }

    public void draw(Point3D start, Point3D end) {

        double x, y;
        x = end.x * cos30 - end.y * sin30;
        y = end.x * sin30 + end.y * cos30;

        end.x = x;
        end.y = y;

        x = start.x * cos30 - start.y * sin30;
        y = start.x * sin30 + start.y * cos30;

        // z translates directly to y
        super.draw(offset.x + (int) x, (int) (offset.y + y - start.z),
                offset.x + (int) end.x, (int) (offset.y + end.y - end.z));

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

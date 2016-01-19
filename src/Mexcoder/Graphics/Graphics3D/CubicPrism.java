/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder.Graphics.Graphics3D;

import java.awt.image.BufferedImage;

/**
 *
 * @author JuanAntonio
 */
public class CubicPrism extends IsometricLine {

    public CubicPrism(BufferedImage c) {
        super(c);
    }

    @Override
    public void draw(Point3D start, Point3D end) {

        Point3D _start, _end;
        double x0 = start.x;
        double y0 = start.y;
        double z0 = start.z;
        double x1 = end.x;
        double y1 = end.y;
        double z1 = end.y;

        super.draw(x0, y0, z0, x0, y1, z0);
        super.draw(x0, y0, z0, x1, y0, z0);
        super.draw(x0, y1, z0, x1, y1, z0);
        super.draw(x1, y0, z0, x1, y1, z0);
        super.draw(x0, y0, z1, x0, y1, z1);
        super.draw(x0, y0, z1, x1, y0, z1);
        super.draw(x0, y1, z1, x1, y1, z1);
        super.draw(x1, y0, z1, x1, y1, z1);

        super.draw(x0, y0, z0, x0, y0, z1);
        super.draw(x1, y0, z0, x1, y0, z1);
        super.draw(x0, y1, z0, x0, y1, z1);
        super.draw(x1, y1, z0, x1, y1, z1);

        /*_start = new Point3D(start);
        _end = new Point3D(end.x, start.y, start.z);
        
        // x0,y0,z0 -> x1,y0,z0
        super.draw(_start, _end);
        
        _end.y = end.y;
        _end.x = start.x;
        
        //x0,y0,z0 -> x0,y1,z0
        super.draw(_start, _end);
        
        _end.x = end.x;
        _start.y = end.y;
        
        //x0,y1,z0 -> x1,y1,z0
        super.draw(_start, _end);
        
        _start.x = end.x;
        _start.y = start.y;
        
        //x1,y0,z0 -> x1,y1,z0
        //super.draw(_start, _end);
        
        _start.z  = end.z;
        _end.z = end.z;
        // x0,y0,z0 -> x1,y0,z0
        super.draw(_start, _end);
        
        _end.y = end.y;
        _end.x = start.x;
        
        //x0,y0,z0 -> x0,y1,z0
        super.draw(_start, _end);
        
        _end.x = end.x;
        _start.y = end.y;
        
        //x0,y1,z0 -> x1,y1,z0
        super.draw(_start, _end);
        
        _start.x = end.x;
        _start.y = start.y;
        
        //x1,y0,z0 -> x1,y1,z0
        //super.draw(_start, _end);*/
    }

}

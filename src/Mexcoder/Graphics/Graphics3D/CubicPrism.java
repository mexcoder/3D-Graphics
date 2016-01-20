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
public class CubicPrism extends Entity3D {

    public CubicPrism(Point3D o, Point3D e, BufferedImage c) {
        super(o, e, c);
    }

    protected Entity3D calculatePoints() {

        if (this.points.isEmpty()) {
            for (int i = 0; i < 8; i++) {
                this.points.add(new Point3D(Point3D.zero));
            }

        }
        Point3D s = this.origin;
        Point3D e = this.end;

        this.points.get(0).fromPoint(s);
        this.points.get(1).setValues(s.x, e.y, s.z);
        this.points.get(2).setValues(e.x, s.y, s.z);
        this.points.get(3).setValues(e.x, e.y, s.z);
        this.points.get(4).setValues(s.x, s.y, e.z);
        //simetry point
        this.points.get(5).setValues(s.x, e.y, e.z);
        this.points.get(6).setValues(e.x, s.y, e.z);
        this.points.get(7).fromPoint(e);

        return this;

    }

    @Override
    public Entity3D drawAt(Point3D p) {
        
        for (Point3D point : points) {
            System.out.println(point.x+","+point.y+","+point.z);
            
        }

        super.draw(points.get(7), points.get(3));
        super.draw(points.get(7), points.get(5));
        super.draw(points.get(7), points.get(6));
        
        super.draw(points.get(3), points.get(1));
        super.draw(points.get(3), points.get(2));
        
        super.draw(points.get(4), points.get(5));
        super.draw(points.get(4), points.get(6));
        
        super.draw(points.get(1), points.get(5));
        
        super.draw(points.get(2), points.get(6));

        //hidden lines:
        if (this.drawHidden) {
            l.setMask((byte) 0b00011100);
            super.draw(points.get(0), points.get(1));
            super.draw(points.get(0), points.get(2));
            super.draw(points.get(0), points.get(4));
            l.setMask((byte) 0xff);
        }

        return this;
    }

}

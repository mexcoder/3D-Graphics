/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder.Graphics.Graphics3D;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author JuanAntonio
 */
public abstract class Entity3D {

    Point3D origin, end;
    IsometricLine l;
    boolean drawHidden = true;
    ArrayList<Point3D> points;

    public abstract Entity3D drawAt(Point3D p);

    protected abstract Entity3D calculatePoints();

    public Entity3D(Point3D start, Point3D end, BufferedImage target) {

        this.origin = new Point3D(start);
        this.end = new Point3D(end);
        l = new IsometricLine(target);
        points = new ArrayList<>();
        this.calculatePoints();

    }

    public Entity3D draw() {
        return this.drawAt(Point3D.zero);
    }

    public Entity3D restore() {

        this.calculatePoints();
        return this;
    }

    //radians
    public Entity3D rotateX(double angle) {

        /**
         * double y = this.p_origin.y; double z = this.p_origin.z;
         * this.p_origin.y = y * Math.cos(angle) - z * Math.sin(angle);
         * this.p_origin.z = y * Math.sin(angle) + z * Math.cos(angle);
         *
         * y = this.end.y; z = this.end.z; this.p_end.y = y * Math.cos(angle) -
         * z * Math.sin(angle); this.p_end.z = y * Math.cos(angle) - z *
         * Math.sin(angle);
         *
         */
        return this;

    }

    //radians
    public Entity3D rotateZ(double angle) {

        double x;//= this.p_origin.x; 
        double y;//= this.p_origin.y;

        for (Point3D point : points) {

            x = point.x;
            y = point.y;
            point.x = x * Math.cos(angle) - y * Math.sin(angle);
            point.y = x * Math.sin(angle) + y * Math.cos(angle);

        }
        /*this.p_origin.x = x * Math.cos(angle) - y * Math.sin(angle);
        this.p_origin.y = x * Math.sin(angle) + y * Math.cos(angle);*/

        return this;
    }

    public Entity3D scale(Double factor) {

        for (Point3D point : points) {
            point.x = point.x * factor;
            point.y = point.y * factor;
            point.z = point.z * factor;
        }

        /*this.p_origin.x = this.p_origin.x * factor;
        this.p_origin.y = this.p_origin.y * factor;
        this.p_origin.z = this.p_origin.z * factor;*/

 /*this.p_end.x = (this.p_end.x * factor) - this.p_origin.x;
        this.p_end.y = this.p_end.y * factor - this.p_origin.y;
        this.p_end.z = this.p_end.z * factor - this.p_origin.z;*/
        return this;
    }

    public Entity3D translate(Point3D destination) {

        for (Point3D point : points) {

            point.x = point.x + destination.x;
            point.y = point.y + destination.y;
            point.z = point.z + destination.z;

        }

        /*this.p_origin.x = this.p_origin.x + destination.x;
        this.p_origin.y = this.p_origin.y + destination.y;
        this.p_origin.z = this.p_origin.z + destination.z;

        this.p_end.x = this.p_end.x + destination.x;
        this.p_end.y = this.p_end.y + destination.y;
        this.p_end.z = this.p_end.z + destination.z;*/
        return this;

    }

    public Entity3D setColor(Color c) {

        l.setColor(c);
        return (this);
    }

    //TODO: add a if to draw isometrict / perspective
    protected void draw(Point3D p1, Point3D p2) {
        l.draw(p1, p2);
    }

}

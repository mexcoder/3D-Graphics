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
        
        double y; 
        double z;

        for (Point3D point : points) {

            y = point.y;
            z = point.z;
            point.y = y * Math.cos(angle) - z * Math.sin(angle);
            point.z = y * Math.sin(angle) + z * Math.cos(angle);

        }

        return this;

    }
    
    //radians
    public Entity3D rotateY(double angle) {
        
        double x; 
        double z;

        for (Point3D point : points) {

            x = point.x;
            z = point.z;
            point.x = x * Math.cos(angle) + z * Math.sin(angle);
            point.z = z * Math.cos(angle) - x * Math.sin(angle);

        }

        return this;

    }

    //radians
    public Entity3D rotateZ(double angle) {

        double x; 
        double y;

        for (Point3D point : points) {

            x = point.x;
            y = point.y;
            point.x = x * Math.cos(angle) - y * Math.sin(angle);
            point.y = x * Math.sin(angle) + y * Math.cos(angle);

        }

        return this;
    }

    public Entity3D scale(Double factor) {

        for (Point3D point : points) {
            point.x = point.x * factor;
            point.y = point.y * factor;
            point.z = point.z * factor;
        }
        return this;
    }

    public Entity3D translate(Point3D destination) {

        for (Point3D point : points) {

            point.x = point.x + destination.x;
            point.y = point.y + destination.y;
            point.z = point.z + destination.z;

        }
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

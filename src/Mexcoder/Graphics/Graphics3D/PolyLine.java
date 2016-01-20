/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder.Graphics.Graphics3D;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author JuanAntonio
 */
public class PolyLine extends Entity3D{
    
    ArrayList<Point3D> original_points;

    public PolyLine(Point3D start, BufferedImage target) {
        super(start, start, target);
        original_points = new ArrayList<>();
        this.addPoint(start);
        this.calculatePoints();
    }

    @Override
    public Entity3D drawAt(Point3D p) {
        Point3D p1 = null;
        for (Point3D point : points) {
            
            if(p1 != null)
                super.draw(p1,point);
            p1 = point;
        }
        return this;
    }

    @Override
    protected Entity3D calculatePoints() {
        if(original_points != null)
            points = (ArrayList<Point3D> ) original_points.clone();
        return this;
    }
    
    public Entity3D addPoint(Point3D p){
        
        original_points.add(p);
        
        return this;
        
    }
    
    public Entity3D pack(){
        this.calculatePoints();
        return this;
    }
    
}

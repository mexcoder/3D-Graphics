/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mexcoder.Graphics.Graphics3D;

/**
 *
 * @author JuanAntonio
 */
public class Point3D{
    
    public double x,y,z;
    
    public static final Point3D zero = new Point3D(0,0,0);
    
    public Point3D(Point3D p){
        this(p.x,p.y,p.z);
    }
    
    public Point3D(double x, double y, double z) {
        this.setValues(x, y, z);
    }
    
    public void setValues(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public void fromPoint(Point3D p) {
        this.x = p.x;
        this.y = p.y;
        this.z = p.z;
    }
}

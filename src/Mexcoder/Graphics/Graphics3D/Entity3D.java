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
public abstract class Entity3D {

    Point3D origin, end, p_origin, p_end;

    public Entity3D(Point3D start, Point3D end) {

        this.origin = this.p_origin = start;
        this.end = this.p_end = end;

    }

    public abstract Entity3D drawAt(Point3D p);

    public Entity3D drawAt() {
        return this.drawAt(Point3D.zero);
    }

    public Entity3D restore() {

        this.p_origin = this.origin;
        this.p_end = this.end;
        return this;
    }

    public Entity3D rotate(Point3D rotation) {

        return this;
    }

    public Entity3D scale(Double factor) {

        this.p_origin.x = this.p_origin.x * factor;
        this.p_origin.y = this.p_origin.y * factor;
        this.p_origin.z = this.p_origin.z * factor;

        this.p_end.x = this.p_end.x * factor;
        this.p_end.y = this.p_end.y * factor;
        this.p_end.z = this.p_end.z * factor;

        return this;
    }

    public Entity3D translate(Point3D destination) {

        return this;
        
    }

}

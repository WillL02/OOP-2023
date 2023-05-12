package ie.tudublin;

import java.util.Vector;

import processing.core.PApplet;
import processing.core.PVector;

public class GameObject {
   protected PVector pos;
    
    protected float rot;
    protected PVector forward;
    protected PApplet p;
    protected int c;

    public GameObject(float x, float y, float rot, int c, PApplet p) 
    {
        pos = new PVector(x, y);
        forward = new PVector(0, -1);
        this.p = p;
        this.rot = rot;
        this.c = c;

    }
}
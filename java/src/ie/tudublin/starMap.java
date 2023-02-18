package ie.tudublin;

import processing.core.PApplet;

public class starMap extends PApplet {

	int mode = 0;

	public void settings() {
		size(800,800);
	}

	public void setup() {
		background(0);;
	}

	public void keyPressed() {

		mode = key - '0';
		println(mode);
	}

	float off = 0;

	public void draw() 
	{
		

	}

}

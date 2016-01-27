package demos;

import processing.core.PApplet;
import processing.core.PImage;

public class TestPApplet extends PApplet{
	
	PImage img;
	public void setup() {
		//Add setup code for MyPApplet
		size(200,200);				//set canvas size
		img = loadImage("palmTrees.jpg", "jpg");

	}
	
	public void draw() {
		img.resize(0, height);			//resize loaded image to full height of canvas
		image(img, 0, 0);			//display image 

		
		int[] color = sunColorSet(second());
		fill(color[0],color[1],color[2]);
		ellipse(width/4,height/5,width/5,height/5);	
		fill(250);
		text(second(), 45, 45);
	}
	
	public int[] sunColorSet(float seconds)
	{
		int[] rgb = new int[3];
		
		float diffFrom30 = Math.abs(30-seconds);
		
		float ratio = diffFrom30/30;
		rgb[0] = (int)(255*ratio);
		rgb[1] = (int)(255*ratio);
		rgb[2] = 0;
		
		return rgb;
		
	}

		
}

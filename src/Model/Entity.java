package Model;

import java.awt.Color;
import java.awt.Image;

public abstract class Entity {
	int x, y;
	Image img;
	Color color;

	public Entity(int xC, int yC, Image icon) {
		x = xC;
		y = yC;
		img = icon;
	}
	
	public Image getImg(){
		return img;
	}
	
	public abstract void act();
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}

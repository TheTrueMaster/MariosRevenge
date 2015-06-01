package Model;

import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class Enemy extends Entity implements Destroyable{
	
	int health;
//
	public Enemy(int x, int y, BufferedImage icon) {
		super(x, y, icon);
		this.hasHealth = true;
		this.status = true;
		health = 1;
	}
	
	
	
}

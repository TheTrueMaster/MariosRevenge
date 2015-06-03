package Model;

import java.awt.image.BufferedImage;

import View.Level;

public class Fireball extends Entity {

	private int distanceMoved;
	private boolean isMovingRight;
	private int moveImage;

	public Fireball(int x, int y, BufferedImage icon, boolean movingRight) {
		super(x, y, icon);
		distanceMoved = 0;
		moveImage = 0;
		isMovingRight = movingRight;
	}

	public void move(){
		if(distanceMoved != 10){
			if(isMovingRight){
				this.xLoc += Level.movePixels;
				distanceMoved++;
			}
			else{
				this.xLoc -= Level.movePixels;
				distanceMoved++;
			}
		}
		else{
			this.changeStatus();
		}
	}



}

package Model;

import java.awt.image.BufferedImage;
import ImportManager.*;
import View.Level;

public class Fireball extends Entity {

	private int distanceMoved;
	private boolean isMovingRight;
	private int moveImage;

	public Fireball(int x, int y, boolean movingRight) {
		super(x, y, ImportManager.fireball[0]);
		distanceMoved = 0;
		moveImage = 0;
		isMovingRight = movingRight;
	}

	public void move(){
		if(distanceMoved != -10){
			if(isMovingRight){
				this.xLoc += Level.movePixels;
				distanceMoved++;
			}
			else{
				this.xLoc -= Level.movePixels;
				distanceMoved++;
			}
			moveImage++;
		}
		else{
			this.changeStatus();
		}
	}
	
	@Override
	public BufferedImage getImg(){
		if(moveImage == 4){
			moveImage = 0;
		}
		int temp = moveImage;
		
		try{
			BufferedImage wtf = ImportManager.fireball[temp];
		}
		catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
		return ImportManager.fireball[temp];
	}



}

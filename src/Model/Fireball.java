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
		if(col + 1 != Level.cols){
			if(isMovingRight){
				this.xLoc += Level.movePixels;
				distanceMoved++;
				if(distanceMoved == 3){
					distanceMoved = 0;
					col++;
				}
			}
			else{
				this.xLoc -= Level.movePixels;
				distanceMoved++;
				if(distanceMoved == 3){
					distanceMoved = 0;
					col--;
				}
			}
			moveImage++;
		}
		else{
			this.changeStatus();
		}
		
	}
	
	public boolean isMovingRight(){
		return isMovingRight;
	}
	
	public int getTimesMoved(){
		return distanceMoved;
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

	public void interact(Entity ent) {
		if(ent instanceof Mushroom){
			Mushroom e = (Mushroom) ent;
			e.changeStatus();//because mushrooms only have one health
		}
		if(ent == null){
			this.move();
			return;//so the fireball doesn't remove itself from the map
		}
		
		//by default, if the fire ball has interacted, the fireball should now no longer be on the map
		this.changeStatus();
		
	}



}

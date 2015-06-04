package Model;

import java.awt.Image;
import java.awt.image.BufferedImage;

import View.Level;
import ImportManager.*;

public class Mushroom extends Enemy {

	private int imageNo;
	private boolean readyToBeKilled;
	private int timesMovedLeft;
	private int timesMovedRight;
	public int moveDir;

	/**
	 * Initializes the Mushroom
	 * @param x
	 * @param y
	 * @param icon
	 */
	public Mushroom(int x, int y, BufferedImage icon) {
		super(x, y, icon);
		imageNo = 0;
		readyToBeKilled = false;
		moveDir = 0;
	}



	public boolean canBeRemoved(){
		if(!this.getStatus()){
			if(readyToBeKilled){
				return true;
			}
			else{
				readyToBeKilled = true;
			}
		}
		return false;
	}
	//kills itself
	public void kill(){
		this.sprite = ImportManager.deadMush;
		this.changeStatus();
	}


	@Override
	public BufferedImage getImg(){
		if(imageNo == 2){
			imageNo = 0;
		}
		return ImportManager.mush[imageNo];
	}

	public void moveRight(){
		if (moveDir == 0){
			xLoc = xLoc += Level.movePixels;
		}
	}

	public void moveLeft(){
		if (moveDir == 180){
			xLoc = xLoc -= Level.movePixels;
		}

	}

	public void move()
	{
		if (moveDir == 0){
			moveRight();
		}
		else if (moveDir == 180)
		{
			moveLeft();
		}
	}

	public void setMoveDir(int dir)
	{
		moveDir = dir;
	}
	
	public int getMoveDir()
	{
		return moveDir;
	}

	public boolean isMovingRight(){
		if (moveDir == 0)
		{
			return true;
		}

		else return false;
	}

	public boolean isMovingLeft(){
		if (moveDir == 180)
		{
			return true;
		}
		else return false;
	}


	/* @Override
	public void interact(Entity other) {
		//Pseudocode: recognizes what kind of entity is being interacted with
		// and interacts accordingly
		if (other instanceof Player)
		{
			giveAbility((Player)other);
		} */

}





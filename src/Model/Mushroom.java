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
		moveDir = 1;
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
		if (moveDir > 1){
			xLoc = xLoc += Level.movePixels;
			timesMovedRight++;
		}
	//	return timesMovedRight;
	}

	public void moveLeft(){
		if (moveDir < 1){
			xLoc = xLoc -= Level.movePixels;
			timesMovedLeft++;
		}
		//return timesMovedRight;
	}

	public void move(int cols)
	{
		if (moveDir > 1 && timesMovedRight != cols){
			moveRight();
			if (timesMovedRight == cols)
			{
				setMoveDir(-1);
			}
		}
		
		else if (moveDir < 1 && timesMovedLeft != cols)
		{
			moveLeft();
			if (timesMovedLeft == cols)
			{
				setMoveDir(1);
			}
		}
	}
	
	public void setMoveDir(int dir)
	{
		moveDir = dir;
	}

	public boolean isMovingRight(){
		if (moveDir > 1)
		{
			return true;
		}

		else return false;
	}

	public boolean isMovingLeft(){
		if (moveDir < 1)
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





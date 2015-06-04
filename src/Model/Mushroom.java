package Model;

import java.awt.Image;
import java.awt.image.BufferedImage;

import View.Level;
import ImportManager.*;

public class Mushroom extends Enemy {

	private int imageNo;
	private boolean readyToBeKilled;
	private int timesMoved;
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
		timesMoved = 0;
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
		xLoc = xLoc + Level.movePixels/2;
		timesMoved++;
		//xLoc = xLoc += Level.width;

	}

	public void moveLeft(){
		xLoc = xLoc - Level.movePixels/2;
		timesMoved --;
		//xLoc = xLoc -= Level.width;
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
		if (moveDir == 1)
		{
			return true;
		}

		else return false;
	}

	public boolean isMovingLeft(){
		if (moveDir == -1)
		{
			return true;
		}
		else return false;
	}

	public int getTimesMoved(){
		return timesMoved;
	}

	public void resetTimesMoved(){
		timesMoved = 0;
	}




	@Override
	public void interact(Entity other) {
		//Pseudocode: recognizes what kind of entity is being interacted with
		// and interacts accordingly
		if (other instanceof Player)
		{
			Player p = ((Player)other);
			setMoveDir(-moveDir);

			p.setHealth(p.getHealth() - 1);
		} 

		else if(other instanceof Platform){
			setMoveDir(-moveDir);
		}
	}


}





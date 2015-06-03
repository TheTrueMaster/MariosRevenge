package Model;

import java.awt.Image;
import java.awt.image.BufferedImage;

import ImportManager.*;

public class Mushroom extends Enemy {

	private int imageNo;
	private boolean readyToBeKilled;
	
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
	
	public int moveRight(){
		
	}
	
	public int moveLeft(){
		
	}
	
	public void move(int cols)
	{
		
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





package Model;

import java.awt.Image;
import ImportManager.ImportManager;
import View.Level;

public class Player extends Entity {

	protected int playerHealth;

	private boolean movingRight, movingLeft, jumping, falling;//Booleans So GUI can see players current status
	private int moveImage;
	private int timesMoved;
	private int yTraveled;

	public Player(int x, int y, Image icon) {
		super(x, y, icon);
		this.hasHealth = true;
		playerHealth = 1;
		movingRight = false;
		movingLeft = false;
		jumping = false;
		falling = false;
		moveImage = 0;
		timesMoved = 1;
		yTraveled = 0;
	}


	public int getTimesMoved(){
		return timesMoved;
	}

	public void resetTime(){
		timesMoved = 0;
	}
	public Image getImg(){

		return ImportManager.mario[moveImage];
	}
	public void setHealth(int a)
	{
		playerHealth = a;
	}

	public int getHealth()
	{
		return playerHealth;
	}


	public void interact(Entity other) {
		if (other instanceof Powerup)
		{
			((Powerup)other).giveAbility(this);			
		}

		else if (other instanceof Destroyable)
		{

			if (other instanceof Enemy)
			{
				//if the player is jumping on the enemy
				if (getX() == other.getX() && getY() == other.getY() && getVelY() < 0)
				{
					((Enemy)other).changeStatus();
				}
				//if the player is next to the enemy
				else
				{
					setHealth(playerHealth - 1);
					changeStatus();
				}
			}

			else if (other instanceof Box )
			{
				if (getX() == other.getX() && getY() == other.getY() && getVelY() > 0)
				{
					if (other instanceof Powerbox)
					{
						//((Powerbox)other).getPowerup(this);			
					}

					((Box)other).changeStatus();
				}
			}

		}

		else if (other instanceof Standable)
		{
			falling = false;
		}

	}

	public void changeAnimation(){
		if(moveImage == 4){
			moveImage = 0;
		}
		int m = moveImage;
		moveImage++;
	}

	public void resetAnimation(){
		moveImage = 0;
	}
	public boolean isMovingRight(){

		return movingRight;
	}

	public boolean isMovingLeft(){
		return movingLeft;
	}

	public boolean isFalling(){
		return falling;
	}

	public boolean isJumping(){
		return jumping;
	}

	public void changeMovingStatus(String dir){
		if(dir.equals("right")){
			movingRight = !movingRight;
		}

		else if(dir.equals("left")){
			movingLeft = !movingLeft;
		}

		 else if(dir.equals("up")){
			jumping = !jumping;
		} 

		else if(dir.equals("falling")){
			falling = !falling;
		}

	}

	public int getYTraveled()
	{
		return yTraveled;
	}


	public void moveRight() {
		xLoc = xLoc += Level.movePixels;
		timesMoved++;
	}


	public void moveLeft() {
		xLoc = xLoc -= Level.movePixels;
		timesMoved --;
	}


	public void moveDown() {
		yLoc += Level.movePixels;

	}

	public int moveUp(int velY)
	{
		//If the player is stationary in y, then the player
        // must not be jumping. The variable 'yTraveled' is
        // reset to avoid problems.
		if (getVelY() == 0) { 
		
			jumping = false;
			yTraveled = 0;
		} 

		//If the velocity is greater than 0, i.e. row is increasing, then
		//the player must be falling.
		else if (getVelY() > 0)
		{
			falling = true;
		}

		else jumping = true;
		
		
		//temp stores current yLoc. yLoc is modified according to current
		//y velocity and gravity to move player.
		int temp = yLoc;
		yLoc += velY + Level.gravity;

		//These changes should only occur if the player is falling.
		//If the player is on a platform, it is no longer falling and 
		//so the player will move downwards (y velocity is updated) until
		// reaching a platform, if any.
		if (falling)
		{

			//Terminal velocity is gravity (5). So this checks if the difference
			//between current velocity and terminal vel is at more than or equal 
			//to gravity. If so, it decreases the velocity.
			if (Level.gravity - getVelY() >= 5){
				setVelY(getVelY() + Level.gravity);
			}
			
			//otherwise if the velocity is not terminal but the difference
			//is less than the magnitude of gravity than it decreases 
			//y velocity by whatever's left.
			else if (velY < 5){

				setVelY(Level.gravity);
			}
		}

		//returns the difference in the old and new locations.
		yTraveled = yLoc - temp;

		return yTraveled;

	}


	/**
	 * Sets TimesMoved to 0
	 */
	public void resetTimesMoved() {
		timesMoved = 0;
	}

}

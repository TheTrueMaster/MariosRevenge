package Model;

import java.awt.Image;
import ImportManager.ImportManager;
import View.Level;

public class Player extends Entity {

	protected int playerHealth;

	private boolean movingRight, movingLeft, jumping, falling, hitPlatform;//Booleans So GUI can see players current status
	private int moveImage;
	private int timesMoved;
	private int yTraveled;
	//
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
			if(getY() > other.getY()){
				falling = true; // :D
				hitPlatform = true;

			}
			else if(getY() < other.getY()){


				falling = false;
			}
		}

	}

	public void changeAnimation(){
		if(moveImage == 4){
			moveImage = 0;
		}
		int m = moveImage;
		moveImage++;
	}

	/**
	 * Resets The Players Picture to its default
	 */
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

	/**
	 * Returns whether the player is jumping
	 * @return
	 */
	public boolean isJumping(){
		return jumping;
	}

	/**
	 * Toggles the moving status of dir
	 * 
	 * @param dir
	 */
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

	/**
	 * Returns the Y pixels the player has traveled
	 * @return
	 */
	public int getYTraveled()
	{
		return yTraveled;
	}


	/**
	 * Visually moves the player right and updates timesMoved
	 */
	public void moveRight() {
		xLoc = xLoc += Level.movePixels;
		timesMoved++;
	}


	/**
	 * Visually moves the player left and updates timesMoved
	 */
	public void moveLeft() {
		xLoc = xLoc -= Level.movePixels;
		timesMoved --;
	}


	/**
	 * Visually Moves the player down
	 */
	public void moveDown() {
		yLoc += Level.movePixels;

	}
	/**
	 * Returns the pixels traveled in y direction. If it is less than zero,
	 * direction moved is up, if it is greater than zero direction moved is down.
	 * @param velY
	 * @return
	 */
	public void moveUp(int velY)
	{
		//If the player is stationary in y, then the player
		// must not be jumping. The variable 'yTraveled' is
		// reset to avoid problems.
		setVelY(velY);

		/*if (getVelY() == 0) { 

			jumping = false;
		} */

		//If the velocity is greater than 0, i.e. row is increasing, then
		//the player must be falling.
		if (getVelY() <= 0)
		{
			falling = true;
		}

		else if (getVelY() < 0){ 
			jumping = true;
		}


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

			if (hitPlatform)
			{
				hitPlatform = false;
				setVelY(0);
			}
			// if 
			//velY + gravity

			//

			//Terminal velocity is gravity (5). So this checks if the difference
			//between current velocity and terminal vel is at more than or equal 
			//to gravity. If so, it decreases the velocity.
			else{
				if (getVelY() < 0)
				{

					if (getVelY() > -5)
					{
						setVelY(0);
					}
					//if (Level.gravity - getVelY() >= 5){
					else{
						setVelY(getVelY() + Level.gravity);
					}
					//}

					//otherwise if the velocity is not terminal but the difference
					//is less than the magnitude of gravity than it decreases 
					//y velocity by whatever's left.
					/*	else if (velY < 5){

					setVelY(Level.gravity);
				} */
				}

				else if (getVelY() > 0)
				{
					if (Level.gravity - getVelY() <= 5){
						setVelY(getVelY() + Level.gravity);
					}

					//otherwise if the velocity is not terminal but the difference
					//is less than the magnitude of gravity than it decreases 
					//y velocity by whatever's left.
					else if (velY < 5){

						setVelY(Level.gravity);
					}
				}
			}
		}



	}


	/**
	 * Sets TimesMoved to 0
	 */
	public void resetTimesMoved() {
		timesMoved = 0;
	}

	@Override
	/**
	 * Returns whether the player is dead or not. So if the player's health is below
	 * 0, the method will return false
	 */
	public boolean getStatus(){
		if(playerHealth <= 0){
			return false;
		}
		return true;
	}
}

package Model;

import java.awt.Image;
import java.awt.image.BufferedImage;

import ImportManager.ImportManager;
import View.Level;

public class Player extends Entity {

	protected int playerHealth;

	private boolean movingRight, movingLeft, jumping, falling, isInJump, hasJumped, standing;//Booleans So GUI can see players current status
	private int moveImage;
	private int timesMoved;
	private int yTraveled;
	private Powerup ability = null;
	//
	public Player(int x, int y, BufferedImage icon) {
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
	//this is a change
	public void resetTime(){
		timesMoved = 0;
	}
	
	public BufferedImage getImg(){
		if(ability == null){
			return ImportManager.mario[moveImage];
		}
		else{
			return ImportManager.fireMario[moveImage];
		}
	}

	public void setHealth(int a)
	{
		playerHealth = a;
	}

	public int getHealth()
	{
		return playerHealth;
	}
	
	public boolean hasJumped()
	{
		if(hasJumped){
			return true;
		}
		return false;
	}
	
	public void toggleJumped()
	{
		hasJumped = !hasJumped;
	}
	
	

//made changes
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
				falling = true;
				isInJump = true;
				//hitPlatform = true;
				setVelY(0);
				setY(other.getY() - Level.height);

			}
			else if(getY() < other.getY()){


				falling = false;
				hasJumped = false;
				jumping = false;
				isInJump = false;
				setVelY(0);
				standing = true;
				setY(other.getY() + Level.height);
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

	public void changeImage(){
		moveImage = 0; //stub code
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
			
			jumping = true;
			isInJump = true;
			//toggleJumped();
			
		} 

		else if(dir.equals("falling")){
			falling = true;
		}

	}

	/**
	 * Returns the Y pixels the player has traveled
	 * @return
	 */
	/*public int getYTraveled()
	{
		return yTraveled;
	} */


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
		if (isInJump)
		{
			setVelY(velY);

			if (getVelY() >= 0)
			{
				falling = true;
				jumping = false;
			}

			else if (getVelY() < 0){ 
				jumping = true;
				falling = false;
			}

			//	int temp = yLoc;
			yLoc += getVelY() + Level.gravity;


			if (jumping){

				if (getVelY() < 0)
				{

					if (0 - getVelY() >= Level.gravity)
					{
						setVelY(getVelY() + Level.gravity);
					}

					else{
						setVelY(0);
					}
				}
			}

			else if (falling)
			{
				if (Level.MAX_FALL_SPEED - getVelY() >= 0 && Level.MAX_FALL_SPEED - getVelY() >= Level.gravity ){
					setVelY(getVelY() + Level.gravity);
				}

				else if (getVelY() < Level.MAX_FALL_SPEED){

					setVelY(Level.MAX_FALL_SPEED);
				}
			}
		}
	}


	public void givePowerup(Powerup pwr) {
		ability = pwr;
		
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


	public void setStanding(boolean bool){
		standing = bool;
	}
	
	public boolean isStanding() {
		// TODO Auto-generated method stub
		return standing;
	}


	public void setFalling(boolean b) {
		falling  = b;
		
	}
}

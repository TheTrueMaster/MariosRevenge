package Model;

import java.awt.Image;
import ImportManager.ImportManager;
import View.Level;

public class Player extends Entity {

	protected int playerHealth;

	private boolean movingRight, movingLeft, jumping, falling;//Booleans So GUI can see players current status
	private int moveImage;

	public Player(int x, int y, Image icon) {
		super(x, y, icon);
		this.hasHealth = true;
		playerHealth = 1;
		movingRight = false;
		movingLeft = false;
		jumping = false;
		falling = false;
		moveImage = 0;
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
				if (getX() == other.getX() && getY() == other.getY() && getVelY() < 0)
				{
					((Enemy)other).changeStatus();
				}

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


	public void moveRight() {
		xLoc = xLoc += Level.movePixels;

	}


	public void moveLeft() {
		xLoc = xLoc -= Level.movePixels;
		
	}
}

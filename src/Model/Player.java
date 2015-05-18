package Model;

import java.awt.Image;

public class Player extends Entity {

	int playerHealth;
	boolean falling;

	public Player(int x, int y, Image icon) {
		super(x, y, icon);
		this.hasHealth = true;
		playerHealth = 1;
	}

	public void setHealth(int a)
	{
		playerHealth = a;
	}

	public int getHealth()
	{
		return playerHealth;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub

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
}

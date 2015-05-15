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
	
	public void addHealth(int a)
	{
		playerHealth += a;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub

	}

	@Override
	public void interact(Entity other) {
		// TODO Auto-generated method stub
		if (other instanceof Mushroom || other instanceof Fireflower)
		{
			other.interact(this);
			other.changeStatus();
		}
		
		else if (other instanceof Platform)
		{
			other.interact(this);
		}
		
	}
}

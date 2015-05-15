package Model;

import java.awt.Image;

public class Mushroom extends Entity implements Powerup {

	public Mushroom(int x, int y, Image icon) {
		super(x, y, icon);
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub

	}

	@Override
	public void giveAbility(Player p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void interact(Entity other) {
		//Pseudocode: recognizes what kind of entity is being interacted with
		// and interacts accordingly
		if (other instanceof Player)
		{
			giveAbility((Player)other);
			changeStatus();
		}

	}



}

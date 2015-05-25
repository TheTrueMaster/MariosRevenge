package Model;

import java.awt.Image;

public class Mushroom extends Entity implements Powerup {

	public Mushroom(int x, int y, Image icon) {
		super(x, y, icon);
	}



	@Override
	public void giveAbility(Player p) {
		// TODO Auto-generated method stub
		p.setHealth(p.getHealth() + 1);

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





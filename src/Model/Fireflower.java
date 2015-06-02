package Model;

import java.awt.image.BufferedImage;

public class Fireflower extends Entity implements Powerup{

	
	/**
	 * Initializes the powerup
	 * @param x
	 * @param y
	 * @param icon
	 * @param pwr
	 */
	public Fireflower(int x, int y, BufferedImage icon) {
		super(x, y, icon);
	}


	/**
	 * Adjusts the Player's Properties Accordingly
	 */
	@Override
	public void giveAbility(Player p) {
		// TODO Auto-generated method stub
		p.setHealth(p.getHealth() +1);
		
		p.givePowerup();

	}
}

package Model;

import java.awt.Image;

public class Boss extends Entity{
	
	int bossHealth;

	public Boss(int x, int y, Image icon, int health) {
		super(x, y, icon);
		this.hasHealth = true;
		bossHealth = health;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interact(Entity other) {
		// TODO Auto-generated method stub
		
	}

	

}

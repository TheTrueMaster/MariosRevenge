package Model;

import java.awt.Image;
import java.awt.image.BufferedImage;

import ImportManager.*;

public class Mushroom extends Enemy implements Powerup {

	private int imageNo;
	public Mushroom(int x, int y, BufferedImage icon) {
		super(x, y, icon);
		imageNo = 0;
	}

//

	public void kill(){
		this.sprite = ImportManager.deadMush;
		this.changeStatus();
	}
	@Override
	public void giveAbility(Player p) {
		// TODO Auto-generated method stub
		p.setHealth(p.getHealth() + 1);

	}
	
	@Override
	public BufferedImage getImg(){
		if(imageNo == 2){
			imageNo = 0;
		}
		int im = imageNo;
		imageNo++;
		return ImportManager.mush[im];
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





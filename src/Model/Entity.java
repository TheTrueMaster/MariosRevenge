package Model;

import java.awt.Image;

public abstract class Entity {

	int xLoc , yLoc;
	boolean status, hasHealth;

	Image sprite;

	public Entity(int x, int y, Image icon) {
		// TODO Auto-generated constructor stub
		xLoc = x;
		yLoc = y;
		sprite = icon;
	}

	public abstract void interact(Entity other);
	
	public int getX()
	{
		return xLoc;
	}

	public int getY()
	{
		return yLoc;
	}

	public Image getImg(){
		return sprite;
	}
	
	public abstract void act();

	public boolean getStatus()
	{
		return status;
	}
	
	public void changeStatus(){
		status = !status;
	}
	
}
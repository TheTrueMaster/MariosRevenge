package Model;

import java.awt.Image;

public class Entity {

	int xLoc, yLoc;
	boolean status, hasHealth;

	Image sprite;

	public Entity(int x, int y, Image icon) {
		// TODO Auto-generated constructor stub
		xLoc = x;
		yLoc = y;
		sprite = icon;
	}

	public Image getSprite()
	{
		return sprite;
	}

	public int getX()
	{
		return xLoc;
	}

	public int getY()
	{
		return yLoc;
	}

	public void act()
	{

	}

	public boolean getStatus()
	{
		return status;
	}
}
package Model;

<<<<<<< HEAD
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
=======
import java.awt.Color;
import java.awt.Image;

public abstract class Entity {
	int x, y;
	Image img;
	Color color;

	public Entity(int xC, int yC, Image icon) {
		x = xC;
		y = yC;
		img = icon;
	}
	
	public Image getImg(){
		return img;
	}
	
	public abstract void act();
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
>>>>>>> origin/master
	}
}

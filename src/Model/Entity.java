package Model;

import java.awt.Image;

public abstract class Entity {

	int xLoc , yLoc;
	boolean status, hasHealth;
	
	int velocityX;
	int velocityY;
	
	Image sprite;

	public Entity(int x, int y, Image icon) {
		// TODO Auto-generated constructor stub
		xLoc = x;
		yLoc = y;
		sprite = icon;
		velocityX = 0;
		velocityY = 0;
	}

	//public abstract void interact(Entity other);
	
	public void setVelX(int x){
		velocityX = x;
	}
	
	public void setVelY(int y){
		velocityY = y;
	}
	
	public int getVelX(){
		return velocityX;
	}
	
	public int getVelY(){
		return velocityY;
	}
	
	public int getX()
	{
		return xLoc;
	}

	public int getY()
	{
		return yLoc;
	}

	public void setX(int x){
		this.xLoc = x;
	}
	
	public void setY(int y){
		this.yLoc = y;
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
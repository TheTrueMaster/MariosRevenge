package Model;

import java.awt.Image;

public  class Entity {

	int xLoc , yLoc;
	boolean status, hasHealth;
	
	int velocityX;
	int velocityY;
	
	Image sprite;
	char self;
	public Entity(int x, int y, Image icon) {
		// TODO Auto-generated constructor stub
		xLoc = x;
		yLoc = y;
		sprite = icon;
		velocityX = 0;
		velocityY = 0;
		self = 'G';
	}
	
	public Entity(){
		xLoc = 0;
		yLoc = 0;
		sprite = null;
		velocityX = 0;
		velocityY = 0;
		self = 'G';
	}
	
	public void setChar(char set){
		self = set;
	}

	public char getChar(){
		return self;
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
	

	public boolean getStatus()
	{
		return status;
	}
	
	public void changeStatus(){
		status = !status;
	}
	
}
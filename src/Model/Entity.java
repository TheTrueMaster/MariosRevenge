package Model;

import java.awt.Image;

public  class Entity {

	protected int xLoc , yLoc;
	protected boolean status, hasHealth;
	
	protected int velocityX;
	protected int velocityY;
	
	protected int row, col;
	
	protected Image sprite;
	protected char self;
	
	protected int timesMoved = 0;//increases until object has moved into next cell
	
	public Entity(int x, int y, Image icon){
		xLoc = x;
		yLoc = y;
		sprite = icon;
		velocityX = 0;
		velocityY = 0;
		self = 'G';
	}
	
	public String toString(){
		return "Row: " + row + " Col: " + col;
	}
	public Entity(int x, int y, Image icon, int xC, int yC) {
		xLoc = x;
		yLoc = y;
		sprite = icon;
		velocityX = 0;
		velocityY = 0;
		self = 'G';
		row = xC;
		col = yC;
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

	/**
	 * The char array coord
	 */
	public void setRow(int x){
		row = x;
	}
	
	public int getRow(){
		return row;
	}
	
	public void setCol(int y){
		col = y;
	}
	
	public int getCol(){
		return col;
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
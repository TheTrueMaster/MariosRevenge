package Model;

import java.awt.image.BufferedImage;

public class Powerbox extends Box implements Standable{

	protected Powerup ability;
	
	/**
	 * Initializes the Powerbox
	 * 
	 * WARNING: YOU MUST CALL THE THE SET POWERUP METHOD IN ORDER TO PROPERLY INIT THIS
	 * 
	 * @param x
	 * @param y
	 * @param icon
	 */
	public Powerbox(int x, int y, BufferedImage icon) {
		super(x, y, icon);
	}
	
	/**
	 * Returns the powerup that this box holds
	 * @return
	 */
	public Powerup getPowerup(){
		return ability;
	}
	
	/**
	 * Sets the powerup that this box holds                                      
	 * 1 - Basic Pwrup (Optional Functionality) 2 - FireFlower
	 * 
	 * ONLY SUPPORTS FireFlower right now
	 * @param pwr
	 */
	public void setPowerup(int pwr){
		this.setPowerup(6);
	}


}


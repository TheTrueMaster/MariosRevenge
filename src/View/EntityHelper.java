package View;

import java.awt.Rectangle;
import java.util.ArrayList;

import Model.Entity;
import Model.Player;

/**
 * A class so I can work on entity collision without causing merge conflicts with the 
 * jumping code
 * @author Ronak Shah
 *
 *
 * All methods in the class are static
 */
public class EntityHelper {
	/**
	 * Checks if the two Entities passes in have collided
	 * @param a (Entity)
	 * @param b (Entity)
	 * @return boolean value
	 */
	public static boolean hasCollided(Entity a, Entity b) {
		if(a == null || b == null){
			return false;
		}
		Rectangle aBounds = a.getBounds();
		Rectangle bBounds = b.getBounds();
		// Check if the boundaries intersect
		if (aBounds.intersects(bBounds)) {
			return true;
		}

		return false;
	}

	public static Entity getEnt(int row, int col, ArrayList<Entity> inGameObs) {

		for(Entity e : inGameObs){
			if(e.getRow() == row && e.getCol() == col)
				return e;
		}

		return null;
	}

	public static Entity getEntityBelow(Entity e, ArrayList<Entity> inGameObs) {

		Entity ent = getEnt(e.getRow() + 1, e.getCol(), inGameObs);
		return ent;
	}

	public static Entity getEntitytoLeft(Entity e, ArrayList<Entity> inGameObs){
		Entity ent = getEnt(e.getRow(), e.getCol() - 1, inGameObs);
		return ent;
	}

	public static Entity getEntitytoRight(Entity e, ArrayList<Entity> inGameObs){
		Entity ent = getEnt(e.getRow(), e.getCol() + 1, inGameObs);
		return ent;
	}

}

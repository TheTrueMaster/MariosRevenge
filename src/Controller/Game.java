package Controller;

import java.util.*;
import Model.*;

public class Game {

	Map<String, Entity> objects;
	Entity[][] grid;
	ClassLoader cldr;
	
	public Game(ClassLoader c) {
		objects = new HashMap<String, Entity>();
		objects.put("player", new Player(10, 10, null));
		cldr = c;
	}
	
	public Map<String, Entity> getObjects(){
		return objects;
	}
	
	public Player getPlayer(){
		return (Player)objects.get("player");
	}
	
	public ClassLoader getCldr(){
		return cldr;
	}

}

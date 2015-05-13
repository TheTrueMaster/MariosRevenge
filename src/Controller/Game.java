package Controller;

import java.util.ArrayList;

import Model.*;

public class Game {

	ArrayList<Entity> objects;
	
	public Game() {
		objects = new ArrayList<Entity>();
		//objects.add(new Player(10));
	}
	
	public ArrayList<Entity> getObjects(){
		return objects;
	}

}

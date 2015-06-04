package Model;

import java.awt.image.BufferedImage;

public class Exit extends Entity {

	private boolean levelCompleted;
	
	public Exit(int x, int y, BufferedImage icon) {
		super(x, y, icon);
		levelCompleted = false;
	}
	
	public void toggleCompleted(){
		levelCompleted = !levelCompleted;
	}

	public boolean isDone() {
		return levelCompleted;
	}
	

}

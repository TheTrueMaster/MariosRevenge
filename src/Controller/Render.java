package Controller;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.net.URL;

import Model.*;

public class Render {

	private Map<Character, ImageIcon> pics;

	public Render() {
		
	}

	public void init(Game game) {

	}

	public ImageIcon getImage(char c) {

		return pics.get(c);

	}


}

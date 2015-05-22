package Controller;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.*;

public class Render {

	private Map<Character, ImageIcon> pics;
	
	public Render() {
		//Reads In All The Pictures
	}

	public void init(Game game) {
		ClassLoader cldr = game.getCldr();
		
	}

	public ImageIcon getImage(char c) {
		// TODO Auto-generated method stub
		return new ImageIcon("res/fish.gif");//stubCode
		//return pics.get(c);
		//^^ what the code will be eventually
	}
	
	
}

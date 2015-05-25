package Controller;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import java.net.URL;

import ImportManager.ImportManager;
import Model.*;

public class Render {

	private Map<Character, Image> pics;

	public Render() {
		pics = new HashMap<Character, Image>();
		Character character = new Character('[');
		Image img = null;
		//player image
		character = 'p';
		img = ImportManager.player;;
		pics.put(character, img);
		
		 
	}

	public void init(Game game) {

	}

	public ImageIcon getImage(char c) {

		return new ImageIcon(pics.get('p'));

	}


}

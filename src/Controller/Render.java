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

	/*HOW TO PLACE AN IMAGE INTO THE MAP
	 * 
	 *  character = 'NAME OF CHAR ASSOCIATED WITH THIS IMAGE';
	 * 	img = ImportManager.NAME_OF_IMAGE;
	 *	pics.put(character, img);
	 *  and that's it :D
	 * 
	 * */
	public Render() {
		pics = new HashMap<Character, Image>();
		Character character = new Character('[');
		Image img = null;
		//player img
		character = 'p';
		img = ImportManager.mario[0];
		pics.put(character, img);
		
		//enemy img
		
		//platform img
		
		//power up box img
		
		//power img
		
		//box img
		
				 
	}

	public void init(Game game) {

	}

	public ImageIcon getImage(char c) {

		return new ImageIcon(pics.get('p'));
		//return new ImageIcon(pics.get(c);
	}


}

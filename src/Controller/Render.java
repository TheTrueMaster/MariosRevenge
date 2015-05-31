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
		character = 'P';
		img = ImportManager.mario[0];
		pics.put(character, img);
//
		//enemy img
		character = 'M';
		img = ImportManager.mush[0];
		pics.put(character, img);
		//platform img
		character = 'G';
		img = ImportManager.box;
		pics.put(character, img);
		//power up box img
		character = 'B';
		img = ImportManager.box;
		pics.put(character, img);
		//box img
		character = 'A';
		img = ImportManager.pwrBox;
		pics.put(character, img);


	}



	public ImageIcon getImage(char c) {


		//return new ImageIcon(pics.get('P'));
		Image a = (pics.get(c));
		if(a!=null)
			return new ImageIcon(a);
		else
			return new ImageIcon(pics.get('G'));
	}


}

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
		// TODO Auto-generated method stub
		//testing class loader
		//ClassLoader cldr = this.getClass().getClassLoader();

		URL u = ClassLoader.getSystemResource("res/fish.gif");
		
		ImageIcon img = new ImageIcon(u);
		
		return img;
		
		
	
		 //not sure if this works. :/

		//stubCode
		//return pics.get(c);
		//^^ what the code will be eventually
	}


}

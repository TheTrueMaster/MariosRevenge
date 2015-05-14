package Controller;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.*;

public class Render {

	public Render() {
		// TODO Auto-generated constructor stub
	}

	public void init(JPanel panel, Game game) {
		ArrayList<Entity> obs = game.getObjects();
		for(Entity a: obs){
			JLabel b = new JLabel();
			b.setIcon(new ImageIcon(a.getImg()));//
			panel.add(b);
		}
	}
	
	//public 

}

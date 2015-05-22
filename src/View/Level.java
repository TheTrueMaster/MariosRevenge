package View;

import Controller.*;
import Model.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class Level extends JPanel implements KeyListener, ActionListener{

	private JPanel contentPane;
	private Game game;
	public final static int movePixels = 10;
	char[][] level;
	private ClassLoader cldr;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Level(int width, int height, Game g) {
		game  = g;
		init();
		cldr = game.getCldr();
	}

	public void init(){

		setBackground(Color.BLACK);//official constructor will be public Level(int width, int height, int levelNo)
		//setBounds(0, 0, width, height); //OFFICIAL SETBOUNDS, commented out for window builder dev
		setBounds(0,0, 850, 450);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		//initializeLevel(int levelNo
		initializeLevel(1);

	}
	private void initializeLevel(int levelNo) {
		TextLoader loader = new TextLoader();
		try {
			level = loader.getFile("files" + "/" + "lvl" + levelNo + ".txt");
		}
		catch (IOException e) {
			//do nothing
		}


	}


	@Override
	public void paint(Graphics g){
		super.paint(g);
		Render render = new Render();

		g.setColor(Color.white);
		for(int r = 0; r < level.length; r++){
			for(int c = 0; c < level[r].length; c++){
				ImageIcon icon = render.getImage(level[r][c]);
				int x = (c * 16) + 10;
				int y = (r * 30)+20;
				//System.out.print(level[r][c]);
				//g.drawRect(x, y, 15, 35);
				String str = "";
				str += level[r][c];
				g.drawString(str, x, y);
				//Graphics Draw Image Parameters: (Image, X-Coord, Y-Coord, Color, ImageObserver)
				//g.drawImage(icon.getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT), x, y, null, null);
				
			}
			//System.out.println();
		}	
	}
	/**
	 * Draws the given Entity at its Location
	 * 
	 * Designed to make it easier to draw an object
	 * @param e
	 * @param g
	 */
	private void drawObject(Entity e, Graphics g){
		g.drawImage(e.getImg(), e.getX(), e.getY(), this);
	}

	/**
	 * Updates the Player Location
	 * 
	 * Uses Compass Directions:
	 *						90
	 *						||
	 *			180<-------------------->0
	 *						||
	 *						270
	 * @param dir
	 * @param p
	 */

	private void updatePlayer() {
		Player p = game.getPlayer();
		int dir = -1;
		//move player
		if(p.isMovingRight()){
			dir = 0;
		}

		else if(p.isMovingLeft()){
			dir = 180;
		}

		else if(p.isJumping()){
			dir = 90;
		}

		else if(p.isFalling()){
			dir = 270;
		}

		switch(dir){
		case 0:
			p.setX(movePixels + p.getX());
			break;
		case 90:
			p.setX(movePixels + p.getY());
			break;
		case 180:
			p.setX(movePixels - p.getX());
			break;
		case 270:
			p.setX(movePixels - p.getX());
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		/*
		 PUEDOCODE
		 if(rightKey is pressed)
		  	tell player that it is moving right
		 else if(leftKey is pressed)
		 	tell player that it is moving left
		 else if(up key is being pressed)
		 	tell player that it is jumping
		 else
		 	do nothing
		 */
		int keyCode = e.getKeyCode();
		switch( keyCode ) { 
		case KeyEvent.VK_UP:
			// handle up 
			game.getPlayer().changeMovingStatus("up");
			break;
		case KeyEvent.VK_DOWN:
			// handle down 
			game.getPlayer().changeMovingStatus("down");

			break;
		case KeyEvent.VK_LEFT:
			// handle left
			game.getPlayer().changeMovingStatus("left");

			break;
		case KeyEvent.VK_RIGHT :
			// handle right
			game.getPlayer().changeMovingStatus("right");
			break;
		}
		System.out.println(keyCode);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		/*
		 PUEDOCODE
		 if(rightKey is released)
		  	tell player that it is no longer moving right
		 else if(leftKey is released)
		 	tell player that it is no longer moving left
		 else if(up key is being released)
		 	tell player that it is no longer jumping
		 else
		 	do nothing
		 */

		int keyCode = e.getKeyCode();
		switch( keyCode ) { 
		case KeyEvent.VK_UP:
			// handle up 
			game.getPlayer().changeMovingStatus("up");
			break;
		case KeyEvent.VK_DOWN:
			// handle down 
			game.getPlayer().changeMovingStatus("down");

			break;
		case KeyEvent.VK_LEFT:
			// handle left
			game.getPlayer().changeMovingStatus("left");

			break;
		case KeyEvent.VK_RIGHT :
			// handle right
			game.getPlayer().changeMovingStatus("right");
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Key Typed: " + e.getKeyCode());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//before repainting, we update all the Entities locations
		/*Player Movement Code Below*/

		/*End of Player Movement*/

		//Then, after that, we repaint
		repaint();
	}

}

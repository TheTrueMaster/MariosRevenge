package View;

import Controller.*;
import Model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Level extends JFrame implements KeyListener, ActionListener{

	private JPanel contentPane;
	private Game game;
	public final static int movePixels = 10;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Level(int width, int height, Game g) {//official constructor will be public Level(int width, int height, int levelNo)
		//setBounds(0, 0, width, height); //OFFICIAL SETBOUNDS, commented out for window builder dev
		game = g;
		setBounds(0,0, 850, 450);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		//initializeLevel(int levelNo
		initializeLevel();
	}
	
	private void initializeLevel() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void paint(Graphics g){
		super.paint(g);
		
		Player player = game.getPlayer();
		//move player
		if(player.isMovingRight()){
			updatePlayer(0, player);
		}
		
		else if(player.isMovingLeft()){
			updatePlayer(180, player);
		}
		
		else if(player.isJumping()){
			updatePlayer(90, player);
		}
		
		else if(player.isFalling()){
			updatePlayer(270, player);
		}
		
		drawObject(player, g);
	}
	/**
	 * Draws the given Entity at its Location
	 * 
	 * Designed to make it easier to draw an object
	 * @param e
	 * @param g
	 */
	private void drawObject(Entity e, Graphics g){
		g.drawImage(e.getImg(), e.getX(), e.getY(), getContentPane());
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
	
	private void updatePlayer(int dir, Player p) {
		
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
		// TODO Auto-generated method stub
		repaint();
	}

}

package View;


import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.*;

import Controller.*;
import Model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gui extends JFrame implements KeyListener, ActionListener{

	private Game game;
	public static final int movePixels = 10;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Game game = new Game();
		Gui gui = new Gui(game);
		
	}

	/**
	 * Create the application.
	 */
	public Gui(Game g) {
		//Frame Construction
		super("Mario's Revenge");
		getContentPane().setLayout(null);

		//giving private instance variable reference to Game object
		game = g;
		//Creating a Timer that goes off every half second
        Timer timer = new javax.swing.Timer(500, this);

		initialize();
		this.setVisible(true);
		timer.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 734, 492);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
}

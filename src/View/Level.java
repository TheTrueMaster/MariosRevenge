package View;

import Controller.*;
import Model.*;
import Model.Box;//required due Box's name (Too Ambiguous)

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class Level extends JPanel implements KeyListener, ActionListener{

	public static final int width = 26;
	public static final int height = 45;


	private JPanel contentPane;
	private Game game;
	public final static int movePixels = 4;
	char[][] level;//for interaction handling
	ArrayList<Entity> inGameObs;//for visualization (more fluid)
	private Player player;//quick refrence

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Level(int width, int height, Game g) {
		setFocusable(true);
		addKeyListener(this);
		game  = g;
		init();
		javax.swing.Timer timer = new javax.swing.Timer(150, this);
		timer.start();
	}

	public void init(){
		inGameObs = new ArrayList<Entity>();
		setBackground(Color.BLACK);//official constructor will be public Level(int width, int height, int levelNo)
		//setBounds(0, 0, width, height); //OFFICIAL SETBOUNDS, commented out for window builder dev
		setBounds(0,0, 850, 450);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		//initializeLevel(int levelNo
		initializeLevel(1);
		updateArrayList();

	}
	private void updateArrayList() {
		Render render = new Render();

		inGameObs.clear();
		for(int r = 0; r < level.length; r++){
			for(int c = 0; c < level[r].length; c++){
				int x = c* width +10;
				int y = r * height -50;
				ImageIcon img = render.getImage(level[r][c]);
				char entity = level[r][c];
				Entity ent = null;

				switch (entity){
				case 'G'://ground
					ent = new Platform(x, y, img.getImage());
					ent.setCol(c);
					ent.setRow(r);
					inGameObs.add(ent);
					break;
				case 'P'://player
					ent = new Player(x, y, img.getImage());
					ent.setRow(r);
					ent.setCol(c);
					player = (Player) ent;
					inGameObs.add(ent);
					break;
				case 'A'://pwrbox
					ent = new Powerbox(x, y, img.getImage());
					ent.setCol(c);
					ent.setRow(r);
					inGameObs.add(ent);
					break;
				case 'E':
					ent = new Enemy(x, y, img.getImage());
					ent.setCol(c);
					ent.setRow(r);
					inGameObs.add(ent);
					break;
				case 'B':
					ent = new Box(x, y, img.getImage());
					ent.setCol(c);
					ent.setRow(r);
					inGameObs.add(ent);
					break;
				}



			}

		}		

	}

	private void initializeLevel(int levelNo) {
		try {
			level = new TextLoader().getFile(levelNo);
		}
		catch (IOException e) {
			//do nothing
		}

	}


	@Override
	public void paint(Graphics g){

		Image offImage = createImage(this.getWidth(), this.getHeight());

		// Creates an off-screen drawable image to be used for
		// double buffering; XSIZE, YSIZE are each of type ‘int’
		Graphics buffer = offImage.getGraphics();
		// Creates a graphics context for drawing to an 
		// off-screen image
		paintOffScreen(buffer);     // your own method
		g.drawImage(offImage, 0, 0, null);  
		// draws the image with upper left corner at 0,0}

	}

	public void paintOffScreen(Graphics g){
		super.paint(g);

		g.setColor(Color.white);
		for(Entity e : inGameObs){
			//g.drawRect(e.getX(), e.getY(), width, height);
			g.drawImage(e.getImg().getScaledInstance(width, height, Image.SCALE_DEFAULT), e.getX(), e.getY(), this);
		
		}
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
		Player p = player;
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
			shift(p, 0);
			break;
		case 90:
			p.setX(movePixels + p.getY());
			shift(p, 90);

		case 180:
			p.setX(p.getX() - movePixels);
			shift(p, 180);
			break;
		case 270:
			p.setY(p.getY() - movePixels);
			shift(p, 270);
			break;
		}
	}

	private void shift(Player p, int i) {
		p.changeAnimation();
		try{
		//we go into the first switch to asses the direction
		Entity ent;
		switch(i){

		case 0://right
			ent = getEnt(p.getRow(), p.getCol() + 1);
			//now we asses the Entity
			if(ent == null){
				p.moveRight();
				level[p.getRow()][p.getCol()] = ' ';
				p.setCol(p.getCol() + 1);
				level[p.getRow()][p.getCol() + 1] = 'P';
			}
			break;
		case 180://left
			ent = getEnt(p.getRow(), p.getCol() - 1);
			//now we asses the Entity
			if(ent == null){
				//p.moveLeft();
				level[p.getRow()][p.getCol()] = ' ';
				p.setCol(p.getCol() - 1);
				level[p.getRow()][p.getCol() - 1] = 'P';
			}
			break;
		case 90://up
			ent = getEnt(p.getRow() + 1, p.getCol());
			//now we asses the Entity
			if(ent == null){
				//p.moveLeft();
				level[p.getRow()][p.getCol()] = ' ';
				p.setCol(p.getCol() - 1);
				level[p.getRow() + 1][p.getCol()] = 'P';
			}
		}
		}catch(IndexOutOfBoundsException e){}
	}

	private Entity getEnt(int row, int col) {

		for(Entity e : inGameObs){
			if(e.getRow() == row && e.getCol() == col)
				return e;
		}

		return null;
	}



	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("Pressed");
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
			player.changeMovingStatus("up");
			break;
		case KeyEvent.VK_DOWN:
			// handle down 
			player.changeMovingStatus("down");

			break;
		case KeyEvent.VK_LEFT:
			// handle left
			player.changeMovingStatus("left");

			break;
		case KeyEvent.VK_RIGHT :
			// handle right
			player.changeMovingStatus("right");
			break;
		}
		//System.out.println(keyCode);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(player.isMovingRight()){
			player.changeMovingStatus("right");
		}
		if(player.isMovingLeft()){
			player.changeMovingStatus("left");
		}
		if(player.isJumping()){
			player.changeMovingStatus("up");
		}


	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Key Typed: " + e.getKeyCode());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		doAllChecks();


	}

	private void doAllChecks() {
		//before repainting, we update all the Entities locations
		updatePlayer();
		repaint();

	}

}

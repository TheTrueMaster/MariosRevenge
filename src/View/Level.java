package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import Controller.Render;
import Model.*;

@SuppressWarnings("serial")
public class Level extends JPanel implements KeyListener, ActionListener{

	public static final int width = 24;
	public static final int height = 24;

	public static boolean paintable = false;
	private JPanel contentPane;
	public final static int movePixels = 8;
	char[][] level;//for interaction handling
	ArrayList<Entity> inGameObs;//for visualization (more fluid)
	private Player player;//quick refrencej
	private javax.swing.Timer timer = new javax.swing.Timer(15, this);
	public final static int gravity = 6;
	public final static int MAX_FALL_SPEED = gravity + 4;
	private int counter;

	/**
	 * Create the frame.
	 */
	public Level(int width, int height) {
		counter= 0;
		paintable = false;
		setFocusable(true);
		addKeyListener(this);
		init();


	}
	public void start(){
		timer.start();
		paintable = true;
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
		initArrayList();

	}

	@SuppressWarnings("unused")
	private void initArrayList() {
		Render render = new Render();
		ArrayList<Entity> pwrBoxes = new ArrayList<Entity>();
		inGameObs.clear();
		for(int r = 0; r < level.length; r++){
			for(int c = 0; c < level[r].length; c++){
				char entity = level[r][c];
				int x = c* width +10;
				int y = r * height +50;

				if(entity == 'A'){
					paintable =true;
				}

				BufferedImage img = render.getImage(level[r][c]);
				Entity ent = null;
				Rectangle bounds = new Rectangle();

				switch (entity){
				case 'G'://ground
					ent = new Platform(x, y, img);
					ent.setCol(c);
					ent.setRow(r);
					inGameObs.add(ent);
					break;
				case 'P'://player
					ent = new Player(x, y, img);
					ent.setRow(r);
					ent.setCol(c);
					player = (Player) ent;
					inGameObs.add(ent);
					break;
				case 'A'://pwrbox
					ent = new Powerbox(x, y, img);
					ent.setCol(c);
					ent.setRow(r);
					inGameObs.add(ent);
					pwrBoxes.add(ent);
					break;
				case 'M':
					ent = new Mushroom(x, y, img);
					ent.setCol(c);
					ent.setRow(r);
					inGameObs.add(ent);
					break;
				case 'B':
					ent = new Box(x, y, img);
					ent.setCol(c);
					ent.setRow(r);
					inGameObs.add(ent);
					break;
				case 'f':
					ent = new Fireflower(x, y, img);
					ent.setCol(c);
					ent.setRow(r);
					inGameObs.add(ent);
					break;
				}
				if(ent != null){
					bounds.setSize(ent.getImg().getWidth(this), ent.getImg().getHeight(this));
					bounds.setLocation(ent.getX(), ent.getY());
					ent.setBounds(bounds);
				}

			}

		}		
		if(pwrBoxes != null){
			if(pwrBoxes == null){

			}
		}
		inGameObs.addAll(pwrBoxes);
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
		ArrayList<Entity> removeMe = new ArrayList<Entity>();

		g.setColor(Color.white);
		for(Entity e : inGameObs){

			if(e instanceof Player){
				g.drawString("Row: " + e.getRow() + " Col: " + e.getCol() + " TimesMoved: " + ((Player) e).getTimesMoved() + " Health: " + ((Player) e).getHealth() + " VelY: " + e.getVelY(), e.getX(), e.getY());
			}

			if(!e.getStatus()){
				level[e.getRow()][e.getCol()] = ' ';
				removeMe.add(e);
			}
			else
				//g.drawRect(e.getX(), e.getY(), width, height);
				g.drawImage(e.getImg().getScaledInstance(width, height, Image.SCALE_DEFAULT), e.getX(), e.getY(), this);

		}

		for(Entity e: removeMe){
			inGameObs.remove(e);
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
		if (!p.isJumping()){
			Entity ent = getEntityBelowPlayer(p);
			if (ent == null)
			{
				p.setFalling(true);
			}

		}

		if(p.isMovingRight()){
			dir = 0;
		}

		else if(p.isMovingLeft()){
			dir = 180;
		}

		else if(p.isJumping()){
			dir = 90;
		}

		else{
			if(p.isFalling()){
				dir = 270;
			}

		}

		switch(dir){
		case 0:

			shift(p, 0);
			break;
		case 90:

			shift(p, 90);
			break;
		case 180:

			shift(p, 180);
			break;
		case 270:
			//p.setY(p.getY() - movePixels);
			shift(p, 270);
			break;
		}
	}



	private Entity getEntityBelowPlayer(Player p) {
		ArrayList<Entity> debugAL = inGameObs;

		Entity ent = getEnt(p.getRow() + 1, p.getCol());
		return ent;
	}

	private void shift(Player p, int i) {


		try{
			//we go into the first switch to assess the direction

			Entity ent = null;
			switch(i){

			case 0://right
				p.changeAnimation();
				ent = getEnt(p.getRow(), p.getCol() + 1);
				//now we asses the Entity
				if(hasCollided(p, ent)){
					p.interact(ent);
				}
				else{

					p.moveRight();
					if(p.getTimesMoved() == 3){
						level[p.getRow()][p.getCol()] = ' ';
						p.setCol(p.getCol() + 1);
						level[p.getRow()][p.getCol() + 1] = 'P';
						p.resetTimesMoved();
					}

				}

				break;
			case 180://left
				p.changeAnimation();
				ent = getEnt(p.getRow(), p.getCol() - 1);
				//now we asses the Entity
				if(hasCollided(p, ent)){
					p.interact(ent);
				}
				else{
					p.moveLeft();
					if(p.getTimesMoved() == -3){
						level[p.getRow()][p.getCol()] = ' ';
						p.setCol(p.getCol() - 1);
						level[p.getRow()][p.getCol() - 1] = 'P';
						p.resetTimesMoved();
					}
				}
				break;
			case 90://up

				p.resetAnimation();
				ent = getEnt(p.getRow() - 1, p.getCol());

				//now we assess the Entity
				//now, ent is equal to the space directly above mario
				//TODO Write amazing jumping code here
				if(!hasCollided(ent, p)){
					if (!p.hasJumped())
					{
						p.moveUp(-30);
					}

					else
					{
						p.moveUp(p.getVelY());
					}
				}

				else{
					p.interact(ent);
				}


				double playerRowDouble = (double)p.getY() / height;

				int playerRowInt = ((int)p.getY()) / height; 
				double difference = (playerRowDouble - playerRowInt);

				if (difference > 0)
				{
					if (difference > 0.08){
						level[p.getRow()][p.getCol()] = ' ';
						p.setRow((p.getY() / height) - 1);
						level[(p.getY() / height) - 1][p.getCol()] = 'P';
					}

					else {
						level[p.getRow()][p.getCol()] = ' ';
						p.setRow(p.getY() / height);
						level[p.getY() / height][p.getCol()] = 'P';
					}
				}

				if (!p.hasJumped()){
					p.toggleJumped();//sets hasJumped to true
				}
				break;




			case 270:
				p.resetAnimation();
				ent = getEntityBelowPlayer(p);


				//Attempted to have platforms work properly. Would check if there's a platform
				//below, and if so, would set falling to false. Doing this would prevent the player
				//executing the code for changing y, and so the player would simply stop upon hitting a platform.
				// **This change did not work. **

				//ent = null;

				if(!hasCollided(ent, p)){


					p.moveUp(p.getVelY());
				}

				else{
					p.interact(ent);
				}

				playerRowDouble = (double)p.getY() / height;

				playerRowInt = (int)p.getY() / height; 

				difference = (playerRowDouble - playerRowInt);
				if ((difference) > 0)
				{
					if (difference > 0.08){
						//row decreases by whatever the amount of rows moved was.
						level[p.getRow()][p.getCol()] = ' ';
						p.setRow(playerRowInt + 1);
						level[playerRowInt + 1][p.getCol()] = 'P';
					}

					else {
						//row decreases by whatever the amount of rows moved was.
						level[p.getRow()][p.getCol()] = ' ';
						p.setRow(playerRowInt);
						level[playerRowInt][p.getCol()] = 'P';
					}

				}


				break;
			}
		}

		catch(IndexOutOfBoundsException e){
			e.printStackTrace();
		}
	}

	private Entity getEnt(int row, int col) {

		for(Entity e : inGameObs){
			if(e.getRow() == row && e.getCol() == col)
				return e;
		}

		return null;
	}

	/**
	 * Checks if the two Entities passes in have collided
	 * @param a (Entity)
	 * @param b (Entity)
	 * @return boolean value
	 */
	protected boolean hasCollided(Entity a, Entity b) {
		if(a == null || b == null){
			return false;
		}
		Rectangle aBounds = a.getBounds();
		Rectangle bBounds = b.getBounds();
		// Check if the boundaries intersect
		if (aBounds.intersects(bBounds)) {
			return true;
		}

		return false;
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
		if(player.isFalling()){
			player.changeMovingStatus("falling");
		}

		player.resetAnimation();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Key Typed: " + e.getKeyCode());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		counter += 30;
		//if(player.isJumping()){
		//paintable = true;
		//}
		if(paintable)
			doAllChecks();


	}

	private void doAllChecks() {
		//before repainting, we update all the Entities locations
		if(!player.getStatus()){
			this.setVisible(false);

		}
		updatePlayer();
		repaint();

	}

}

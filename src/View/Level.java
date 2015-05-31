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

	public static final int width = 24;
	public static final int height = 24;

	public static boolean paintable = false;
	private JPanel contentPane;
	private Game game;
	public final static int movePixels = 8;
	char[][] level;//for interaction handling
	ArrayList<Entity> inGameObs;//for visualization (more fluid)
	private Player player;//quick refrencej
	private javax.swing.Timer timer = new javax.swing.Timer(30, this);
	public final static int gravity = 5;
	private int counter;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Level(int width, int height, Game g) {
		counter= 0;
		paintable = false;
		setFocusable(true);
		addKeyListener(this);
		game  = g;
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
		updateArrayList();

	}

	private void updateArrayList() {
		Render render = new Render();

		inGameObs.clear();
		for(int r = 0; r < level.length; r++){
			for(int c = 0; c < level[r].length; c++){
				char[][] debug = level;
				int x = c* width +10;
				int y = r * height -50;
				if(r == 11){
					paintable =true;
				}
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
			if(e instanceof Player){
				g.drawString("Row: " + e.getRow() + " Col: " + e.getCol() + " TimesMoved: " + ((Player) e).getTimesMoved() + " Health: " + ((Player) e).getHealth() + " VelY: " + e.getVelY(), e.getX(), e.getY());
			}


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

		else{
			dir = 270;
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
			//we go into the first switch to asses the direction

			Entity ent = null;
			switch(i){

			case 0://right
				p.changeAnimation();
				ent = getEnt(p.getRow(), p.getCol() + 1);
				//now we asses the Entity
				if(ent == null){
					p.moveRight();
					if(p.getTimesMoved() == 3){
						level[p.getRow()][p.getCol()] = ' ';
						p.setCol(p.getCol() + 1);
						level[p.getRow()][p.getCol() + 1] = 'P';
						p.resetTimesMoved();
					}
				}
				else{
					p.interact(ent);
				}
				break;
			case 180://left
				p.changeAnimation();
				ent = getEnt(p.getRow(), p.getCol() - 1);
				//now we asses the Entity
				if(ent == null){
					p.moveLeft();
					if(p.getTimesMoved() == -6){
						level[p.getRow()][p.getCol()] = ' ';
						p.setCol(p.getCol() - 1);
						level[p.getRow()][p.getCol() - 1] = 'P';
					}
				}
				else{
					p.interact(ent);
				}
				break;
			case 90://up
			{
				p.resetAnimation();
				ent = getEnt(p.getRow() - 1, p.getCol());
				//now we asses the Entity
				//now, ent is equal to the space directly above mario
				//TODO Write amazing jumping code here
				if(ent == null ){
					//Gets the difference between new and old locations in y.
					p.moveUp(-30);

					double doubleMoved = (double)p.getY() / height;

					int approxMoved = (int)p.getY() / height; 
					double difference = (doubleMoved - approxMoved) / 24;
					if (difference > 0)
					{
						if (difference > 0.8){
							level[p.getRow()][p.getCol()] = ' ';
							p.setRow((p.getY() / height) + 1);
							level[(p.getY() / height) + 1][p.getCol()] = 'P';
						}

						else {
							level[p.getRow()][p.getCol()] = ' ';
							p.setRow(p.getY() / height);
							level[p.getY() / height][p.getCol()] = 'P';
						}
					}

				}

				else{
					p.interact(ent);
				}

				break;
			}


			case 270:
				p.resetAnimation();
				ent = getEntityBelowPlayer(p);
				//Attempted to have platforms work properly. Would check if there's a platform
				//below, and if so, would set falling to false. Doing this would prevent the player
				//executing the code for changing y, and so the player would simply stop upon hitting a platform.
				// **This change did not work. **

				//ent = null;
				if(ent == null){
					//Similar code to 'case: 90' 

					/*
					int temp = Math.abs(p.moveUp(p.getVelY())) / 24;
					if (temp > 0)

					{
					level[p.getRow()][p.getCol()] = ' ';
					p.setRow(p.getRow() + temp);
					level[p.getRow() + temp][p.getCol()] = 'P';
					} */

					//new code below

					p.moveUp(p.getVelY());

					double doubleMoved = (double)p.getY() / height;

					int approxMoved = (int)p.getY() / height; 

					double difference = (doubleMoved - approxMoved) / 24;
					//int amtMoved = Math.abs(dY) / height;
					//If it is, . . .
					if (Math.abs(difference) > 0)
					{
						//If player moved up (difference is negative)
						if (difference < 0 )
						{
							if (difference <= -0.8){
								//row decreases by whatever the amount of rows moved was.
								level[p.getRow()][p.getCol()] = ' ';
								p.setRow(approxMoved - 1);
								level[approxMoved - 1][p.getCol()] = 'P';
							}

							else {
								//row decreases by whatever the amount of rows moved was.
								level[p.getRow()][p.getCol()] = ' ';
								p.setRow(approxMoved);
								level[approxMoved][p.getCol()] = 'P';
							}

						}

						else 
						{
							if (difference >= 0.8){
								//row decreases by whatever the amount of rows moved was.
								level[p.getRow()][p.getCol()] = ' ';
								p.setRow(approxMoved + 1);
								level[approxMoved + 1][p.getCol()] = 'P';
							}

							else {
								//row decreases by whatever the amount of rows moved was.
								level[p.getRow()][p.getCol()] = ' ';
								p.setRow(approxMoved);
								level[approxMoved][p.getCol()] = 'P';
							}
						}
					}
					else{
						p.interact(ent);
					}

					break;




				}



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
		updatePlayer();
		repaint();

	}

}

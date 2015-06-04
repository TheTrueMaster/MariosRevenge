package ImportManager;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class ImportManager {

	public static BufferedImage title;
	public static BufferedImage instructions;
	public static BufferedImage startLogo;
	public static BufferedImage backToMain;
	public static InputStream lvl1;
	public static BufferedImage player;
	public static BufferedImage[] mario;
	public static BufferedImage[] leftMario;
	public static BufferedImage[] fireMario;
	public static BufferedImage[] fireLeftMario;
	
	public static BufferedImage box;
	public static BufferedImage pwrBox;
	public static BufferedImage[] mush;
	public static BufferedImage deadMush;
	public static BufferedImage platform;
	public static BufferedImage meme;
	public static BufferedImage flower;
	public static BufferedImage fireball[];
	
	public static BufferedImage exit;
	/**
	 * Reads in all the files. MUST BE CALLED FIRST (Like absolutely first) in order to not 
	 * get apon thousands apon thousands apon thousands apon thousands apon thousands 
	 * apon thousands apon thousands apon thousands apon thousands apon thousands of java.lang.NULLPOINTEREXCEPTIONS
	 */
	public static void loadFiles(){
		try{
			player = ImageIO.read(ImportManager.class.getResource("fish.gif"));
			title = ImageIO.read(ImportManager.class.getResource("logo.png"));
			instructions = ImageIO.read(ImportManager.class.getResource("Instructions.png"));
			startLogo = ImageIO.read(ImportManager.class.getResource("start.png"));
			backToMain = ImageIO.read(ImportManager.class.getResource("mainmenuobj.png"));
			lvl1 = ImportManager.class.getResource("lvl1.txt").openStream();
			//InputStream in = ImportManager.class.getClassLoader().getResourceAsStream("/data.sav");
			//initializing mario
			mario = new BufferedImage[7];
			mario[0] = ImageIO.read(ImportManager.class.getResource("sprite_Mario1.png"));
			mario[1] = ImageIO.read(ImportManager.class.getResource("sprite_Mario2.png"));
			mario[2] = ImageIO.read(ImportManager.class.getResource("sprite_Mario3.png"));
			mario[3] = ImageIO.read(ImportManager.class.getResource("sprite_Mario4.png"));
			mario[4] = ImageIO.read(ImportManager.class.getResource("sprite_Mario5.png"));
			mario[5] = ImageIO.read(ImportManager.class.getResource("sprite_Mario6.png"));
			mario[6] = ImageIO.read(ImportManager.class.getResource("sprite_Mario7.png"));

			//left  mario
			leftMario = new BufferedImage[6];
			leftMario[0] = ImageIO.read(ImportManager.class.getResource("sprite_Mario_left1.png"));
			leftMario[1] = ImageIO.read(ImportManager.class.getResource("sprite_Mario_left2.png"));
			leftMario[2] = ImageIO.read(ImportManager.class.getResource("sprite_Mario_left3.png"));
			leftMario[3] = ImageIO.read(ImportManager.class.getResource("sprite_Mario_left4.png"));
			leftMario[4] = ImageIO.read(ImportManager.class.getResource("sprite_Mario_left5.png"));
			leftMario[5] = ImageIO.read(ImportManager.class.getResource("sprite_Mario_left6.png"));
			
			box = ImageIO.read(ImportManager.class.getResource("box.png"));
			pwrBox = ImageIO.read(ImportManager.class.getResource("pwrbox.png"));
			platform = ImageIO.read(ImportManager.class.getResource("platform1.png"));
			mush = new BufferedImage[2];
			mush[0] = ImageIO.read(ImportManager.class.getResource("mushroom1.png"));
			mush[1] = ImageIO.read(ImportManager.class.getResource("mushroom2.png"));
			meme = ImageIO.read(ImportManager.class.getResource("amazingmeme.jpg"));
			
			fireMario = new BufferedImage[6];
			fireMario[0] = ImageIO.read(ImportManager.class.getResource("fireMario1.png"));
			fireMario[1] = ImageIO.read(ImportManager.class.getResource("fireMario2.png"));
			fireMario[2] = ImageIO.read(ImportManager.class.getResource("fireMario3.png"));
			fireMario[3] = ImageIO.read(ImportManager.class.getResource("fireMario4.png"));
			fireMario[4] = ImageIO.read(ImportManager.class.getResource("fireMario5.png"));
			fireMario[5] = ImageIO.read(ImportManager.class.getResource("fireMario6.png"));
			
			fireLeftMario = new BufferedImage[6];
			fireLeftMario[0] = ImageIO.read(ImportManager.class.getResource("fireMario_left1.png"));
			fireLeftMario[1] = ImageIO.read(ImportManager.class.getResource("fireMario_left2.png"));
			fireLeftMario[2] = ImageIO.read(ImportManager.class.getResource("fireMario_left3.png"));
			fireLeftMario[3] = ImageIO.read(ImportManager.class.getResource("fireMario_left4.png"));
			fireLeftMario[4] = ImageIO.read(ImportManager.class.getResource("fireMario_left5.png"));
			fireLeftMario[5] = ImageIO.read(ImportManager.class.getResource("fireMario_left6.png"));
			
			
			
			flower = ImageIO.read(ImportManager.class.getResource("Fireflower.gif"));
			deadMush = ImageIO.read(ImportManager.class.getResource("deadMushroom.png"));
			
			fireball = new BufferedImage[4];
			fireball[0] = ImageIO.read(ImportManager.class.getResource("fireball1.png"));
			fireball[1] = ImageIO.read(ImportManager.class.getResource("fireball2.png"));
			fireball[2] = ImageIO.read(ImportManager.class.getResource("fireball3.png"));
			fireball[3] = ImageIO.read(ImportManager.class.getResource("fireball4.png"));
			
			exit = ImageIO.read(ImportManager.class.getResource("Exit.gif"));
			
		}
		catch(IOException e){
			//do nothing
		}
	}

}
package ImportManager;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImportManager {

	public static BufferedImage title;
	public static BufferedImage instructions;
	public static BufferedImage startLogo;
	public static BufferedImage backToMain;
	public static InputStream lvl1;
	public static BufferedImage player;
	public static BufferedImage[] mario;
	public static BufferedImage box;
	public static BufferedImage pwrBox;
	public static BufferedImage mush;
	
	
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

			box = ImageIO.read(ImportManager.class.getResource("box.png"));
			pwrBox = ImageIO.read(ImportManager.class.getResource("pwrBox.png"));
			mush = ImageIO.read(ImportManager.class.getResource("mushroom1.png"));
		}
		catch(IOException e){
			//do nothing
		}
	}

}

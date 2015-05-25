package ImportManager;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

public class ImportManager {

	public static BufferedImage title;
	public static BufferedImage instructions;
	public static BufferedImage startLogo;
	public static BufferedImage backToMain;
	public static File lvl1;

	public static void loadFiles(){
		try{
			title = ImageIO.read(ImportManager.class.getResource("logo.png"));
			instructions = ImageIO.read(ImportManager.class.getResource("Instructions.png"));
			startLogo = ImageIO.read(ImportManager.class.getResource("start.png"));
			backToMain = ImageIO.read(ImportManager.class.getResource("mainmenuobj.png"));
			lvl1 = new File(ImportManager.class.getResource("lvl1.txt").toURI());
		}
		catch(IOException e){
			//do nothing
		} catch (URISyntaxException e) {
			//do nothing
		}
	}

}

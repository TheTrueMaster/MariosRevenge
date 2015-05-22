package View;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* REFRENCE TABLE
 * Conversion table from chn.util.FileInput to java.util.Scanner:
 * |  FileInput:     |  Scanner:     |
 * |  readToken()    |  next()       |
 * |  readInt()      |  nextInt()    |
 * |  readLine()     |  nextLine()   |
 * |  readDouble()   |  nextDouble() |
 * |  hasMoreLines() |  hasNextLine()|
 * |  hasMoreTokens()|  hasNext()    |
 */

public class TextLoader
{ 
	public char[][] getFile(String path) throws IOException
	{
		char[][] level = new char[12][57];
		ArrayList<String> strings = new ArrayList<String>();


		try	//try-with-resources - new in Java 7
		{
			Scanner file = new Scanner(new File(path));
			while(file.hasNext())
			{
				String read = file.nextLine();
				//code to use input ...here's a test:
				//System.out.println("read in: " + read);
				strings.add(read);
			}
			file.close();
		}
		catch(FileNotFoundException e)
		{
			//in case the file is not found
		}
		//after getting the file, parsing through each string and adding it to the char array
		
		for(int r = 0; r < level.length; r++){
			String str = strings.get(r);
			for(int c = 0; c < level[r].length; c++){
				try{
					level[r][c] = str.charAt(c);
				}
				catch(StringIndexOutOfBoundsException e){
					//in case the line in the text file has no text
					break;//go to the next line
				}
			}
		}
		/*
		for(int r = 0; r < level.length; r++){
			for(int c = 0; c < level[r].length; c++){
				System.out.print(level[r][c]);
			}
			System.out.println();
		}		*/
		
	
		return level;
	}
}
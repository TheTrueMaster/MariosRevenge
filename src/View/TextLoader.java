package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class TextLoader
{ 
	public static char[][] getFile(String path, ClassLoader loader) throws IOException
	{
		char[][] level = new char[12][57];
		InputStream is = loader.getResourceAsStream(path);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		int r = 0;
		while ((line = br.readLine()) != null) 
		{
			int c = 0;
			for(byte a: line.getBytes()){
				char ch = (char)a;
				level[r][c] = ch;
			}
			r++;
		}
		br.close();
		isr.close();
		is.close();
		return level;
	}}
package com.brancato.game.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Font {
	
	private BufferedImage FONTSHEET = null;
	private BufferedImage[][] fontArray;
	private final int TILE_SIZE = 32;
	public int w;
	public int h;
	private int wLetter;
	private int hLetter;
	
	public Font(String file) {
		w = TILE_SIZE;
		h = TILE_SIZE;
		
		System.out.println("loading " + file + "...");
		FONTSHEET = loadFont(file);
		
		wLetter = FONTSHEET.getWidth() / w;
		hLetter = FONTSHEET.getHeight() / h;
		loadFontArray();
	}//end constructor
	
	public Font(String file, int w, int h) {
		this.w = w;
		this.h = h;
		
		System.out.println("loading " + file + "...");
		FONTSHEET = loadFont(file);
		wLetter = FONTSHEET.getWidth() / w;
		hLetter = FONTSHEET.getHeight() / h;
				
		loadFontArray();
		
	}//end constructor
	
	public void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);		
	}//end set size
	
	private void setWidth(int i) {
		w = i;
		wLetter = FONTSHEET.getWidth() / w;
	}//end set width
	
	private void setHeight(int i) {
		h = i;
		hLetter = FONTSHEET.getHeight() / h;
	}//end set height
	
	public int getWith() {return w; }
	public int getheight() {return h; }
	
	private BufferedImage loadFont(String file) {
		BufferedImage sprite = null;
		
		try {  
			sprite = ImageIO.read(new File(file));
		} catch (Exception e) {
			System.out.println("ERROR: could not load file: " + file);
		}//end try catch
		
		return sprite;
	}//end load font
	
	public void loadFontArray() {
		fontArray = new BufferedImage[wLetter][hLetter];
		
		for(int x = 0; x < wLetter; x++) {
			for(int y = 0; y < hLetter; y++) {
				fontArray[x][y] = getLetter(x,y);
			}// end inside loop
		}//end outside for
	}//end
	
	public BufferedImage getFontSheet() {
		return FONTSHEET;
	}//end get sprite sheet
	
	public BufferedImage getLetter(int x, int y) {
		return FONTSHEET.getSubimage(x * w, y * h, w, h);
	}//end get sprite
	
	public BufferedImage getFont(char letter) {
		int value = letter;
		
		int x = value % wLetter;
		int y  = value / wLetter;
		
		return getLetter(x , y);
	}//end get sprite
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//end sprite

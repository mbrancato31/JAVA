package com.brancato.game.graphics;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.brancato.game.util.Vector2f;

public class Sprite {
	
	private BufferedImage SPRITESHEET = null;
	private BufferedImage[][] spriteArray;
	private final int TILE_SIZE = 32;
	public int w;
	public int h;
	private int wSprite;
	private int hSprite;
	
	public Sprite(String file) {
		w = TILE_SIZE;
		h = TILE_SIZE;
		
		System.out.println("loading " + file + "...");
		SPRITESHEET = loadSprite(file);
		
		wSprite = SPRITESHEET.getWidth() / w;
		hSprite = SPRITESHEET.getWidth() / h;
		loadSpriteArray();
	}//end constructor
	
	public Sprite(String file, int w, int h) {
		this.w = w;
		this.h = h;
		
		System.out.println("loading " + file + "...");
		SPRITESHEET = loadSprite(file);
		wSprite = SPRITESHEET.getWidth() / w;
		hSprite = SPRITESHEET.getWidth() / h;
		loadSpriteArray();
		
	}//end constructor
	
	public void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);		
	}//end set size
	
	private void setWidth(int i) {
		w = i;
		wSprite = SPRITESHEET.getWidth() / w;
	}//end set width
	
	private void setHeight(int i) {
		h = i;
		hSprite = SPRITESHEET.getWidth() / h;
	}//end set height
	
	public int getWith() {return w; }
	public int getheight() {return h; }
	
	private BufferedImage loadSprite(String file) {
		BufferedImage sprite = null;
		
		try {
			sprite = ImageIO.read(new File(file));
		} catch (Exception e) {
			System.out.println("ERROR: could not load file: " + file);
		}//end try catch
		
		return sprite;
	}//end load sprite
	
	public void loadSpriteArray() {
		spriteArray = new BufferedImage[hSprite][wSprite];
		
		
		for(int y = 0; y < hSprite; y++) {
			for(int x = 0; x < wSprite; x++) {
				spriteArray[y][x] = getSprite(x,y);
			}// end inside loop
		}//end outside for
	}//end
	
	public BufferedImage getSpriteSheet() {
		return SPRITESHEET;
	}//end get sprite sheet
	
	public BufferedImage getSprite(int x, int y) {
		return SPRITESHEET.getSubimage(x * w, y * h, w, h);
	}//end get sprite
	
	public BufferedImage[] getSpriteArray(int i) {
		return spriteArray[i];
	}// end get sprite array
	
	public BufferedImage[][] getSpriteArray2(int i) {
		return spriteArray;
	}// end get sprite array
	
	public static void drawArray(Graphics2D g, ArrayList<BufferedImage> img, Vector2f pos, int width, int height, int xOffset, int yOffset) {
		float x = pos.x;
		float y = pos.y;
		for(int i = 0; i < img.size(); i++) {
			if(img.get(i) != null) {
				g.drawImage(img.get(i), (int) x, (int) y, width, height, null);
			}//end if
			
			x += xOffset;
			y += yOffset;
			}//end for
	}//end draw array
	
	public static void drawArray(Graphics2D g, Font f, String word, Vector2f pos, int width, int height,  int xOffset, int yOffset) {
		float x = pos.x;
		float y = pos.y;
		
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) != 32) {
				g.drawImage(f.getFont(word.charAt(i)), (int) x, (int) y, width, height, null);
			}//end if
			x += xOffset;
			y += yOffset;
		}//end for
		
		
	}//end draw array
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//end sprite

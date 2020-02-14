package com.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;

public class Bullet extends GameObject {

	private Handler handler;
	private BufferedImage image;

	public Bullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		try {
			image = ImageIO.read(new File("C:/Users/Maurizio Brancato/Documents/vscode/java/Stop The Bullet/res/bullet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		velX = 5;
		velY = 0;
		
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		System.out.println("funciona");
	
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int) y, 8, 8);
	}


	@Override
	public void tick() {
		x += velX;
		y += velY;
			
	}

	@Override
	public void render(Graphics g) {

		g.drawImage(image,(int)x,(int) y, 50, 50 , null);
		
		
	}

}

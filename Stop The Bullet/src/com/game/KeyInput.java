package com.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	private Random r = new Random();
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
		
	}
	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		//if(key == KeyEvent.VK_SPACE) { handler.addObject(new Bullet(-80,r.nextInt(Game.HEIGHT - 100 ), ID.Bullet, handler)); }
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
		}
		
		if(key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}
	
	public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
		
				for(int i = 0; i < handler.object.size(); i++) {
					GameObject tempObject = handler.object.get(i);
			
	
				}
	}
	

}

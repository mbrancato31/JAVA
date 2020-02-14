package com.brancato.game.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import com.brancato.game.GamePanel;

public class KeyHandler implements KeyListener {
	
	public static List<Key> keys = new ArrayList<Key>();
	
	public class Key {
		public int presses, absorbs;
		public boolean down, clicked;
		
		public Key() {
			keys.add(this);
		}//end constructor
		
		public void toggle(boolean pressed) {
			if(pressed != down) {
				down = pressed;
			}//end if
			if(pressed) {
				presses++;
			}//end if
			
		}//end toggle
		
		public void tick() {
			if(absorbs < presses) {
				absorbs++;
				clicked = true;
			}else {
				clicked = false;				
			}//end if else
			
		}//end tick
		
	}//end key class
	
	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();
	public Key attack = new Key();
	public Key menu = new Key();
	public Key enter = new Key();
	public Key escape = new Key();
	
	public KeyHandler(GamePanel game) {
		game.addKeyListener(this);
	}//end constructor
	
	public void releaseAll() {
		for(int i = 0;i< keys.size(); i++) {
			keys.get(i).down = false;
		}//end for
	}//end release all
	
	public void tick() {
		for(int i = 0;i< keys.size(); i++) {
			keys.get(i).tick();
		}//end for
	}//end tick
	
	public void toggle(KeyEvent e, boolean pressed) {
		if(e.getKeyCode() == KeyEvent.VK_W) up.toggle(pressed);
		if(e.getKeyCode() == KeyEvent.VK_S) down.toggle(pressed);
		if(e.getKeyCode() == KeyEvent.VK_A) left.toggle(pressed);
		if(e.getKeyCode() == KeyEvent.VK_D) right.toggle(pressed);
		if(e.getKeyCode() == KeyEvent.VK_SPACE) attack.toggle(pressed);
		if(e.getKeyCode() == KeyEvent.VK_E) menu.toggle(pressed);
		if(e.getKeyCode() == KeyEvent.VK_ENTER) enter.toggle(pressed);
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) escape.toggle(pressed);
	}//end toggle
	
	@Override
	public void keyTyped(KeyEvent e) {
		// do nothing		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		toggle(e, true);		
	}//end key pressed

	@Override
	public void keyReleased(KeyEvent e) {
		toggle(e, false);		
	}//end key released

	

}// end key handler

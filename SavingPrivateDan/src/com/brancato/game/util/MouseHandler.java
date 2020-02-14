package com.brancato.game.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.brancato.game.GamePanel;

public class MouseHandler implements MouseListener, MouseMotionListener {
	
	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;
	
	public MouseHandler(GamePanel game) {
		game.addMouseListener(this);
	}//end constructor
	
	public int getX() {
		return mouseX;
	}// end get x
	
	public int getY() {
		return mouseY;
	}// end get Y
	
	public int getButton() {
		return mouseB;
	}// end get button 
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		mouseB = e.getButton();
	}// end mouse pressed
	
	@Override
	public void mouseReleased(MouseEvent e) {
		mouseB = -1;
	}// end mouse released
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();		
	}//end mouse dragged

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();	
	}//end mouse moved
	

}// end mouse handler

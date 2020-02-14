package com.brancato.game.states;

import java.awt.Graphics2D;

import com.brancato.game.util.KeyHandler;
import com.brancato.game.util.MouseHandler;

public abstract class GameState {
	
	private GameStateManager gam;
	
	public GameState(GameStateManager gam) {
		
		this.gam = gam;
				
	}//end constructor

	public abstract void update();
	public abstract void render(Graphics2D g);
	public abstract void input(MouseHandler mouse, KeyHandler key);
	
	
	
}// end game states

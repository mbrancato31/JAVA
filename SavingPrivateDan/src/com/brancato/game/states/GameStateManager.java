package com.brancato.game.states;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.brancato.game.GamePanel;
import com.brancato.game.util.KeyHandler;
import com.brancato.game.util.MouseHandler;
import com.brancato.game.util.Vector2f;

public class GameStateManager {
	
	private ArrayList<GameState> states;
	public static Vector2f map;
	public static final int PLAY = 0;
	public static final int MENU = 1;
	public static final int PAUSE = 2;
	public static final int GAMEOVER = 3;

	public GameStateManager() {
		map = new Vector2f(GamePanel.width, GamePanel.height);
		Vector2f.setWorldVar(map.x, map.y);
		
		states = new ArrayList<GameState>();
		
		states.add(new PlayState(this));
	}//end constructor
	
	public void pop(int state) {
		states.remove(state);
	}//end pop
	
	public void add(int state) {
		if(state == PLAY) {
			states.add(new PlayState(this));
		}//end if play
		if(state == MENU) {
			states.add(new MenuState(this));
		}//end if menu
		if(state == PAUSE) {
			states.add(new PauseState(this));
		}//end if pause
		if(state == GAMEOVER) {
			states.add(new GameOverState(this));
		}//end if game over
	}// end add
	
	public void addAndPop(int state) {
		states.remove(0);
		add(state);
	}//end add and pop
	
	public void update() {
		Vector2f.setWorldVar(map.x, map.y);
		for(int i = 0; i < states.size(); i++) {
			states.get(i).update();
		}// end for
		
	}//end update
	
	public void input(MouseHandler mouse, KeyHandler key) {
		for(int i = 0; i < states.size(); i++) {
			states.get(i).input(mouse, key);
		}// end for
		
	}//end input
	
	public void render(Graphics2D g) {
		for(int i = 0; i < states.size(); i++) {
			states.get(i).render(g);
		}// end for
		
	}//end render
	
}// end manager

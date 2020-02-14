package com.game;
import java.util.Random;

public class Spawner {
	
	private Handler handler;
	private int scoreKeep = 0;
	private Random r = new Random();
	private int count = 1000;
	
	public Spawner(Handler handler) {
		this.handler = handler;
	}

	public void tick() {
		scoreKeep++;
		
		
		if(scoreKeep >= r.nextInt(count)) {
			scoreKeep = 0;
			
			//System.out.println(count);
				handler.addObject(new Bullet(-80,r.nextInt(Game.HEIGHT - 100 ), ID.Bullet, handler));
				
			
			if(count == 80){	}  else{ count--; }
		}
	}
	
	
}

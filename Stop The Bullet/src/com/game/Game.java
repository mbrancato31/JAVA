package com.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1550691097823471818L;
	
	public static final int WIDTH = 1280, HEIGHT = 720;
	private Thread thread;
	private boolean running = false;
	private Random r;
	private Handler handler;
	private Spawner spawner;
	private Color color;
	
	
	public enum STATE {
		Menu,
		Help,
		Game,
		End;
	};
	   
	public static void main(String args[]) {
		new Game();
	}
	
	public static STATE gameState = STATE.Menu;

	public Game() {
		handler = new Handler();		
		spawner = new Spawner(handler);
		this.addKeyListener(new KeyInput(handler));
				
		new Window(WIDTH, HEIGHT, "STOP THE BULLET", this);
		
		color = new Color(192, 192, 192);
		r = new Random();	
		
		
		//	handler.addObject(new Bullet(0, r.nextInt(HEIGHT), ID.Bullet, handler));
		
				
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta>= 1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
		
	}
	
	private void tick() {
		handler.tick();
		spawner.tick();
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(color);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
			
		g.dispose();
		bs.show();
	}
	
	public static float clamp(float var, float min, float max) {
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else return var;
	}
	
	

	

}//end game

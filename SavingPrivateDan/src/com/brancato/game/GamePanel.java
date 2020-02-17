package com.brancato.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.brancato.game.states.GameStateManager;
import com.brancato.game.util.KeyHandler;
import com.brancato.game.util.MouseHandler;

public class GamePanel extends JPanel implements Runnable{
	
	public static int width, height;
	private Thread thread;
	private boolean running = false;
	private BufferedImage img;
	private Graphics2D g;
	private MouseHandler mouse;
	private KeyHandler key;
	private GameStateManager gsm;
	public static int oldFrameCount;
	
	public GamePanel(int width, int height) {
		this.width = width;
		this.height = height;
		
		setPreferredSize(new Dimension(width,height));
		setFocusable(true);
		requestFocus();
		
	}//end constructor
	
	@Override
	public void run() {
		init();
		
		final double GAME_HERTZ = 60.0;
		final double TBU = 1000000000 / GAME_HERTZ; // time before update
		final int MUBR = 5;// must update before render
		double lastUpdateTime = System.nanoTime();
		double lastRenderTime;
		final double TARGET_FPS = 60; //TARGET FRAMES PER SECOND
		final double TTBR = 1000000000 / TARGET_FPS; // total time before render
		int frameCount = 0;
		int lastSecondTime = (int)(lastUpdateTime / 1000000000);
		oldFrameCount = 0;
		
		
		while(running) {
			double now = System.nanoTime();
			int updateCount = 0;
			while (((now - lastUpdateTime) > TBU) && (updateCount < MUBR)) {
				update();
				input(mouse, key);
				lastUpdateTime += TBU;
				updateCount++;				
			}// end while
			
			if(now - lastUpdateTime > TBU) {
				lastUpdateTime = now - TBU;
			}//end if
			
			input(mouse, key);
			render();
			draw();
			lastRenderTime = now;
			frameCount++;
			
			int thisSecond = (int) (lastUpdateTime/1000000000);
			if(thisSecond>lastSecondTime) {
				if(frameCount != oldFrameCount) {
					System.out.println(" NEW SECOND " + thisSecond + " " + frameCount);
					oldFrameCount = frameCount;
				}//end inside if
				frameCount = 0;
				lastSecondTime = thisSecond;
			}//end outside if
			
			while(now - lastRenderTime < TTBR && now - lastUpdateTime < TBU) {
				Thread.yield();
				
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					System.out.println("ERROR: yielding thread");
				}// end try catch
				now = System.nanoTime();
				
			}//end inside while
			
		}//end while
		
	}//end run
	

	public void update() {
		
		gsm.update();

	}//end update
	
	private void input(MouseHandler mouse, KeyHandler key) {
		gsm.input(mouse, key);

	}//end input
	
	private void render() {
		if(g != null) {
			g.setColor(new Color(66, 134, 244));
			g.fillRect(0, 0, width, height);
			gsm.render(g);
		}//end if
		
	}//end render
	
	private void draw() {
		Graphics g2 = (Graphics)this.getGraphics();
		g2.drawImage(img, 0, 0, width, height, null);
		g2.dispose();
	}//end draw
	
	private void init() {
		running = true;
		
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) img.getGraphics();
		
		mouse = new MouseHandler(this);
		key = new KeyHandler(this);
		
		gsm = new GameStateManager();
				
	}//end init
	
	public void addNotify() {
		super.addNotify();
		
		if(thread == null) {
			thread = new Thread(this,"GameThread");
			thread.start();
		}//end if
		
	}//end add notify

}//end game panel
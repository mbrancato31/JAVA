package com.brancato.game.entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.brancato.game.graphics.Animation;
import com.brancato.game.graphics.Sprite;
import com.brancato.game.util.AABB;
import com.brancato.game.util.TileCollision;
import com.brancato.game.util.Vector2f;

public abstract class Entity {
	
	protected final int FALLEN = 4;
	protected final int UP = 3;
	protected final int DOWN = 2;
	protected final int RIGHT = 0;
	protected final int LEFT = 1;
	protected int currentAnimation;
	
	protected Animation ani;
	protected Sprite sprite;
	protected Vector2f pos;
	protected int size;
	
	protected boolean up;
	protected boolean down;
	protected boolean right;
	protected boolean left;
	protected boolean attack;
	protected boolean fallen;
	protected int attackSpeed;
	protected int attackDuration;
	
	protected float dx;
	protected float dy;
	
	protected float maxSpeed = 4f;
	protected float acc = 3f;
	protected float deacc = 0.3f;
	
	protected AABB hitBounds;
	protected AABB bounds;
	
	protected TileCollision tc;
	
	
	public Entity(Sprite sprite, Vector2f orgin, int size) {
		this.sprite = sprite;
		pos = orgin;
		this.size = size;
		
		bounds = new AABB(orgin, size, size);
		hitBounds = new AABB(new Vector2f(orgin.x + (size / 2), orgin.y), size, size);
		
		ani = new Animation();
		setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);
		
		tc = new TileCollision(this);
	}//end constructor
	
	public void setAnimation(int i, BufferedImage[] frames, int delay) {
		currentAnimation = i;
		ani.setFrames(frames);
		ani.setDelay(delay);
	}//end set animation
	
	public void update() {
		animate();
		setHitBoxDirection();
		ani.update();
	}//end update
	
	public abstract void render(Graphics2D g);
	
	
	public void animate() {
		if(up) {
			if(currentAnimation != UP || ani.getDelay() == -1) {
				setAnimation(UP, sprite.getSpriteArray(UP), 5);
			}//end inside if
		}else if(down) {
			if(currentAnimation != DOWN || ani.getDelay() == -1) {
				setAnimation(DOWN, sprite.getSpriteArray(DOWN), 5);
			}//end inside if
		}else if(left) {
			if(currentAnimation != LEFT || ani.getDelay() == -1) {
				setAnimation(LEFT, sprite.getSpriteArray(LEFT), 5);
			}//end inside if
		}else if(right) {
			if(currentAnimation != RIGHT || ani.getDelay() == -1) {
				setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 5);
			}//end inside if
		}else if(fallen) {
			if(currentAnimation != FALLEN  || ani.getDelay() == -1) {
				setAnimation(FALLEN, sprite.getSpriteArray(FALLEN), 15);
				
			}
		}else {
			setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), -1);
		}//end else if
	}//end animate
	
	public int getSize() { return size; }
	public Animation getAnimation() { return ani; }
	public AABB getBounds() {return bounds; }
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}//end get sprite
	
	public void setFallen(boolean b) { fallen = b; }
	public void setSize(int i) { size = i; }
	public void setMaxSpeed(float f) { maxSpeed = f; }
	public void setAcc(float f) { acc = f; }
	public void setDeacc(float f) { deacc = f; }
	
	
	
	public void setHitBoxDirection() {
		if(up) {
			hitBounds.setYOffset(-size /2);
			hitBounds.setXOffset(-size /2);
		}else if(down) {
			hitBounds.setYOffset(size /2);
			hitBounds.setXOffset(-size /2);
		}else if(left) {
			hitBounds.setYOffset(-size /2);
			hitBounds.setXOffset(0);
		}else if(right) {
			hitBounds.setYOffset(0);
			hitBounds.setXOffset(0);
		}
	}// end
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//end entity

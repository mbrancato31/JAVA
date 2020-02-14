package com.brancato.game.entity;

import java.awt.Color;
import java.awt.Graphics2D;

import com.brancato.game.GamePanel;
import com.brancato.game.graphics.Sprite;
import com.brancato.game.states.PlayState;
import com.brancato.game.util.KeyHandler;
import com.brancato.game.util.MouseHandler;
import com.brancato.game.util.Vector2f;

public class Player extends Entity {

	public Player(Sprite sprite, Vector2f orgin, int size) {
		super(sprite, orgin, size);
		acc = 2f;
		maxSpeed = 3f;
		bounds.setWidth(42);
		bounds.setHeight(20);
		bounds.setXOffset(12);
		bounds.setYOffset(40);
	}//end constructor	

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.blue);
		g.drawRect((int) (pos.getWorldVar().x + bounds.getXOffset()), (int) (pos.getWorldVar().y + bounds.getYOffset()),(int) bounds.getWidth(),(int) bounds.getHeight() / 2);
		g.drawImage(ani.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
		
	}//end render

	@Override
	public void update() {
		super.update();
		
		if(!fallen) {
			move();
			if(!tc.collisionTile(dx, 0)) {
				PlayState.map.x += dx;
				pos.x += dx;
			}
			if(!tc.collisionTile(0, dy)) {
				PlayState.map.y += dy;		
				pos.y += dy;
			}
		} else {
			if(ani.hasPlayedOnce()) {
				resetPosition();
				
				fallen = false;
			}
		}
		
		
	}//end update
	
	private void resetPosition() {
		System.out.println("reseting player... ");
		pos.x = GamePanel.width / 2 - 32;
		PlayState.map.x = 0;
		
		pos.y = GamePanel.height / 2 - 32;
		PlayState.map.y = 0;
		
		setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);
	}
	
	public void input(MouseHandler mouse, KeyHandler key) {
		
		if(mouse.getButton() == 1) {
			System.out.println("player: " + pos.x + ", " + pos.y);
		}//end if
		
		if(!fallen) {
			if(key.up.down) {
				up = true;
			} else {
				up = false;
			}//end if up
			if(key.down.down) {
				down = true;
			} else {
				down = false;
			}//end if down
			if(key.left.down) {
				left = true;
			} else {
				left = false;
			}//end if left
			if(key.right.down) {
				right = true;
			} else {
				right = false;
			}//end if right
			
			if(key.attack.down) {
				attack = true;
			} else {
				attack = false;
			}//end if attack		
		}else {
			up = false;
			down = false;
			right = false;
			left = false;
		}
	
		
	}//end input
	
	public void move() {
		//////////////////////////// up ////////////////////////////////////////////////////////
		if(up) {
			dy -= acc;
			if(dy < -maxSpeed) {
				dy = -maxSpeed;
			}//end if
		}else {
			if( dy < 0) {
				dy += deacc;
				if(dy > 0) {
					dy = 0;
				}//end inside if
			}//end inside if
		}// end up
		////////////////////////////// down ////////////////////////////////////////////////////
		if(down) {
			dy += acc;
			if(dy > maxSpeed) {
				dy = maxSpeed;
			}//end if
		}else {
			if( dy > 0) {
				dy -= deacc;
				if(dy < 0) {
					dy = 0;
				}//end inside if
			}//end inside if
		}// end up
		//////////////////////////// left //////////////////////////////////////////////////////////
		if(left) {
			dx -= acc;
			if(dx < -maxSpeed) {
				dx = -maxSpeed;
			}//end if
		}else {
			if( dx < 0) {
				dx += deacc;
				if(dx > 0) {
					dx = 0;
				}//end inside if
			}//end inside if
		}// end up
		////////////////////////////////// right ////////////////////////////////////////////////////////
		if(right) {
			dx += acc;
			if(dx > maxSpeed) {
				dx = maxSpeed;
			}//end if
		}else {
			if( dx > 0) {
				dx -= deacc;
				if(dx < 0) {
					dx = 0;
				}//end inside if
			}//end inside if
		}// end up
	
	}//end move
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//end player

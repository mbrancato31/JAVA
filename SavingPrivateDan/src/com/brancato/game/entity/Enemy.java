package com.brancato.game.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import com.brancato.game.graphics.Sprite;
import com.brancato.game.util.AABB;
import com.brancato.game.util.Vector2f;

public class Enemy extends Entity{
	
	private AABB sense;
	private int r;

	public Enemy(Sprite sprite, Vector2f orgin, int size) {
		super(sprite, orgin, size);
		
		acc = 1f;
		maxSpeed = 3f;
		r = 135;
		
		bounds.setWidth(42);
		bounds.setHeight(20);
		bounds.setXOffset(12);
		bounds.setYOffset(40);
		
		sense = new AABB(new Vector2f(orgin.x - size / 2, orgin.y - size / 2), r);
		
	}
	
	
	public void update(AABB player) {
		if(sense.colCircleBox(player)) {
			System.out.println("yep");
		}
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.green);
		g.drawRect((int) (pos.getWorldVar().x + bounds.getXOffset()), (int) (pos.getWorldVar().y + bounds.getYOffset()), (int) bounds.getWidth(), (int) bounds.getHeight());
		
		g.setColor(Color.blue);
		g.drawOval((int) (sense.getPos().getWorldVar().x), (int) (sense.getPos().getWorldVar().y), r, r);
		
		g.drawImage(ani.getImage(),(int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
		
	}

}

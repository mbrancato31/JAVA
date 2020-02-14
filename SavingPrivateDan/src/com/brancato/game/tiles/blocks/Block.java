package com.brancato.game.tiles.blocks;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import com.brancato.game.util.AABB;
import com.brancato.game.util.Vector2f;

public abstract class Block {

	protected int w;
	protected int h;
	protected BufferedImage img;
	protected Vector2f pos;
	
	public Block(int w, int h, BufferedImage img, Vector2f pos) {
		this.w = w;
		this.h = h;
		this.img = img;
		this.pos = pos;
	}
	

	public abstract boolean update(AABB p);
	public abstract boolean isInside(AABB p);
	public Vector2f getPos() { return pos; }
	
	public void render(Graphics2D g) {
		g.drawImage(img, (int) pos.getWorldVar().x, (int) pos.getWorldVar().y, w, h, null);
	}
	
	
}

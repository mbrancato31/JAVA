package com.brancato.game.util;

import com.brancato.game.entity.Entity;
import com.brancato.game.tiles.TileMapObj;
import com.brancato.game.tiles.blocks.Block;
import com.brancato.game.tiles.blocks.HoleBlock;

public class AABB {
	
	private Vector2f pos;
	private float xOffset = 0;
	private float yOffset = 0;
	private float w;
	private float h;
	private float r;
	private int size;
	private Entity e;
	
	public AABB(Vector2f pos, int w, int h) {
		this.pos = pos;
		this.w = w;
		this.h= h;
		size = Math.max(w, h);
	}//end constructor
	
	public AABB(Vector2f pos, int r) {
		this.pos = pos;
		this.r = r;
		size = r;
	}//end constructor
	
	public Vector2f getPos() { return pos; }
	public float getRadius() { return r; }
	public float getWidth() { return w; }
	public float getHeight() { return w; }
	public float getXOffset() { return xOffset; }
	public float getYOffset() { return yOffset; }
	
	public void setBox(Vector2f pos,int w, int h) {
		this.pos = pos;
		this.w = w;
		this.h= h;
		size = Math.max(w, h);
	}//end set box
	
	public void setCircle(Vector2f pos,int r) {
		this.pos = pos;
		this.r = r;
		size = r;
	}//end set circle
	
	public void setWidth(float f) { w = f; }
	public void setHeight(float f) { h = f; }
	public void setXOffset(float f) { xOffset = f; }
	public void setYOffset(float f) { yOffset = f; }
	
	public boolean collides(AABB bBox) {
		float ax = ((pos.getWorldVar().x + (xOffset)) + (w/2));
		float ay = ((pos.getWorldVar().y + (yOffset)) + (h/2));
		float bx = ((bBox.pos.getWorldVar().x + (bBox.xOffset/2)) + (w/2));
		float by = ((bBox.pos.getWorldVar().y + (bBox.yOffset/2)) + (h/2));
		
		if(Math.abs(ax-bx) < (this.w /2) + (bBox.w /2)) {
			if(Math.abs(ay - by) < (this.h /2) + (bBox.h /2)) {
				return true;
			}//end inside if
		}//end if
		return false;
	}// end collides
	
	public boolean colCircleBox(AABB aBox) {
		
		float dx = Math.max(aBox.getPos().getWorldVar().x + aBox.getXOffset(), Math.min(pos.getWorldVar().x + (r / 2), aBox.getPos().getWorldVar().x + aBox.getXOffset() + aBox.getWidth()));
		float dy = Math.max(aBox.getPos().getWorldVar().y + aBox.getYOffset(), Math.min(pos.getWorldVar().y + (r / 2), aBox.getPos().getWorldVar().y + aBox.getYOffset() + aBox.getHeight()));
		
		dx = pos.getWorldVar().x + (r / 2) - dx;
		dy = pos.getWorldVar().y + (r / 2) - dy;
		
		if(Math.sqrt(dx * dx + dy * dy) < r / 2) {
			return true;
		}	
		
		return false;
	}// end col circle box
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}// end aa bb

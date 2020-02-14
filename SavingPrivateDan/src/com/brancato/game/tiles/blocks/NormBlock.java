package com.brancato.game.tiles.blocks;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.brancato.game.util.AABB;
import com.brancato.game.util.Vector2f;

public class NormBlock extends Block {

	public NormBlock(BufferedImage img,Vector2f pos, int w, int h) {
		super(w, h, img, pos);
		
	}

	@Override
	public boolean update(AABB p) {
		return false;
	}
	
	public boolean isInside(AABB p) {
		return false;
	}
	
	@Override
	public void render(Graphics2D g) {
		super.render(g);
	}
	
	

}

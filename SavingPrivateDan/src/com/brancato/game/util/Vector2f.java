package com.brancato.game.util;

public class Vector2f {

	public float x;
	public float y;
	public static float worldX;
	public static float worldY;
	
	public Vector2f() {
		x = 0;
		y = 0;
	}//end constructor 1
	
	public Vector2f(Vector2f vec) {
		new Vector2f(vec.x,vec.y);
	}//end constructor 2
	
	public Vector2f (float x, float y) {
		this.x = x;
		this.y = y;
	}//end constructor 3
	
	public void addX(float f) {x += f; }//end add x
	public void addY(float f) {y += f; }//end add y

	public void setX(float f) { x = f; }// end set x
	public void sety(float f) { y = f; }// end set y
	
	public void setVector(Vector2f vec) {
		this.x = vec.x;
		this.y = vec.y;
	}// end set vector 
	
	public void setVector(float x, float y) {
		this.x = x;
		this.y = y;
	}// end set vector 2
	
	public static void setWorldVar(float x, float y) {
		worldX = x;
		worldY = y;
	}//end set world var
	
	public Vector2f getWorldVar() {
		return new Vector2f(x - worldX, y - worldY);
	}//end get world var
	
	@Override
	public String toString() {
		return x + ", " + y;
	}//end to string
	
	
	
}//end vector 2f

package com.mgd.math;

/**
  *@author:michael dunleavy
  */

public class Rectangle{
	private Vector2 bl, tl, tr, br;
	private Vector2 dimensions;
	public Rectangle(){
		bl = new Vector2();
		tl = new Vector2();
		tr = new Vector2();
		br = new Vector2();
		dimensions = new Vector2();
	}

	public Rectangle(float width, float height){
		float hw = width * 0.5f;
		float hh = height * 0.5f;

		bl = new Vector2(-hw, -hh);
		tl = new Vector2(-hw, hh);
		tr = new Vector2(hw, hh);
		br = new Vector2(hw, -hh);
		dimensions = new Vector2(width, height);
	}

	public float getCenterX() { 
		float x = (tl.x + tr.x) * 0.5f;
		return x;
	}
	public float getCenterY() {
		float y = (bl.y + tl.y) * 0.5f;
		return y;
	}
	public float getWidth() { return dimensions.x; }
	public float getHeight() { return dimensions.y; }
}

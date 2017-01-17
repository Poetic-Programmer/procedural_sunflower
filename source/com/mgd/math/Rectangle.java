package com.mgd.math;

/**
  *@author:michael dunleavy
  */

public class Rectangle{
	public Vector2 bl, tl, tr, br;

	public Rectangle(){
		bl = new Vector2();
		tl = new Vector2();
		tr = new Vector2();
		br = new Vector2();
	}

	public Rectangle(float width, float height){
		float hw = width * 0.5f;
		float hh = height * 0.5f;

		bl = new Vector2(-hw, -hh);
		tl = new Vector2(-hw, hh);
		tr = new Vector2(hw, hh);
		br = new Vector2(hw, -hh);
	}
}

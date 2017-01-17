package com.mgd.math;

/**
  *@author:michael dunleavy
  *<h1>2D Quadratic Bezier Curve</h1>
  */

public class QuadBezier2{
	// public access! be carefull!
	public Vector2 a, b, c;

	public QuadBezier2(){
		a = new Vector2();
		b = new Vector2();
		c = new Vector2();
	}

	public QuadBezier2(Vector2 a, Vector2 b, Vector2 c){
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Vector2 evalAt(float t){
		Vector2 ans = new Vector2(
				((1-t)*(1-t)*a.x + 2*(1-t)*t*b.x + t*t*c.x),
				((1-t)*(1-t)*a.y + 2*(1-t)*t*b.y + t*t*c.y));
		return ans;
	}
}

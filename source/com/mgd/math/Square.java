package com.mgd.math;

/**
  *@author:michael dunleavy
  */
public class Square{
	private Vector2 bl, tl, tr, br;
	private float dimension;

	public Square(){
		bl = new Vector2();
		tl = new Vector2();
		tr = new Vector2();
		br = new Vector2();
		dimension = 0.0f;
	}
	public Square(float dimension){
		float hd = dimension * 0.5f;

		bl = new Vector2(-hd, -hd);
		tl = new Vector2(-hd, hd);
		tr = new Vector2(hd, hd);
		br = new Vector2(hd, -hd);
		this.dimension = dimension;
	}
	// Assumes correct dimensions!
	public Square(Vector2 bl, Vector2 tl, 
			Vector2 tr, Vector2 br){
		this.bl = bl;
		this.tl = tl;
		this.tr = tr;
		this.br = br;
		dimension = br.x - bl.x;
	}

	public Vector2 getBottomLeft() { return bl; }
	public Vector2 getTopLeft() { return tl; }
	public Vector2 getTopRight() { return tr; }
	public Vector2 getBottomRight() { return br; }
	public float getDimensions() { return dimension; }
}

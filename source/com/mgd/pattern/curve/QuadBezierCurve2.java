package com.mgd.pattern.curve;

public class QuadBezierCurve2 implements Curve{
	private int[] pointA;
	private int[] pointB;
	private int[] pointC;

	public QuadBezierCurve2(int [] pointA, 
			int [] pointB, int[] pointC){
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}

	@Override
	public int[] getPointAt(float time){
		float x = ((1-t)*(1-t)*pointA[0] +
			2*t*(1-t)*pointB[0] +
			t*t*pointC[0]);

		float y = ((1-t)*(1-t)*pointA[1] +
			2*t*(1-t)*pointB[1] +
			t*t*pointC[1]);

		return new int[]{(int) x, (int) y};
	}
}

package com.mgd.pattern.curve;

public class LinearBezierCurve1 implements Curve{
	private int[] pointA;

	public LinearBezierCurve1(int[] pointA){
		this.pointA = pointA;
	}

	@Override
	public int[] getPointOnCurve(float t){
		float x = ((1-t)*pointA[0] + t*pointA[1]);

		return new int[]{(int) x, 0};
	}
}

package com.mgd.pattern.bounds;

public interface Bounds{
	static final String NAME = "Bounds";
	/*
	   each bounds can be in one of four possible
	   rotations, represented in radians
	*/
	public static enum Angle{
		HALF_PI,
		PI,
		ONE_AND_HALF_PI,
		TWO_PI,
	};
	
	default public int getWidth() {
		System.out.println(NAME + " has no width");
		return 0;
	}
	default public int getHeight() {
		System.out.println(NAME + " has no height value");
		return 0;
	}
	default public int getRadius() {
		System.out.println(NAME + " has no radius value");
		return 0;
	}
	default public int getCenterX() {
		System.out.println(NAME + " has no center value");
		return 0;
	}
	default public int getCenterY() {
		System.out.println(NAME + " has no center value");
		return 0;
	}
	default public Angle getAngle() {
		System.out.println(NAME + " has no angle value");
		return Angle.PI;
	}
}

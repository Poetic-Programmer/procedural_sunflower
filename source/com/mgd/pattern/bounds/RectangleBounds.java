package com.mgd.pattern.bounds;

public class RectangleBounds implements Bounds {
	private int[] center;
	private int[] dimensions;
	private Angle angle;

	public RectangleBounds(int x, int y, int width,
			int height){
		center = new int[2];
		center[0] = x;
		center[1] = y;
		dimensions = new int[2];
		dimensions[0] = width;
		dimensions[1] = height;
		angle = Angle.TWO_PI;
	}

	@Override
	public int getWidth() { return dimensions[0]; }
	@Override
	public int getHeight() { return dimensions[1]; }
	@Override
	public int getCenterX() { return center[0]; }
	@Override
	public int getCenterY() { return center[1]; }
	@Override
	public Angle getAngle() { return angle; }
}

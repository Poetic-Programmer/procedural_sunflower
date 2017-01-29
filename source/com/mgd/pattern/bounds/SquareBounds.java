package com.mgd.pattern.bounds;

public class SquareBounds implements Bounds {
	private int [] center;
	private int dimensions;
	private Angle angle;
	public SquareBounds(int x, int y, int dimensions, Angle angle){
		center = new int[2];
		center[0] = x;
		center[1] = y;
		this.dimensions = dimensions;
		this.angle = angle;
	}

	@Override
	public int getWidth() { return dimensions; }
	@Override
	public int getHeight() { return dimensions; }
	@Override
	public int getCenterX() { return center[0]; }
	@Override
	public int getCenterY() { return center[1]; }
	@Override
	public Angle getAngle() { return angle; }
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("<---------SQUARE BOUNDS--------->\n");
		builder.append("center (" + center[0] + ", " + center[1] + ")\n");
		builder.append("width, height: " + dimensions + "\n");
		builder.append("====================================");
		return builder.toString();
	}
}



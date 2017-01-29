package com.mgd.pattern;

import static com.mgd.pattern.bounds.Bounds.Angle;

import java.util.List;
import java.util.ArrayList;

import com.mgd.pattern.bounds.Bounds;
import com.mgd.pattern.bounds.RectangleBounds;
import com.mgd.pattern.bounds.SquareBounds;
import com.mgd.pattern.time.TimeFunction;
import com.mgd.pattern.time.LinearTimeFunction;
import com.mgd.math.FibonacciSeq;
import com.mgd.math.Vector2;
/**
  *@author:michael dunleavy
  *<p>use the golden rectangle, break into squares and 
  *use 3 points of each square to create smooth bezier
  *curves</p>
  */
public class GoldenSpiralPattern implements Pattern{
	private enum Quadrant{
		TR,
		TL,
		BL,
		BR
	} 
	private Bounds outterBounds;
	private List<Bounds> innerBounds;
	private Path path;
	private int numSquares;

	public GoldenSpiralPattern(RectangleBounds outterBounds, int numSquares){
		this.outterBounds = clampBoundsToGolden(outterBounds);
		this.numSquares = numSquares;
		
		innerBounds = getSquareBounds(outterBounds, numSquares);
	}

	private Bounds clampBoundsToGolden(Bounds bounds){
		// check rectangle is golden, if not, make it!
		if(FibonacciSeq.getInstance().isGoldenRectangle(
					(int) bounds.getWidth(),(int) bounds.getHeight())){
			return bounds;	
		} else{
			int width = (int) FibonacciSeq.getInstance()
				.getClosestLowerValue((int) bounds.getWidth()); 
			int height = (int) FibonacciSeq.getInstance()
				.getClosestLowerValue(width-1);

			return new RectangleBounds(0, 0,
					width,
				        height);	
		}
	}
	private List<Bounds> getSquareBounds(RectangleBounds bounds, int numSquares){
		// create a temporary square class to avoid as much floating
		// point precision errors as possible
		class TempSquare{
			public float dimensions;
			public float[] center;
			public Angle angle;
			public TempSquare(){
				dimensions = 0;
				center = new float[2];
				angle = Angle.TWO_PI;
			}
		}

		List<TempSquare> tSquareList = new ArrayList<>();
		// the first square is always to the left of outter golden origin
		TempSquare first = new TempSquare();
		first.dimensions = bounds.getHeight();
		first.center[0] = (float) (-bounds.getWidth() * 0.5f) 
			+ (float) (bounds.getHeight() * 0.5f);
		first.center[1] = 0;

		// add first square to list
		tSquareList.add(first);

		// offset to top required fib seq
		int fibOffset = FibonacciSeq.getInstance().getIndexOf(
				(int) bounds.getWidth());

		// make a sub list of Fib seq for conveinience
		List<Integer> fib = FibonacciSeq.getInstance()
			.getSubList(0, fibOffset+1);

		// quadrant will determin sign of center offset
		Quadrant quad = Quadrant.TR;
		int topFib = fib.get(fibOffset);
		int botFib = fib.get(numSquares-2);

		int topOffset = fibOffset + 1;
		int botOffset = numSquares - 1;
		for(int i = 1; i < numSquares; ++i){
			TempSquare temp = new TempSquare();

			topOffset--;
			botOffset--;

			float prevX = tSquareList.get(i-1).center[0];
			float prevY = tSquareList.get(i-1).center[1];
			switch(quad){
			case TR:
				System.out.println("TR");
				temp.center[0] = prevX + fib.get(topOffset) * 0.5f;
				temp.center[1] = prevY + fib.get(botOffset) * 0.5f;
				temp.angle = Angle.HALF_PI;
				quad = Quadrant.TL;
				break;
			case TL:
				System.out.println("TL");
				temp.center[0] = prevX + fib.get(botOffset) * 0.5f;
				temp.center[1] = prevY - fib.get(topOffset) * 0.5f;
				temp.angle = Angle.PI;
				quad = Quadrant.BL;
				break;
			case BL:
				System.out.println("BL");
				temp.center[0] = prevX - fib.get(topOffset) * 0.5f;
				temp.center[1] = prevY - fib.get(botOffset) * 0.5f;
				temp.angle = Angle.ONE_AND_HALF_PI;
				quad = Quadrant.BR;
				break;
			case BR:
				System.out.println("BR");
				temp.center[0] = prevX - fib.get(botOffset) * 0.5f;
				temp.center[1] = prevY + fib.get(topOffset) * 0.5f;
				temp.angle = Angle.TWO_PI;
				quad = Quadrant.TR;
				break;
			}
			temp.dimensions = fib.get(botOffset+1);

			System.out.println(i + ": " + topFib + ", " + botFib);
			System.out.println("top offset: " + topOffset + " bottom offset: " + botOffset);

			tSquareList.add(temp);
		}
		List<Bounds> squareList = new ArrayList<>();
		/* copy temp squares to bounding squares, there will be
		 * float-int conversions
		 */
		int offset = 0;
		for(TempSquare ts : tSquareList){
			squareList.add(new SquareBounds(
				(int) ts.center[0],
				(int) ts.center[1],
				(int) ts.dimensions,
				ts.angle));
		}
		return squareList;
	}

	public void printSquares(){
		int offset = 0;
		for(Bounds b : innerBounds){
			System.out.println("square " + offset++);
			System.out.println(b.toString());
		}
	}
	@Override
	public Vector2 getPointAt(float time){
		return new Vector2();
	}

	@Override
	public boolean hasBounds() { return true; }

	@Override
	public float getBoundsCenterX() { return outterBounds.getCenterX(); }

	@Override
	public float getBoundsCenterY() { return outterBounds.getCenterY(); }

	@Override
	public float getBoundsWidth() { return outterBounds.getWidth(); }

	@Override
	public float getBoundsHeight() { return outterBounds.getHeight(); }

	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("<----GOLDEN SPIRAL PATTERN---->\n");
		builder.append("Base Rectangle (w,h): " + outterBounds.getWidth());
		builder.append(", " + outterBounds.getHeight() + ")\n");
		builder.append("Number of squares: " + numSquares + "\n");
		builder.append("===============================\n");
		return builder.toString();
	}
}

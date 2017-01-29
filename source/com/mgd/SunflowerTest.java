package com.mgd;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import com.mgd.gui.*;
import com.mgd.math.*;
import com.mgd.pattern.*;
import com.mgd.pattern.bounds.Bounds;
import com.mgd.pattern.bounds.RectangleBounds;
public class SunflowerTest{
	public static void main(String [] args){
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle windowBounds = env.getMaximumWindowBounds();
		int width = FibonacciSeq.getInstance().getClosestLowerValue(windowBounds.width);
		int height = FibonacciSeq.getInstance().getClosestLowerValue(width-1);
		MyGUI gui = new MyGUI(width, height);

		gui.initialize();

		FibonacciSeq.getInstance().printSequence();

		System.out.println("width: " + windowBounds.width + ", height: " + windowBounds.height);
		System.out.println("new Width: " + width + ", new height: " + height);

		gui.draw();

		int goldenRectangleWidth = FibonacciSeq.getInstance()
			.getClosestLowerValue(width-1);
		int goldenRectangleHeight = FibonacciSeq.getInstance()
			.getClosestLowerValue(goldenRectangleWidth-1);

		//RectangleBounds bounds = new RectangleBounds(0, 0, goldenRectangleWidth, goldenRectangleHeight);
		RectangleBounds bounds = new RectangleBounds(0, 0, 13, 8);
		GoldenSpiralPattern pattern = new GoldenSpiralPattern(bounds, 5);
		System.out.println(pattern.toString());
				
		pattern.printSquares();
	}
}

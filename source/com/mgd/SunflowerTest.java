package com.mgd;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import com.mgd.gui.*;
import com.mgd.math.*;

public class SunflowerTest{
	public static void main(String [] args){
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle bounds = env.getMaximumWindowBounds();
		int width = FibonacciSeq.getInstance().getClosestLowerValue(bounds.width);
		int height = FibonacciSeq.getInstance().getClosestLowerValue(width-1);
		MyGUI gui = new MyGUI(width, height);

		gui.initialize();

		FibonacciSeq.getInstance().printSequence();

		System.out.println("width: " + bounds.width + ", height: " + bounds.height);
		System.out.println("new Width: " + width + ", new height: " + height);

		gui.draw();
	}
}

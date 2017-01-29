package com.mgd.pattern;

import com.mgd.math.Vector2;
/**
  *@author:michael dunleavy
  *<p>Each pattern is rendered based on a time function [0, 1]</p>
  */
public interface Pattern{
	Vector2 getPointAt(float time);
	boolean hasBounds(); // some patterns are bound by shapes. Used for debug
	
	default float getBoundsCenterX(){
		System.out.println("Pattern has no bounds");
		return 0;
	}
	default float getBoundsCenterY(){
		System.out.println("Pattern has no bounds");
		return 0;
	}
	default float getBoundsWidth(){
		System.out.println("Pattern has no bounds");
		return 0;
	}
	default float getBoundsHeight(){
		System.out.println("Pattern has no bounds");
		return 0;
	}


}

package com.mgd.pattern;

import com.mgd.pattern.path.*;
import com.mgd.pattern.time.*;
import com.mgd.pattern.curve.*;

public class Path{
	private TimeFunction timeFunction;
	private Curve curve;
	private float speed;
	private int[] pointOnCurve;

	public Path(TimeFunction timeFunction,
			Curve curve, float speed){
		this.timeFunction = timeFunction;
		this.curve = curve;
		this.speed = speed;
		
		pointOnCurve = new int[2];
	}

	public void setTimeFunction(TimeFunction timeFunction){
		this.timeFunction = timeFunction;
	}
	public void setCurve(Curve curve){
		this.curve = curve;
	}
	public void setSpeed(float speed){
		this.speed = speed;
	}

	public int[] getPoint() { return pointOnCurve; }

	public void update(){
		timeFunction.tick(speed);
		pointOnCurve = curve.getPointOnCurve(timeFunction.getTime());
	}
}
		


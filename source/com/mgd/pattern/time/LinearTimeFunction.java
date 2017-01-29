package com.mgd.pattern.time;

import com.mgd.pattern.curve.*;

public class LinearTimeFunction implements TimeFunction{
	private float time;
	private float functionTime;
	private boolean finished;
	private LinearBezierCurve1 curve;

	public LinearTimeFunction(){
		time = 0;
		functionTime = 0;
		finished = false;
		curve = new LinearBezierCurve1(new int[]{1, 0});
	}

	@Override
	public void tick(float speed){
		time += speed;
		if(time >= 1){
			finished = true;
			time = 1;
		}		
		if(time < 0){
			finished = true;
			time = 0;
		}
		int [] point = curve.getPointOnCurve(time);

		functionTime = curve.getPointOnCurve(time)[0];
	}

	@Override
	public float getTime(){ return functionTime; }
}

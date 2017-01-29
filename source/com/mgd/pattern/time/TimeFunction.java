package com.mgd.pattern.time;

/**
  *@author:michael dunleavy
  *time functions [0, 1] are used in pattern objects to
  *interpolate points*/
public interface TimeFunction{
	public void tick(float speed);
	public float getTime();
}

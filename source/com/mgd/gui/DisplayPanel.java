package com.mgd.gui;

import com.mgd.pattern.Pattern;
import javax.swing.JPanel;

import java.awt.*;
/**
  *@author:michael dunleavy
  */

public class DisplayPanel extends JPanel{
	private Pattern pattern;

	private int width;
	private int height;

	// display switches
	private boolean showBounds;

	public DisplayPanel(int width, int height){
		super();
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));
		showBounds = true;
	}
	public void initialize(){
	}

	public void setPattern(Pattern pattern){
		this.pattern = pattern;
	}

	public int getWidth() { return width; }
	public int getHeight() { return height; }
	@Override
	public void paintComponent(Graphics g){
		System.out.println("paint being called");
		g.setColor(Color.orange);
		g.fillRect(0, 0, width, height);

		if(showBounds){
			float hw = pattern.getBoundsWidth() * 0.5f;
			float hh = pattern.getBoundsHeight() * 0.5f;

			g.setColor(Color.black);
			g.drawRect((int) pattern.getBoundsCenterX(),
				(int) 	pattern.getBoundsCenterY(),
				(int) 	pattern.getBoundsWidth(),
				(int) 	pattern.getBoundsHeight());
		}
	}
}

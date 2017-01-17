package com.mgd.gui;

import javax.swing.JPanel;

import java.awt.*;
/**
  *@author:michael dunleavy
  */

public class DisplayPanel extends JPanel{
	private int width;
	private int height;

	public DisplayPanel(int width, int height){
		super();
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));
	}
	public void initialize(){
	}

	@Override
	public void paintComponent(Graphics g){
		System.out.println("paint being called");
		g.setColor(Color.orange);
		g.fillRect(0, 0, width, height);
	}
}

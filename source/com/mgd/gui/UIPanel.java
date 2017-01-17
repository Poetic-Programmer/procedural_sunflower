package com.mgd.gui;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
/**
  *@author:michael dunleavy
  */

public class UIPanel extends JPanel{
	private int width;
	private int height;

	public UIPanel(int width, int height){
		super();

		this.width = width;
		this.height = height;

		setPreferredSize(new Dimension(width, height));
	}

	public void initialize(){

	}

	@Override
	public void paintComponent(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(0, 0, width, height);
	}
}

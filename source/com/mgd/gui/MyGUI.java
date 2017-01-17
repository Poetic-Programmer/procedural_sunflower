package com.mgd.gui;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import com.mgd.math.FibonacciSeq;
/**
  *@author:michael dunleavy
  */

public class MyGUI extends JFrame{
	private final int width;
	private final int height;

	private JPanel panel;
	private DisplayPanel display;
	private UIPanel ui;

	private JButton button;
	public MyGUI(int width, int height){
		super();

		this.width = width;
		this.height = height;

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));
		int displayWidth = height;
		int displayHeight = FibonacciSeq.getInstance()
			.getClosestLowerValue(displayWidth - 1);
		display = new DisplayPanel(displayWidth, displayHeight);
		ui = new UIPanel(displayHeight, displayWidth);
		button = new JButton("he");
	}

	public void initialize(){
		display.initialize();
		ui.initialize();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.setBackground(Color.blue);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(display);
		panel.add(ui);

		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(panel);

		setSize(width, height);
		setVisible(true);
	}

	public void update(){
	}

	public void draw(){
		display.repaint();
	}
}

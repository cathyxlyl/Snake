package com.tinytech.snake.property;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class Element extends JFrame
{
	protected int sizeX;
	protected int sizeY;
	protected int initX;
	protected int initY;
	public int directionX = 0;
	public int directionY = 0;
	protected String elementAddr;
	protected ImageIcon elementImg;
	public JLabel elementJLabel;
	
	public Element(int sizeX, int sizeY, int initX, int initY) 
	{ 
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.initX = initX;
		this.initY = initY;
	}
	
	public int getSizeX()
	{
		return sizeX;
	}
	
	public int getSizeY()
	{
		return sizeY;
	}
	
	public int getInitX()
	{
		return initX;
	}
	
	public int getInitY()
	{
		return initY;
	}
	
	public void addToCont(Gate gate)
	{
		gate.cont.add(elementJLabel);
		gate.cont.setComponentZOrder(elementJLabel, 0);
		elementJLabel.setBounds((initX + Gate.initLocation) * gate.gateProperty.getElementWidth(), 
				(initY + Gate.initLocation) * gate.gateProperty.getElementHeight(), 
				sizeX * gate.gateProperty.getElementWidth(), 
				sizeY * gate.gateProperty.getElementHeight());
	}

}

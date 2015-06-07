package com.tinytech.snake.property;

public class GateProperty
{
	private int countX;
	private int countY;
	private int elementHeight;
	private int elementWidth;
	
	public GateProperty(int countX, int countY, int elementHeight, int elementWidth)
	{
		this.countX = countX;
		this.countY = countY;
		this.elementHeight = elementHeight;
		this.elementWidth = elementWidth;
	}
	
	public int getCountX()
	{
		return countX;
	}
	
	public int getCountY()
	{
		return countY;
	}
	
	public int getElementHeight()
	{
		return elementHeight;
	}
	
	public int getElementWidth()
	{
		return elementWidth;
	}
}

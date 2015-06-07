package com.tinytech.snake.element.silent;

public class Wall extends SilentElement
{
	public static final int elementID = 1;
	private static String wallAddr = "wall.jpg";
	
	public Wall(int initX, int initY, String addr) 
	{
		super(1, 1, initX, initY, addr);
	}
	
	public Wall(int initX, int initY) 
	{
		super(1, 1, initX, initY, wallAddr);
	}
}

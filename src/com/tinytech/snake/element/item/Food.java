package com.tinytech.snake.element.item;

import java.awt.Component;

import com.tinytech.snake.property.*;

public class Food extends Inventory
{
	public static final int elementID = 3;
	public static String foodAddr = "food.jpg";
	
	public Food(int initX, int initY) 
	{
		super(1, 1, initX, initY, foodAddr);
	}
	
	@Override
	public int reaction(Gate gate, int elementID, Component comp) 
	{
		if (elementID == 2)
		{
			gate.cont.remove(this);
		}
		return elementID;
	}
}

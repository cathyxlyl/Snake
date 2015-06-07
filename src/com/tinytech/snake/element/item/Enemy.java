package com.tinytech.snake.element.item;

import com.tinytech.snake.property.*;

public abstract class Enemy extends Element implements Mutative //,Reaction
{
	public Enemy(int sizeX, int sizeY, int initX, int initY) 
	{
		super(sizeX, sizeY, initX, initY);
	}
}

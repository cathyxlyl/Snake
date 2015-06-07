package com.tinytech.snake.property;

import java.awt.Component;

public interface Reaction 
{
	public int reaction(Gate gate, int elementID, Component comp);
}
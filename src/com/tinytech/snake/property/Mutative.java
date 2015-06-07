package com.tinytech.snake.property;

public interface Mutative 
{
	public abstract class MutativeThread extends Thread
	{
		public abstract void run();
	}
	
	public abstract void resetToCont(Gate gate);
}

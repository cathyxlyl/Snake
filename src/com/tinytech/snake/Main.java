package com.tinytech.snake;
import com.tinytech.snake.gate.*;

public class Main 
{
	public static void main(String[] args) throws InterruptedException 
	{
		FirstGate fg = new FirstGate();
		while (true)
		{
			if (fg.isFinished)
			{
				fg = new FirstGate();
			}
			Thread.sleep(3000);
		}	
	}

}

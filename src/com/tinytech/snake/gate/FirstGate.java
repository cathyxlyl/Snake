package com.tinytech.snake.gate;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.tinytech.snake.element.*;
import com.tinytech.snake.element.silent.Wall;
import com.tinytech.snake.property.*;

public class FirstGate extends Gate
{
	public FirstGate() 
	{
		super(new GateProperty(15, 15, 30, 30), "FirstGate");
		this.setBackGround();
		this.setInitLayout();

		GateThread gt = new GateThread();
		gt.start();
	}

	@Override
	protected void setBackGround() 
	{
		backGround = new BackGround();
		backGround.addToCont(this);
	}

	@Override
	protected void generateSilent() 
	{
		for (int i = 0; i < gateProperty.getCountY(); i++)
		{
			for (int j = 0; j < gateProperty.getCountX(); j++)
			{
				if ((i == 0) || (j == 0) || (i == gateProperty.getCountY() - 1) ||
						(j == gateProperty.getCountX() - 1))
				{
					layout[i][j] = 1;
					this.addElement(new Wall(j, i));
				} 
				else 
				{
					layout[i][j] = 0;
				}
			}
		}
	}
	
	@Override
	protected void setInitLayout() 
	{
		layout = new int[gateProperty.getCountY()][gateProperty.getCountX()];
		generateSilent();
		generateSnake(200, 15, 1, 0);
		generateItem(3, 1);
	}

	public class GateThread extends Thread implements KeyListener
	{
		public void run()
		{
			addKeyListener(this);
		}

		@Override
		public void keyTyped(KeyEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) 
		{
			Element snake = elements.get(snakeIndex);
			if ((e.getKeyCode() == KeyEvent.VK_UP) && (snake.directionX != 0))
			{
				snake.directionX = 0;
				snake.directionY = -1;
			}
			if ((e.getKeyCode() == KeyEvent.VK_DOWN) && (snake.directionX != 0))
			{
				snake.directionX = 0;
				snake.directionY = 1;
			}
			if ((e.getKeyCode() == KeyEvent.VK_LEFT) && (snake.directionY != 0))
			{
				snake.directionX = -1;
				snake.directionY = 0;
			}
			if ((e.getKeyCode() == KeyEvent.VK_RIGHT) && (snake.directionY != 0))
			{
				snake.directionX = 1;
				snake.directionY = 0;
			}
		}
			
		@Override
		public void keyReleased(KeyEvent e) 
		{
			// TODO Auto-generated method stub
			
		}
	}

}

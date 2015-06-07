package com.tinytech.snake.element;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.tinytech.snake.property.*;

public class Snake extends Element implements Mutative, Reaction
{
	public static final int elementID = 2;
	public int length = 0;
	public int interval;
	public int targetLength;
	public LinkedList<JLabel> labelList = new LinkedList<JLabel>();
		
	private String snakeHeadAddr = "snakehead.jpg";
	private String snakeBodyAddr = "snakebody.jpg";
	private ImageIcon snakeHeadImg = new ImageIcon(this.getClass().getResource(snakeHeadAddr));
	private ImageIcon snakeBodyImg = new ImageIcon(this.getClass().getResource(snakeBodyAddr));
	public JLabel snakeBodyLabel;
	
	public Snake(int initX, int initY, int interval, int targetLength, int directionX, int directionY) 
	{
		super(1, 1, initX, initY);
		this.interval = interval;
		this.targetLength = targetLength;
		this.directionX = directionX;
		this.directionY = directionY;
		this.elementJLabel = new JLabel(snakeHeadImg);
		this.length = 1;
	}
	
	public class SnakeThread extends Thread
	{
		Gate gate;
		
		private void getGate(Gate gate)
		{
			this.gate = gate;
		}
		
		public void run()
		{
			while (true)
			{
				try
				{
					Thread.sleep(interval);
					resetToCont(gate);
					if (length > targetLength)
					{
						gate.cont.removeAll();
						gate.cont.setBackground(Color.BLACK);
						JLabel winResult = new JLabel("You Win!");
						gate.cont.add(winResult);
						winResult.setFont(new Font("Times New Roman", Font.BOLD, 30));
						winResult.setBounds(50, 50, 300, 30);
						winResult.setForeground(Color.WHITE);
						gate.Finishing();
					}
					
				}
				catch (Exception e) { }
			}
		}
	}

	@Override
	public void addToCont(Gate gate) 
	{
		super.addToCont(gate);
		labelList.add(elementJLabel);
		
		SnakeThread st = new SnakeThread();
		st.getGate(gate);
		st.start();
	}
	

	@Override
	public int reaction(Gate gate, int elementID, Component comp) 
	{
		if ((elementID == 1) || (elementID == 2))
		{
			gate.cont.removeAll();
			gate.cont.setBackground(Color.BLACK);
			JLabel loseResult = new JLabel("You lose!");
			gate.cont.add(loseResult);
			loseResult.setFont(new Font("Times New Roman", Font.BOLD, 30));
			loseResult.setBounds(50, 50, 300, 30);
			loseResult.setForeground(Color.WHITE);
			gate.Finishing();
		}
		if (elementID == 3)
		{
			Point location = comp.getLocation();
			gate.cont.remove(comp);
			gate.layout[location.y / gate.gateProperty.getElementHeight() - Gate.initLocation]
					[location.x / gate.gateProperty.getElementWidth() - Gate.initLocation] = 0;
			gate.generateItem(3, 1);
		}
		return elementID;
	}

	@Override
	public void resetToCont(Gate gate) 
	{
		Point newLocation = new Point(elementJLabel.getX() + directionX * gate.gateProperty.getElementWidth(),
				elementJLabel.getY() + directionY * gate.gateProperty.getElementHeight());
		int nextElementID = gate.layout[newLocation.y / gate.gateProperty.getElementHeight() - Gate.initLocation]
				[newLocation.x / gate.gateProperty.getElementWidth() - Gate.initLocation];
		int result = this.reaction(gate, nextElementID, gate.cont.findComponentAt(newLocation));
		
		Point oldLocation = new Point();
		for (JLabel snakeLabel : labelList)
		{
			oldLocation.setLocation(snakeLabel.getX(), snakeLabel.getY());
			snakeLabel.setLocation(newLocation.x, newLocation.y);
			gate.layout[newLocation.y / gate.gateProperty.getElementHeight() - Gate.initLocation]
					[newLocation.x / gate.gateProperty.getElementWidth() - Gate.initLocation] = 2;
			newLocation.setLocation(oldLocation);
			gate.layout[oldLocation.y / gate.gateProperty.getElementHeight() - Gate.initLocation]
					[oldLocation.x / gate.gateProperty.getElementWidth() - Gate.initLocation] = 0;
		}
		
		if (result == 3)
		{
			snakeBodyLabel = new JLabel(snakeBodyImg);
			gate.cont.add(snakeBodyLabel);
			gate.cont.setComponentZOrder(snakeBodyLabel, 0);
			snakeBodyLabel.setBounds(newLocation.x, newLocation.y, sizeX * gate.gateProperty.getElementWidth(), 
					sizeY * gate.gateProperty.getElementHeight());
			labelList.add(snakeBodyLabel);
			length++;
		}
	} 

}

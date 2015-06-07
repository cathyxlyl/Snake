package com.tinytech.snake.property;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import com.tinytech.snake.element.*;
import com.tinytech.snake.element.item.Food;


public abstract class Gate extends JFrame
{
	public GateProperty gateProperty;
	public BackGround backGround;
	protected static int gateCount = 0;
	protected int gateID;
	public int[][] layout;
	public Container cont;
	protected List<Element> elements;
	public boolean isFinished = false;
	
	public int snakeIndex;
	
	public static int initLocation = 1;
	
	{
		gateCount++;
		gateID = gateCount;
		elements = new ArrayList<Element>();
	}
	
	public Gate(GateProperty gateProperty, String name)
	{
		super(name);
		this.gateProperty = gateProperty;
;		
		setVisible(true);
		setSize(gateProperty.getElementWidth() * (gateProperty.getCountX() + 3), 
				gateProperty.getElementHeight() * (gateProperty.getCountY() + 3));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cont = getContentPane();
		cont.setLayout(null);
	}
	
	protected void addElement(Element element)
	{
		elements.add(element);
		element.addToCont(this);
		
		if (element instanceof Snake)
		{
			snakeIndex = elements.size() - 1;
		}
	}
	
	protected abstract void generateSilent();
	
	public void generateSnake(int interval, int targetLength, int directionX, int directionY)
	{
		int locationY;
		int locationX;

		do
		{
			locationY = (int)(Math.random() * gateProperty.getCountY());
			locationX = (int)(Math.random() * gateProperty.getCountY());
		}
		while (layout[locationY][locationX] != 0);
		layout[locationY][locationX] = 2;
		this.addElement(new Snake(locationX ,locationY, interval, targetLength, directionX, directionY));
	}
	
	public void generateItem(int elementID, int count)
	{
		int locationY;
		int locationX;

		for (int i = 0; i < count; i++)
		{
			do
			{
				locationY = (int)(Math.random() * gateProperty.getCountY());
				locationX = (int)(Math.random() * gateProperty.getCountY());
			}
			while (layout[locationY][locationX] != 0);
			layout[locationY][locationX] = elementID;

			if (elementID == 3)
			{
				this.addElement(new Food(locationX ,locationY));
			}
		}
	}
	
	protected abstract void setInitLayout();
	
	protected abstract void setBackGround();
	
	public void Finishing()
	{
		isFinished = true;
	}
	
}

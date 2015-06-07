package com.tinytech.snake.element.item;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.tinytech.snake.property.*;

public abstract class Inventory extends Element implements Reaction
{
	private String inventoryAddr;
	private ImageIcon inventoryImg;
	
	public Inventory(int sizeX, int sizeY, int initX, int initY, String inventoryAddr) 
	{
		super(sizeX, sizeY, initX, initY);
		this.inventoryAddr = inventoryAddr;
		inventoryImg = new ImageIcon(this.getClass().getResource(this.inventoryAddr));
		this.elementJLabel = new JLabel(inventoryImg);
	}
}

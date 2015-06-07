package com.tinytech.snake.element.silent;

import javax.swing.*;
import com.tinytech.snake.property.Element;

public abstract class SilentElement extends Element
{	
	public SilentElement(int sizeX, int sizeY, int initX, int initY, String addr) 
	{
		super(sizeX, sizeY, initX, initY);
		ImageIcon silentElementImg = new ImageIcon(this.getClass().getResource(addr));
		this.elementJLabel = new JLabel(silentElementImg);
	}
}

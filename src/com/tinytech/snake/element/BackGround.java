package com.tinytech.snake.element;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.tinytech.snake.property.*;

public class BackGround
{
	public static final int elementID = 0;
	private JLabel backGroundLabel;
	private static String backgroundAddr = "background.jpg";
	
	public BackGround() 
	{
		ImageIcon backGroundImg = new ImageIcon(this.getClass().getResource(backgroundAddr));
		backGroundLabel = new JLabel(backGroundImg);
	}
		
	public void addToCont(Gate gate) 
	{
		gate.cont.add(backGroundLabel);
		backGroundLabel.setBounds(Gate.initLocation * gate.gateProperty.getElementWidth(), 
				Gate.initLocation * gate.gateProperty.getElementHeight(), 
				gate.gateProperty.getCountX() * gate.gateProperty.getElementWidth(), 
				gate.gateProperty.getCountY() * gate.gateProperty.getElementHeight());
	}
}

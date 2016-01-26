package com.freedan.world;
import java.awt.*;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LandscapeDisplay extends JComponent {
	
	int xVal, yVal, size;
	World w;
	
	public LandscapeDisplay(int x, int y, int s, World wa){
		w = wa;
		xVal = x;
		yVal = y;
		size = s;
	}
	public void paintComponent(Graphics g){
		Graphics2D display = (Graphics2D) g;
		Rectangle tile = new Rectangle(xVal, yVal,size, size);
		display.setBackground(w.getLandInfo(xVal/size, yVal/size).getColor());
		display.draw(tile);
	}
	

}

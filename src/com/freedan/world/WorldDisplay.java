package com.freedan.world;
import java.awt.*;
import javax.swing.*;

public class WorldDisplay {
	JFrame worldShower;
	LandscapeDisplay[][] tiles;
	World worldShown;
	int tileSize;

	public WorldDisplay(int size, int ts, String name, World wa) {
		worldShown = wa;
		tileSize = ts;
		worldShower = new JFrame();
		worldShower.setSize(size * 20, size * 20);
		worldShower.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		worldShower.setTitle(name);
		worldShower.setBackground(Color.WHITE);
		worldShower.setVisible(true);
		tiles = new LandscapeDisplay[size][size];
		
		for(int i = 0; i < size; i ++){
			for(int j = 0; j < size; j ++){
				tiles[i][j] = new LandscapeDisplay(20*i,20*j,tileSize, worldShown);
				worldShower.add(tiles[i][j]);
			}
		}
		worldShower.setVisible(true);
	}
	
	public void createDisplay(int size){
		for(int i = 0; i < size; i ++){
			for(int j = 0; j < size; j ++){

			}
		}
	}
}

package com.freedan.world;
import java.awt.Color;

public class Landscape {
	
	private String type;
	private int[] resources;
	private Color c;
	
	public Landscape(){
		type = "";
		resources = new int[5];
		c = Color.WHITE;
	}
	
	public Landscape(String t){
		type = t;
		resources = setResources(type);
		c = setColor();
	}
	
	public static int[] setResources(String type){
		int[] holdResources = new int[5];
		if(type.equalsIgnoreCase("Water")){
			holdResources[0] = (int) (75 + Math.random() * 25);
			holdResources[1] = (int) (50 + Math.random() * 25);
			holdResources[2] = 5;
			holdResources[3] = 0;
			holdResources[4] = (int) (Math.random() * 40);
 		}
		else if(type.equalsIgnoreCase("Ice")){
			holdResources[0] = (int) (50 + Math.random() * 25);
			holdResources[1] = (int) ( Math.random() * 15);
			holdResources[2] = 5;
			holdResources[3] = (int) (Math.random() * 40);
			holdResources[4] = (int) (25 + Math.random() * 60);
 		}
		else if(type.equalsIgnoreCase("Plains")){
			holdResources[0] = (int) ( Math.random() * 25);
			holdResources[1] = (int) ( 70 + Math.random() * 30);
			holdResources[2] = (int) (40 + Math.random() * 25);
			holdResources[3] = (int) (Math.random() * 40);
			holdResources[4] = (int) (15 + Math.random() * 35);
 		}
		else if(type.equalsIgnoreCase("Des")){
			holdResources[0] = (int) ( Math.random() * 25);
			holdResources[1] = (int) ( Math.random() * 15);
			holdResources[2] = 5;
			holdResources[3] = (int) (Math.random() * 25);
			holdResources[4] = (int) (25 + Math.random() * 60);
 		}
		else if(type.equalsIgnoreCase("Forest")){
			holdResources[0] = (int) ( 15 + Math.random() * 25);
			holdResources[1] = (int) ( 15 + Math.random() * 60);
			holdResources[2] = (int) ( 50 + Math.random() * 40);
			holdResources[3] = (int) (Math.random() * 40);
			holdResources[4] = (int) ( Math.random() * 40);
 		}
		else if(type.equalsIgnoreCase("Mount")){
			holdResources[0] = (int) ( Math.random() * 25);
			holdResources[1] = (int) ( Math.random() * 25);
			holdResources[2] = (int) (Math.random() * 40);
			holdResources[3] = (int) (35 + Math.random() * 60);
			holdResources[4] = (int) (25 + Math.random() * 25);
 		}
		
		
		return holdResources;
	}
	public Color setColor(){
		if(type.equalsIgnoreCase("Water")){
			return Color.BLUE;

 		}
		else if(type.equalsIgnoreCase("Ice")){
			return Color.WHITE;

 		}
		else if(type.equalsIgnoreCase("Plains")){
			return new Color(210,180,140);

 		}
		else if(type.equalsIgnoreCase("Des")){
			return Color.yellow;
			
 		}
		else if(type.equalsIgnoreCase("Forest")){
			return Color.GREEN;

 		}
		else{
			return Color.DARK_GRAY;
 		}
	}
	
	public String getType(){
		return type;
	}
	
	public int[] getResources(){
		return resources;
	}
	
	public String toString(){
		return type;
	}
	public Color getColor(){
		return c;
	}
}

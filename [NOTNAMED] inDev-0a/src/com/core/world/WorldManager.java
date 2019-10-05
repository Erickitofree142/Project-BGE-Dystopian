package com.core.world;

import java.util.ArrayList;

public class WorldManager{
	
	private ArrayList<Area> areas;
	private Area currentArea;
	
	public WorldManager(String path) {
		areas = new ArrayList<Area>();
		
	}

	public ArrayList<Area> getAreas() {
		return areas;
	}
	
	public void setArea(Area area) {
		this.currentArea = area;
	}
	
	public Area getArea() {
		return currentArea;
	}
	
	public Area getArea(int id) {
		for (Area a : areas) {
			if (a.getId() == id) {
				return a;
			}
		}
		return currentArea;
	}
}

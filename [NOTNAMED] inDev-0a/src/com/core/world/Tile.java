package com.core.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static int TILE_SIZE = 64;
	
	protected BufferedImage texture;
	protected int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		TilesLibrary.tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILE_SIZE, TILE_SIZE, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}
}

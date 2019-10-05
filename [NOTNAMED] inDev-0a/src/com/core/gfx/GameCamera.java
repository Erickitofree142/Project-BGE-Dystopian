package com.core.gfx;

import com.core.engine.Framework;
import com.core.entites.Entity;
import com.core.world.Tile;

public class GameCamera {
	
	private Framework framework;
	private float xOffset, yOffset;
	
	public GameCamera(Framework engine, float xOffset, float yOffset) {
		this.framework = engine;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void checkBlankSpace() {
		if(xOffset < 0) {
			xOffset = 0;
		}else if (xOffset > framework.getWorldManager().getArea().getWidth() * Tile.TILE_SIZE - framework.getWidth()){
			xOffset = framework.getWorldManager().getArea().getWidth() * Tile.TILE_SIZE - framework.getWidth();
		}
		
		if(yOffset < 0) {
			yOffset = 0;
		}else if (yOffset > framework.getWorldManager().getArea().getHeight() * Tile.TILE_SIZE - framework.getHeight()){
			yOffset = framework.getWorldManager().getArea().getHeight() * Tile.TILE_SIZE - framework.getHeight();
		}
	}
	
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getxPos() - framework.getWidth() / 2 + e.getHeight() / 2;
		yOffset = e.getyPos() - framework.getHeight() / 2 + e.getWidth() / 2;
		checkBlankSpace();

	}
	
	public void move(float xAmnt, float yAmnt) {
		xOffset += xAmnt;
		yOffset += yAmnt;
		checkBlankSpace();
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	

}

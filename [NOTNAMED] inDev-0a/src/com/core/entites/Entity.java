package com.core.entites;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.core.engine.Framework;

public abstract class Entity {
	
	protected Framework framework;
	protected float xPos, yPos;
	protected int width, height;
	protected Rectangle bounds;
	
	public Entity(Framework framework, float xPos, float yPos, int width, int height) {
		this.framework = framework;
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0, 0 , width, height);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public boolean checkEntityCollisions(float xOffset, float yOffset) {
		for (Entity e : framework.getWorldManager().getArea().getEntityManager().getEntites()) {
			if(e.equals(this))
				continue;
			
			if (e.getCollisionBounds(0f,  0f).intersects(getCollisionBounds(xOffset, yOffset))) {
				return true;
			}
		}
		return false;
	}

	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		return new Rectangle((int) (xPos + bounds.x + xOffset), (int) (yPos + bounds.y + yOffset),
								bounds.width, bounds.height);
	}

	public float getxPos() {
		return xPos;
	}

	public void setxPos(float xPos) {
		this.xPos = xPos;
	}

	public float getyPos() {
		return yPos;
	}

	public void setyPos(float yPos) {
		this.yPos = yPos;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
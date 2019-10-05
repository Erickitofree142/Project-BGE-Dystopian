package com.core.entites;

import com.core.engine.Framework;
import com.core.world.Tile;

public abstract class DynamicEntity extends Entity{

	public static final int DEFAULT_HEALTH = 10,
							DEFAULT_CREATURE_WIDTH = 32,
							DEFAULT_CREATURE_HEIGHT = 32;
	public static final float DEFAULT_SPEED = 4.0f;
	
	protected int health;
	protected float speed, xMove, yMove;
	
	public DynamicEntity(Framework framework, float xPos, float yPos, int width, int height) {
		super(framework, xPos, yPos, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();
	}
	
	public void moveX() {
		if(xMove > 0) {
			int tx = (int)(xPos + xMove + bounds.x + bounds.width) / Tile.TILE_SIZE;
			
			if (!collisionWithTile(tx, (int) (yPos + bounds.y) / Tile.TILE_SIZE) &&
					!collisionWithTile(tx, (int) (yPos + bounds.y + bounds.height) / Tile.TILE_SIZE)){
				xPos += xMove;
			}else {
				xPos = tx * Tile.TILE_SIZE - bounds.x - bounds.width - 1;
			}
		
		} else if(xMove < 0){
			int tx = (int)(xPos + xMove + bounds.x) / Tile.TILE_SIZE;
			
			if (!collisionWithTile(tx, (int) (yPos + bounds.y) / Tile.TILE_SIZE) &&
					!collisionWithTile(tx, (int) (yPos + bounds.y + bounds.height) / Tile.TILE_SIZE)){
				xPos += xMove;
			}else {
				xPos = tx * Tile.TILE_SIZE + Tile.TILE_SIZE - bounds.x;
			}
		}
	}
	
	public void moveY() {
		if(yMove < 0) {
			int ty = (int) (yPos + yMove + bounds.y) / Tile.TILE_SIZE;
			
			if (!collisionWithTile((int) (xPos + bounds.x) / Tile.TILE_SIZE , ty) &&
					!collisionWithTile((int) (xPos + bounds.width) / Tile.TILE_SIZE , ty)) {
				yPos += yMove;
			}else {
				yPos = ty * Tile.TILE_SIZE + Tile.TILE_SIZE - bounds.y;
			}
		}else if (yMove > 0) {
			int ty = (int) (yPos + yMove + bounds.y + bounds.height) / Tile.TILE_SIZE;
			
			if (!collisionWithTile((int) (xPos + bounds.x) / Tile.TILE_SIZE , ty) &&
					!collisionWithTile((int) (xPos + bounds.width) / Tile.TILE_SIZE , ty)) {
				yPos += yMove;
			}else {
				yPos = ty * Tile.TILE_SIZE - bounds.y - bounds.height - 1;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return framework.getWorldManager().getArea().getTile(x, y).isSolid();
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	
}

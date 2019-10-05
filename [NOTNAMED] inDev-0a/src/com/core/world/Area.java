package com.core.world;

import java.awt.Graphics;

import com.core.engine.Framework;
import com.core.engine.Utils;
import com.core.entites.EntityManager;

public class Area {
	
	private int spawnX, spawnY;
	private Framework framework;
	private EntityManager entityManager;
	private int width, height, id;
	private int[][] map;
	
	public Area(Framework framework, EntityManager entityManager, String path, int id) {
		this.framework = framework;
		this.id = id;
		this.entityManager = entityManager; 
		
		loadWorld(path);
	
		entityManager.getPlayer().setxPos(spawnX);
		entityManager.getPlayer().setyPos(spawnY);
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		map = new int[width][height];
		for (int y = 0; y < width; y++) {
			for (int x = 0; x < width; x++){
				map[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x  >= width || y >= height)
			return TilesLibrary.floorTile2;
		
		Tile t = TilesLibrary.tiles[map[x][y]];
		if (t == null)
			return TilesLibrary.floorTile1;
		return t;
	}
	
	public void tick() {
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int)Math.max(0, framework.getGameCamera().getxOffset() / Tile.TILE_SIZE);
		int xEnd = (int)Math.min(width, (framework.getGameCamera().getxOffset() + framework.getWidth()) / Tile.TILE_SIZE + 1);
		int yStart = (int)Math.max(0, framework.getGameCamera().getyOffset() / Tile.TILE_SIZE);
		int yEnd = (int)Math.min(height, (framework.getGameCamera().getyOffset() + framework.getHeight()) / Tile.TILE_SIZE + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++){
				getTile(x, y).render(g,(int) (x * Tile.TILE_SIZE - framework.getGameCamera().getxOffset()) ,
										(int) (y * Tile.TILE_SIZE  - framework.getGameCamera().getyOffset()));
			}
		}
		entityManager.render(g);
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public int getId() {
		return id;
	}

}

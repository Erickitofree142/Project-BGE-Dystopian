package com.core.world;

import com.core.games.zeday.tiles.FloorTile;
import com.core.games.zeday.tiles.WallTile;

public class TilesLibrary {
	public static Tile[] tiles = new Tile[256];
	
	public static Tile floorTile1 = new FloorTile(0, 0);
	public static Tile floorTile2 = new FloorTile(1, 1);
	public static Tile floorTile3 = new FloorTile(2, 2);
	public static Tile floorTile4 = new FloorTile(3, 3);
	
	public static Tile wallTile1 = new WallTile(0, 4);
	public static Tile wallTile2 = new WallTile(1, 5);
	public static Tile wallTile3 = new WallTile(2, 6);
	public static Tile wallTile4 = new WallTile(3, 7);
	
	
}

package com.core.games.zeday.tiles;

import com.core.gfx.Assets;
import com.core.world.Tile;

public class FloorTile extends Tile{

	public FloorTile(int imgNumber, int id) {
		super(Assets.floors[imgNumber], id);
	}
}

package com.core.games.zeday.tiles;

import com.core.gfx.Assets;
import com.core.world.Tile;

public class WallTile extends Tile{

	public WallTile(int imgNumber, int id) {
		super(Assets.walls[imgNumber], id);
	}
	
	public boolean isSolid() {
		return true;
	}
}

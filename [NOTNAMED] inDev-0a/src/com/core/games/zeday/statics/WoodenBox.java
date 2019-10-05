package com.core.games.zeday.statics;

import java.awt.Graphics;

import com.core.engine.Framework;
import com.core.entites.StaticEntity;
import com.core.gfx.Assets;
import com.core.world.Tile;

public class WoodenBox extends StaticEntity{

	public WoodenBox(Framework framework, float xPos, float yPos) {
		super(framework, xPos, yPos, Tile.TILE_SIZE, Tile.TILE_SIZE);
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.wbox1[0], (int) (xPos - framework.getGameCamera().getxOffset())
									, (int) (yPos - framework.getGameCamera().getyOffset()),
										width, height, null);
	}

}

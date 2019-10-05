package com.core.games.pong;

import java.awt.Graphics;

import com.core.engine.Framework;
import com.core.entites.DynamicEntity;

public class Ball extends DynamicEntity{


	public Ball(Framework framework, float xPos, float yPos) {
		super(framework, xPos, yPos, 50, 50);
		
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.fillRect((int) xPos, (int) yPos, width, height);
		
	}

}

package com.core.entites;

import com.core.engine.Framework;

public abstract class StaticEntity extends Entity{

	public StaticEntity(Framework framework, float xPos, float yPos, int width, int height) {
		super(framework, xPos, yPos, width, height);
	}

}

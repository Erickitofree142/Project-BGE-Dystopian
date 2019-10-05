package com.core.gfx.animations;

import java.awt.image.BufferedImage;

public class DefaultAnimation {
	
	private int speed, index;
	private BufferedImage[] frames;
	private long lastTime, timer;

	public DefaultAnimation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed) {
			index++;
			timer = 0;
			if (index >= frames.length)
				index = 0;
		}
	}
	
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}

}
package com.core.gfx.animations;

import java.awt.image.BufferedImage;

public class CharacterAnimation {
	
	private int speed, index, row, currentLength;
	private BufferedImage[][] frames;
	private long lastTime, timer;

	public CharacterAnimation(int speed, BufferedImage[][] frames, int row) {
		this.speed = speed;
		this.frames = frames;
		this.row = row;
		currentLength = getCurrentLength();
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	private int getCurrentLength() {
		int ret = 1;
		for(int x = 0; x <= ret; x++) {
			try {
				if (!frames[row][x].equals(null)) {
					ret += 1;
				}
			}catch(Exception e){
				break;
			}
		}
		return ret;
	}
	
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed) {
			index++;
			timer = 0;
			if (index >= currentLength - 1)
				index = 0;
		}
	}
	
	public BufferedImage getCurrentFrame() {
		return frames[row][index];
	}

	public void setRow(int row) {
		this.row = row;
	}

}

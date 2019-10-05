package com.core.inputs;

import java.awt.event.KeyEvent;

public class KeyLibrary{
	
	private boolean[] keys;
	
	public boolean moveUp, moveDown, moveRight, moveLeft, sprint,
					startDevMode, endDevMode;

	public KeyLibrary() {	
		keys = new boolean[256];
	
	}
	
	public void tick() {
		moveUp = keys[KeyEvent.VK_W];
		moveDown = keys[KeyEvent.VK_S];
		moveLeft = keys[KeyEvent.VK_A];
		moveRight = keys[KeyEvent.VK_D];
		sprint = keys[KeyEvent.VK_SHIFT];
		startDevMode = keys[KeyEvent.VK_SEMICOLON];
		endDevMode = keys[KeyEvent.VK_PERIOD];
	}
	
	public boolean[] getKeys() {
		return keys;
	}

}

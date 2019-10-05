package com.core.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{
	
	private KeyLibrary keyLibrary;
	private boolean[] keys;
	
	public KeyInput() {
		keyLibrary = new KeyLibrary();
		keys = keyLibrary.getKeys();
	}
	
	public void tick() {
		keyLibrary.tick();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	public KeyLibrary getLibrary() {
		return keyLibrary;
	}
}

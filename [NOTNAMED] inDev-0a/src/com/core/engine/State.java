package com.core.engine;

import java.awt.Graphics;

public abstract class State {
	
	public static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	protected Framework framework;
	protected boolean developerMode;
	
	public State(Framework framework) {
		this.framework = framework;
		this.developerMode = false;
	}
	
	protected void devInput() {
		if (framework.getKeyInput().getLibrary().startDevMode) {
			developerMode = true;
		}
		if (framework.getKeyInput().getLibrary().endDevMode) {
			developerMode = false;
		}
			
			
	}
	
	public boolean onDevMode() {
		return developerMode;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
}

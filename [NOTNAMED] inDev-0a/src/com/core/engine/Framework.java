package com.core.engine;

import com.core.gfx.GameCamera;
import com.core.inputs.KeyInput;
import com.core.inputs.MouseInput;
import com.core.world.WorldManager;

public class Framework {

	private Engine engine;
	private WorldManager worldManager;
	
	public Framework(Engine engine) {
		this.engine = engine;
		
	}
	
	public GameCamera getGameCamera() {
		return engine.getGameCamera();
	}
	
	public KeyInput getKeyInput() {
		return engine.getKeyInput();
	}
	
	public MouseInput getMouseInput(){
		return engine.getMouseInput();
	}
	
	public int getWidth() {
		return engine.getWidth();
	}
	
	public int getHeight() {
		return engine.getHeight();
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public WorldManager getWorldManager() {
		return worldManager;
	}

	public void setWorldManager(WorldManager worldManager) {
		this.worldManager = worldManager;
	}

}

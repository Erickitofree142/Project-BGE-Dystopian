package com.core.games.zeday;

import java.awt.Graphics;

import com.core.engine.Framework;
import com.core.engine.State;
import com.core.games.Handler;
import com.core.world.Area;

public class ZeroDay extends State{
	
	private Area area;
	
	public ZeroDay(Framework framework, Handler handler) {
		super(framework);
		area = framework.getWorldManager().getArea();
		framework.getGameCamera().move(0, 0);
		
		
	}
	
	@Override
	public void tick() {
		area.tick();
		devInput();
		
	}

	@Override
	public void render(Graphics g) {
		area.render(g);
	}
}

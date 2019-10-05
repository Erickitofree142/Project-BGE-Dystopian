package com.core.games.zeday.dynamics;

import java.awt.Color;
import java.awt.Graphics;

import com.core.engine.Framework;
import com.core.entites.User;
import com.core.gfx.Assets;
import com.core.gfx.animations.CharacterAnimation;

public class Player extends User{
	
	public Player(Framework framework, float xPos, float yPos) {
		super(framework, xPos, yPos, 38 * 2, 52 * 2, new CharacterAnimation(500, Assets.civ1, 1));
		bounds.x = 15;
		bounds.y = 52;
		bounds.width = 46;
		bounds.height = 49;
		
		playerAnim = new CharacterAnimation(500, Assets.civ1, 3);
	}

	@Override
	public void tick() {
		playerAnim.tick();
		setAnimationFrame();
		getInput();
		move();
		framework.getGameCamera().centerOnEntity(this);
	}
	
	@Override
	public void render(Graphics g) {

		g.drawImage(playerAnim.getCurrentFrame(), (int) (xPos - framework.getGameCamera().getxOffset()), 
										(int) (yPos - framework.getGameCamera().getyOffset()), width, height,null);
		
		devMode(g);
	}
	
	private void devMode(Graphics g) {
		
		if (framework.getEngine().core.onDevMode()) {
			g.setColor(Color.RED);
			g.fillRect((int) (xPos + bounds.x - framework.getGameCamera().getxOffset()), 
						(int) (yPos + bounds.y - framework.getGameCamera().getyOffset()),
						bounds.width, bounds.height);
		}
		
	}

}

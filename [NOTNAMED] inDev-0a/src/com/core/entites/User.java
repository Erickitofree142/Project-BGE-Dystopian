package com.core.entites;

import com.core.engine.Framework;
import com.core.gfx.animations.CharacterAnimation;

public abstract class User extends DynamicEntity{
	
	protected CharacterAnimation playerAnim;
	
	public User(Framework framework, float xPos, float yPos, int width, int height, CharacterAnimation playerAnim) {
		super(framework, xPos, yPos, width, height);
		this.playerAnim = playerAnim;

	}
	
	protected void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(framework.getKeyInput().getLibrary().moveUp)
			yMove = -speed;
		if(framework.getKeyInput().getLibrary().moveDown)
			yMove = speed;
		if(framework.getKeyInput().getLibrary().moveLeft)
			xMove = -speed;
		if(framework.getKeyInput().getLibrary().moveRight)
			xMove = speed;
		if(framework.getKeyInput().getLibrary().sprint)
			speed = 7;
		if(!framework.getKeyInput().getLibrary().sprint)
			speed = 4;
	}
	
	protected void setAnimationFrame() {
		if(framework.getKeyInput().getLibrary().moveDown) {
			playerAnim.setRow(3);
		}if(framework.getKeyInput().getLibrary().moveLeft) {
			playerAnim.setRow(2);
		}if(framework.getKeyInput().getLibrary().moveRight) {
			playerAnim.setRow(1);
		}if(framework.getKeyInput().getLibrary().moveUp) {
			playerAnim.setRow(0);
		}
	}
	

}

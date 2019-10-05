package com.core.games;

import com.core.engine.Framework;
import com.core.engine.State;
import com.core.entites.EntityManager;
import com.core.games.zeday.ZeroDay;
import com.core.games.zeday.dynamics.Player;
import com.core.games.zeday.statics.WoodenBox;
import com.core.world.Area;
import com.core.world.WorldManager;

public class Handler{
	
	private State[] games;
	private State currentGame;
	
	private EntityManager entityManager;
	
	public Handler(Framework framework) {
		//Temporary Entity Loading 
		this.entityManager =  new EntityManager(framework, new Player(framework, 0, 0));										
		entityManager.addEntity(new WoodenBox(framework, 1000, 100));
		
		//Temporary Map Loading
		framework.setWorldManager(new WorldManager("res/zeday/maps/maps.psfm"));
		framework.getWorldManager().setArea(new Area(framework,  entityManager, "res/zeday/maps/test_map.psfm", 0));
		
		games = new State[4];
		games[0] = new ZeroDay(framework, this);
		
		currentGame = games[0];
		
	}

	public State getCurrentGame() {
		return currentGame;
	}
	
	public void setCurrentGame(State game) {
		this.currentGame = game;
	}
}

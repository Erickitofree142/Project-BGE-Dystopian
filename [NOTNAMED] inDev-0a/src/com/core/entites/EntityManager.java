package com.core.entites;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

import com.core.engine.Framework;

public class EntityManager {
	
	@SuppressWarnings("unused")
	private Framework framework;
	private User user;
	private ArrayList<Entity> entities;
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {

		@Override
		public int compare(Entity a, Entity b) {
			if (a.getyPos() + a.getHeight() < b.getyPos() + b.getHeight())
				return -1;
			return 1;
		}
	};

	public EntityManager(Framework framework, User user) {
		this.framework = framework;
		this.user = user;
		entities = new ArrayList<Entity>();
		entities.add(user);
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
		}
	}
	
	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
		
		entities.sort(renderSorter);
	}

	public User getPlayer() {
		return user;
	}

	public void setPlayer(User player) {
		this.user = player;
	}

	public ArrayList<Entity> getEntites() {
		return entities;
	}

	public void setEntites(ArrayList<Entity> entites) {
		this.entities = entites;
	}

}

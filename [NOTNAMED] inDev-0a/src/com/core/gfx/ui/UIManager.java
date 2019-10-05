package com.core.gfx.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.core.engine.Framework;

public class UIManager {
	
	private Framework framework;
	private ArrayList<UIObject> objects;

	public UIManager(Framework framework) {
		this.framework = framework;
		objects = new ArrayList<UIObject>();
	}
	
	public void tick() {
		for (UIObject o : objects)
			o.tick();
	}
	
	public void render(Graphics g) {
		for (UIObject o : objects)
			o.render(g);
	}
	
	public void onMouseMove(MouseEvent e) {
		for (UIObject o : objects)
			o.onMouseMove(e);
	}
	
	public void onMouseRelease(MouseEvent e) {
		for (UIObject o : objects)
			o.onMouseRealesed(e);
	}
	
	public void addObject(UIObject o) {
		objects.add(o);
	}
	
	public void removeObject(UIObject o) {
		objects.remove(o);
	}

	public Framework getFramework() {
		return framework;
	}

	public void setFramework(Framework framework) {
		this.framework = framework;
	}

	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}

}

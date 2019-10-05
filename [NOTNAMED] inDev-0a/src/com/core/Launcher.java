package com.core;

import com.core.engine.Engine;

public class Launcher {
	public static void main(String[] args){
		Engine engine = new Engine("Project Z-D", 1280, 740);
		engine.start();												  
	}	
}
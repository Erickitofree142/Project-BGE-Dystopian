package com.core.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.core.gfx.Assets;
import com.core.gfx.GameCamera;
import com.core.inputs.KeyInput;
import com.core.inputs.MouseInput;

public class Engine implements Runnable {
	
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private KeyInput keyInput;
	private MouseInput mouseInput;
	
	private BufferStrategy bs;
	private Graphics g;
	private GameCamera gameCamera;
	
	private Framework framework;
	
	public State core;

	public Engine(String title, int width, int height){ 
		this.width = width;
		this.height = height;
		this.title = title;
		
		keyInput = new KeyInput();
		mouseInput = new MouseInput();
	}
							
	private void init() {
		display = new Display(title, width, height); 
		display.getFrame().addKeyListener(keyInput);
		display.getFrame().addMouseListener(mouseInput);
		display.getFrame().addMouseMotionListener(mouseInput);
		display.getCanvas().addMouseListener(mouseInput);
		display.getCanvas().addMouseMotionListener(mouseInput);
		
		Assets.init();
		
		framework = new Framework(this);
		gameCamera = new GameCamera(framework, 0, 0);
		
		core = new Core(framework);
		State.setState(core);
	}
	
	private void tick(){
		keyInput.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render(){ 
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
		if(State.getState() != null)
			State.getState().render(g);

		bs.show();
		g.dispose();
	}
	
	public void run(){
		init();
		int ticks = 0;
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("FPS: "+ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}

	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public KeyInput getKeyInput() {
		return keyInput;
	}
	
	public MouseInput getMouseInput() {
		return mouseInput;
	}
							
	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}
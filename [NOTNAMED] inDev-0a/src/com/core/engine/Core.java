package com.core.engine;

import java.awt.Graphics;

import com.core.games.Handler;
import com.core.gfx.Assets;
import com.core.gfx.ui.ClickListener;
import com.core.gfx.ui.UIImageButton;
import com.core.gfx.ui.UIManager;

public class Core extends State{
	
	private UIManager uiManager;
	private Handler handler;
	
	public Core(Framework framework){
		super(framework);
		uiManager = new UIManager(framework);
		framework.getMouseInput().setUiManager(uiManager);
		handler = new Handler(framework);
		
		
		//Temporary Button
		uiManager.addObject(new UIImageButton(200, 200, 128, 64, Assets.start_btn, new ClickListener() {
			@Override
			public void onClick() {
				State.setState(handler.getCurrentGame());
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	
	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}

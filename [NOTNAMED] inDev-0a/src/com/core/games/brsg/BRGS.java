package com.core.games.brsg;

import java.awt.Graphics;

import com.core.engine.Framework;
import com.core.engine.State;

public class BRGS extends State{	
	
	public BRGS(Framework framework) {
		super(framework);
		
		startLobby(10);
	}

	public String title;
	private Time time;
	
	private void startLobby(int max){
		for (int x = 0; x < max; x++){

		}
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	public Time getTime() {
		return time;
	}

    class Time{
		private int currentTime;
		private boolean seeTime;
		
		public Time() {
			currentTime = 0;
			seeTime = false;
		}
		
		public String readTime() {
			String time = "";
			
			if (seeTime) {
				int hr = 0, min = 0, sec = 0;
				
				for (int counter = 0; counter < currentTime; counter++) {
					sec ++;
					
					if (sec >= 60) {
						min ++;
						sec = 0;
					}
					if (min >= 60) {
						hr ++;
					}
				}
				
				time = hr + ":" + min + ":" + sec;
				return time;
			}
			
			return time;
		}
		
		public int getCurrentTime() {
			return currentTime;
		}
		
		public void setTime(int currentTime) {
			this.currentTime = currentTime;
		}
	}
}
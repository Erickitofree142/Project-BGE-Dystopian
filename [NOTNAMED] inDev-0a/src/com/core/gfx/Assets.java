package com.core.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static final int width = 32, height = 32;
	public static BufferedImage[] floors, walls,
									wbox1,
									start_btn;
	public static BufferedImage[][] civ1;
	
	public static void init() {
		SpriteSheet floorsSheet = new SpriteSheet(ImageLoader.loadImage("/zeday/txtrs/texture1/floor1.png"));
		SpriteSheet wallsSheet = new SpriteSheet(ImageLoader.loadImage("/zeday/txtrs/texture1/wall1.png"));
		
		SpriteSheet wbox1Sheet = new SpriteSheet(ImageLoader.loadImage("/zeday/txtrs/texture1/box1.png"));
		
		SpriteSheet civ1Sheet = new SpriteSheet(ImageLoader.loadImage("/zeday/txtrs/texture1/civilians/civilian1.png"));
		
		SpriteSheet startBtnSheet = new SpriteSheet(ImageLoader.loadImage("/zeday/txtrs/texture1/buttons/Start_btn.png"));
		//SpriteSheet civ2Sheet = new SpriteSheet(ImageLoader.loadImage("/txtrs/texture1/civilians/civilian2.png")); | TODO: Create more people sprite 

		walls = getFramesA(wallsSheet, width, height, 2, 2);
		floors = getFramesA(floorsSheet, width, height, 2, 2);
		
		wbox1 = getFramesA(wbox1Sheet, width, height, 1, 2);
		
		civ1 = new BufferedImage[6][4];// width + 6, height + 20 |  //TODO: Delete all this huge amound useless code in once getFramesB() is debugged
		civ1[0][0] = civ1Sheet.crop(0, 0, width + 6, height + 20); civ1[0][1] = civ1Sheet.crop((width + 6) * 2, 0, width + 6, height + 20);
		civ1[0][2] = civ1Sheet.crop(width + 6, 0, width + 6, height + 20);
		
		civ1[1][0] = civ1Sheet.crop(0, height + 20, width + 6, height + 20); civ1[1][1] = civ1Sheet.crop((width + 6) * 2, height + 20 , width + 6, height + 20);
		civ1[1][2] = civ1Sheet.crop(width + 6, height + 20, width + 6, height + 20);
		
		civ1[2][0] = civ1Sheet.crop((width + 6) * 4, (height + 20) * 2, width + 6, height + 20); civ1[2][1] = civ1Sheet.crop((width + 6) * 3, (height + 20) * 2, width + 6, height + 20);
		civ1[2][2] = civ1Sheet.crop((width + 6) * 2, (height + 20) * 2, width + 6, height + 20);
		
		civ1[3][0] = civ1Sheet.crop(0, (height + 20) * 3, width + 6, height + 20); civ1[3][1] = civ1Sheet.crop(width + 6, (height + 20) * 3, width + 6, height + 20);
		civ1[3][2] = civ1Sheet.crop((width + 6) * 2, (height + 20) * 3, width + 6, height + 20);
		
		
		
		civ1[4][0] = civ1Sheet.crop(0, 0, width + 6, height + 20); civ1[4][1] = civ1Sheet.crop(0, 0, width + 6, height + 20);
		civ1[4][2] = civ1Sheet.crop(0, 0, width + 6, height + 20); civ1[4][3] = civ1Sheet.crop(0, 0, width + 6, height + 20);		
		civ1[5][0] = civ1Sheet.crop(0, 0, width + 6, height + 20); civ1[5][1] = civ1Sheet.crop(0, 0, width + 6, height + 20);
		civ1[5][2] = civ1Sheet.crop(0, 0, width + 6, height + 20); civ1[5][3] = civ1Sheet.crop(0, 0, width + 6, height + 20);
		

		//civ1 = getFramesB(civ1Sheet, width + 6, height + 20, 4, 3);
		
		start_btn = new BufferedImage[3];
		start_btn[0] = startBtnSheet.crop(0, 0, (width + 28) * 2, height + 28); start_btn[1] = startBtnSheet.crop((width + 28) * 2, 0, (width + 28) * 2, height + 28);
		start_btn[2] = startBtnSheet.crop(((width + 28) * 2) * 2, 0, (width + 28) * 2, height + 28);
	}
	
	private static BufferedImage[] getFramesA(SpriteSheet spritesheet, int w_size, int h_size, int rows, int columns) {
		BufferedImage[] frames = new BufferedImage[rows * columns];
		int frame = 0;
		
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < columns; y++, frame++) {
				frames[frame] = spritesheet.crop(w_size * x, w_size * y, w_size, h_size);
			}
		}
		return frames;
	}
	//TODO: Debug getFramesB()
	private static BufferedImage[][] getFramesB(SpriteSheet spritesheet, int w_size, int h_size, int rows, int columns) {
		BufferedImage[][] frames = new BufferedImage[4][3];
		
		for (int column = 0; column < columns; column++) {
			for (int row = 0; row < rows; row++) {
	
				frames[row][column] = spritesheet.crop(w_size * row, w_size * column, w_size, h_size);
			}
		}
			
		return frames;
	}

}
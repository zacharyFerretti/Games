package gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int tileWidth = 32, tileHeight = 32;

	
	
	public static BufferedImage Mabel, Abel, TreeScene, River, Logo, Lake, PitScene, Grass;
	public static BufferedImage NorthWall, WestWall, EastWall, SouthWall;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sprite.png"));
		SpriteSheet wall = new SpriteSheet(ImageLoader.loadImage("/textures/wallSprites.png"));
		
		River = sheet.crop(0, 0, tileWidth, tileHeight);
		Abel = sheet.crop(0, tileHeight, tileWidth, tileHeight);
		Mabel = sheet.crop(tileWidth, 0, tileWidth, tileHeight);
		TreeScene = sheet.crop(tileWidth, tileHeight, tileWidth, tileHeight);
		Lake = sheet.crop(0, 2*tileHeight, tileWidth*4, tileHeight*2);
		PitScene = sheet.crop(2*tileWidth, 0, tileWidth, tileHeight);
		Grass = sheet.crop(3*tileWidth, tileHeight, tileWidth, tileHeight);
		
		//Borders of the game.
		
		NorthWall = wall.crop(tileWidth, 0, tileWidth, tileHeight);
		SouthWall = wall.crop(0, tileHeight, tileWidth, tileHeight);
		WestWall = wall.crop(0, 0, tileWidth, tileHeight);
		EastWall = wall.crop(tileWidth, tileHeight, tileWidth, tileHeight);
		
		Logo = ImageLoader.loadImage("/textures/logo.png");
	}
	
	
}

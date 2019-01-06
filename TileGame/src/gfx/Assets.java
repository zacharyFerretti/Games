package gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int tileWidth = 32, tileHeight = 32;
	
	public static BufferedImage Mabel, Abel, TreeScene, River, Logo, Lake, Pit;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sprite.png"));
		
		River = sheet.crop(0, 0, tileWidth, tileHeight);
		Abel = sheet.crop(0, tileHeight, tileWidth, tileHeight);
		Mabel = sheet.crop(tileWidth, 0, tileWidth, tileHeight);
		TreeScene = sheet.crop(tileWidth, tileHeight, tileWidth, tileHeight);
		Lake = sheet.crop(0, 2*tileHeight, tileWidth*4, tileHeight*4);
		Pit = sheet.crop(3*tileWidth,0, tileWidth, tileHeight);
		Logo = ImageLoader.loadImage("/textures/logo.png");
	}
	
	
}

package gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int tileWidth = 32, tileHeight = 32;
	
	public static BufferedImage Mabel, Abel, Grass, River, Logo;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sprite.png"));
		
		River = sheet.crop(0, 0, tileWidth, tileHeight);
		Abel = sheet.crop(0, tileHeight, tileWidth, tileHeight);
		Mabel = sheet.crop(tileWidth, 0, tileWidth, tileHeight);
		Grass = sheet.crop(tileWidth, tileHeight, tileWidth, tileHeight);
		Logo = ImageLoader.loadImage("/textures/logo.png");
	}
	
	
}

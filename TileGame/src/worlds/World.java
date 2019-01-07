package worlds;

import java.awt.Graphics;
import java.util.Arrays;

import tiles.PitTile;
import tiles.Tile;
import utils.Utilities;

public class World {
	private int width, height, spawnX, spawnY;
	private int [][] tiles;
	
	public World(String path) {
		loadWorld(path);
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		for(int j = 0; j<width; j++) {
			for (int i = 0; i<height; i++) {
				getTile(i,j).render(g,i*Tile.TILEWIDTH,j*Tile.TILEHEIGHT);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) {
			return Tile.treeTile;
		}else return t;
	}
	
	private void loadWorld(String path) {
		String loadedFile = Utilities.loadFileAsString(path);
		String [] tokens = loadedFile.split("\\s+");
		width = Utilities.parseInt(tokens[0]);
		height = Utilities.parseInt(tokens[1]);
		spawnX = Utilities.parseInt(tokens[2]);
		spawnY = Utilities.parseInt(tokens[3]);
		tiles = new int [width][height];
		
		System.out.println("Length of tiles: " + tiles.length);
		System.out.println("Length of tiles[]: " + tiles[0].length);
		
		System.out.println("Width: " + width);
		System.out.println("Height: " + height);
		
		for (int j = 0; j<height; j++) {
			for (int i = 0; i<width; i++) {
				tiles[i][j] = Utilities.parseInt(tokens[(i + j * width) + 4]);
			}
		}
	}
}

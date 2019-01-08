package worlds;

import java.awt.Graphics;

import tilegame.Handler;
import tiles.Tile;
import utils.Utilities;

public class World {
	
	private Handler handler;
	@SuppressWarnings("unused")
	private int width, height, spawnX, spawnY;
	private int [][] tiles;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
	}
	public void tick() {
		
	}
	public void render(Graphics g) {
		
		int xStart = (int) Math.max(0, (int) handler.getGameCamera().getxOffSet() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffSet() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, (int) handler.getGameCamera().getyOffSet() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffSet() + handler.getHeight()) / Tile.TILEHEIGHT+1);
		
		for(int j = yStart; j<yEnd; j++) {
			for (int i = xStart; i<xEnd; i++) {
				getTile(i,j).render(g,(int)(i*Tile.TILEWIDTH-handler.getGameCamera().getxOffSet()),
								      (int) (j*Tile.TILEHEIGHT-handler.getGameCamera().getyOffSet()));
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
		
		for (int y = 0; y<height; y++) {   //This is wrong I shouldn't have to stop counting early.
			for (int x = 0; x<width; x++) {
				tiles[x][y] = Utilities.parseInt(tokens[(x+y * width) + 4]);
				//System.out.println(Utilities.parseInt(tokens[(x+y * width) + 4]));
			}
		}
	}
}

package Tiles;

import java.awt.image.BufferedImage;

import gfx.Assets;

public class PitTile extends Tile {

	public PitTile(int id) {
		super(Assets.Pit, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}

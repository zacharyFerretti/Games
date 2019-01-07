package tiles;

import gfx.Assets;

public class NorthWallTile extends Tile {
	public NorthWallTile(int id) {
		super(Assets.NorthWall, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}

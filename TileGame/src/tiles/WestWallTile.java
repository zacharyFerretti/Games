package tiles;

import gfx.Assets;

public class WestWallTile extends Tile {
	public WestWallTile(int id) {
		super(Assets.WestWall, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
}

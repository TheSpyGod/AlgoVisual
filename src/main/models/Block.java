package main.models;

import java.util.Random;

public class Block {
	public int x, y;
	public int contents;
	static public Block[] ids;
	static private final Random rand = new Random();

	public Block() {}

	private Block(int x, int y, int contents) {
		this.x = x;
		this.y = y;
		this.contents = contents;
	}

	public Block[] getIds() {
		return ids;
	}

	private boolean initBlocks(int arrSize) {
		if (arrSize > 0) {
			ids = new Block[arrSize];
			return true;
		}
		return false;
	}

	private boolean addBlock(Block block) {
		for (int i = 0; i < ids.length ; i++) {
			if (ids[i] == null) {
				ids[i] = block;
				return true;
			}
		}
		return false;
	}

	public Block[] populateBlocksRandom(int x, int y, int arrSize) {
		if (!initBlocks(arrSize)) {
			return null;
		}
		for (int i = 0; i < ids.length; i++) {
			Block bl = new Block(x,y,rand.nextInt(101));
			if (!addBlock(bl)) {
				break;
			}
		}
		return ids;	
	}

}

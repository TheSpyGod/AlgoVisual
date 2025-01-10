package main.models;

import java.util.Random;

public class Block {
	int x, y;
	double contents;
	static Block[] ids;
	static private final Random rand = new Random();
	
	private Block(int x, int y, double contents) {
		this.x = x;
		this.y = y;
		this.contents = contents;
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
		if (!initBlocks(arrSize)) return null;
		for (int i = 0; i < ids.length; i++) {
			Block bl = new Block(x,y,rand.nextInt(101));
			if (addBlock(bl) == false) break;
		}
		return ids;
	}
	
}

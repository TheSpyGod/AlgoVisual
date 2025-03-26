package main.logic;

import main.models.Block;

import main.frame.*;
public class Logic {
	
	Frame instance;
	Block[] ids;
	public Logic(Frame frameinstance) {
		instance = frameinstance;
		ids = instance.getContent();
	}
	
	public void BubbleSort() {
		for (int i = 0; i < ids.length - 1; i++) {
			for (int j = 0; j < ids.length - 1; j++) {
				if (ids[j].contents < ids[j + 1].contents) {
					SwapValues(ids[j], ids[j + 1]);
				}	
			}
		}
		instance.RepaintFrame();
	}
		
	public void TestSwap() {
		SwapValues(ids[0], ids[1]);
		instance.RepaintFrame();
	}
	
	public void SwapValues(Block block_1, Block block_2) {
		int temp = block_1.contents;
		block_1.contents = block_2.contents;
		block_2.contents = temp;
	}
	
}

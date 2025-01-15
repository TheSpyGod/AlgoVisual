package main;

import main.models.Block;
import main.frame.*;
public class Application {
	
	static private Block block = new Block();
	static private Block[] list;
	static private Frame f;
	public static void main(String[] args) {
		f = new Frame(500,500, "Title");
		f.createBlocks(15,15,10);
	}
}
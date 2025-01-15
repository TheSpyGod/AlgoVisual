package main.frame;

import java.awt.Color;

import javax.swing.*;
import main.models.*;
public class Frame {
	private JFrame jf = new JFrame();
	private JPanel p;
	private Color c;
	private int frameHeight, frameWidth;
	private Block block = new Block();
	private Block[] container;
	
	public Frame(int height, int width, String title) {
		jf.setTitle(title);
		jf.setSize(width, height);
		frameHeight = height;
		frameWidth = width;
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createBlocks(int x, int y, int size) {
		setContent(x, y, size);
		var space = 5;
		for (Block i: container) {
			p = new JPanel();
			space+=40;
			p.setBackground(c.BLACK);
			p.setBounds(space, (frameHeight >> 2) * 3, i.x, i.y);
			jf.add(p);
		}
	}
	
	public boolean DisposeFrame() { 
		if (jf.isDisplayable()) {
			jf.dispose();
			return true;
		} else return false;
	}
	
	public void FrameVisibility(boolean visible) {
		jf.setVisible(visible);
	}
	
	private void setContent(int x, int y, int size) {
		block.populateBlocksRandom(x,y,size);
		container = block.getIds();
	}
	
	public Block[] getContent() {
		return container;
	}
	
}

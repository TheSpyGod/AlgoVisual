package main.frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import main.frame.mousehandler.MouseH;
import main.models.*;
public class Frame {
	private JFrame jf = new JFrame();
	private JPanel p;
	private JLabel l;
	MouseH m;
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
		m = new MouseH(this);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createBlocks(int x, int y, int size) {
		setContent(x, y, size);
		var space = 5;
		for (Block i: container) {
			p = createPanel(space, i);
			l = createLabel("Arial", i, y);
			p.add(l);
			p.addMouseListener(m);
			jf.add(p);	
			space+=40;
		}
	}	
	
	private JLabel createLabel(String font, Block content, int y) {
		l = new JLabel(String.valueOf(content.contents));
		l.setForeground(Color.WHITE);
		l.setFont(new Font(font, Font.BOLD, y / 2 - 3));
		l.setBounds(0, 0, content.x, content.y);
		l.setOpaque(false);
		return l;
	}
	
	private JPanel createPanel(int spaceBetween, Block content) {
		p = new JPanel();
		p.setBackground(Color.BLACK);
		p.setBounds(spaceBetween, (frameHeight >> 2) * 3, content.x, content.y);
		return p;
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
	
	public JFrame getFrame() {
		return jf;
	}
	
	public JPanel getPanel() {
		return p;
	}
}

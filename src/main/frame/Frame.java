	package main.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.*;

import main.frame.mousehandler.MouseH;
import main.models.*;
public class Frame {
	private JFrame jf = new JFrame();
	private JPanel p;
	private JLabel l;
	private JPanel[] PanelArr;
	private MouseH m;
	private int frameHeight, frameWidth;
	private Block block = new Block();
	private Block[] container;
	private JButton btn;
	public Frame(int height, int width, String title) {
		jf.setTitle(title);
		jf.setSize(width, height);
		frameHeight = height;
		frameWidth = width;
		jf.setResizable(false);
		m = new MouseH(this);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(null);
		
		jf.setLocationRelativeTo(null);
		//createButton(400, 200, 20, 40, "Hello", Color.BLACK);
		jf.setVisible(true);
	}
	
	public void createButton(int x, int y, int width, int height, String label, Color color) {
		btn = new JButton(label);
		btn.setBounds(x,y,width,height);
		btn.setBackground(color);
		btn.setForeground(Color.BLACK);
		
		jf.add(btn);
		jf.revalidate();
	    jf.repaint();
	}

	public void createBlocks(int x, int y, int size, boolean random) {
		PanelArr = new JPanel[size];
		setContent(x, y, size, random);
		int j = 0;
		int spaceBetween = 0;
		for (Block i: container) {
			JPanel p = createPanel(i, spaceBetween);
			p.setLayout(null);
			spaceBetween -= 30;
			PanelArr[j++] = p;
			l = createLabel("Arial", i, y);
			p.add(l);
			p.addMouseListener(m);
			jf.add(p);	
		}
		jf.revalidate();
		jf.repaint();
	}	
	
	public void updateFrame(int x, int y, int size) {
		jf.getContentPane().removeAll();
		createBlocks(x,y,size, false);
	}
	
	private JLabel createLabel(String font, Block content, int y) {
		l = new JLabel(String.valueOf(content.contents));
		l.setForeground(Color.WHITE);
		l.setFont(new Font(font, Font.BOLD, y / 2 - 3));
		l.setOpaque(false);
		return l;	
	}
	
	private JPanel createPanel(Block content, int spaceBetween) {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		p.setBackground(Color.BLACK);
		p.setBounds(content.x + spaceBetween, content.y, 30, 30);
		return p;
	}
	
	public void FrameVisibility(boolean visible) {
		jf.setVisible(visible);
	}
	
	private void setContent(int x, int y, int size, boolean random) {
		if (random) block.populateBlocksRandom(x,y,size);
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
	
	public JPanel[] getPanelArray() {
		return PanelArr;
	}
	
	public void RepaintFrame() {
		jf.revalidate();
		jf.repaint();
	}
}

package main.frame.animation;

import java.awt.Color;

import javax.swing.*;

import main.frame.*;
import main.models.Block;
public class Anim {
	Frame f;
	JFrame currFrame;
	public Anim(Frame frameInstance) {
		f = frameInstance;
		currFrame = f.getFrame();
	}
	
	public void glowEffect() {
		for (var i: currFrame.getContentPane().getComponents()) {
			if (i instanceof JPanel) {
				JPanel p = (JPanel) i;
				p.setForeground(Color.BLUE);
				p.setBackground(Color.RED);
			}
		}
	}
}

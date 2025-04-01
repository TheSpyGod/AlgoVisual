package main.frame.mousehandler;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import main.frame.*;
public class MouseH extends MouseAdapter {
	
	Frame instance;
	JFrame f;
	public MouseH(Frame frameInstance) {
		instance = frameInstance;
		f = instance.getFrame();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
       Object source = e.getSource();
			if (source instanceof JPanel) {
				JPanel j = (JPanel) source;
				if (j.getBackground() == Color.RED) {
					j.setBackground(Color.BLACK);
				} else j.setBackground(Color.RED);
	                   
		}
    }
}

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
        // Called when the mouse is clicked
       Object source = e.getSource();
			if (source instanceof JPanel) {
				JPanel j = (JPanel) source;
	            j.setBackground(Color.RED);  // Change color when panel is clicked
	                   
		}
    }
}
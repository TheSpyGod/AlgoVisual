package main.logic;

import main.models.Block;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import main.frame.*;
public class Logic {
	
	Frame instance;
	Block[] ids;
	JPanel[] PanelArr;
	public Logic(Frame frameinstance) {
		instance = frameinstance;
	}
	
	public void pauseGUI(int delay) {
	    CountDownLatch latch = new CountDownLatch(1); 
	    
	    Timer pauseTimer = new Timer(delay, new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            latch.countDown();
	            ((Timer) evt.getSource()).stop();
	        }
	    });

	    pauseTimer.setRepeats(false);
	    pauseTimer.start();

	    try {
	        latch.await();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	private void RepaintArray() {
		for(int i = 0; i < ids.length; i++) {
			PanelArr[i].removeAll();
            JLabel label = new JLabel(String.valueOf(ids[i].contents));
            label.setBounds(8, 0, 30, 30);
            label.setForeground(Color.WHITE);
            PanelArr[i].add(label);
            PanelArr[i].revalidate();
            PanelArr[i].repaint();
		}
	}

	private void AnimateSquares(int index, Color baseColor, Color secondaryColor) {
		
		PanelArr[index].setLocation(PanelArr[index].getX(), PanelArr[index].getY() - 30);
        PanelArr[index + 1].setLocation(PanelArr[index + 1].getX(), PanelArr[index + 1].getY() - 30);
        
        PanelArr[index].setBackground(secondaryColor);
        PanelArr[index + 1].setBackground(secondaryColor);
        
        PanelArr[index].removeAll();
        PanelArr[index + 1].removeAll();
        
        JLabel label1 = new JLabel(String.valueOf(ids[index].contents));
        JLabel label2 = new JLabel(String.valueOf(ids[index + 1].contents));
        
        label1.setBounds(8, 0, 30, 30);
        label2.setBounds(8, 0, 30, 30);
        
        label1.setForeground(Color.BLACK);
        label2.setForeground(Color.BLACK);
        
        PanelArr[index].add(label1);
        PanelArr[index + 1].add(label2);
        
        PanelArr[index].revalidate();
        PanelArr[index].repaint();
        PanelArr[index + 1].revalidate();
        PanelArr[index + 1].repaint();
        
        pauseGUI(1000);
        
        PanelArr[index].setLocation(PanelArr[index].getX() - 30, PanelArr[index].getY());
        PanelArr[index + 1].setLocation(PanelArr[index + 1].getX() + 30, PanelArr[index + 1].getY());
        
        PanelArr[index].setBackground(secondaryColor);
        PanelArr[index + 1].setBackground(secondaryColor);
        
        PanelArr[index].removeAll();
        PanelArr[index + 1].removeAll();
        
        label1 = new JLabel(String.valueOf(ids[index].contents));
        label2 = new JLabel(String.valueOf(ids[index + 1].contents));
        
        label1.setBounds(8, 0, 30, 30);
        label2.setBounds(8, 0, 30, 30);
        
        label1.setForeground(Color.BLACK);
        label2.setForeground(Color.BLACK);
        
        PanelArr[index].add(label1);
        PanelArr[index + 1].add(label2);
        
        PanelArr[index].revalidate();
        PanelArr[index].repaint();
        PanelArr[index + 1].revalidate();
        PanelArr[index + 1].repaint();

        pauseGUI(1000);

        PanelArr[index].setLocation(PanelArr[index].getX() + 30, PanelArr[index].getY() + 30);
        PanelArr[index + 1].setLocation(PanelArr[index + 1].getX() - 30, PanelArr[index + 1].getY() + 30);
        	            
        PanelArr[index].setBackground(baseColor);
        PanelArr[index + 1].setBackground(baseColor);
        
        PanelArr[index].removeAll();
        PanelArr[index + 1].removeAll();
        
        label1 = new JLabel(String.valueOf(ids[index + 1].contents));
        label2 = new JLabel(String.valueOf(ids[index].contents));
        
        label1.setBounds(8, 0, 30, 30);
        label2.setBounds(8, 0, 30, 30);
        
        label1.setForeground(Color.WHITE);
        label2.setForeground(Color.WHITE);
        
        PanelArr[index].add(label1);
        PanelArr[index + 1].add(label2);
        
        PanelArr[index].revalidate();
        PanelArr[index].repaint();
        PanelArr[index + 1].revalidate();
        PanelArr[index + 1].repaint();
        
	}
	
	public void BubbleSort(){
		instance.createBlocks(380,200,10, true);
		ids = instance.getContent();
		PanelArr = instance.getPanelArray();
		RepaintArray();
		for (int i = 0; i < ids.length - 1; i++) {
			for (int j = 0; j < ids.length - 1; j++) {
				if (ids[j].contents < ids[j + 1].contents) {
					 final int index = j; 
					 
					 	AnimateSquares(index, Color.BLACK, Color.green);
		                
		                SwapValues(ids[index], ids[index + 1]);

		                instance.RepaintFrame();
				}	
			}
		}
		RepaintArray();
	}
		
	public void TestSwap() {
		SwapValues(ids[0], ids[1]);
		instance.RepaintFrame();
	}
	
	public void SwapValues(Block b1, Block b2) {
		int temp = b1.contents;
		b1.contents = b2.contents;
		b2.contents = temp;
	}
	
}

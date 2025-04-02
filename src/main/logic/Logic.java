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

	//<summary>
	//
	// This function takes two indexes, the base color of the square and the secondary highlight color
	// It then calculates the distance between the squares, then switches their places while highlighting them
	//
	//<summary>
	private void AnimateSquares(int i1, int i2, Color baseColor, Color secondaryColor) {
		
		int distance = i2 - i1;
		
		PanelArr[i1].setLocation(PanelArr[i1].getX(), PanelArr[i1].getY() - 30);
        PanelArr[i2].setLocation(PanelArr[i2].getX(), PanelArr[i2].getY() - 30);
        
        PanelArr[i1].setBackground(secondaryColor);
        PanelArr[i2].setBackground(secondaryColor);
        
        PanelArr[i1].removeAll();
        PanelArr[i2].removeAll();
        
        JLabel label1 = new JLabel(String.valueOf(ids[i1].contents));
        JLabel label2 = new JLabel(String.valueOf(ids[i2].contents));
        
        label1.setBounds(8, 0, 30, 30);
        label2.setBounds(8, 0, 30, 30);
        
        label1.setForeground(Color.BLACK);
        label2.setForeground(Color.BLACK);
        
        PanelArr[i1].add(label1);
        PanelArr[i2].add(label2);
        
        PanelArr[i1].revalidate();
        PanelArr[i1].repaint();
        PanelArr[i2].revalidate();
        PanelArr[i2].repaint();
        
        pauseGUI(1000);
        
        PanelArr[i1].setLocation(PanelArr[i1].getX()  - (distance * 30), PanelArr[i1].getY());
        PanelArr[i2].setLocation(PanelArr[i2].getX() + (distance * 30), PanelArr[i2].getY());
        
        PanelArr[i1].setBackground(secondaryColor);
        PanelArr[i2].setBackground(secondaryColor);
        
        PanelArr[i1].removeAll();
        PanelArr[i2].removeAll();
        
        label1 = new JLabel(String.valueOf(ids[i1].contents));
        label2 = new JLabel(String.valueOf(ids[i2].contents));
        
        label1.setBounds(8, 0, 30, 30);
        label2.setBounds(8, 0, 30, 30);
        
        label1.setForeground(Color.BLACK);
        label2.setForeground(Color.BLACK);
        
        PanelArr[i1].add(label1);
        PanelArr[i2].add(label2);
        
        PanelArr[i1].revalidate();
        PanelArr[i1].repaint();
        PanelArr[i2].revalidate();
        PanelArr[i2].repaint();

        pauseGUI(1000);

        PanelArr[i1].setLocation(PanelArr[i1].getX() + (distance * 30), PanelArr[i1].getY() + 30);
        PanelArr[i2].setLocation(PanelArr[i2].getX() - (distance * 30), PanelArr[i2].getY() + 30);
        	            
        PanelArr[i1].setBackground(baseColor);
        PanelArr[i2].setBackground(baseColor);
        
        PanelArr[i1].removeAll();
        PanelArr[i2].removeAll();
        
        label1 = new JLabel(String.valueOf(ids[i2].contents));
        label2 = new JLabel(String.valueOf(ids[i1].contents));
        
        label1.setBounds(8, 0, 30, 30);
        label2.setBounds(8, 0, 30, 30);
        
        label1.setForeground(Color.WHITE);
        label2.setForeground(Color.WHITE);
        
        PanelArr[i1].add(label1);
        PanelArr[i2].add(label2);
        
        PanelArr[i1].revalidate();
        PanelArr[i1].repaint();
        PanelArr[i2].revalidate();
        PanelArr[i2].repaint();
        
	}
	
	public void BubbleSort(Block[] ids){
		this.ids = ids;
		PanelArr = instance.getPanelArray();
		RepaintArray();
		for (int i = 0; i < ids.length - 1; i++) {
			for (int j = 0; j < ids.length - 1; j++) {
				if (ids[j].contents < ids[j + 1].contents) {
					 final int index = j; 
					 	AnimateSquares(index, index + 1, Color.BLACK, Color.green);
		                SwapValues(ids[index], ids[index + 1]);
		                instance.RepaintFrame();
				}	
			}
		}
		RepaintArray();
	}
	
	public void Quicksort(Block[] ids, int start, int end) {
		this.ids = ids;
		PanelArr = instance.getPanelArray();
		RepaintArray();
		if (end <= start)
			return;
		int pivot = Partition(ids, start, end);
		Quicksort(ids, start, pivot - 1);
		Quicksort(ids, pivot + 1, end);
	}
	
	private int Partition(Block[] ids, int start, int end) {
		int pivot = ids[end].contents;
		int i = start - 1;
		
		for (int j = start; j <= end - 1; j++) {
			if (ids[j].contents < pivot) {
				i++;
				AnimateSquares(i, j, Color.BLACK, Color.green);
				SwapValues(ids[i], ids[j]);
				instance.RepaintFrame();
			}
		}
		i++;
		AnimateSquares(i, end, Color.BLACK, Color.green);
		SwapValues(ids[i], ids[end]);
		instance.RepaintFrame();
		return i;
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

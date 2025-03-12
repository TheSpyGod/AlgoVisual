package main;

import javax.swing.*;
import main.frame.*;
import main.frame.animation.*;
import main.logic.Logic;
public class Application {

	static private Frame f;
	static private Logic l;
	public static void main(String[] args) {
		f = new Frame(500,500, "Title");
		f.createBlocks(30,30,10);
		l = new Logic(f);
		l.BubbleSort();
		f.updateFrame(30, 30, 10);
	}
}
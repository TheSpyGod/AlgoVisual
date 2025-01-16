package main;

import javax.swing.*;
import main.frame.*;
import main.frame.animation.*;
public class Application {

	static private Frame f;
	public static void main(String[] args) {
		f = new Frame(500,500, "Title");
		f.createBlocks(30,30,10);
	}
}